package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TechnologythesissecrecyTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologythesissecrecyTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(TechnologythesissecrecyTbl record);


    TechnologythesissecrecyTbl selectByPrimaryKey(String id);

    List<TechnologythesissecrecyTbl> query(@Param("start") int start,@Param("pageSize") int pageSize,@Param("formId") String formId,@Param("type") String type);

    int selectTotal(@Param("formId") String formId,@Param("type") String type);


    int updateByPrimaryKey(TechnologythesissecrecyTbl record);

    TechnologythesissecrecyTbl selectByInstanceId(String id);

    int updateByInstanceId(@Param("instanceId") String instanceId, @Param("status")  int status);
}