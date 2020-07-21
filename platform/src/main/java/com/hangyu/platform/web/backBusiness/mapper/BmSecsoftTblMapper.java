package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmSecsoftTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmSecsoftTbl record);

    BmSecsoftTbl selectByPrimaryKey(String id);

    List<BmSecsoftTbl> select(@Param("start") int start, @Param("pageSize") int pageSize);

    List<BmSecsoftTbl> queryByType(@Param("type") String type);

    int selectTotal();

    int updateByPrimaryKey(BmSecsoftTbl record);
}