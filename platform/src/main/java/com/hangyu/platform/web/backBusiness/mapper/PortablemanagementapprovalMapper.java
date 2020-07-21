package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Portablemanagementapproval;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PortablemanagementapprovalMapper {


    int deleteByPrimaryKey(String id);

    int insert(Portablemanagementapproval record);


    Portablemanagementapproval selectByPrimaryKey(String id);

    int updateByPrimaryKey(Portablemanagementapproval record);

    Portablemanagementapproval selectByInstanceId(String id);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}