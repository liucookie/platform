package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2CreditrulesettingTbl;

public interface Bm2CreditrulesettingTblMapper {


    int deleteByPrimaryKey(String creditrulesettingid);

    int insert(Bm2CreditrulesettingTbl record);

    int insertSelective(Bm2CreditrulesettingTbl record);


    Bm2CreditrulesettingTbl selectByPrimaryKey(String creditrulesettingid);

    Bm2CreditrulesettingTbl queryByYear(int year);



    int updateByPrimaryKeySelective(Bm2CreditrulesettingTbl record);

    int updateByPrimaryKey(Bm2CreditrulesettingTbl record);
}