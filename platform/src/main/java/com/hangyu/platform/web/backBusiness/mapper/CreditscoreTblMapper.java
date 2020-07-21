package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.CreditscoreTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditscoreTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(CreditscoreTbl record);

    CreditscoreTbl selectByPrimaryKey(Integer id);

    List<CreditscoreTbl> selectDeptScore(@Param("orgId")String orgId,@Param("year")String year, @Param("start")int start, @Param("pageSize") int pageSize);

    List<CreditscoreTbl> exportDeptScore(@Param("orgId")String orgId,@Param("year")String year);

    int selectDeptScoreCount(@Param("orgId")String orgId,@Param("year")String year);

    List<CreditscoreTbl> selectUserScore(@Param("orgId")String orgId,@Param("userId")String userId ,
                                         @Param("year")String year, @Param("start")int start, @Param("pageSize") int pageSize);

    int selectUserScoreCount(@Param("orgId")String orgId,@Param("userId")String userId ,
                             @Param("year")String year);


    List<CreditscoreTbl> exportUserScore(@Param("orgId")String orgId,@Param("userId")String userId ,
                                         @Param("year")String year);


    CreditscoreTbl selectDeptOrUserScore(@Param("key")String key,@Param("type")String type ,
                                         @Param("year")int year);


    int updateByPrimaryKey(CreditscoreTbl record);
}