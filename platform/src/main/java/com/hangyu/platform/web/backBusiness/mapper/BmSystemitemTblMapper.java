package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSystemTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BmSystemitemTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmSystemitemTbl record);

    BmSystemitemTbl selectByPrimaryKey(String id);

    List<BmSystemitemTbl> select(@Param("name")String name, @Param("id")String id , @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("name")String name,@Param("id")String id);

    int updateByPrimaryKey(BmSystemitemTbl record);

    List<BmSystemitemTbl> selectContent(@Param("start") int start,@Param("pageSize") int pageSize,
                                        @Param("type") String type,@Param("content") String content,@Param("sysId") String sysId);

    int selectContentTotal(@Param("type") String type,@Param("content") String content,@Param("sysId") String sysId);

    List<BmSystemitemTbl> selectBatch(List<String> list);


}