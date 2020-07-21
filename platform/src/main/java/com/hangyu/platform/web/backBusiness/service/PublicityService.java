package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgfileTbl;
import com.hangyu.platform.web.backBusiness.dto.PublicityTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.PublicityTblMapper;
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
 * 教育管理
 *
 * @auther liuXuan
 * @date 2020/3/4
 */
@Service
public class PublicityService {

    @Resource
    private PublicityTblMapper mapper;

    @Resource
    private BmOrgfileTblMapper orgFileTblMapper;


    /**
     * 查询所有教育
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<PublicityTbl> list = mapper.select(start, pageSize);
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
    public PublicityTbl queryById(String id) {
        PublicityTbl tbl = mapper.selectByPrimaryKey(id);
        //查询出附件表的数据
        BmOrgfileTbl file = orgFileTblMapper.selectByOrgId(tbl.getUniqueid());
        tbl.setFileUrl(null == file ? null : file.getFileurl());
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(PublicityTbl tbl, MultipartFile file) throws IOException {
        String uniqueId = CommonUtils.generateUUID();
        tbl.setUniqueid(uniqueId);
        //上传附件
        if (null != file) {
            addOrgFile(file, uniqueId);
        }
        mapper.insert(tbl);
    }

    /**
     * 增加附件信息到机构附件表中
     *
     * @param file
     * @throws IOException
     */
    private void addOrgFile(MultipartFile file, String id) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileUrl = FileUtils.uploadStaticFile(file);
        BmOrgfileTbl tbl = new BmOrgfileTbl();
        tbl.setOrgid(id);
        tbl.setFileurl(fileUrl);
        tbl.setFilename(fileName);
        tbl.setOrgfileid(CommonUtils.generateUUID());
        orgFileTblMapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(PublicityTbl tbl, MultipartFile file) throws IOException {

        //上传附件
        if (null != file) {
            //删除附件
            deleteFile(tbl);
            //重新增加数据
            addOrgFile(file, tbl.getUniqueid());
        }
        if (null == tbl.getFileUrl()) {
            //删除orgFile表的数据
            BmOrgfileTbl orgfileTbl = orgFileTblMapper.selectByOrgId(tbl.getUniqueid());
            //删除附件
            if (null != orgfileTbl){
                FileUtils.deleteStaticFile(orgfileTbl.getFileurl());
            }
            orgFileTblMapper.deleteByOrgId(tbl.getUniqueid());
        }

        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除附件
     *
     * @param tbl
     */
    private void deleteFile(PublicityTbl tbl) throws IOException{
        //删除orgFile表的数据
        orgFileTblMapper.deleteByOrgId(tbl.getUniqueid());
        if (StringUtils.isNotEmpty(tbl.getFileUrl())) {
            FileUtils.deleteStaticFile(tbl.getFileUrl());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException {
        PublicityTbl tbl = mapper.selectByPrimaryKey(id);
        deleteFile(tbl);
        //删除附件
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
