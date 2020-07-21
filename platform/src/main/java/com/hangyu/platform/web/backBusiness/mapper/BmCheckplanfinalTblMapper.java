package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckplanfinalTbl;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmCheckplanfinalTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmCheckplanfinalTbl record);



    BmCheckplanfinalTbl selectByPrimaryKey(Integer id);

    List<BmCheckplanfinalTbl> queryCheckResult(@Param("planId")String planId,@Param("userId")String userId,
                                               @Param("checkFinal") String checkFinal);


    int updateByPrimaryKey(BmCheckplanfinalTbl record);
}