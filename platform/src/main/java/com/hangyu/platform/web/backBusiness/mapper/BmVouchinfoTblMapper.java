package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmVouchinfoTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmVouchinfoTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmVouchinfoTbl record);

    List<BmVouchinfoTbl> select(@Param("start") int start, @Param("pageSize") int pageSize);


    List<BmVouchinfoTbl> queryIsSign(@Param("name") String name);


    List<BmVouchinfoTbl> querySecretKnowledge();

    int cancelTop();

    int selectTotal();

    BmVouchinfoTbl selectByPrimaryKey(String id);


    int updateByPrimaryKey(BmVouchinfoTbl record);
}