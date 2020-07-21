package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.ComputerpropertyTbl;

import java.util.List;


public interface ComputerpropertyTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(ComputerpropertyTbl record);

    int insertSelective(ComputerpropertyTbl record);


    ComputerpropertyTbl selectByPrimaryKey(String id);

    List<ComputerpropertyTbl> queryProperty(int start,int pageSize);

    int selectTotal();



    int updateByPrimaryKeySelective(ComputerpropertyTbl record);

    int updateByPrimaryKey(ComputerpropertyTbl record);
}