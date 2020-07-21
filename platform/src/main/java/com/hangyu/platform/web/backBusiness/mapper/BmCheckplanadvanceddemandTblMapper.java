package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckplanadvanceddemandTbl;

import java.util.List;

public interface BmCheckplanadvanceddemandTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmCheckplanadvanceddemandTbl record);

    int insertSelective(BmCheckplanadvanceddemandTbl record);


    BmCheckplanadvanceddemandTbl selectByPrimaryKey(Integer id);

    List<BmCheckplanadvanceddemandTbl> selectByPlanId(String id);



    int updateByPrimaryKeySelective(BmCheckplanadvanceddemandTbl record);

    int updateByPrimaryKey(BmCheckplanadvanceddemandTbl record);
}