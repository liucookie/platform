package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationlevelTbl;

import java.util.List;

public interface Bm2KeepsecretqualificationlevelTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2KeepsecretqualificationlevelTbl record);

    int insertSelective(Bm2KeepsecretqualificationlevelTbl record);


    Bm2KeepsecretqualificationlevelTbl selectByPrimaryKey(String id);

    List<Bm2KeepsecretqualificationlevelTbl> queryType(int start, int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(Bm2KeepsecretqualificationlevelTbl record);

    int updateByPrimaryKey(Bm2KeepsecretqualificationlevelTbl record);
}