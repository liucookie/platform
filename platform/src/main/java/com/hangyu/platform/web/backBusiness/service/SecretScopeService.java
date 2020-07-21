package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2FriendlysoftwareTbl;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolscopeTbl;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolscopeTbl;
import com.hangyu.platform.web.backBusiness.mapper.SecretcontrolscopeTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.SecretcontrolscopeTblMapper;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国家秘密范围目录管理
 * @auther  liuXuan
 * @date 2020/2/7
 */
@Service
public class SecretScopeService {

    @Resource
    private SecretcontrolscopeTblMapper mapper;

    @Resource
    private BasecodeMapper basecodeMapper;

    /**
     * 查询所有国家秘密范围目录
     *
     * @param 
     * @return
     */
    public Map<String, Object> query(String levelId,String keyWord,int pageNum,int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<SecretcontrolscopeTbl> list = mapper.select(levelId,keyWord,start,pageSize);
        int total = mapper.selectTotal(levelId,keyWord);
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
    public SecretcontrolscopeTbl queryById(String id) {
        SecretcontrolscopeTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(SecretcontrolscopeTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param avidmLevelintegrate
     */
    @Transactional
    public void update(SecretcontrolscopeTbl avidmLevelintegrate) {
        mapper.updateByPrimaryKeySelective(avidmLevelintegrate);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(String id){
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有国家秘密范围目录
     *
     * @param
     * @return
     */
    public List<SecretcontrolscopeTbl> exportExcel(String levelId,String keyWord) {
        List<SecretcontrolscopeTbl> list = mapper.exportExcel(levelId,keyWord);
        return list;
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            SecretcontrolscopeTbl info = new SecretcontrolscopeTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String typeName = (String) list.get(i)[0];
            info.setTypenamer(basecodeMapper.queryIdByName(typeName));
            info.setNamer((String) list.get(i)[1]);
            String levelName = (String) list.get(i)[2];
            info.setSecretlevelid(levelName);
            info.setKeepsecretdate((String) list.get(i)[3]);
            info.setScope((String) list.get(i)[4]);
            info.setRemarkr((String) list.get(i)[5]);
            mapper.insert(info);
        }
    }
}
