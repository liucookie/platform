package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmFormcommonlinkTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmFormcommonlinkTblMapper;
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
 * 保密表单链接管理
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Service
public class BmFormCommonLinkService {

    @Resource
    private BmFormcommonlinkTblMapper mapper;


    /**
     * 查询所有保密表单链接管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmFormcommonlinkTbl> list = mapper.select(start, pageSize);
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
    public BmFormcommonlinkTbl queryById(String id) {
        BmFormcommonlinkTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmFormcommonlinkTbl tbl, MultipartFile file) throws IOException {
        tbl.setUniqueid(CommonUtils.generateUUID());
        //上传附件
        if (null != file) {
            String fileUrl = FileUtils.uploadStaticFile(file);
            tbl.setLinkicon(fileUrl);
        }
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmFormcommonlinkTbl tbl, MultipartFile file) throws IOException {
        //上传附件
        if (null != file) {
            //删除附件
            deleteFile(tbl);
            String fileUrl = FileUtils.uploadStaticFile(file);
            tbl.setLinkicon(fileUrl);
        }
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除附件
     *
     * @param tbl
     */
    private void deleteFile(BmFormcommonlinkTbl tbl) throws IOException{
        if (StringUtils.isNotEmpty(tbl.getLinkicon())) {
            FileUtils.deleteStaticFile(tbl.getLinkicon());
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
        BmFormcommonlinkTbl tbl = mapper.selectByPrimaryKey(id);
        deleteFile(tbl);
        mapper.deleteByPrimaryKey(id);
    }


}
