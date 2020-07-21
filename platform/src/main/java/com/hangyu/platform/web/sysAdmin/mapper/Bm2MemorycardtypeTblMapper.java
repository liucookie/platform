package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2MemorycardtypeTbl;

import java.util.List;

public interface Bm2MemorycardtypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(Bm2MemorycardtypeTbl record);

    int insertSelective(Bm2MemorycardtypeTbl record);

    Bm2MemorycardtypeTbl selectByPrimaryKey(String id);

    List<Bm2MemorycardtypeTbl> selectType(int start,int pageSize);

    int selectTotal();


    int updateByPrimaryKeySelective(Bm2MemorycardtypeTbl record);

    int updateByPrimaryKey(Bm2MemorycardtypeTbl record);
}