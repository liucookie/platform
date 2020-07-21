package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MessagebasicinfoTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MessageinformstrTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2MessageInFormStrMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2MessageInFormService {

    @Resource
    private Bm2MessageInFormStrMapper bm2MessageinformstrMapper;

    //邮件基本设置查询
    public List<Bm2MessagebasicinfoTbl> basicSelect(int type){
        return bm2MessageinformstrMapper.basicSelect(type);
    }

    //邮件基本信息修改
    public  void basicUpdate(Bm2MessagebasicinfoTbl bm2MessagebasicinfoTbl){
        bm2MessageinformstrMapper.basicUpdate(bm2MessagebasicinfoTbl);
    }

    //批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize,int type){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        map.put("total",bm2MessageinformstrMapper.selectTotal(type));
        map.put("list",bm2MessageinformstrMapper.selectAll(start,pageSize,type));
        return  map;
    }

    //添加
    @Transactional
    public void insert(Bm2MessageinformstrTbl bm2MessageinformstrTbl){
        bm2MessageinformstrTbl.setUniqueid(CommonUtils.generateUUID());
        bm2MessageinformstrMapper.insert(bm2MessageinformstrTbl);
    }

    //删除
    @Transactional
    public void delete(List<String> list){
        bm2MessageinformstrMapper.delete(list);
    }

    //单条查询
    public List<Bm2MessageinformstrTbl> select(String uniqueid){
        return bm2MessageinformstrMapper.select(uniqueid);
    }

    //修改
    @Transactional
    public void update(Bm2MessageinformstrTbl bm2MessageinformstrTbl){
        bm2MessageinformstrMapper.update(bm2MessageinformstrTbl);
    }

}
