package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmKeydeptTbl;

import java.util.List;

import com.hangyu.platform.web.backBusiness.dto.BmSystemTbl;
import org.apache.ibatis.annotations.Param;

public interface BmKeydeptTblMapper {

    int deleteByPrimaryKey(@Param("keyId")int keyId,@Param("id")String id,@Param("isHistory")int isHistory);

    int deleteByDeptId(@Param("id")String id);

    int deleteHistory(@Param("id")int id);

    int insert(BmKeydeptTbl record);

    BmKeydeptTbl selectByPrimaryKey(String id);

    List<BmKeydeptTbl> queryDeptHistory(String id);

    int updateByPrimaryKey(BmKeydeptTbl record);

    List<BmKeydeptTbl> selectDept(@Param("orgName")String orgName, @Param("userName")String userName , @Param("start")int start, @Param("pageSize") int pageSize);

    List<BmKeydeptTbl> exportDept(@Param("orgName")String orgName, @Param("userName")String userName);

    int selectTotal(@Param("orgName")String orgName,@Param("userName")String userName);
}