package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.MjqdyjTbl;
import com.hangyu.platform.web.sysAdmin.mapper.MjqdyjTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MjqdyjTblService {

    @Resource
    private MjqdyjTblMapper mjqdyjTblMapper;

    //单条查询
    public List<MjqdyjTbl> select(int id){
        return mjqdyjTblMapper.select(id);
    }

    //批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<MjqdyjTbl> list = mjqdyjTblMapper.selectAll(start,pageSize);
        int total = mjqdyjTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //添加信息
    @Transactional
    public void  insert(MjqdyjTbl mjqdyjTbl){
        mjqdyjTblMapper.insert(mjqdyjTbl);
    }

    //删除信息
    @Transactional
    public void  delete(List<Integer> list){
        mjqdyjTblMapper.delete(list);
    }

    //修改信息
    @Transactional
    public void  update(MjqdyjTbl mjqdyjTbl){
        mjqdyjTblMapper.update(mjqdyjTbl);
    }

}
