package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2RecordmodulerelationTbl;

public interface Bm2RecordmodulerelationTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2RecordmodulerelationTbl record);

    int insertSelective(Bm2RecordmodulerelationTbl record);

    Bm2RecordmodulerelationTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bm2RecordmodulerelationTbl record);

    int updateByPrimaryKey(Bm2RecordmodulerelationTbl record);
}