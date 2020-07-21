package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FriendlySoftTypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FriendlySoftTypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2FriendlySoftTypeService {

    @Resource
    private Bm2FriendlySoftTypeTblMapper bm2FriendlysofttypeTblMapper;

    //软件白名单类型管理批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2FriendlySoftTypeTbl> list = bm2FriendlysofttypeTblMapper.selectAll(start,pageSize);
        int total = bm2FriendlysofttypeTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //软件白名单管理添加
    @Transactional
    public  void insert(Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl){
        bm2FriendlysofttypeTblMapper.insert(bm2FriendlysofttypeTbl);
    }

    //软件白名单管理删除
    @Transactional
    public  void delete(List<String> list){
        bm2FriendlysofttypeTblMapper.delete(list);
    }

    //软件白名单单条查询
    public List<Bm2FriendlySoftTypeTbl> select(String typeid){
        return bm2FriendlysofttypeTblMapper.select(typeid);
    }

    //软件白名单管理修改
    @Transactional
    public  void update(Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl){
        bm2FriendlysofttypeTblMapper.update(bm2FriendlysofttypeTbl);
    }

}
