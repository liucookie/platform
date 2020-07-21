package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckplandemandTbl;

import java.util.List;

public interface BmCheckplandemandTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmCheckplandemandTbl record);

    int insertSelective(BmCheckplandemandTbl record);


    BmCheckplandemandTbl selectByPrimaryKey(Integer id);

    List<BmCheckplandemandTbl> selectByPlanId(String id);



    int updateByPrimaryKeySelective(BmCheckplandemandTbl record);

    int updateByPrimaryKey(BmCheckplandemandTbl record);
}