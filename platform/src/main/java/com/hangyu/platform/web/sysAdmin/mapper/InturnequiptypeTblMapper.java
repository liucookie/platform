package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.InturnequiptypeTbl;

import java.util.List;


public interface InturnequiptypeTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(InturnequiptypeTbl record);

    int insertSelective(InturnequiptypeTbl record);



    InturnequiptypeTbl selectByPrimaryKey(String id);

    List<InturnequiptypeTbl> selectAllType(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(InturnequiptypeTbl record);

    int updateByPrimaryKey(InturnequiptypeTbl record);
}