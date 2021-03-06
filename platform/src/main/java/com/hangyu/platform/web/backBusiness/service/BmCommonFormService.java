package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmCommonformTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmCommonformTblMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常用表格管理
 *
 * @auther liuXuan
 * @date 2020/3/9
 */
@Service
public class BmCommonFormService {

    @Resource
    private BmCommonformTblMapper mapper;


    /**
     * 查询所有常用表格管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize,String isPublish) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmCommonformTbl> list = mapper.select(start, pageSize,isPublish);
        int total = mapper.selectTotal(isPublish);
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
    public BmCommonformTbl queryById(String id) {
        BmCommonformTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmCommonformTbl tbl, MultipartFile file) throws IOException {
        tbl.setFormid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmCommonformTbl tbl, MultipartFile file) throws IOException {
        //上传附件
        if (null != file) {
            //删除附件
            deleteFile(tbl);
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除附件
     *
     * @param tbl
     */
    private void deleteFile(BmCommonformTbl tbl) {
        if (StringUtils.isNotEmpty(tbl.getFileurl())) {
            FileUtils.deleteFile(tbl.getFileurl());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        //删除附件
        BmCommonformTbl tbl = mapper.selectByPrimaryKey(id);
        deleteFile(tbl);
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除
     *
     * @param id
     * @param status 0未发布，1已发布
     */
    @Transactional
    public void isPublish(String id, int status) {
        mapper.isPublish(id, status);
    }
}
