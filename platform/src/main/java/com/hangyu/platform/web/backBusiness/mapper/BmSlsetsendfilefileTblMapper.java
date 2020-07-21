package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSlsetsendfilefileTbl;

import java.util.List;

public interface BmSlsetsendfilefileTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmSlsetsendfilefileTbl record);

    int insertSelective(BmSlsetsendfilefileTbl record);


    BmSlsetsendfilefileTbl selectByPrimaryKey(Integer id);

    BmSlsetsendfilefileTbl selectBySetId(String id);


    int updateByPrimaryKeySelective(BmSlsetsendfilefileTbl record);

    int updateByPrimaryKey(BmSlsetsendfilefileTbl record);
}