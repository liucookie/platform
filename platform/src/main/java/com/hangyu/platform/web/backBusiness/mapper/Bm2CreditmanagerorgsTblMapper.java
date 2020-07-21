package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2CreditmanagerorgsTbl;

import java.util.List;

public interface Bm2CreditmanagerorgsTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Bm2CreditmanagerorgsTbl record);


    Bm2CreditmanagerorgsTbl selectByPrimaryKey(Integer id);

    List<Bm2CreditmanagerorgsTbl> querySecretPerson();


    int updateByPrimaryKey(Bm2CreditmanagerorgsTbl record);
}