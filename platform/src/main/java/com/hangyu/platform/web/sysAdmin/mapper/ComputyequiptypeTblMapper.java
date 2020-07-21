package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.ComputyequiptypeTbl;

import java.util.List;


public interface ComputyequiptypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(ComputyequiptypeTbl record);

    int insertSelective(ComputyequiptypeTbl record);

    ComputyequiptypeTbl selectByPrimaryKey(String id);

    List<ComputyequiptypeTbl> selectAllType(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(ComputyequiptypeTbl record);

    int updateByPrimaryKey(ComputyequiptypeTbl record);
}