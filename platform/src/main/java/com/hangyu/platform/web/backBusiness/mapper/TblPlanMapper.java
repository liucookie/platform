package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblPlan;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblPlanMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TblPlan record);

    TblPlan selectByPrimaryKey(Integer id);

    List<TblPlan> select(@Param("name")String name, @Param("startDate")String startDate, @Param("endDate")String endDate,
                         @Param("status")Integer status, @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("name")String name, @Param("startDate")String startDate, @Param("endDate")String endDate,
                    @Param("status")Integer status);

    int updateByPrimaryKey(TblPlan record);

    int updateCount(int id);

    List<TblPlan> selectByIsTest(@Param("isTest") Integer isTest,@Param("isNow") Integer isNow);

    List<TblPlan> selectByUserId(@Param("userId") String userId);

    List<TblPlan> selectByExamId(@Param("examId") int examId);
}