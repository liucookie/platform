package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.SecretexaminaapproveTbl;
import org.apache.ibatis.annotations.Param;


public interface SecretexaminaapproveTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(SecretexaminaapproveTbl record);

    SecretexaminaapproveTbl selectByPrimaryKey(String id);

    SecretexaminaapproveTbl selectByInstanceId(String instanceId);


    int updateByPrimaryKey(SecretexaminaapproveTbl record);

    int updateByInstanceId(@Param("instanceId") String instanceId,@Param("status")  int status);
}