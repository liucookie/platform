package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestorageinfoTbl;
import com.hangyu.platform.web.sysAdmin.vo.Bm2HistoryQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface Bm2HistoryremovablestorageinfoTblMapper {

    int deleteByPrimaryKey(String hremovablestorageid);

    int insert(Bm2HistoryremovablestorageinfoTbl record);

    int insertBatch(@Param("list") List<Bm2HistoryremovablestorageinfoTbl> list);

    int insertSelective(Bm2HistoryremovablestorageinfoTbl record);


    Bm2HistoryremovablestorageinfoTbl selectByPrimaryKey(String hremovablestorageid);

    List<Bm2HistoryremovablestorageinfoTbl> selectByAddition(Bm2HistoryQueryVO vo);

    int selectTotal(Bm2HistoryQueryVO vo);

    int updateByPrimaryKeySelective(Bm2HistoryremovablestorageinfoTbl record);

    int updateByPrimaryKey(Bm2HistoryremovablestorageinfoTbl record);
}