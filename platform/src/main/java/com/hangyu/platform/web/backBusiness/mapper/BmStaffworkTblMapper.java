package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStaffworkTbl;

import java.util.List;


public interface BmStaffworkTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmStaffworkTbl record);

    int insertSelective(BmStaffworkTbl record);

    BmStaffworkTbl selectByPrimaryKey(Integer id);

    List<BmStaffworkTbl> selectByUserId(String userid);

    int updateByPrimaryKeySelective(BmStaffworkTbl record);

    int updateByPrimaryKey(BmStaffworkTbl record);

    int deleteByStaffId(String staffid);
}