package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmCheckplanitemTbl;

import java.util.List;

public interface BmCheckplanitemTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmCheckplanitemTbl record);

    int insertSelective(BmCheckplanitemTbl record);


    BmCheckplanitemTbl selectByPrimaryKey(Integer id);

    List<BmCheckplanitemTbl> queryItem();

    BmCheckplanitemTbl queryItemId(String itemId);

    List<BmCheckplanitemTbl> queryItemById(int id);

    int updateByPrimaryKeySelective(BmCheckplanitemTbl record);

    int updateByPrimaryKey(BmCheckplanitemTbl record);
}