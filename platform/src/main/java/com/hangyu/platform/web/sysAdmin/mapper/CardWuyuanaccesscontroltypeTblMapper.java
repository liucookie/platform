package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.CardWuyuanaccesscontroltypeTbl;

import java.util.List;

public interface CardWuyuanaccesscontroltypeTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(CardWuyuanaccesscontroltypeTbl record);

    int insertSelective(CardWuyuanaccesscontroltypeTbl record);


    CardWuyuanaccesscontroltypeTbl selectByPrimaryKey(Integer id);

    List<CardWuyuanaccesscontroltypeTbl> queryType(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(CardWuyuanaccesscontroltypeTbl record);

    int updateByPrimaryKeyWithBLOBs(CardWuyuanaccesscontroltypeTbl record);

    int updateByPrimaryKey(CardWuyuanaccesscontroltypeTbl record);
}