package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmWorkdynTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmWorkdynTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmWorkdynTbl record);

    BmWorkdynTbl selectByPrimaryKey(String id);

    List<BmWorkdynTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal();

    int isPublish(@Param("id")String id, @Param("status") int status);

    int updateByPrimaryKey(BmWorkdynTbl record);

    List<BmWorkdynTbl> queryWorkDynamic(@Param("topSign") String topSign);

}