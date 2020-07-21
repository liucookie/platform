package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrsultTbl;
import com.hangyu.platform.web.backBusiness.vo.DeptPunishQueryVO;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2LocalcheckrsultTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2LocalcheckrsultTbl record);

    Bm2LocalcheckrsultTbl selectByPrimaryKey(String id);

    int updateByPrimaryKey(Bm2LocalcheckrsultTbl record);

    List<Bm2LocalcheckrsultTbl> select(DeptPunishQueryVO vo);

    int selectCount(@Param("orgId") String orgId, @Param("planId") String planId, @Param("checkType") int checkType);

    int selectTotal(DeptPunishQueryVO vo);

    int queryPersonIssueCount(@Param("type") Integer type);

    int queryPersonAllQuestion();

    List<Bm2LocalcheckrsultTbl> queryFengYuanCheck(@Param("year") String year, @Param("deptId") String deptId,
                                                   @Param("userId") String userId, @Param("month") String month, @Param("type") String type,
                                                   @Param("isAdd") int isAdd);


}