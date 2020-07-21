package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSpecnewsTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmSpecnewsTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmSpecnewsTbl record);

    BmSpecnewsTbl selectByPrimaryKey(String id);

    List<BmSpecnewsTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal();

    List<BmSpecnewsTbl> querySpecNews(@Param("topSign") String topSign);

    int updateByPrimaryKey(BmSpecnewsTbl record);

    int isPublish(@Param("id")String id, @Param("status") int status);
}