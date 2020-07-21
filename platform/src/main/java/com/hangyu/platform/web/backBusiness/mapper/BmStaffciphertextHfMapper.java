package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextHf;

import java.util.List;


public interface BmStaffciphertextHfMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmStaffciphertextHf record);

    int insertSelective(BmStaffciphertextHf record);


    BmStaffciphertextHf selectByPrimaryKey(String id);

    List<BmStaffciphertextHf> select(String id);

    int updateByPrimaryKeySelective(BmStaffciphertextHf record);

    int updateByPrimaryKey(BmStaffciphertextHf record);
}