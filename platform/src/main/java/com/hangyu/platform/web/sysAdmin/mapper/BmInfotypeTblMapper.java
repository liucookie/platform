package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmInfotypeTbl;

import java.util.List;

public interface BmInfotypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmInfotypeTbl record);

    int insertSelective(BmInfotypeTbl record);


    List<BmInfotypeTbl> selectAllType(int start,int pageSize);

    int selectTotal();

    BmInfotypeTbl selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(BmInfotypeTbl record);

    int updateByPrimaryKeyWithBLOBs(BmInfotypeTbl record);

    int updateByPrimaryKey(BmInfotypeTbl record);
}