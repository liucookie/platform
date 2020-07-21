package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Usestate;

import java.util.List;


public interface UsestateMapper {


    int deleteByPrimaryKey(String id);

    int insert(Usestate record);

    int insertSelective(Usestate record);

    Usestate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Usestate record);

    int updateByPrimaryKey(Usestate record);

    List<Usestate> selectAllByPage(int start,int pageSize);

    int selectTotal();
}