package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Basetype;

import java.util.List;

public interface BasetypeMapper {


    int deleteByPrimaryKey(String typeid);

    int insert(Basetype record);

    int insertSelective(Basetype record);


    Basetype selectByPrimaryKey(String typeid);

    List<Basetype> select();

    int updateByPrimaryKeySelective(Basetype record);

    int updateByPrimaryKey(Basetype record);
}