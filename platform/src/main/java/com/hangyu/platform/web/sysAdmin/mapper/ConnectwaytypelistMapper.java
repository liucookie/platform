package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Connectwaytypelist;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectwaytypelistMapper {

    //总数据量
    int selectTotal();

    //模糊查询总数据量
    int selectTotals(String typename);

    //单条查询
    List<Connectwaytypelist> select(int id);

    //批量查询
    List<Connectwaytypelist> selectAll(int start,int pageSize);

    //条件模糊查询
    List<Connectwaytypelist> factorSelect(int start,int pageSize,String typename);

    //添加
    void insert(Connectwaytypelist connectwaytypelist);

    //删除
    void delete(List<Integer> list);

    //修改
    void update(Connectwaytypelist connectwaytypelist);
}