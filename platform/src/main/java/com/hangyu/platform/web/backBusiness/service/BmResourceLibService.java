package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmResourcelibTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmResourcelibTblMapper;
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
 * 文化资源管理
 *
 * @auther liuXuan
 * @date 2020/3/2
 */
@Service
public class BmResourceLibService {

    @Resource
    private BmResourcelibTblMapper mapper;


    /**
     * 查询所有文化资源
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmResourcelibTbl> list = mapper.select(start, pageSize);
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
    public BmResourcelibTbl queryById(String id) {
        BmResourcelibTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmResourcelibTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {
        tbl.setReslibid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setRespic(picUrl);
        }
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param resourcelibTbl
     */
    @Transactional
    public void update(BmResourcelibTbl resourcelibTbl, MultipartFile file, MultipartFile picture) throws IOException {
        //查询出附件信息
        BmResourcelibTbl tbl = mapper.selectByPrimaryKey(resourcelibTbl.getReslibid());
        //上传附件
        if (null != file) {
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            String fileUrl = FileUtils.uploads(file);
            resourcelibTbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getRespic())) {
                FileUtils.deleteStaticFile(tbl.getRespic());
            }
            String picUrl = FileUtils.uploadStaticFile(picture);
            resourcelibTbl.setRespic(picUrl);
        }
        mapper.updateByPrimaryKey(resourcelibTbl);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(String id) throws IOException {
        //查询出附件信息
        BmResourcelibTbl tbl = mapper.selectByPrimaryKey(id);
        if (null != tbl) {
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getRespic())) {
                FileUtils.deleteStaticFile(tbl.getRespic());
            }
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException{
        deleteFile(id);
        mapper.deleteByPrimaryKey(id);
    }
}
