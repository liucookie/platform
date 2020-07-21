package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.SecretcontrolscopeTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecretcontrolscopeTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(SecretcontrolscopeTbl record);

    int insertSelective(SecretcontrolscopeTbl record);

    SecretcontrolscopeTbl selectByPrimaryKey(String id);

    List<SecretcontrolscopeTbl> select(@Param("levelId") String levelId, @Param("keyWord") String keyWord, @Param("start") int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("levelId") String levelId,@Param("keyWord") String keyWord);

    int updateByPrimaryKeySelective(SecretcontrolscopeTbl record);


    int updateByPrimaryKey(SecretcontrolscopeTbl record);

    List<SecretcontrolscopeTbl> exportExcel(@Param("levelId") String levelId, @Param("keyWord") String keyWord);
}