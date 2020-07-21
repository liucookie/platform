package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2FilemoduleTbl;

import java.util.List;

public interface Bm2FilemoduleTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Bm2FilemoduleTbl record);

    int insertSelective(Bm2FilemoduleTbl record);


    Bm2FilemoduleTbl selectByPrimaryKey(Integer id);

    List<Bm2FilemoduleTbl> selectByType(int type);

    List<Bm2FilemoduleTbl> selectById(String id);

    int updateByPrimaryKeySelective(Bm2FilemoduleTbl record);

    int updateByPrimaryKey(Bm2FilemoduleTbl record);
}