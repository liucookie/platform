package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationlevelTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2KeepsecretqualificationlevelTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSecretManageService {


    @Resource
    private Bm2KeepsecretqualificationlevelTblMapper mapper;

    /**
     * 查询信息安全软件类别
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2KeepsecretqualificationlevelTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个信息安全软件类别
     *
     * @param id
     * @return
     */
    public Bm2KeepsecretqualificationlevelTbl queryById(String id) {
        Bm2KeepsecretqualificationlevelTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加信息安全软件类别
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2KeepsecretqualificationlevelTbl type) {

        type.setQualificationlevelid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改信息安全软件类别
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2KeepsecretqualificationlevelTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改信息安全软件类别
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
