package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Connectwaytypelist;
import com.hangyu.platform.web.sysAdmin.mapper.ConnectwaytypelistMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConnectWayTypeListService {

    @Resource
    private ConnectwaytypelistMapper connectwaytypelistMapper;

    //单条查询
    public List<Connectwaytypelist> select(int id){
        return connectwaytypelistMapper.select(id);
    }

    //批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Connectwaytypelist> list = connectwaytypelistMapper.selectAll(start,pageSize);
        int total =  connectwaytypelistMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //条件模糊查询
    public Map<String,Object> factorSelect(int pageNum,int pageSize,String typename){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Connectwaytypelist> list = connectwaytypelistMapper.factorSelect(start,pageSize,typename);
        int total = connectwaytypelistMapper.selectTotals(typename);
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //添加
    @Transactional
    public void insert(Connectwaytypelist connectwaytypelist){
        connectwaytypelistMapper.insert(connectwaytypelist);
    }

    //删除
    @Transactional
    public void delete(List<Integer> list){
        connectwaytypelistMapper.delete(list);
    }
    //修改
    @Transactional
    public void update(Connectwaytypelist connectwaytypelist){
        connectwaytypelistMapper.update(connectwaytypelist);
    }

}
