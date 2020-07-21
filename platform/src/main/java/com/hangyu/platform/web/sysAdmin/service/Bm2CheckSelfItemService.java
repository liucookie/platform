package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfItemTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfTypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckSelfItemTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2CheckSelfItemService {

    @Resource
    private Bm2CheckSelfItemTblMapper bm2CheckselfitemTblMapper;

    //保密自查检查项批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2CheckSelfItemTbl> list = bm2CheckselfitemTblMapper.selectAll(start,pageSize);
        int total = bm2CheckselfitemTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //保密自查检查项条件查询
    public Map<String,Object> factorSelect(String itemname,String createtime,String endtime,String typeid,int pageNum,int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2CheckSelfItemTbl> list = bm2CheckselfitemTblMapper.factorSelect(itemname,createtime,endtime,typeid,start,pageSize);
        int total = bm2CheckselfitemTblMapper.selectTotals(itemname,createtime,endtime,typeid);
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //查询保密自查类型名和id
    public List<Bm2CheckSelfTypeTbl> typeSelect(){
        return bm2CheckselfitemTblMapper.typeSelect();
    }

    //保密自查检查项添加
    @Transactional
    public void insert(Bm2CheckSelfItemTbl bm2CheckselfitemTbl){
        bm2CheckselfitemTblMapper.insert(bm2CheckselfitemTbl);
    }

    //保密自查检查项删除
    @Transactional
    public void delete(List<String> list){
        bm2CheckselfitemTblMapper.delete(list);
    }

    //查询单条信息
    public List<Bm2CheckSelfItemTbl> select(String itemid){
        return bm2CheckselfitemTblMapper.select(itemid);
    }

    //保密自查检查项修改
    @Transactional
    public void update(Bm2CheckSelfItemTbl bm2CheckselfitemTbl){
        bm2CheckselfitemTblMapper.update(bm2CheckselfitemTbl);
    }

}
