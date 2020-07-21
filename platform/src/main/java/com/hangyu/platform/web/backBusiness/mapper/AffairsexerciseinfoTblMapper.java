package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AffairsexerciseinfoTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(AffairsexerciseinfoTbl record);

    int insertSelective(AffairsexerciseinfoTbl record);


    AffairsexerciseinfoTbl selectByPrimaryKey(String id);

    List<AffairsexerciseinfoTbl> select(@Param("orgName")String orgName, @Param("start")int start, @Param("pageSize") int pageSize);

    List<AffairsexerciseinfoTbl> selectTotal(@Param("orgName")String orgName);


    int updateByPrimaryKey(AffairsexerciseinfoTbl record);
}