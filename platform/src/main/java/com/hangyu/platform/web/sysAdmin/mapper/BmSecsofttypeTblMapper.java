package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmSecsofttypeTbl;

import java.util.List;

public interface BmSecsofttypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmSecsofttypeTbl record);

    int insertSelective(BmSecsofttypeTbl record);



    BmSecsofttypeTbl selectByPrimaryKey(String id);

    List<BmSecsofttypeTbl> queryType(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(BmSecsofttypeTbl record);

    int updateByPrimaryKeyWithBLOBs(BmSecsofttypeTbl record);

    int updateByPrimaryKey(BmSecsofttypeTbl record);
}