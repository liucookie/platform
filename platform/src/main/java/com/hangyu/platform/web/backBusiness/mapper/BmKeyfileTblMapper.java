package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmKeyfileTbl;

import java.util.List;


public interface BmKeyfileTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmKeyfileTbl record);

    BmKeyfileTbl selectByFileId(String fileId);

    List<BmKeyfileTbl> selectByDeptId(String id);


    int updateByPrimaryKey(BmKeyfileTbl record);
}