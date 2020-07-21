package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmLibtypeTbl;

import java.util.List;

public interface BmLibtypeTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmLibtypeTbl record);

    int insertSelective(BmLibtypeTbl record);

    BmLibtypeTbl selectByPrimaryKey(String id);

    List<BmLibtypeTbl> queryType(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(BmLibtypeTbl record);

    int updateByPrimaryKeyWithBLOBs(BmLibtypeTbl record);

    int updateByPrimaryKey(BmLibtypeTbl record);
}