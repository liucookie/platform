package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2ConcactwayTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2ConcactwayTblMapper {


    int deleteByPrimaryKey(String concactwayid);

    int insert(Bm2ConcactwayTbl record);

    Bm2ConcactwayTbl selectByPrimaryKey(String concactwayid);

    List<Bm2ConcactwayTbl> select(@Param("orgName")String orgName, @Param("userName")String userName,
                                  @Param("typeName")String typeName,@Param("start")int start, @Param("pageSize") int pageSize);

    int selectCount(@Param("orgName")String orgName, @Param("userName")String userName, @Param("typeName")String typeName);

    List<Bm2ConcactwayTbl> selectTotal(@Param("orgName")String orgName, @Param("name")String name);


    int updateByPrimaryKey(Bm2ConcactwayTbl record);
}