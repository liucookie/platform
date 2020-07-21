package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblExamineereply;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblExamineereplyMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(TblExamineereply record);

    int insertBatch(List<TblExamineereply> list);


    TblExamineereply selectByPrimaryKey(Integer id);

    List<TblExamineereply> selectByUserId(@Param("userId") String userId,@Param("examineeId") int examineeId);


    int updateByPrimaryKey(TblExamineereply record);
}