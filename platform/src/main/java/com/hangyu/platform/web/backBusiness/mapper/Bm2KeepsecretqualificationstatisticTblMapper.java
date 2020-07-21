package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2ConcactwayTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2KeepsecretqualificationstatisticTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2KeepsecretqualificationstatisticTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2KeepsecretqualificationstatisticTbl record);

    List<Bm2KeepsecretqualificationstatisticTbl> select(@Param("orgName")String orgName, @Param("type")String type, @Param("levelId")String levelId,
                                                        @Param("start")int start, @Param("pageSize") int pageSize);

    int selectCount(@Param("orgName")String orgName,  @Param("type")String type, @Param("levelId")String levelId);


    List<Bm2KeepsecretqualificationstatisticTbl> exportExcel(@Param("orgName")String orgName, @Param("type")String type, @Param("levelId")String levelId);

    Bm2KeepsecretqualificationstatisticTbl selectByPrimaryKey(String id);


    int updateByPrimaryKey(Bm2KeepsecretqualificationstatisticTbl record);
}