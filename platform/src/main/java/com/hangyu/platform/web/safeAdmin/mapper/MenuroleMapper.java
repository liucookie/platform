package com.hangyu.platform.web.safeAdmin.mapper;

import com.hangyu.platform.web.safeAdmin.dto.Menurole;

import java.util.List;

public interface MenuroleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menurole record);

    int insertSelective(Menurole record);


    Menurole selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Menurole record);

    int updateByPrimaryKey(Menurole record);

    //批量插入数据
    int insertBatch(List<Menurole> list);

    int deleteByRoleId(int roleid);
}