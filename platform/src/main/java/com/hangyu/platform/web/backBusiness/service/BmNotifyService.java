package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmNotifyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmNotifyTblMapper;
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
 * 通知公告管理
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Service
public class BmNotifyService {

    @Resource
    private BmNotifyTblMapper mapper;


    /**
     * 查询所有通知公告管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize, String name, String keyWords, String startDate, String endDate) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmNotifyTbl> list = mapper.select(start, pageSize, name, keyWords, startDate, endDate);
        int total = mapper.selectTotal(name, keyWords, startDate, endDate);
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
    public BmNotifyTbl queryById(String id) {
        BmNotifyTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmNotifyTbl tbl, MultipartFile file) throws IOException {
        tbl.setNotifyid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploadStaticFile(file);
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
    public void update(BmNotifyTbl tbl, MultipartFile file) throws IOException {
        if (null == tbl.getFileurl()) {
            //删除附件
            BmNotifyTbl oldTbl = mapper.selectByPrimaryKey(tbl.getNotifyid());
            deleteFile(oldTbl);
        }
        //上传附件
        if (null != file) {
            //删除附件
            deleteFile(tbl);
            String fileUrl = FileUtils.uploadStaticFile(file);
            tbl.setFileurl(fileUrl);
        }
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除附件
     *
     * @param tbl
     */
    private void deleteFile(BmNotifyTbl tbl) throws IOException {
        if (StringUtils.isNotEmpty(tbl.getFileurl())) {
            FileUtils.deleteStaticFile(tbl.getFileurl());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException {
        //删除附件
        BmNotifyTbl tbl = mapper.selectByPrimaryKey(id);
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
