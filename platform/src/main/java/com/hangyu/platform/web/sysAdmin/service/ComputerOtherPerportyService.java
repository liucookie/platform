package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.ComputerotherpropertyTbl;
import com.hangyu.platform.web.sysAdmin.mapper.ComputerotherpropertyTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComputerOtherPerportyService {


    @Resource
    private ComputerotherpropertyTblMapper computerMapper;

    /**
     * 查询计算机其他属性
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object>  queryOtherProperty(int pageNum, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<ComputerotherpropertyTbl> list = computerMapper.queryProperty(start, pageSize);
        int total = computerMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    /**
     * 查询单个计算机其他属性
     *
     * @param id
     * @return
     */
    public ComputerotherpropertyTbl queryById(String id) {
        return computerMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加计算机其他属性
     * @param computer
     */
    @Transactional
    public void addProperty(ComputerotherpropertyTbl computer){

        computer.setComputerpropertyid(CommonUtils.generateUUID());
        computerMapper.insert(computer);
    }

    /**
     * 修改计算机其他属性
     * @param computer
     */
    @Transactional
    public void updateProperty(ComputerotherpropertyTbl computer){

        computerMapper.updateByPrimaryKeySelective(computer);
    }


    /**
     * 修改计算机设备其他属性
     * @param id
     */
    @Transactional
    public void deleteProperty(String id){

        computerMapper.deleteByPrimaryKey(id);
    }


}
