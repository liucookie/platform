package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmKeyplacepicmodelTbl;

import java.util.List;


public interface BmKeyplacepicmodelTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmKeyplacepicmodelTbl record);


    BmKeyplacepicmodelTbl selectByPrimaryKey(Integer id);

    List<BmKeyplacepicmodelTbl> queryPlace();

    int updateByPrimaryKey(BmKeyplacepicmodelTbl record);
}