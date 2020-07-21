package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.NationlevelalterTbl;
import com.hangyu.platform.web.backBusiness.dto.NationlevelremoveTbl;
import org.apache.ibatis.annotations.Param;

public interface NationlevelalterTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(NationlevelalterTbl record);

    NationlevelalterTbl selectByPrimaryKey(String id);

    NationlevelalterTbl selectByInstanceId(String id);

    int updateByPrimaryKey(NationlevelalterTbl record);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}