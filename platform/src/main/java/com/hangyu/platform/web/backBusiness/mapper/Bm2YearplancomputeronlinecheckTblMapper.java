package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2YearplancomputeronlinecheckTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2YearplancomputeronlinecheckTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2YearplancomputeronlinecheckTbl record);


    Bm2YearplancomputeronlinecheckTbl selectByPrimaryKey(Integer id);

    Bm2YearplancomputeronlinecheckTbl selectByYearMonth(@Param("year")int year, @Param("month") int month);

    List<Bm2YearplancomputeronlinecheckTbl> select(@Param("year")String year, @Param("start")int start, @Param("pageSize") int pageSize);

    int  selectTotal(@Param("year")String year);

    int updateByPrimaryKey(Bm2YearplancomputeronlinecheckTbl record);
}