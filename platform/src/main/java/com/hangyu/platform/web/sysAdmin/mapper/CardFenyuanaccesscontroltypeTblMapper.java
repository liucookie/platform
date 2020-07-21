package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.CardFenyuanaccesscontroltypeTbl;

import java.util.List;

public interface CardFenyuanaccesscontroltypeTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(CardFenyuanaccesscontroltypeTbl record);

    int insertSelective(CardFenyuanaccesscontroltypeTbl record);


    CardFenyuanaccesscontroltypeTbl selectByPrimaryKey(Integer id);

    List<CardFenyuanaccesscontroltypeTbl>  queryType(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(CardFenyuanaccesscontroltypeTbl record);

    int updateByPrimaryKeyWithBLOBs(CardFenyuanaccesscontroltypeTbl record);

    int updateByPrimaryKey(CardFenyuanaccesscontroltypeTbl record);
}