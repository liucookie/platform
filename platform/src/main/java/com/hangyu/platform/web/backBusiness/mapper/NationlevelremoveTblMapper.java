package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.NationlevelremoveTbl;
import org.apache.ibatis.annotations.Param;


public interface NationlevelremoveTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(NationlevelremoveTbl record);

    NationlevelremoveTbl selectByPrimaryKey(String id);

    NationlevelremoveTbl selectByInstanceId(String id);

    int updateByPrimaryKey(NationlevelremoveTbl record);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}