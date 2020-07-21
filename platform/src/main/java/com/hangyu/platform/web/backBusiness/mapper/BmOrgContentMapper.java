package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmOrgContent;

import java.util.List;

public interface BmOrgContentMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmOrgContent record);

    int insertSelective(BmOrgContent record);

    BmOrgContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BmOrgContent record);

    int updateByPrimaryKey(BmOrgContent record);

    List<BmOrgContent> selectByOrgId(String orgId);

    int deleteByOrgId(String orgId);
}