package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSecrettoolTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSecrettoolTblMapper;
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
 * 检查工具管理
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Service
public class BmSecretTooleService {

    @Resource
    private BmSecrettoolTblMapper mapper;


    /**
     * 查询所有检查工具管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSecrettoolTbl> list = mapper.select(start, pageSize);
        int total = mapper.selectTotal();
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
    public BmSecrettoolTbl queryById(String id) {
        BmSecrettoolTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmSecrettoolTbl tbl, MultipartFile file) throws IOException {
        tbl.setToolid(CommonUtils.generateUUID());
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
    public void update(BmSecrettoolTbl tbl, MultipartFile file) throws IOException {
        //上传附件
        if (null != file) {
            //删除原来的附件
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
    private void deleteFile(BmSecrettoolTbl tbl) {
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
        BmSecrettoolTbl tbl = mapper.selectByPrimaryKey(id);
        deleteFile(tbl);
        mapper.deleteByPrimaryKey(id);
    }


}
