package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmWorkdynTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmWorkdynTblMapper;
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
 * 工作动态管理
 *
 * @auther liuXuan
 * @date 2020/3/4
 */
@Service
public class BmWorkDynamicService {

    @Resource
    private BmWorkdynTblMapper mapper;


    /**
     * 查询所有工作动态
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmWorkdynTbl> list = mapper.select(start, pageSize);
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
    public BmWorkdynTbl queryById(String id) {
        BmWorkdynTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmWorkdynTbl tbl, MultipartFile file) throws IOException {
        tbl.setWorkdynid(CommonUtils.generateUUID());
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
    public void update(BmWorkdynTbl tbl, MultipartFile file) throws IOException {
        if (null == tbl.getFileurl()){
            //删除附件
            BmWorkdynTbl oldTbl = mapper.selectByPrimaryKey(tbl.getWorkdynid());
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
    private void deleteFile(BmWorkdynTbl tbl) throws IOException{
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
    public void delete(String id) throws IOException{
        //删除附件
        BmWorkdynTbl tbl = mapper.selectByPrimaryKey(id);
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
