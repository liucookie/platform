package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmSecsoftverTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmSecsoftverTbl record);


    BmSecsoftverTbl selectByPrimaryKey(String id);

    List<BmSecsoftverTbl> select(@Param("id") String id,@Param("start") int start, @Param("pageSize") int pageSize);

    List<BmSecsoftverTbl> selectById(@Param("id") String id);

    BmSecsoftverTbl selectNewSoft(String id);

    int selectTotal(@Param("id") String id);

    int updateByPrimaryKey(BmSecsoftverTbl record);
}