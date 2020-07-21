package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.CardGuomipasstypeTbl;

import java.util.List;

public interface CardGuomipasstypeTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(CardGuomipasstypeTbl record);

    int insertSelective(CardGuomipasstypeTbl record);



    CardGuomipasstypeTbl selectByPrimaryKey(Integer id);

    List<CardGuomipasstypeTbl> queryType(int start,int pageSize);

    int selectTotal();




    int updateByPrimaryKeySelective(CardGuomipasstypeTbl record);

    int updateByPrimaryKeyWithBLOBs(CardGuomipasstypeTbl record);

    int updateByPrimaryKey(CardGuomipasstypeTbl record);
}