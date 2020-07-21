package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2PlancheckobjfoulactionstatTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface Bm2PlancheckobjfoulactionstatTblMapper {

    int deleteByPrimaryKey(String uniqueid);

    int insert(Bm2PlancheckobjfoulactionstatTbl record);

    Bm2PlancheckobjfoulactionstatTbl selectByPrimaryKey(String uniqueid);

    Bm2PlancheckobjfoulactionstatTbl selectByUserID(@Param("userId")String userId,@Param("planId")String planId);

    List<Bm2PlancheckobjfoulactionstatTbl> queryCheckUser(@Param("planId")String planId, @Param("start")int start, @Param("pageSize") int pageSize);

   int queryCheckCount(@Param("planId")String planId);

    int updateByPrimaryKey(Bm2PlancheckobjfoulactionstatTbl record);
}