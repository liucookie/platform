package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmOrgfileTbl;


public interface BmOrgfileTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmOrgfileTbl record);

    int insertSelective(BmOrgfileTbl record);


    int updateByPrimaryKeySelective(BmOrgfileTbl record);

    int updateByPrimaryKey(BmOrgfileTbl record);

    //根据组织id查询附件
    BmOrgfileTbl selectByOrgId(String orgId);
    //删除文件
    int deleteByOrgId(String orgId);
}