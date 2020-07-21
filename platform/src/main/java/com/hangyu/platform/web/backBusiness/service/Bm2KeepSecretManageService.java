package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2KeepsecretqualificationstatisticTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2KeepsecretqualificationstatisticTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSecsoftverTblMapper;
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
 * 外协单位保密资质管理
 *
 * @auther liuXuan
 * @date 2020/3/9
 */
@Service
public class Bm2KeepSecretManageService {

    @Resource
    private Bm2KeepsecretqualificationstatisticTblMapper mapper;


    /**
     * 查询所有外协单位保密资质
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(String orgName, String type, String levelId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2KeepsecretqualificationstatisticTbl> list = mapper.select(orgName, type,levelId, start, pageSize);
        int total = mapper.selectCount(orgName, type,levelId);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    public Bm2KeepsecretqualificationstatisticTbl queryById(String id){
        return mapper.selectByPrimaryKey(id);
    }
    /**
     * 导出外协单位保密资质
     *
     * @return
     */
    public List<Bm2KeepsecretqualificationstatisticTbl> exportExcel(String orgName, String type, String levelId) {
        List<Bm2KeepsecretqualificationstatisticTbl> list = mapper.exportExcel(orgName, type,levelId);
        return list;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Bm2KeepsecretqualificationstatisticTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {
        tbl.setUniqueid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            //处理数据库存储的字段
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setCertificatephoto( picUrl);
        }
        //将软件信息加入到主表
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Bm2KeepsecretqualificationstatisticTbl tbl, MultipartFile file, MultipartFile picture) throws IOException {

        //上传附件
        if (null != file) {
            //删除原来的附件
            FileUtils.deleteFile(tbl.getFileurl());
            String fileUrl = FileUtils.uploads(file);
            //处理数据库存储的字段
            tbl.setFileurl(fileUrl);
        }
        //上传图片
        if (null != picture) {
            FileUtils.deleteStaticFile(tbl.getCertificatephoto());
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setCertificatephoto(picUrl);
        }
        //更新主表
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(Bm2KeepsecretqualificationstatisticTbl tbl) throws IOException {
        //删除附件
        if (StringUtils.isNotEmpty(tbl.getFileurl())) {
            FileUtils.deleteFile(tbl.getFileurl());
        }
        //删除图片
        if (StringUtils.isNotEmpty(tbl.getCertificatephoto())) {
            FileUtils.deleteStaticFile(tbl.getCertificatephoto());
        }
    }



    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void deleteDetail(String id) throws IOException{
        //删除文件
        Bm2KeepsecretqualificationstatisticTbl tbl = mapper.selectByPrimaryKey(id);
        deleteFile(tbl);
        //删除详情表
        mapper.deleteByPrimaryKey(id);
    }
}
