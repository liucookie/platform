package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblClasssify;

import java.util.List;

import com.hangyu.platform.web.backBusiness.dto.TblTest;
import org.apache.ibatis.annotations.Param;

public interface TblClasssifyMapper {


    int deleteByPrimaryKey(Integer id);

    int deleteByExamId(Integer examId);

    int insert(TblClasssify record);


    TblClasssify selectByPrimaryKey(Integer id);

    List<TblClasssify> selectByExamId(Integer examID);

    int updateByPrimaryKey(TblClasssify record);
}