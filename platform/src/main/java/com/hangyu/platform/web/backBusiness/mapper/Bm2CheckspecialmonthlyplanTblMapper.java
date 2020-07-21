package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2CheckspecialmonthlyplanTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2CheckspecialmonthlyplanTblMapper {


    int deleteByPrimaryKey(String monthlyplanid);

    int insert(Bm2CheckspecialmonthlyplanTbl record);



    Bm2CheckspecialmonthlyplanTbl selectByPrimaryKey(String monthlyplanid);

    List<Bm2CheckspecialmonthlyplanTbl> select(@Param("month") String month, @Param("year") String year,
                                               @Param("status") String status, @Param("start") int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("month") String month, @Param("year") String year,
                    @Param("status") String status);

    int updateByPrimaryKeySelective(Bm2CheckspecialmonthlyplanTbl record);


    int updateByPrimaryKey(Bm2CheckspecialmonthlyplanTbl record);
}