package com.hangyu.platform.web.sysAdmin.mapper;


import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfItemTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfTypeTbl;

import java.util.List;

public interface Bm2CheckSelfItemTblMapper {

    //总数据量查询
    int selectTotal();

    //条件查询总数据量
    int selectTotals(String itemname,String createtime,String endtime,String typeid);

    //保密检查项批量查询
    List<Bm2CheckSelfItemTbl> selectAll(int start, int pageSize);

    //保密自查检查项条件查询
    List<Bm2CheckSelfItemTbl> factorSelect(String itemname,String createtime,String endtime,String typeid,int start,int pageSize);

    //查询保密自查类型名和id
    List<Bm2CheckSelfTypeTbl> typeSelect();

    //保密检查项添加
    void insert(Bm2CheckSelfItemTbl bm2CheckselfitemTbl);

    //保密检查项删除
    void delete(List<String> list);

    //查询单条信息
    List<Bm2CheckSelfItemTbl> select(String itemid);

    //保密检查项修改
    void update(Bm2CheckSelfItemTbl bm2CheckselfitemTbl);

}