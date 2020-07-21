package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgContent;
import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;
import com.hangyu.platform.web.backBusiness.dto.BmOrgfileTbl;
import com.hangyu.platform.web.backBusiness.dto.BmOrguserTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgContentMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrguserTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.vo.BmOrgManageVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author abel
 * @ClassName BmOrgService
 * @date 2019-11-28
 */
@Service
public class BmOrgService {

    @Resource
    private BmOrgTblMapper bmOrgTblMapper;

    @Resource
    private BmOrguserTblMapper orgUserTblMapper;

    @Resource
    private BmOrgContentMapper bmOrgContentMapper;

    @Resource
    private BmOrgfileTblMapper bmOrgfileTblMapper;

    @Autowired
    private BmOrgUserService orgUserService;

    @Autowired
    private BmOrgContentService contentService;

    @Autowired
    private BmOrgFileService bmOrgFileService;

    @Resource
    private BmStaffTblMapper bmStaffTblMapper;

    /**
     * 批量查询，根据不同机构查询首页情况
     *
     * @return BmOrgManageVO
     */
    public Map<String, Object> getOrgManageInfo(int pageSize, int pageNum, String orgName, String startDate, String endDate) {
        BmOrgManageVO bmOrgManageVO = new BmOrgManageVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        //机构信息
        List<BmOrgTbl> bmOrgTbl = bmOrgTblMapper.getBmOrgInfo(start, pageSize, orgName, startDate, endDate);
        bmOrgTbl.forEach(org ->{
            //机构管理附件
            BmOrgfileTbl orgfileTbl = bmOrgfileTblMapper.selectByOrgId(org.getOrgid());
            org.setBmOrgfileTbl(orgfileTbl);
        });
        bmOrgManageVO.setBmOrgTbl(bmOrgTbl);
        int count = bmOrgTblMapper.selectTotal(orgName, startDate, endDate);
        Map<String, Object> map = new HashMap<>();
        map.put("list", bmOrgManageVO);
        map.put("count", count);
        return map;
    }

    /**
     * 查询单个
     *
     * @return BmOrgManageVO
     */
    public BmOrgTbl queryById(String orgId) {
        //机构信息
        BmOrgTbl bm = bmOrgTblMapper.queryByOrgId(orgId);
        if (StringUtils.isNotEmpty(bm.getOrguser())) {
            String[] userIds = bm.getOrguser().split(",");
            //员工信息,批量查询
            List<BmOrguserTbl> userList = orgUserTblMapper.selectByIds(Arrays.asList(userIds), bm.getOrgid());
            bm.setOrguserTblList(userList);
        }
        //人员履职信息，用机构名称查询
        List<BmOrgContent> bmOrgContentList = bmOrgContentMapper.selectByOrgId(bm.getOrgid());
        //机构管理附件
        BmOrgfileTbl orgfileTbl = bmOrgfileTblMapper.selectByOrgId(bm.getOrgid());
        bm.setBmOrgContentList(bmOrgContentList);
        bm.setBmOrgfileTbl(orgfileTbl);
        return bm;
    }

    /**
     * 查询历史版本信息
     *
     * @param orgId
     * @return
     */
    public List<BmOrgTbl> queryHistory(String orgId) {
        List<BmOrgTbl> bmOrgTbl = bmOrgTblMapper.queryHistory(orgId);
        for (BmOrgTbl bm : bmOrgTbl) {
            String[] userIds = bm.getOrguser().split(",");
            StringBuilder sb = new StringBuilder();
            if (userIds != null && userIds.length > 0) {
                for (int i = 0; i < userIds.length; i++) {
                    BmStaffTbl staffTbl = bmStaffTblMapper.selectByUserId(userIds[i]);
                    if (null != staffTbl) {
                        sb.append(staffTbl.getUsername()).append(",");
                    }
                }
                bm.setOrguser(sb.toString().substring(0, sb.lastIndexOf(",")));
            }
        }
        return bmOrgTbl;
    }


    /**
     * 增加组织机构
     *
     * @param bmOrgTbl
     */
    @Transactional
    public void addOrganization(BmOrgTbl bmOrgTbl, MultipartFile[] files) throws IOException {
        //机构id
        String orgId = CommonUtils.generateUUID();
        //如果机构下有成员，处理成员信息
        if (CollectionUtils.isNotEmpty(bmOrgTbl.getBmStaffTblList())) {
            String sb = dealUserId(bmOrgTbl);
            //设置机构新人员
            bmOrgTbl.setOrguser(sb);
        }
        //设置机构id
        bmOrgTbl.setOrgid(orgId);
        //默认不是历史版本,1不是历史版本
        bmOrgTbl.setStater(1);
        bmOrgTblMapper.insert(bmOrgTbl);
        //将机构成员数据存储入库
        orgUserService.add(bmOrgTbl);

        //判断增加机构时，有没有上传机构附件
        if (null != bmOrgTbl.getMultipartFile()) {
            bmOrgFileService.addOrgFile(bmOrgTbl);
        }
        //处理机构活动和人员履职以及文件上传,判断用户是否选择人员履职或者机构活动
        if (CollectionUtils.isNotEmpty(bmOrgTbl.getBmOrgContentList())) {
            dealOrgContent(bmOrgTbl, orgId, files);
        }

    }

    /**
     * 处理机构内容
     *
     * @param bmOrgTbl
     * @param orgId
     * @param files
     * @throws IOException
     */
    private void dealOrgContent(BmOrgTbl bmOrgTbl, String orgId, MultipartFile[] files) throws IOException {
        //orgContent封装数据
        List<BmOrgContent> contentList = bmOrgTbl.getBmOrgContentList();
        //循环，对机构活动和员工活动分组
        for (BmOrgContent content : contentList) {
            content.setOrgid(orgId);
            content.setContentid(CommonUtils.generateUUID());
            for (MultipartFile file : files) {
                if (StringUtils.equals(file.getOriginalFilename(), content.getAttfile())) {
                    String url = FileUtils.uploads(file);
                    content.setAttfile(url);
                }
            }
        }
        //存表
        contentService.addContent(contentList);
    }


    /**
     * 修改组织机构
     *
     * @param bmOrgTbl
     */
    @Transactional
    public void updateOrganization(BmOrgTbl bmOrgTbl, MultipartFile[] files, int type) throws IOException {

        //如果机构下有成员，处理成员信息
        if (CollectionUtils.isNotEmpty(bmOrgTbl.getBmStaffTblList())) {
            String sb = dealUserId(bmOrgTbl);
            //设置机构新人员
            bmOrgTbl.setOrguser(sb);
        }
        if (type == 0) {
            //更新org表
            bmOrgTblMapper.updateByOrgId(bmOrgTbl);
        } else {
            //设置原来的数据为历史版本，新增加一条数据
            bmOrgTblMapper.deleteByPrimaryKey(bmOrgTbl.getId());
            bmOrgTbl.setStater(0);
            bmOrgTbl.setId(null);
            bmOrgTblMapper.insert(bmOrgTbl);
        }

        //先删除orgUser表数据，再重新增加
        orgUserTblMapper.deleteByOrgId(bmOrgTbl.getOrgid());
        orgUserService.add(bmOrgTbl);

        //如果更新不传附件，那就是删除
        BmOrgfileTbl bmOrgfileTbl = bmOrgTbl.getBmOrgfileTbl();
        if (null != bmOrgfileTbl && null == bmOrgfileTbl.getFileurl()) {
            bmOrgFileService.delOrgFile(bmOrgTbl.getOrgid());
        }

        //以前文件附件表由数据且，新的附件文件不是空，则删除原来得附件，重新上传新的
        if (null != bmOrgTbl.getMultipartFile()) {
            //删除原来数据库的文件以及服务器上的文件，重新增加
            bmOrgFileService.delOrgFile(bmOrgTbl.getOrgid());
            bmOrgFileService.addOrgFile(bmOrgTbl);
        }

        contentService.updateContent(bmOrgTbl, files);

    }


    /**
     * 处理员工id，拼成字符串
     *
     * @param bmOrgTbl
     * @return
     */
    private String dealUserId(BmOrgTbl bmOrgTbl) {
        StringBuilder sb = new StringBuilder();
        for (BmStaffTbl st : bmOrgTbl.getBmStaffTblList()) {
            sb.append(st.getStaffid()).append(",");
        }
        return sb.toString().substring(0, sb.lastIndexOf(","));
    }

    /**
     * 删除部门信息
     *
     * @param orgId
     */
    @Transactional
    public void delOrg(String orgId) {

        //删除org表
        bmOrgTblMapper.delByOrgId(orgId);
        //删除org_user
        orgUserTblMapper.deleteByOrgId(orgId);
        //删除org_file
        bmOrgFileService.delOrgFile(orgId);
        //删除org_content
        List<BmOrgContent> contentList = bmOrgContentMapper.selectByOrgId(orgId);
        for (BmOrgContent content : contentList) {
            if (null != content.getAttfile()) {
                FileUtils.deleteFile( content.getAttfile());
            }
        }
        bmOrgContentMapper.deleteByOrgId(orgId);
    }

    /**
     * 删除部门信息
     *
     * @param orgId
     */
    @Transactional
    public void delHostiory(Integer orgId) {
        //删除org表
        bmOrgTblMapper.deleteHistroy(orgId);

    }


    /**
     * 导出excel
     *
     * @param orgId    orgId
     * @param response response
     * @throws IOException
     */
    public void exportExcelTemplate(String orgId, HttpServletResponse response) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        BmOrgTbl bmOrgTbl = bmOrgTblMapper.queryByOrgId(orgId);
        StringBuilder name = new StringBuilder();
        List<BmStaffTbl> staffTblList = bmStaffTblMapper.queryByOrgId(orgId);
        if (CollectionUtils.isNotEmpty(staffTblList)) {
            for (BmStaffTbl bm : staffTblList) {
                name.append(bm.getUsername()).append(",");
            }
            bmOrgTbl.setOrguser(name.toString().substring(0, name.lastIndexOf(",")));
        }
        //加载模板
        File fi = new File("src/main/resources/templates/保密机构.xls");
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
        HSSFWorkbook wb = new HSSFWorkbook(fs);

        HSSFSheet sheet = wb.getSheet("保密管理");

        HSSFCell cell = sheet.getRow(0).getCell(0);
        cell.setCellValue("保密机构信息");
        HSSFCell cell2 = sheet.getRow(1).getCell(0);
        cell2.setCellValue("截至日期:" + date);
        HSSFCell cell1 = sheet.getRow(2).getCell(1);
        cell1.setCellValue(bmOrgTbl.getOrgname());
        HSSFCell cell3 = sheet.getRow(3).getCell(1);
        cell3.setCellValue(bmOrgTbl.getOrgdate());
        HSSFCell cell4 = sheet.getRow(4).getCell(1);
        cell4.setCellValue(bmOrgTbl.getOrguser());

        HSSFCell cell5 = sheet.getRow(5).getCell(1);
        cell5.setCellValue(bmOrgTbl.getOrgfunction());

        HSSFCell cell6 = sheet.getRow(6).getCell(1);
        cell6.setCellValue(bmOrgTbl.getOrgrule());


        String fileName = "保密机构-" + date + ".xls";

        FileOutputStream fos = new FileOutputStream(fileName);
        wb.write(fos);
        fos.flush();
        fos.close();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }
}