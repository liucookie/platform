package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2ExaminestandardhandleTbl;
import com.hangyu.platform.web.sysAdmin.vo.ExamHandleQueryVO;

import java.util.List;

public interface Bm2ExaminestandardhandleTblMapper {


    int deleteByPrimaryKey(List<String> list);

    int insert(Bm2ExaminestandardhandleTbl record);

    int insertSelective(Bm2ExaminestandardhandleTbl record);


    Bm2ExaminestandardhandleTbl selectByPrimaryKey(String exstdhandleid);

    List<Bm2ExaminestandardhandleTbl> query(ExamHandleQueryVO vo);

    int selectTotal(ExamHandleQueryVO vo);


    int updateByPrimaryKeySelective(Bm2ExaminestandardhandleTbl record);

    int updateByPrimaryKey(Bm2ExaminestandardhandleTbl record);
}