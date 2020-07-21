package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmVouchinfoTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmVouchinfoTblMapper;
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
 * 应知应会管理
 *
 * @auther liuXuan
 * @date 2020/3/3
 */
@Service
public class BmVouchInfoService {

    @Resource
    private BmVouchinfoTblMapper mapper;


    /**
     * 查询所有应知应会
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmVouchinfoTbl> list = mapper.select(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询所有应知应会(不分页)
     *
     * @param name
     * @return
     */
    public List<BmVouchinfoTbl> queryIsSign(String name) {
        List<BmVouchinfoTbl> list = mapper.queryIsSign(name);
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmVouchinfoTbl queryById(String id) {
        BmVouchinfoTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmVouchinfoTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {
        tbl.setVouchinfoid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setPicture(picUrl);
        }
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param resourcelibTbl
     */
    @Transactional
    public void update(BmVouchinfoTbl resourcelibTbl, MultipartFile file, MultipartFile picture) throws IOException {
        //查询出附件信息
        BmVouchinfoTbl tbl = mapper.selectByPrimaryKey(resourcelibTbl.getVouchinfoid());
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
            if (StringUtils.isNotEmpty(tbl.getPicture())) {
                FileUtils.deleteStaticFile(tbl.getPicture());
            }
            String picUrl = FileUtils.uploadStaticFile(picture);
            resourcelibTbl.setPicture(picUrl);
        }
        mapper.updateByPrimaryKey(resourcelibTbl);
    }

    /**
     * 置顶
     *
     * @param list
     */
    public void setTopSign(List<BmVouchinfoTbl> list) {
        //先将原来的数据都不置顶
        mapper.cancelTop();
        list.forEach(tbl -> {
            tbl.setTopsign(1);
            mapper.updateByPrimaryKey(tbl);
        });

    }

    /**
     * 删除原来附件
     */
    private void deleteFile(String id) throws IOException {
        //查询出附件信息
        BmVouchinfoTbl tbl = mapper.selectByPrimaryKey(id);
        if (null != tbl) {
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getPicture())) {
                FileUtils.deleteStaticFile(tbl.getPicture());
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
