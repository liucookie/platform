package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblTestMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TblTest record);

    TblTest selectByPrimaryKey(Integer id);

    List<TblTest> select(@Param("type")String type, @Param("name")String name, @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("type")String type, @Param("name")String name);

    List<TblTest> exportExcel(@Param("type")String type, @Param("name")String name);

    List<TblTest> queryByTypeAndCount(@Param("type")String type,@Param("count")Integer count);

    List<TblTest> queryTestByExamId(@Param("examId")int examId);

    int updateByPrimaryKey(TblTest record);

    int insertBatch(List<TblTest> record);

    int updateBatch(List<TblTest> record);
}