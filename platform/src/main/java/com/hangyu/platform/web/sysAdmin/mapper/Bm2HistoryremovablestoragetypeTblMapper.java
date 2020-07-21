package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragetypeTbl;

import java.util.List;

public interface Bm2HistoryremovablestoragetypeTblMapper {


    int deleteByPrimaryKey(String typeid);

    int insert(Bm2HistoryremovablestoragetypeTbl record);

    int insertSelective(Bm2HistoryremovablestoragetypeTbl record);


    Bm2HistoryremovablestoragetypeTbl selectByPrimaryKey(String typeid);

    String selectByName(String typeName);

    List<Bm2HistoryremovablestoragetypeTbl> queryClassify();

    List<Bm2HistoryremovablestoragetypeTbl> queryType(int start,int pageSize);

    int updateByPrimaryKeySelective(Bm2HistoryremovablestoragetypeTbl record);

    int updateByPrimaryKeyWithBLOBs(Bm2HistoryremovablestoragetypeTbl record);

    int updateByPrimaryKey(Bm2HistoryremovablestoragetypeTbl record);
}