package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Basecode;

import java.util.List;


public interface BasecodeMapper {


    int deleteByPrimaryKey(String id);

    int insert(Basecode record);

    int insertSelective(Basecode record);


    Basecode selectByPrimaryKey(String id);

    List<Basecode> select(String id,int start,int pageSize);

    List<Basecode> queryAll(String id);

    int selectTotal(String id);

    int updateByPrimaryKeySelective(Basecode record);

    int updateByPrimaryKey(Basecode record);

    String queryIdByName(String name);
}