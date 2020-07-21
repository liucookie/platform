package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2CreditmanagerorgsTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemfileTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2CreditmanagerorgsTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemitemTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现场检查计划管理
 *
 * @auther liuXuan
 * @date 2020/2/24
 */
@Service
public class Bm2LocalCheckService {

    @Resource
    private Bm2LocalcheckplanTblMapper mapper;

    @Resource
    private Bm2CheckspecialtypeTblMapper typeMapper;

    @Resource
    private Bm2CreditmanagerorgsTblMapper personMapper;
    @Resource
    private BmSystemfileTblMapper systemTblMapper;

    /**
     * 查询所有现场检查计划
     *
     * @param year
     * @param month
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(String year, String month, String name, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2LocalcheckplanTbl> list = mapper.select(year, month, name, start, pageSize);
        //处理检查类别
        for (Bm2LocalcheckplanTbl tbl : list) {
            if (StringUtils.isNotEmpty(tbl.getPlanchecktypeid())) {
                String[] typeId = tbl.getPlanchecktypeid().split("/");
                List<String> typeIds = Arrays.asList(typeId);
                StringBuilder sb = new StringBuilder();
                typeIds.forEach(Id -> {
                    String typeName = typeMapper.selectNameById(Id);
                    sb.append(typeName).append("/");
                });
                tbl.setPlanCheckName(sb.toString().substring(0, sb.lastIndexOf("/")));
            }
        }
        int total = mapper.selectTotal(year, month, name);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Bm2LocalcheckplanTbl queryById(String id) {
        Bm2LocalcheckplanTbl tbl = mapper.selectByPrimaryKey(id);
        if (StringUtils.isNotEmpty(tbl.getPlanchecktypeid())) {
            //处理类别id，转换成list
            String[] typeIds = tbl.getPlanchecktypeid().split("/");
            List<String> list = Arrays.asList(typeIds);
            tbl.setCheckTypeIds(list);
        }
        BmSystemfileTbl file = systemTblMapper.selectById(id);
        if (null != file) {
            tbl.setFileName(file.getAttachurl());
        }
        return tbl;
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Bm2LocalcheckplanTbl> queryAll() {
        List<Bm2LocalcheckplanTbl> list = mapper.queryAll();
        return list;

    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Bm2LocalcheckplanTbl tbl, MultipartFile file) throws IOException {
        String planId = CommonUtils.generateUUID();
        tbl.setPlanid(planId);
        //上传附件
        uploadFile(file, planId);
        //处理部门
        dealTypeIds(tbl);
        mapper.insert(tbl);
    }

    private void uploadFile(MultipartFile file, String planId) throws IOException {
        if (null != file) {
            BmSystemfileTbl bmSystemfileTbl = new BmSystemfileTbl();
            String fileName = file.getOriginalFilename();
            String url = FileUtils.uploads(file);
            bmSystemfileTbl.setAttachid(CommonUtils.generateUUID());
            bmSystemfileTbl.setAttachname(fileName);
            bmSystemfileTbl.setAttachurl(url);
            bmSystemfileTbl.setSystemid(planId);
            systemTblMapper.insert(bmSystemfileTbl);
        }
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Bm2LocalcheckplanTbl tbl, MultipartFile file) throws IOException {
        if (null == tbl.getFileName()){
            deleteFile(tbl.getPlanid());
        }
        if (null != file) {
            deleteFile(tbl.getPlanid());
            uploadFile(file, tbl.getPlanid());
        }
        dealTypeIds(tbl);
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(String id) {
        //查询出附件信息
        BmSystemfileTbl tbl = systemTblMapper.selectById(id);
        if (null != tbl) {
            //删除表中数据
            systemTblMapper.deleteFile(tbl.getAttachid());
            //删除附件
            FileUtils.deleteFile(tbl.getAttachurl());
        }
    }

    /**
     * 处理类型id
     *
     * @param tbl
     */
    private void dealTypeIds(Bm2LocalcheckplanTbl tbl) {
        //处理部门
        if (CollectionUtils.isNotEmpty(tbl.getCheckTypeIds())) {
            StringBuilder sb = new StringBuilder();
            for (String id : tbl.getCheckTypeIds()) {
                sb.append(id).append("/");
            }
            tbl.setPlanchecktypeid(sb.toString().substring(0, sb.lastIndexOf("/")));
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        deleteFile(id);
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有定密责任人
     * @return
     */
    public List<Bm2CreditmanagerorgsTbl> querySecretPerson(){
        List<Bm2CreditmanagerorgsTbl> list =  personMapper.querySecretPerson();
        return list;

    }
}
