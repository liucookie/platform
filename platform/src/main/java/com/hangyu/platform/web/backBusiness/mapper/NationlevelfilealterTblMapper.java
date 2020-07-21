package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.NationlevelfilealterTbl;
import org.apache.ibatis.annotations.Param;


public interface NationlevelfilealterTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(NationlevelfilealterTbl record);


    NationlevelfilealterTbl selectByPrimaryKey(String id);


    int updateByPrimaryKey(NationlevelfilealterTbl record);

    NationlevelfilealterTbl selectByInstanceId(String id);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}