package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2CheckspecialplanTbl;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;

import java.util.List;

public interface Bm2CheckspecialplanTblMapper {


    int deleteByPrimaryKey(String planid);

    int insert(Bm2CheckspecialplanTbl record);

    int insertSelective(Bm2CheckspecialplanTbl record);

    Bm2CheckspecialplanTbl selectByPrimaryKey(String planid);

    List<Bm2CheckspecialplanTbl> queryByMonthId(CheckPlanQueryVO vo);

    int selectTotal(CheckPlanQueryVO vo);

    int selectNumber(String planId);


    int updateByPrimaryKeySelective(Bm2CheckspecialplanTbl record);

    int updateByPrimaryKey(Bm2CheckspecialplanTbl record);
}