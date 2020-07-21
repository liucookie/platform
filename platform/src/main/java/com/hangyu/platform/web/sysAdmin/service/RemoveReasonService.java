package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.RemovereasonTbl;
import com.hangyu.platform.web.sysAdmin.mapper.RemovereasonTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RemoveReasonService {

    @Resource
    private RemovereasonTblMapper removereasonTblMapper;

    //单条查询
    public List<RemovereasonTbl> select(int id){
        return removereasonTblMapper.select(id);
    }

    //批量查询
    public Map<String,Object> selectAll(int pageNum,int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<RemovereasonTbl> list = removereasonTblMapper.selectAll(start,pageSize);
        int total = removereasonTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //添加
    @Transactional
    public void  insert(RemovereasonTbl removereasonTbl){
        removereasonTblMapper.insert(removereasonTbl);
    }

    //删除
    @Transactional
    public void  delete(List<Integer> id){
        removereasonTblMapper.delete(id);
    }

    //修改
    @Transactional
    public void  update(RemovereasonTbl removereasonTbl){
        removereasonTblMapper.update(removereasonTbl);
    }

}
