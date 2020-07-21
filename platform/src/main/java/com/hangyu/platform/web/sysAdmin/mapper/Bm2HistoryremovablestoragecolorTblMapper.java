package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragecolorTbl;

import java.util.List;

public interface Bm2HistoryremovablestoragecolorTblMapper {


    int deleteByPrimaryKey(String colorid);

    int insert(Bm2HistoryremovablestoragecolorTbl record);

    int insertSelective(Bm2HistoryremovablestoragecolorTbl record);


    Bm2HistoryremovablestoragecolorTbl selectByPrimaryKey(String colorid);

    List<Bm2HistoryremovablestoragecolorTbl> selectColor();


    int updateByPrimaryKeySelective(Bm2HistoryremovablestoragecolorTbl record);

    int updateByPrimaryKey(Bm2HistoryremovablestoragecolorTbl record);
}