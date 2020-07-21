package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSecrectwayTbl;

import java.util.List;


public interface BmSecrectwayTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmSecrectwayTbl record);

    int insertSelective(BmSecrectwayTbl record);


    BmSecrectwayTbl selectByPrimaryKey(Integer id);

    List<BmSecrectwayTbl> select(List<String> list);

    List<BmSecrectwayTbl> selectByType(int type);

    int updateByPrimaryKeySelective(BmSecrectwayTbl record);

    int updateByPrimaryKey(BmSecrectwayTbl record);
}