package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblPlanorganization;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TblPlanorganizationMapper {


    int deleteByPrimaryKey(Integer id);

    int deleteByPlanId(Integer planId);

    int insert(TblPlanorganization record);


    TblPlanorganization selectByPrimaryKey(Integer id);

    TblPlanorganization selectByPlanAndOrgId(@Param("planId") Integer planId,@Param("orgId") String orgId);

    List<TblPlanorganization> selectByPlanId(Integer planId);

    int updateByPrimaryKey(TblPlanorganization record);
}