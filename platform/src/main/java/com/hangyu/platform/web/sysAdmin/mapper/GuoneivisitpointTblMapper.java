package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.GuoneivisitpointTbl;

import java.util.List;

public interface GuoneivisitpointTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(GuoneivisitpointTbl record);

    int insertSelective(GuoneivisitpointTbl record);


    GuoneivisitpointTbl selectByPrimaryKey(String id);

    List<GuoneivisitpointTbl> query(int start, int pageSize,String accessName,String orgName);

    int selectTotal(String accessName,String orgName);


    int updateByPrimaryKeySelective(GuoneivisitpointTbl record);

    int updateByPrimaryKey(GuoneivisitpointTbl record);
}