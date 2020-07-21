package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationlevelTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationlevelTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2KeepsecretqualificationlevelTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2KeepsecretqualificationtypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSecretTypeManageService {


    @Resource
    private Bm2KeepsecretqualificationtypeTblMapper mapper;

    /**
     * 查询保密资质类型管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2KeepsecretqualificationtypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个保密资质类型管理
     *
     * @param id
     * @return
     */
    public Bm2KeepsecretqualificationtypeTbl queryById(String id) {
        Bm2KeepsecretqualificationtypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加保密资质类型管理
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2KeepsecretqualificationtypeTbl type) {

        type.setQualificationtypeid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保密资质类型管理
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2KeepsecretqualificationtypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除保密资质类型管理
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
