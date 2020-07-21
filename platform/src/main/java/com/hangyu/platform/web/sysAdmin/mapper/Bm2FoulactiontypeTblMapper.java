package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactiontypeTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2FoulactiontypeTblMapper {


    int deleteByPrimaryKey(List<String> list);

    int insert(Bm2FoulactiontypeTbl record);

    int insertSelective(Bm2FoulactiontypeTbl record);


    Bm2FoulactiontypeTbl selectByPrimaryKey(String foulactiontypeid);

    List<Bm2FoulactiontypeTbl> query(int start, int pageSize);

    List<Bm2FoulactiontypeTbl> queryAll();

    int selectTotal();

    String selectByName(@Param("name") String name);

    int updateByPrimaryKeySelective(Bm2FoulactiontypeTbl record);

    int updateByPrimaryKey(Bm2FoulactiontypeTbl record);
}