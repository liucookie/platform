package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckplanTbl;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;

import java.util.List;

public interface Bm2DeptcheckplanTblMapper {


    int deleteByPrimaryKey(String planid);

    int insert(Bm2DeptcheckplanTbl record);

    int insertSelective(Bm2DeptcheckplanTbl record);


    Bm2DeptcheckplanTbl selectByPrimaryKey(String planid);

    Bm2DeptcheckplanTbl selectByDate(String date);

    List<Bm2DeptcheckplanTbl> select(CheckPlanQueryVO vo);

    int  selectTotal(CheckPlanQueryVO vo);

    int updateByPrimaryKeySelective(Bm2DeptcheckplanTbl record);

    int updateByPrimaryKeyWithBLOBs(Bm2DeptcheckplanTbl record);

    int updateByPrimaryKey(Bm2DeptcheckplanTbl record);
}