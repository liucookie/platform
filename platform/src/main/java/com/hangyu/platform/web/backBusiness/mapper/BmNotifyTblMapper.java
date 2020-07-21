package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmNotifyTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmNotifyTbl record);


    BmNotifyTbl selectByPrimaryKey(String id);


    List<BmNotifyTbl> select(@Param("start")int start, @Param("pageSize") int pageSize,@Param("name") String name,
                             @Param("keyWords") String keyWords,@Param("startDate") String startDate,@Param("endDate") String endDate );

    int selectTotal(@Param("name") String name,
                    @Param("keyWords") String keyWords,@Param("startDate") String startDate,@Param("endDate") String endDate );

    int isPublish(@Param("id")String id, @Param("status") int status);

    List<BmNotifyTbl> queryNotify(@Param("topSign") String topSign);

    int updateByPrimaryKey(BmNotifyTbl record);
}