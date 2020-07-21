package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.ServerpropertymatchTbl;

import java.util.List;

public interface ServerpropertymatchTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(ServerpropertymatchTbl record);


    ServerpropertymatchTbl selectByPrimaryKey(Integer id);

    List<String> selectByComputerId(String id);


    int updateByPrimaryKey(ServerpropertymatchTbl record);
}