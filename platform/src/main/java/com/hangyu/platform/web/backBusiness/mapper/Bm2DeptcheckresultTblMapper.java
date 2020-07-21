package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrsultTbl;
import com.hangyu.platform.web.backBusiness.vo.DeptPunishQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2DeptcheckresultTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2DeptcheckresultTbl record);


    Bm2DeptcheckresultTbl selectByPrimaryKey(String id);

    List<Bm2DeptcheckresultTbl> select(DeptPunishQueryVO vo);

    int selectTotal(DeptPunishQueryVO vo);


    int updateByPrimaryKey(Bm2DeptcheckresultTbl record);

    List<Bm2DeptcheckresultTbl> queryDeptCheck(@Param("year") String year, @Param("deptId") String deptId,
                                                   @Param("userId") String userId, @Param("month") String month, @Param("type") String type);
}