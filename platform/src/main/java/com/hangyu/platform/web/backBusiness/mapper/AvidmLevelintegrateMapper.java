package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;

import java.util.List;

public interface AvidmLevelintegrateMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(AvidmLevelintegrate record);

    int insertSelective(AvidmLevelintegrate record);


    AvidmLevelintegrate selectByPrimaryKey(Integer id);

    List<AvidmLevelintegrate> select(AvidmQueryVO vo);

    List<AvidmLevelintegrate> selectTotal(AvidmQueryVO vo);

    int updateByPrimaryKeySelective(AvidmLevelintegrate record);

    int updateByPrimaryKey(AvidmLevelintegrate record);
}