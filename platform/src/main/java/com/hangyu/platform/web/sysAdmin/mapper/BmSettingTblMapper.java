package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmSettingTbl;

import java.util.List;


public interface BmSettingTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmSettingTbl record);

    int insertSelective(BmSettingTbl record);


    BmSettingTbl selectByPrimaryKey(Integer id);

    List<BmSettingTbl> querySet(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(BmSettingTbl record);

    int updateByPrimaryKey(BmSettingTbl record);
}