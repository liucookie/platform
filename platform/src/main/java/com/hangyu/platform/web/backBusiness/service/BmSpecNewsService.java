package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmPictureTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSpecnewsTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmPictureTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSpecnewsTblMapper;
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
 * 百叶窗信息管理
 *
 * @auther liuXuan
 * @date 2020/3/3
 */
@Service
public class BmSpecNewsService {

    @Resource
    private BmSpecnewsTblMapper mapper;

    @Resource
    private BmPictureTblMapper picMapper;


    /**
     * 查询所有百叶窗信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSpecnewsTbl> list = mapper.select(start, pageSize);
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
    public BmSpecnewsTbl queryById(String id) {
        BmSpecnewsTbl tbl = mapper.selectByPrimaryKey(id);
        //处理导入的图片
        String importPic = tbl.getImportpictures();
        if (StringUtils.isNotEmpty(importPic)){
            List<String> picIds = Arrays.asList(StringUtils.split(importPic, "|"));
            List<BmPictureTbl> list = picMapper.selectBatch(picIds);
            tbl.setPictureTblList(list);
        }
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmSpecnewsTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {
        tbl.setSpecnewsid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setSpecpic(picUrl);
        }
        //处理导入的图片
        dealPciture(tbl);
        mapper.insert(tbl);
    }

    /**
     * 将导入的图片的id，用 | 拼接存储到表
     * @param tbl
     */
    private void dealPciture(BmSpecnewsTbl tbl) {
        //处理导入的图片
        List<BmPictureTbl> pictureTbls = tbl.getPictureTblList();
        if (CollectionUtils.isNotEmpty(pictureTbls)) {
            StringBuilder sb = new StringBuilder();
            for (BmPictureTbl pic : pictureTbls) {
                sb.append(pic.getUniqueid()).append("|");
            }
            tbl.setImportpictures(sb.toString().substring(0, sb.lastIndexOf("|")));
        }
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmSpecnewsTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {
        //上传附件
        if (null != file) {
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getSpecpic())) {
                FileUtils.deleteStaticFile(tbl.getSpecpic());
            }
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setSpecpic(picUrl);
        }
        dealPciture(tbl);
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(String id)  throws  IOException{
        //查询出附件信息
        BmSpecnewsTbl tbl = mapper.selectByPrimaryKey(id);
        if (null != tbl) {
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getSpecpic())) {
                FileUtils.deleteStaticFile(tbl.getSpecpic());
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

    /**
     * 删除
     *
     * @param id
     * @param status 0未发布，1已发布
     */
    @Transactional
    public void isPublish(String id,int status) {
        mapper.isPublish(id,status);
    }
}
