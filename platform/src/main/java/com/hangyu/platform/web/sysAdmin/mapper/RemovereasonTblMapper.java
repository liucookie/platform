package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.RemovereasonTbl;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemovereasonTblMapper {

    //总数据量查询
    int selectTotal();

    //单条查询
    List<RemovereasonTbl> select(int id);

    //国家秘密事项解除审批表批量查询
    List<RemovereasonTbl> selectAll(int start,int pageSize);

    //国家秘密事项解除审批表添加
    void insert(RemovereasonTbl removereasonTbl);

    //国家秘密事项解除审批表删除
    void  delete(List<Integer> id);

    //国家秘密事项解除审批表修改
    void  update(RemovereasonTbl removereasonTbl);

}