package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfTypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckSelfTypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2CheckSelfTypeService {

    @Resource
    private Bm2CheckSelfTypeTblMapper bm2CheckselftypeTblMapper;

    //保密自查类型配批量查询
    public Map<String,Object> selectAll(int pageNum,int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2CheckSelfTypeTbl> list = bm2CheckselftypeTblMapper.selectAll(start,pageSize);
        int total = bm2CheckselftypeTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return  map;
    }

    //保密自查类型条件查询
    public Map<String,Object>  factorSelect(String typename,String createtime,String endtime,int isinvolve,int pageNum,int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2CheckSelfTypeTbl> list = bm2CheckselftypeTblMapper.factorSelect(typename,createtime,endtime,isinvolve,start,pageSize);
        int total = bm2CheckselftypeTblMapper.selectTotals(typename,createtime,endtime,isinvolve);
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //保密自查类型添加
    @Transactional
    public void insert(Bm2CheckSelfTypeTbl bm2CheckselftypeTbl){
        bm2CheckselftypeTblMapper.insert(bm2CheckselftypeTbl);
    }

    //保密自查类型删除
    @Transactional
    public void delete(List<String> list){
        bm2CheckselftypeTblMapper.delete(list);
    }

    //保密自查单条查询
    public List<Bm2CheckSelfTypeTbl> select(String itemid){
        return bm2CheckselftypeTblMapper.select(itemid);
    }

    //保密自查类型修改
    @Transactional
    public void update(Bm2CheckSelfTypeTbl bm2CheckselftypeTbl){
        bm2CheckselftypeTblMapper.update(bm2CheckselftypeTbl);
    }

}
