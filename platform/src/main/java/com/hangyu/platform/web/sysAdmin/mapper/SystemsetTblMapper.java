package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.SystemsetTbl;

public interface SystemsetTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(SystemsetTbl record);

    int insertSelective(SystemsetTbl record);


    SystemsetTbl selectByPrimaryKey();

    int updateByPrimaryKeySelective(SystemsetTbl record);

    int updateByPrimaryKey(SystemsetTbl record);
}