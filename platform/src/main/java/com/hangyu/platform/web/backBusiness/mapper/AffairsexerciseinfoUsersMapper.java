package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoUsers;

import java.util.List;

public interface AffairsexerciseinfoUsersMapper {


    int deleteByPrimaryKey(String id);

    int insert(AffairsexerciseinfoUsers record);

    int insertSelective(AffairsexerciseinfoUsers record);

    List<AffairsexerciseinfoUsers> select(String id);

    int updateByPrimaryKeySelective(AffairsexerciseinfoUsers record);

    int updateByPrimaryKey(AffairsexerciseinfoUsers record);
}