package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckselfdeptTbl;

public interface BmCheckselfdeptTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmCheckselfdeptTbl record);

    int insertSelective(BmCheckselfdeptTbl record);


    BmCheckselfdeptTbl selectByPrimaryKey(String id);



    int updateByPrimaryKeySelective(BmCheckselfdeptTbl record);

    int updateByPrimaryKey(BmCheckselfdeptTbl record);
}