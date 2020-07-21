package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.NationlevelalteropinionTbl;

import java.util.List;

public interface NationlevelalteropinionTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(NationlevelalteropinionTbl record);

    int insertSelective(NationlevelalteropinionTbl record);


    NationlevelalteropinionTbl selectByPrimaryKey(String id);

    List<NationlevelalteropinionTbl> query(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(NationlevelalteropinionTbl record);

    int updateByPrimaryKey(NationlevelalteropinionTbl record);
}