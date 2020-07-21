package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStafffamilyTbl;

import java.util.List;

public interface BmStafffamilyTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmStafffamilyTbl record);

    int insertSelective(BmStafffamilyTbl record);


    BmStafffamilyTbl selectByPrimaryKey(Integer id);

    List<BmStafffamilyTbl> selectByUserId(String userid);

    int updateByPrimaryKeySelective(BmStafffamilyTbl record);

    int updateByPrimaryKeyWithBLOBs(BmStafffamilyTbl record);

    //删除
    int updateByPrimaryKey(String staffid);


}