package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.NationalsecurityTbl;
import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoUsers;
import com.hangyu.platform.web.backBusiness.mapper.NationalsecurityTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国家安全技术检测管理
 *
 * @auther liuXuan
 * @date 2020/2/11
 */
@Service
public class NationalSecurityService {

    @Resource
    private NationalsecurityTblMapper mapper;


    /**
     * 查询所有国家安全技术检测
     *
     * @return
     */
    public Map<String, Object> query(String orgName, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<NationalsecurityTbl> list = mapper.select(orgName, start, pageSize);
        int total = mapper.selectTotal(orgName).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @param orgId
     * @return
     */
    public List<NationalsecurityTbl> exportExcel(String orgId) {
        List<NationalsecurityTbl> list = mapper.selectTotal(orgId);
        return list;
    }


    /**
     * 查询单个数据
     *
     * @param id
     * @return
     */
    public NationalsecurityTbl queryById(String id) {
        NationalsecurityTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(NationalsecurityTbl info, MultipartFile file) throws IOException {
        //上传文件
        if (null != file){
            String url = FileUtils.uploads(file);
            info.setRfilename(url);
        }
        String uniqueId = CommonUtils.generateUUID();
        info.setUniqueid(uniqueId);
        mapper.insert(info);
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(NationalsecurityTbl info, MultipartFile file) throws IOException {
        if (null != file) {
            //上传文件
            String url = FileUtils.uploads(file);
            info.setRfilename(url);
        }
        mapper.updateByPrimaryKey(info);

    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        NationalsecurityTbl tbl = mapper.selectByPrimaryKey(id);
        //删除附件
        if (StringUtils.isNotEmpty(tbl.getRfilename())){
            FileUtils.deleteFile(tbl.getRfilename());
        }
        mapper.deleteByPrimaryKey(id);

    }
}
