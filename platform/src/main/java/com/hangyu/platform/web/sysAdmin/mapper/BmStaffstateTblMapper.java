package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmStaffstateTbl;

import java.util.List;

public interface BmStaffstateTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmStaffstateTbl record);

    int insertSelective(BmStaffstateTbl record);


    BmStaffstateTbl selectByPrimaryKey(Integer id);

    List<BmStaffstateTbl> select();



    int updateByPrimaryKeySelective(BmStaffstateTbl record);

    int updateByPrimaryKey(BmStaffstateTbl record);
}