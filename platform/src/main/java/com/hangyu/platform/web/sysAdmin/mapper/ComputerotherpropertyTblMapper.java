package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.ComputerotherpropertyTbl;

import java.util.List;

public interface ComputerotherpropertyTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(ComputerotherpropertyTbl record);

    int insertSelective(ComputerotherpropertyTbl record);


    ComputerotherpropertyTbl selectByPrimaryKey(String id);

    List<ComputerotherpropertyTbl> queryProperty(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(ComputerotherpropertyTbl record);

    int updateByPrimaryKey(ComputerotherpropertyTbl record);
}