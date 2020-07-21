package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.ExaminationsecretTbl;
import com.hangyu.platform.web.backBusiness.dto.Mediamanagementapproval;
import org.apache.ibatis.annotations.Param;

public interface MediamanagementapprovalMapper {


    int deleteByPrimaryKey(String id);

    int insert(Mediamanagementapproval record);

    Mediamanagementapproval selectByPrimaryKey(String id);


    int updateByPrimaryKey(Mediamanagementapproval record);

    Mediamanagementapproval selectByInstanceId(String id);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}