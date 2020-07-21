package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmResourcelibTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmResourcelibTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmResourcelibTbl record);

    int insertSelective(BmResourcelibTbl record);


    BmResourcelibTbl selectByPrimaryKey(String id);

    List<BmResourcelibTbl> select(@Param("start") int start, @Param("pageSize") int pageSize);


    int selectTotal();


    int updateByPrimaryKey(BmResourcelibTbl record);
}