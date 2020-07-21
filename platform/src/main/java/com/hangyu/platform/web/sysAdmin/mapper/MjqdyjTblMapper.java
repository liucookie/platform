package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.MjqdyjTbl;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MjqdyjTblMapper {

    //总数据量
    int selectTotal();

    //单条查询
    List<MjqdyjTbl> select(int id);

    //批量查询
    List<MjqdyjTbl> selectAll(int start,int pageSize);

    //添加信息
    void  insert(MjqdyjTbl mjqdyjTbl);

    //删除信息
    void  delete(List<Integer> list);

    //修改信息
    void  update(MjqdyjTbl mjqdyjTbl);

}