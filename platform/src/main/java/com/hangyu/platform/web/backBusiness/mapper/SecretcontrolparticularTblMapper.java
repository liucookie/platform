package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecretcontrolparticularTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(SecretcontrolparticularTbl record);



    SecretcontrolparticularTbl selectByPrimaryKey(String id);

    List<SecretcontrolparticularTbl> select(@Param("levelId")String levelId, @Param("name")String name,@Param("start")int start, @Param("pageSize") int pageSize);

    List<SecretcontrolparticularTbl> selectTotal(@Param("levelId")String levelId, @Param("name")String name);

    List<SecretcontrolparticularTbl> selectByFormId(String formId);

    int updateByPrimaryKey(SecretcontrolparticularTbl record);
}