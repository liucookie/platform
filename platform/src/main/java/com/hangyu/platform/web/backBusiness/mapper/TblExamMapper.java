package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblExam;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblExamMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TblExam record);

    TblExam selectByPrimaryKey(Integer id);

    List<TblExam> select(@Param("name")String name, @Param("minScore")Integer minScore, @Param("maxScore")Integer maxScore,
                         @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("name")String name, @Param("minScore")Integer minScore, @Param("maxScore")Integer maxScore);

    List<TblExam> queryAllExam();

    List<TblExam> randomExam(int type);

    int updateByPrimaryKey(TblExam record);

    int updateCount(int id);
}