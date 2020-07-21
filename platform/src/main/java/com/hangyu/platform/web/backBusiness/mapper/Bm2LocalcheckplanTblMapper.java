package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckplanTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2LocalcheckplanTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2LocalcheckplanTbl record);

    int insertSelective(Bm2LocalcheckplanTbl record);


    Bm2LocalcheckplanTbl selectByPrimaryKey(String id);

    List<Bm2LocalcheckplanTbl> queryAll();

    List<Bm2LocalcheckplanTbl> select(@Param("year") String year, @Param("month") String month,
                                      @Param("name") String name, @Param("start") int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("year") String year, @Param("month") String month,
                    @Param("name") String name);


    int updateByPrimaryKeySelective(Bm2LocalcheckplanTbl record);

    int updateByPrimaryKey(Bm2LocalcheckplanTbl record);
}