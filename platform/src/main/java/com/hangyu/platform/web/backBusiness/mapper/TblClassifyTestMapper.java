package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblClassifyTest;

import java.util.List;

import com.hangyu.platform.web.backBusiness.dto.TblClasssify;
import org.apache.ibatis.annotations.Param;

public interface TblClassifyTestMapper {


    int deleteByPrimaryKey(Integer id);

    int deleteByClassifyId(Integer classifyId);

    int insert(TblClassifyTest record);


    TblClassifyTest selectByPrimaryKey(Integer id);

    List<TblClassifyTest> selectByClassifyId(Integer classifyId);

    int insertBatch(List<TblClassifyTest> record);

    int updateByPrimaryKey(TblClassifyTest record);

    int selectScore(@Param("examId") int examId,@Param("testId") int testId);
}