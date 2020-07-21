package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmPunishTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmPunishTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmPunishTbl record);

    BmPunishTbl selectByPrimaryKey(String id);

    List<BmPunishTbl> select(@Param("start")int start, @Param("pageSize") int pageSize,
                             @Param("isPublish") String isPublish);

    int selectTotal(@Param("isPublish") String isPublish);

    int isPublish(@Param("id")String id, @Param("status") int status);


    int updateByPrimaryKey(BmPunishTbl record);
}