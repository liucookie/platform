package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSecsoftTblMapper;
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
 * 信息安全软件管理
 *
 * @auther liuXuan
 * @date 2020/3/9
 */
@Service
public class BmSecSoftManageService {

    @Resource
    private BmSecsoftTblMapper mapper;

    @Resource
    private BmSecsoftverTblMapper softMapper;


    /**
     * 查询所有信息安全软件
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSecsoftTbl> list = mapper.select(start, pageSize);
        list.forEach(tbl->{
            //查询出 最新的版本号和描述
            BmSecsoftverTbl softTbl =  softMapper.selectNewSoft(tbl.getUniqueid());
            if (null != softTbl){
                tbl.setVersion(softTbl.getVersion());
                tbl.setDesc(softTbl.getSoftdesc());
            }
        });

        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 根据type查询所有的软件
     * @param type
     * @return
     */
    public   List<BmSecsoftTbl> queryByType(String type){
        List<BmSecsoftTbl> list = mapper.queryByType(type);
        list.forEach(tbl->{
            //查询出 最新的版本号和描述
            BmSecsoftverTbl softTbl =  softMapper.selectNewSoft(tbl.getUniqueid());
            if (null != softTbl){
                tbl.setVersion(softTbl.getVersion());
                tbl.setDesc(softTbl.getSoftdesc());
                tbl.setUpdateDate(softTbl.getUpdatedate());
            }
        });
        return list;
    }

    /**
     * 查询安全软件下的列表
     *
     * @return
     */
    public  List<BmSecsoftverTbl> downloadSoft(String id) {
        List<BmSecsoftverTbl> list = softMapper.selectById(id);
//        for (BmSecsoftverTbl tbl : list){
//            //返回图标
//            if (StringUtils.isNotEmpty(tbl.getSofticon())) {
//                tbl.setSofticon(revertUrl(tbl.getSofticon()));
//            }
//            //返回截图
//            if (StringUtils.isNotEmpty(tbl.getSoftpics())) {
//                tbl.setSoftpics(revertUrl(tbl.getSoftpics()));
//            }
//            //返回文件
//            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
//                tbl.setFileurl(revertUrl(tbl.getFileurl()));
//            }
//        }
        return list;
    }

    /**
     * 查询安全软件下的列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryById(String id, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSecsoftverTbl> list = softMapper.select(id, start, pageSize);
//        for (BmSecsoftverTbl tbl : list){
//            //返回图标
//            if (StringUtils.isNotEmpty(tbl.getSofticon())) {
//                tbl.setSofticon(revertUrl(tbl.getSofticon()));
//            }
//            //返回截图
//            if (StringUtils.isNotEmpty(tbl.getSoftpics())) {
//                tbl.setSoftpics(revertUrl(tbl.getSoftpics()));
//            }
//            //返回文件
//            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
//                tbl.setFileurl(revertUrl(tbl.getFileurl()));
//            }
//        }
        int total = softMapper.selectTotal(id);
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
    public BmSecsoftverTbl queryById(String id) {
        //查询出详情信息
        BmSecsoftverTbl tbl = softMapper.selectByPrimaryKey(id);
        //返回图标
//        if (StringUtils.isNotEmpty(tbl.getSofticon())) {
//            tbl.setSofticon(revertUrl(tbl.getSofticon()));
//        }
//        //返回截图
//        if (StringUtils.isNotEmpty(tbl.getSoftpics())) {
//            tbl.setSoftpics(revertUrl(tbl.getSoftpics()));
//        }
//        //返回文件
//        if (StringUtils.isNotEmpty(tbl.getFileurl())) {
//            tbl.setFileurl(revertUrl(tbl.getFileurl()));
//        }
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmSecsoftTbl tbl, MultipartFile file, MultipartFile picture, MultipartFile icon) throws IOException {
        //修改
        if (StringUtils.isNotEmpty(tbl.getUniqueid())){
            BmSecsoftverTbl soft = dealSoft(tbl,file,picture,icon);
            //设置软件id
            soft.setSoftid(tbl.getUniqueid());
            soft.setUniqueid(CommonUtils.generateUUID());
            mapper.updateByPrimaryKey(tbl);
            softMapper.insert(soft);
        }else {
            //判断是新增还是
            String softId = CommonUtils.generateUUID();
            tbl.setUniqueid(softId);
            //将软件信息加入到主表
            mapper.insert(tbl);

            BmSecsoftverTbl soft = dealSoft(tbl,file,picture,icon);
            //设置软件id
            soft.setSoftid(softId);
            soft.setUniqueid(CommonUtils.generateUUID());
            softMapper.insert(soft);
        }


    }

    private BmSecsoftverTbl dealSoft(BmSecsoftTbl tbl,MultipartFile file, MultipartFile picture, MultipartFile icon) throws IOException {
        //添加到详情表中
        BmSecsoftverTbl soft = tbl.getSecSoft();
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploads(file);
            //处理数据库存储的字段
            soft.setFileurl(dealUrl(file.getOriginalFilename(), fileUrl));
        }
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            soft.setSoftpics(dealUrl(picture.getOriginalFilename(), picUrl));
        }
        //上传图标
        if (null != icon) {
            String iconUrl = FileUtils.uploadStaticFile(icon);
            soft.setSofticon(dealUrl(icon.getOriginalFilename(), iconUrl));
        }
        return soft;
    }

    private String revertUrl(String url) {
        String url1 = url.substring(1, url.indexOf("}"));
        String urlName = url1.split(",")[1];
        return urlName;
    }

    private String dealUrl(String name, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(name).append(",").append(url).append("}");
        return sb.toString();
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmSecsoftTbl tbl, MultipartFile file, MultipartFile picture, MultipartFile icon) throws IOException {
        //更新主表
        mapper.updateByPrimaryKey(tbl);

        BmSecsoftverTbl soft = tbl.getSecSoft();
        //上传附件
        if (null != file) {
            //删除原来的附件
            FileUtils.deleteFile(soft.getFileurl());
            String fileUrl = FileUtils.uploads(file);
            //处理数据库存储的字段
            soft.setFileurl(dealUrl(file.getOriginalFilename(), fileUrl));
        }
        //上传图片
        if (null != picture) {
            FileUtils.deleteStaticFile(soft.getSoftpics());
            String picUrl = FileUtils.uploadStaticFile(picture);
            soft.setSoftpics(dealUrl(picture.getOriginalFilename(), picUrl));
        }
        //上传图标
        if (null != icon) {
            FileUtils.deleteStaticFile(soft.getSofticon());
            String iconUrl = FileUtils.uploadStaticFile(icon);
            soft.setSofticon(dealUrl(icon.getOriginalFilename(), iconUrl));
        }
        softMapper.updateByPrimaryKey(soft);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(BmSecsoftverTbl tbl) throws IOException{
            //删除附件
            if (StringUtils.isNotEmpty(tbl.getFileurl())) {
                FileUtils.deleteFile(revertUrl(tbl.getFileurl()));
            }
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getSoftpics())) {
                FileUtils.deleteStaticFile(revertUrl(tbl.getSoftpics()));
            }
            //删除图标
            if (StringUtils.isNotEmpty(tbl.getSofticon())) {
                FileUtils.deleteStaticFile(revertUrl(tbl.getSofticon()));
            }
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException{
        //删除主表
        mapper.deleteByPrimaryKey(id);
        //删除详情表和文件
        List<BmSecsoftverTbl> list = softMapper.selectById(id);
        for (BmSecsoftverTbl soft : list) {
            softMapper.deleteByPrimaryKey(soft.getUniqueid());
            //删除附件
            deleteFile(soft);
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
        BmSecsoftverTbl soft = softMapper.selectByPrimaryKey(id);
        deleteFile(soft);
        //删除详情表
        softMapper.deleteByPrimaryKey(id);
    }
}
