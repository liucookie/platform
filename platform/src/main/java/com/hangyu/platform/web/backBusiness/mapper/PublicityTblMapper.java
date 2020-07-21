package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.PublicityTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublicityTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(PublicityTbl record);

    PublicityTbl selectByPrimaryKey(String id);

    List<PublicityTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    List<PublicityTbl> queryPublicity(@Param("type")String type);

    int selectTotal();

    int updateByPrimaryKey(PublicityTbl record);

    int isPublish(@Param("id")String id, @Param("status") int status);
}