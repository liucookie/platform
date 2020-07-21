package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmInfotypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmInfotypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmInfoTypeService {



    @Resource
    private BmInfotypeTblMapper typeMapper;

    /**
     * 查询所有保密知识库分类
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryType(int pageNum, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmInfotypeTbl> list = typeMapper.selectAllType(start, pageSize);
        int total = typeMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    /**
     * 查询单个保密知识库分类
     *
     * @param id
     * @return
     */
    public BmInfotypeTbl queryById(String id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加保密知识库分类
     * @param type
     */
    @Transactional
    public void addType(BmInfotypeTbl type){

        type.setTypeid(CommonUtils.generateUUID());
        typeMapper.insert(type);
    }

    /**
     * 修改保密知识库分类
     * @param type
     */
    @Transactional
    public void updateType(BmInfotypeTbl type){

        typeMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改保密知识库分类
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        typeMapper.deleteByPrimaryKey(id);
    }


}
