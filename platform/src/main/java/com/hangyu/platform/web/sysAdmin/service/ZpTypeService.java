package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.ZptypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.ZptypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZpTypeService {

    @Resource
    private ZptypeTblMapper zptypeTblMapper;

    //单条查询
    public List<ZptypeTbl> select(int id){
        return zptypeTblMapper.select(id);
    }

    //批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<ZptypeTbl> list = zptypeTblMapper.selectAll(start,pageSize);
        int total = zptypeTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //添加信息
    @Transactional
    public void insert(ZptypeTbl zptypeTbl){
        zptypeTblMapper.insert(zptypeTbl);
    }

    //删除信息
    @Transactional
    public void delete(List<Integer> list){
        zptypeTblMapper.delete(list);
    }

    //修改信息
    @Transactional
    public void update(ZptypeTbl zptypeTbl){
        zptypeTblMapper.update(zptypeTbl);
    }

}
