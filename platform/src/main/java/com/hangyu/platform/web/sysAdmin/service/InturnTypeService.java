package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.InturnequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.InturnequiptypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InturnTypeService {



    @Resource
    private InturnequiptypeTblMapper typeMapper;

    /**
     * 查询中转机设备类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryType(int pageNum, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<InturnequiptypeTbl> list = typeMapper.selectAllType(start, pageSize);
        int total = typeMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    /**
     * 查询单个中转机设备类型
     *
     * @param id
     * @return
     */
    public InturnequiptypeTbl queryById(String id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加中转机设备类型
     * @param type
     */
    @Transactional
    public void addType(InturnequiptypeTbl type){

        type.setUniqueid(CommonUtils.generateUUID());
        typeMapper.insert(type);
    }

    /**
     * 修改中转机设备类型
     * @param type
     */
    @Transactional
    public void updateType(InturnequiptypeTbl type){

        typeMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改中转机设备类型
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        typeMapper.deleteByPrimaryKey(id);
    }


}
