package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.X5User;


public interface X5UserMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(X5User record);


    X5User selectByPrimaryKey(Integer id);

    X5User selectByBmStaffId(String id);

    X5User selectByX5Id(String x5Id);


    int updateByPrimaryKey(X5User record);
}