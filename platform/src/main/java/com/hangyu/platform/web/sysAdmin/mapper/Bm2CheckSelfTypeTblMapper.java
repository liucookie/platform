package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfTypeTbl;

import java.util.List;

public interface Bm2CheckSelfTypeTblMapper {

    //总数据量查询
    int selectTotal();

    //条件总数据量查询
    int selectTotals(String typename,String createtime,String endtime,int isinvolve);

    //保密自查类型配批量查询
    List<Bm2CheckSelfTypeTbl>  selectAll(int start, int pageSize);

    //保密自查类型条件查询
    List<Bm2CheckSelfTypeTbl>  factorSelect(String typename, String createtime, String endtime, int isinvolve, int start, int pageSize);

    //保密自查类型添加
    void insert(Bm2CheckSelfTypeTbl bm2CheckselftypeTbl);

    //保密自查类型删除
    void delete(List<String> list);

    //保密自查单条查询
    List<Bm2CheckSelfTypeTbl> select(String typeid);

    //保密自查类型修改
    void update(Bm2CheckSelfTypeTbl bm2CheckselftypeTbl);
}