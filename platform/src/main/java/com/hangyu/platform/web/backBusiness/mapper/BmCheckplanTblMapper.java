package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmCheckplanTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmCheckplanTbl record);

    int insertSelective(BmCheckplanTbl record);

    BmCheckplanTbl selectByPrimaryKey(String id);

    BmCheckplanTbl selectByDate(String date);

    List<BmCheckplanTbl> select(CheckPlanQueryVO vo);

    int  selectTotal(CheckPlanQueryVO vo);

    int updateByPrimaryKeySelective(BmCheckplanTbl record);


    int updateByPrimaryKey(BmCheckplanTbl record);


}