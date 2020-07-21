package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmAllroundcheckTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmAllroundcheckTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmAllroundcheckTbl record);

    int insertSelective(BmAllroundcheckTbl record);


    BmAllroundcheckTbl selectByPrimaryKey(String id);

    List<BmAllroundcheckTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal();

    int updateByPrimaryKeySelective(BmAllroundcheckTbl record);

    int updateByPrimaryKey(BmAllroundcheckTbl record);
}