package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSlsetsendfileTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSlsetsendfilefileTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSlsetsendfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSlsetsendfilefileTblMapper;
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
 * 定密责任人发文
 *
 * @auther liuXuan
 * @date 2020/2/13
 */
@Service
public class BmSetFileService {

    @Resource
    private BmSlsetsendfileTblMapper mapper;

    @Resource
    private BmSlsetsendfilefileTblMapper fileMapper;


    /**
     * 查询所有发文
     *
     * @return
     */
    public Map<String, Object> query(String name, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSlsetsendfileTbl> list = mapper.select(name, start, pageSize);
        for (BmSlsetsendfileTbl tbl : list){
            BmSlsetsendfilefileTbl fileTbl = fileMapper.selectBySetId(tbl.getUniqueid());
            if (null != fileTbl){
                //设置文件名称
                tbl.setFileName(fileTbl.getFilename());
                tbl.setFileUrl(fileTbl.getFileurl());
            }
        }
        int total = mapper.selectTotal(name);
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
    public BmSlsetsendfileTbl queryById(String id) {
        BmSlsetsendfileTbl tbl = mapper.selectByPrimaryKey(id);
        BmSlsetsendfilefileTbl fileTbl = fileMapper.selectBySetId(tbl.getUniqueid());
        if (null != fileTbl){
            //设置文件名称
            tbl.setFileName(fileTbl.getFilename());
            tbl.setFileUrl(fileTbl.getFileurl());
        }
        return tbl;
    }

    /**
     * 查询历史记录
     *
     * @param id
     * @return
     */
    public List<BmSlsetsendfileTbl> queryHistoryById(String id) {
        List<BmSlsetsendfileTbl> list = mapper.selectHistory(id);
        for (BmSlsetsendfileTbl tbl : list){
            //查询附件信息
            BmSlsetsendfilefileTbl fileTbl = fileMapper.selectBySetId(tbl.getUniqueid());
            if (null != fileTbl){
                //设置文件名称
                tbl.setFileName(fileTbl.getFilename());
                tbl.setFileUrl(fileTbl.getFileurl());
            }
        }
        return list;
    }

    /**
     * 删除历史记录
     *
     * @param id
     */
    @Transactional
    public void deleteHistory(String id) {
        mapper.deleteHistory(id);
    }


    /**
     * 增加
     * ishistory 0 历史版本，1 非历史版本
     * @param info
     */
    @Transactional
    public void add(BmSlsetsendfileTbl info, MultipartFile file) throws IOException {
        String setId = CommonUtils.generateUUID();
        //上传文件
        if (null != file) {
            addFile(setId, file);
        }
        //默认为非历史版本
        info.setIshistory(1);
        info.setUniqueid(setId);
        mapper.insert(info);

    }

    /**
     * 存储到文件表
     *
     * @param setId
     * @param file
     * @throws IOException
     */
    private void addFile(String setId, MultipartFile file) throws IOException {
        String url = FileUtils.uploads(file);
        String name = file.getOriginalFilename();
        BmSlsetsendfilefileTbl fileTbl = new BmSlsetsendfilefileTbl();
        fileTbl.setUniqueid(CommonUtils.generateUUID());
        fileTbl.setSendfid(setId);
        fileTbl.setFilename(name);
        fileTbl.setFileurl(url);
        //存储到附件表
        fileMapper.insert(fileTbl);
    }

    /**
     * 修改
     * ishistory 0 历史版本，1 非历史版本
     * @param info
     */
    @Transactional
    public void update(BmSlsetsendfileTbl info, int type, MultipartFile file) throws IOException {
        //上传文件
        if (null != file) {
            //先删除文件表中的 数据，再新增
            fileMapper.deleteByPrimaryKey(info.getUniqueid());
            BmSlsetsendfilefileTbl tbl = fileMapper.selectBySetId(info.getUniqueid());
            if (null != tbl) {
                //删除文件
                FileUtils.deleteFile(tbl.getFileurl());
            }
            addFile(info.getUniqueid(), file);
        }
        //0则更新为历史版本
        if (type == 0) {
            info.setIsdelete(1);
            //先更新原来的为历史版本 ishistory 1 1
            info.setIshistory(1);
            mapper.deleteByPrimaryKey(info.getUniqueid());

            //新增加一条数据
            info.setIshistory(0);
            //初始化递增主键
            info.setId(null);
            mapper.insert(info);
        }else {
            mapper.updateByPrimaryKey(info);
        }

    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
        //删除附件表的数据，以及文件
        fileMapper.deleteByPrimaryKey(id);
        BmSlsetsendfilefileTbl tbl = fileMapper.selectBySetId(id);
        if (null != tbl) {
            //删除文件
            FileUtils.deleteFile(tbl.getFileurl());
        }
    }

}
