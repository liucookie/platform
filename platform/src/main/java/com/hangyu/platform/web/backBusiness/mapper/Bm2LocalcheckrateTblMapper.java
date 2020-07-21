package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrateTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2LocalcheckrateTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Bm2LocalcheckrateTbl record);

    int insertSelective(Bm2LocalcheckrateTbl record);


    Bm2LocalcheckrateTbl selectByPrimaryKey(Integer id);

    List<Bm2LocalcheckrateTbl> select(@Param("orgId")String orgId,@Param("checkId")String checkId, @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("orgId")String orgId,@Param("checkId")String checkId);

    int updateByPrimaryKeySelective(Bm2LocalcheckrateTbl record);

    int updateByPrimaryKey(Bm2LocalcheckrateTbl record);

    int queryDeptIssueCount();
}