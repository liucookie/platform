package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;

import java.util.List;


public interface Bm2CheckspecialtypeTblMapper {


    int deleteByPrimaryKey(String checktypeid);

    int insert(Bm2CheckspecialtypeTbl record);

    int insertSelective(Bm2CheckspecialtypeTbl record);


    Bm2CheckspecialtypeTbl selectByPrimaryKey(String checktypeid);

    String selectNameById(String checktypeid);

    List<String> queryNameBatch(List<String> list);

    List<Bm2CheckspecialtypeTbl> queryType(int start,int pageSize);

    List<Bm2CheckspecialtypeTbl> queryAllType();

    int selectTotal();

    int updateByPrimaryKeySelective(Bm2CheckspecialtypeTbl record);

    int updateByPrimaryKey(Bm2CheckspecialtypeTbl record);
}