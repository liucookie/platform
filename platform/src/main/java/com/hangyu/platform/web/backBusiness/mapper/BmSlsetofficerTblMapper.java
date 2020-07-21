package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSlsetofficerTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmSlsetofficerTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmSlsetofficerTbl record);

    int insertSelective(BmSlsetofficerTbl record);


    BmSlsetofficerTbl selectByPrimaryKey(String id);

    List<BmSlsetofficerTbl> select(@Param("typeId")String typeId, @Param("orgId")String orgId,@Param("userId")String userId,
                                   @Param("start")int start, @Param("pageSize") int pageSize);

    int  selectTotal(@Param("typeId")String typeId, @Param("orgId")String orgId,@Param("userId")String userId);


    int updateByPrimaryKeySelective(BmSlsetofficerTbl record);

    int updateByPrimaryKey(BmSlsetofficerTbl record);
}