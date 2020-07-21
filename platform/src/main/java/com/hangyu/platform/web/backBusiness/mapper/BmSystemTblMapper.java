package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSystemTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BmSystemTblMapper {


    int deleteByPrimaryKey(String id);

    int deleteHistory(Integer id);

    int insert(BmSystemTbl record);


    List<BmSystemTbl> queryHistory(String id);

    BmSystemTbl selectByPrimaryKey(String id);

    List<BmSystemTbl> select(@Param("name")String name, @Param("type")String type ,@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("name")String name,@Param("type")String type);

    int updateByPrimaryKey(BmSystemTbl record);

    List<BmSystemTbl> exportExcel(@Param("name")String name, @Param("type")String type);

    List<BmSystemTbl> selectSystemByType(int type);


}