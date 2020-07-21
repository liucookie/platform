package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStaffstudyTbl;

import java.util.List;


public interface BmStaffstudyTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmStaffstudyTbl record);

    int insertSelective(BmStaffstudyTbl record);

    List<BmStaffstudyTbl> selectByUserId(String userid);

    BmStaffstudyTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmStaffstudyTbl record);

    int deleteByStaffId(String staffid);
}