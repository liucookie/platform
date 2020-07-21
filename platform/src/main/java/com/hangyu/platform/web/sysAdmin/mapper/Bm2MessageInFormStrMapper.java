package com.hangyu.platform.web.sysAdmin.mapper;


import com.hangyu.platform.web.sysAdmin.dto.Bm2MessagebasicinfoTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MessageinformstrTbl;

import java.util.List;

public interface Bm2MessageInFormStrMapper {

    //总数据量查询
    int selectTotal(int type);

    //邮件基本设置查询
    List<Bm2MessagebasicinfoTbl> basicSelect(int type);

    //邮件基本信息修改
    void  basicUpdate(Bm2MessagebasicinfoTbl bm2MessagebasicinfoTbl);

    //批量查询
    List<Bm2MessageinformstrTbl> selectAll(int start,int pageSize,int type);

    //添加
    void insert(Bm2MessageinformstrTbl bm2MessageinformstrTbl);

    //删除
    void delete(List<String> list);

    //单条查询
    List<Bm2MessageinformstrTbl> select(String id);

    //修改
    void update(Bm2MessageinformstrTbl bm2MessageinformstrTbl);

}