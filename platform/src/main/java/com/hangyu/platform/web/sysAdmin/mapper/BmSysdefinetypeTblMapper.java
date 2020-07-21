package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmSysdefinetypeTbl;

import java.util.List;

public interface BmSysdefinetypeTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmSysdefinetypeTbl record);

    int insertSelective(BmSysdefinetypeTbl record);


    BmSysdefinetypeTbl selectByPrimaryKey(String id);

    List<BmSysdefinetypeTbl> selectAllType(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(BmSysdefinetypeTbl record);

    int updateByPrimaryKeyWithBLOBs(BmSysdefinetypeTbl record);

    int updateByPrimaryKey(BmSysdefinetypeTbl record);
}