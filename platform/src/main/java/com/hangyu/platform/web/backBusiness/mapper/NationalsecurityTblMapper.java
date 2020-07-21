package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.NationalsecurityTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NationalsecurityTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(NationalsecurityTbl record);

    int insertSelective(NationalsecurityTbl record);

    NationalsecurityTbl selectByPrimaryKey(String id);

    List<NationalsecurityTbl> select(@Param("orgName")String orgName, @Param("start")int start, @Param("pageSize") int pageSize);

    List<NationalsecurityTbl> selectTotal(@Param("orgName")String orgName);

    int updateByPrimaryKeySelective(NationalsecurityTbl record);

    int updateByPrimaryKey(NationalsecurityTbl record);
}