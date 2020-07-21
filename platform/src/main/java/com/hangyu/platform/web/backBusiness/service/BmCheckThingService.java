package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmCheckthingTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckthingTblMapper;
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
 * 检查情况通报
 *
 * @auther liuXuan
 * @date 2020/3/5
 */
@Service
public class BmCheckThingService {

    @Resource
    private BmCheckthingTblMapper mapper;


    /**
     * 查询所有检查情况通报
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize,String isPublish) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmCheckthingTbl> list = mapper.select(start, pageSize,isPublish);
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
    public BmCheckthingTbl queryById(String id) {
        BmCheckthingTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmCheckthingTbl tbl, MultipartFile file) throws IOException {
        tbl.setChkthingid(CommonUtils.generateUUID());
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
    public void update(BmCheckthingTbl tbl, MultipartFile file) throws IOException {
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
    private void deleteFile(BmCheckthingTbl tbl) {
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
        BmCheckthingTbl tbl = mapper.selectByPrimaryKey(id);
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
