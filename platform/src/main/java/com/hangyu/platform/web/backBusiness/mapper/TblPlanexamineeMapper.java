package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblPlanexaminee;
import com.hangyu.platform.web.backBusiness.vo.PlanExamAddVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TblPlanexamineeMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByOrgId(Integer orgId);

    int insert(TblPlanexaminee record);

    TblPlanexaminee selectByPrimaryKey(Integer id);

    List<PlanExamAddVO.PlanStaff> selectByOrgId(Integer orgId);

    int updateByPrimaryKey(TblPlanexaminee record);

    List<TblPlanexaminee> selectYetExam(int planId);

    List<TblPlanexaminee> selectAllByOrgId(@Param("orgId") int orgId,@Param("state") Integer state,
                                           @Param("result") Integer result);

    List<TblPlanexaminee> selectDetailByOrgId(Integer orgId);

    List<TblPlanexaminee> selectDetailByExamId(@Param("planId") int planId,@Param("examId") Integer examId);

    List<TblPlanexaminee> querySelfTest(@Param("examName")String examName, @Param("userName")String userName,
                                        @Param("isNewStaffExam")Integer isNewStaffExam , @Param("isTest")Integer isTest ,@Param("startDate")String startDate, @Param("endDate")String endDate,
                         @Param("status")Integer status, @Param("start")int start, @Param("pageSize") int pageSize);

    int querySelfTestCount(@Param("examName")String examName, @Param("userName")String userName,
                           @Param("isNewStaffExam")Integer isNewStaffExam ,@Param("isTest")Integer isTest ,@Param("startDate")String startDate, @Param("endDate")String endDate,
                                        @Param("status")Integer status);


    TblPlanexaminee selectByUserId(@Param("planId") int planId,@Param("userId") String userId,@Param("examId") int examId);
}