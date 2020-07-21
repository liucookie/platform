package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2YearplanspecialcheckTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2YearplanspecialcheckTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2YearplanspecialcheckTbl record);

    Bm2YearplanspecialcheckTbl selectByPrimaryKey(String id);

    int updateByPrimaryKey(Bm2YearplanspecialcheckTbl record);

    List<Bm2YearplanspecialcheckTbl> select(@Param("year")String year, @Param("start")int start, @Param("pageSize") int pageSize);

    int  selectTotal(@Param("year")String year);
}