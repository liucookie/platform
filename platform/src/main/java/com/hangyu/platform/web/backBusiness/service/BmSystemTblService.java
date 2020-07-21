package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSystemTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemfileTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemitemTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSystemTblService {

    @Value("${file.upload.path}")
    private String filePath;

    @Resource
    private BmSystemTblMapper bmSystemTblMapper;

    @Resource
    private BmSystemfileTblMapper fileMapper;

    @Resource
    private BmSystemitemTblMapper itemMapper;




    /**
     * 查询所有制度
     *
     * @param name
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> selectSystem(String name, String type, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSystemTbl> list = bmSystemTblMapper.select(name, type, start, pageSize);
        list.forEach(tbl -> {
            List<BmSystemfileTbl> fileTbls = fileMapper.selectByPrimaryKey(tbl.getSysid());
            if (CollectionUtils.isNotEmpty(fileTbls)) {
                tbl.setFileUrl(fileTbls.get(0).getAttachurl());
            }
        });
        int count = bmSystemTblMapper.selectTotal(name, type);
        map.put("total", count);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @param name
     * @param type
     * @return
     */
    public List<BmSystemTbl> exportExcel(String name, String type) {
        List<BmSystemTbl> list = bmSystemTblMapper.exportExcel(name, type);
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmSystemTbl queryById(String id) {
        BmSystemTbl systemTbl = bmSystemTblMapper.selectByPrimaryKey(id);
        //查出附件信息
        List<BmSystemfileTbl> fileTbl = fileMapper.selectByPrimaryKey(id);
        systemTbl.setSysFiles(fileTbl);
        return systemTbl;

    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public List<BmSystemTbl> queryHistory(String id) {
        List<BmSystemTbl> systemTbls = bmSystemTblMapper.queryHistory(id);
        for (BmSystemTbl tbl : systemTbls) {
            //查出附件信息
            List<BmSystemfileTbl> fileTbl = fileMapper.selectByPrimaryKey(id);
            tbl.setSysFiles(fileTbl);
        }
        return systemTbls;

    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmSystemTbl tbl, MultipartFile[] files) throws IOException {
        String sysId = CommonUtils.generateUUID();
        tbl.setSysid(sysId);
        //上传附件,上传到systemfile表中
        if (null != files) {
            add(files, sysId);
        }
        bmSystemTblMapper.insert(tbl);
    }

    private void add(MultipartFile[] files, String sysId) throws IOException {
        for (MultipartFile file : files) {
            String fileUrl = FileUtils.uploads(file);
            BmSystemfileTbl fileTbl = new BmSystemfileTbl();
            fileTbl.setAttachid(CommonUtils.generateUUID());
            fileTbl.setSystemid(sysId);
            fileTbl.setAttachname(file.getOriginalFilename());
            fileTbl.setAttachurl(fileUrl);
            fileMapper.insert(fileTbl);
        }
    }

    private void deleteFile(String sysId) {
        List<BmSystemfileTbl> systemfileTbls = fileMapper.selectByPrimaryKey(sysId);
        for (BmSystemfileTbl tbl : systemfileTbls) {
            if (null != tbl.getAttachurl()) {
                FileUtils.deleteFile(tbl.getAttachurl());
            }
            fileMapper.deleteFile(tbl.getAttachid());
        }
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmSystemTbl tbl, MultipartFile[] files) throws IOException {
        //如果filename为Null,则说明删除了文件，删除附件表
        List<BmSystemfileTbl> sysFiles = tbl.getSysFiles();
        for (BmSystemfileTbl file : sysFiles) {
            if (null == file.getAttachurl()) {
                BmSystemfileTbl oldFile = fileMapper.selectByAttrId(file.getAttachid());
                FileUtils.deleteFile(oldFile.getAttachurl());
                //删除原文件和数据
                fileMapper.deleteFile(file.getAttachid());
            }
        }
        //上传附件,上传到systemfile表中
        if (null != files) {
            add(files, tbl.getSysid());
        }
        bmSystemTblMapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        deleteFile(id);
        bmSystemTblMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void deleteHistory(Integer id) {
        bmSystemTblMapper.deleteHistory(id);
    }


    /**
     * 查询制度内容（下拉用）
     *
     * @param pageNum
     * @param pageSize
     * @param type
     * @param content
     * @param name
     * @return
     */
    public Map<String, Object> selectContent(int pageNum, int pageSize, String type, String content, String name) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSystemitemTbl> list = itemMapper.selectContent(start, pageSize, type, content, name);
        int total = itemMapper.selectContentTotal(type, content, name);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询制度细则
     *
     * @param name
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> selectSystemItem(String name, String id, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSystemitemTbl> list = itemMapper.select(name, id, start, pageSize);
        int count = itemMapper.selectTotal(name, id);
        map.put("total", count);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmSystemitemTbl queryItem(String id) {
        BmSystemitemTbl tbl = itemMapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 查询单个
     *
     * @param type
     * @return
     */
    public List<BmSystemTbl> selectSystemByType(int type) {
        List<BmSystemTbl> list = bmSystemTblMapper.selectSystemByType(type);
        return list;
    }

    /**
     * 添加制度细则
     *
     * @param tbl
     * @param id
     */
    public void insertItem(BmSystemitemTbl tbl, String id) {
        tbl.setSysid(id);
        tbl.setItemid(CommonUtils.generateUUID());
        itemMapper.insert(tbl);
    }

    /**
     * 添加制度细则
     *
     * @param tbl
     */
    public void updateItem(BmSystemitemTbl tbl) {
        itemMapper.updateByPrimaryKey(tbl);
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void deleteItem(String id) {
        itemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file, String id) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            BmSystemitemTbl info = new BmSystemitemTbl();
            info.setSysid(id);
            info.setItemid(CommonUtils.generateUUID());
            info.setItemcontent((String) list.get(i)[0]);
            info.setDscore(Integer.valueOf((String) list.get(i)[1]));
            info.setDconsub(Integer.valueOf((String) list.get(i)[2]));
            info.setDwages(Integer.valueOf((String) list.get(i)[3]));
            info.setSortorder(Integer.valueOf((String) list.get(i)[4]));
            itemMapper.insert(info);
        }
    }
}
