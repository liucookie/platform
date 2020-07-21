package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmCheckitemsetTbl;

import java.util.List;

public interface BmCheckitemsetTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmCheckitemsetTbl record);

    int insertSelective(BmCheckitemsetTbl record);


    BmCheckitemsetTbl selectByPrimaryKey(Integer id);

    List<BmCheckitemsetTbl> query();



    int updateByPrimaryKeySelective(BmCheckitemsetTbl record);

    int updateByPrimaryKey(BmCheckitemsetTbl record);

    int updateBatch(List<BmCheckitemsetTbl> list);
}