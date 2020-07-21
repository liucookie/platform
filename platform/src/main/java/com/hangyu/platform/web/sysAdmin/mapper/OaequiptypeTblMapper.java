package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.OaequiptypeTbl;

import java.util.List;

public interface OaequiptypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(OaequiptypeTbl record);

    int insertSelective(OaequiptypeTbl record);


    OaequiptypeTbl selectByPrimaryKey(String id);

    List<OaequiptypeTbl> selectAllType(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(OaequiptypeTbl record);

    int updateByPrimaryKey(OaequiptypeTbl record);
}