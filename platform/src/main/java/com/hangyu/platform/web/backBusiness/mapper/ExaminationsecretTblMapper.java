package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.ExaminationsecretTbl;


import org.apache.ibatis.annotations.Param;

public interface ExaminationsecretTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(ExaminationsecretTbl record);


    ExaminationsecretTbl selectByPrimaryKey(String id);

    int updateByPrimaryKey(ExaminationsecretTbl record);

    ExaminationsecretTbl selectByInstanceId(String id);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}