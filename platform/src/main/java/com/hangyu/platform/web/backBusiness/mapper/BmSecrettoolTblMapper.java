package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSecrettoolTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmSecrettoolTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmSecrettoolTbl record);

    BmSecrettoolTbl selectByPrimaryKey(String id);

    List<BmSecrettoolTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal();

    int updateByPrimaryKey(BmSecrettoolTbl record);
}