package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCheckthingTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmCheckthingTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmCheckthingTbl record);


    BmCheckthingTbl selectByPrimaryKey(String id);

    List<BmCheckthingTbl> select(@Param("start")int start, @Param("pageSize") int pageSize,
                                 @Param("isPublish") String isPublish);

    int selectTotal(@Param("isPublish") String isPublish);

    int isPublish(@Param("id")String id, @Param("status") int status);


    int updateByPrimaryKey(BmCheckthingTbl record);
}