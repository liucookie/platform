package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSystemfileTbl;

import java.util.List;


public interface BmSystemfileTblMapper {


    int deleteByPrimaryKey(String id);

    int deleteFile(String id);

    int insert(BmSystemfileTbl record);

    BmSystemfileTbl selectById(String id);

    BmSystemfileTbl selectByAttrId(String id);

    List<BmSystemfileTbl> selectByPrimaryKey(String id);



    int updateByPrimaryKey(BmSystemfileTbl record);
}