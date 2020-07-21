package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.ApprovesuggestionselectTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApprovesuggestionselectTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(ApprovesuggestionselectTbl record);

    int insertSelective(ApprovesuggestionselectTbl record);


    ApprovesuggestionselectTbl selectByPrimaryKey(Integer id);

    List<ApprovesuggestionselectTbl> select(@Param("formId") String formId,@Param("orgName") String orgName,@Param("start") int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("formId") String formId,@Param("orgName") String orgName);

    int updateByPrimaryKeySelective(ApprovesuggestionselectTbl record);

    int updateByPrimaryKey(ApprovesuggestionselectTbl record);
}