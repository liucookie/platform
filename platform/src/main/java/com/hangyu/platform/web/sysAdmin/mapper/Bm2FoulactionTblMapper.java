package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactionTbl;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionQueryVO;

import java.util.List;

public interface Bm2FoulactionTblMapper {

    int deleteByPrimaryKey(String foulactionid);

    int insert(Bm2FoulactionTbl record);

    int insertSelective(Bm2FoulactionTbl record);

    Bm2FoulactionTbl selectByPrimaryKey(String foulactionid);

    List<Bm2FoulactionTbl> query(Bm2FoulactionQueryVO vo);

    List<Bm2FoulactionTbl> queryByType(String type);

    int selectTotal(Bm2FoulactionQueryVO vo);

    int insertBatch(List<Bm2FoulactionTbl> list);

    List<Bm2FoulactionTbl> queryAll(Bm2FoulactionQueryVO vo);

    int updateByPrimaryKeySelective(Bm2FoulactionTbl record);

    int updateByPrimaryKey(Bm2FoulactionTbl record);
}