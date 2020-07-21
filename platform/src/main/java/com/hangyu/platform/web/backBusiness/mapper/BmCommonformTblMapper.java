package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmCommonformTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmCommonformTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmCommonformTbl record);

    BmCommonformTbl selectByPrimaryKey(String id);


    List<BmCommonformTbl> select(@Param("start")int start, @Param("pageSize") int pageSize,
            @Param("isPublish") String isPublish);

    int selectTotal(@Param("isPublish") String isPublish);

    int isPublish(@Param("id")String id, @Param("status") int status);

    int updateByPrimaryKey(BmCommonformTbl record);
}