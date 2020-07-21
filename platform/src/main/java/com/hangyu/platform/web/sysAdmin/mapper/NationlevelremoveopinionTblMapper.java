package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.NationlevelremoveopinionTbl;

import java.util.List;

public interface NationlevelremoveopinionTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(NationlevelremoveopinionTbl record);

    int insertSelective(NationlevelremoveopinionTbl record);

    NationlevelremoveopinionTbl selectByPrimaryKey(String id);

    List<NationlevelremoveopinionTbl> query(int start,int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(NationlevelremoveopinionTbl record);

    int updateByPrimaryKey(NationlevelremoveopinionTbl record);
}