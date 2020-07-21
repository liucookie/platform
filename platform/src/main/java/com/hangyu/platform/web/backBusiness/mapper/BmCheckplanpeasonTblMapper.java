package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmCheckplanpeasonTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmCheckplanpeasonTbl record);


    BmCheckplanpeasonTbl selectByDateAndUser(@Param("planId") String planId,@Param("userId") String userId);


    BmCheckplanpeasonTbl selectByPrimaryKey(Integer id);

    List<BmCheckplanpeasonTbl> selectByPlanId(String id);

    List<BmCheckplanpeasonTbl> queryCheckUserDetail(@Param("planId") String planId,@Param("orgId") String orgId);


    int updateByPrimaryKey(BmCheckplanpeasonTbl record);


    int queryCheckUser(@Param("planId")String planId,
                                     @Param("checkState")String checkState, @Param("checkRes") String checkRes);
}