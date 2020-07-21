package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmKeypositionTbl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BmKeypositionTblMapper {


    int deleteByPrimaryKey(@Param("keyId") int keyId, @Param("id") String id, @Param("isHistory") int isHistory);

    int deleteByPositionId(@Param("id") String id);

    int deleteHistoryPosition(@Param("id") int id);

    int insert(BmKeypositionTbl record);

    BmKeypositionTbl selectByPrimaryKey(String id);

    List<BmKeypositionTbl> queryPosition(@Param("orgName") String orgName, @Param("userName") String userName, @Param("start") int start, @Param("pageSize") int pageSize);

    List<BmKeypositionTbl> queryPositionHistory(String id);

    int selectTotal(@Param("orgName") String orgName, @Param("userName") String userName);

    List<BmKeypositionTbl> exportPosition(@Param("orgName") String orgName, @Param("userName") String userName);

    int updateByPrimaryKey(BmKeypositionTbl record);
}