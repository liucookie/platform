package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationtypeTbl;

import java.util.List;

public interface Bm2KeepsecretqualificationtypeTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(Bm2KeepsecretqualificationtypeTbl record);

    int insertSelective(Bm2KeepsecretqualificationtypeTbl record);


    Bm2KeepsecretqualificationtypeTbl selectByPrimaryKey(String id);

    List<Bm2KeepsecretqualificationtypeTbl> queryType(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(Bm2KeepsecretqualificationtypeTbl record);

    int updateByPrimaryKey(Bm2KeepsecretqualificationtypeTbl record);
}