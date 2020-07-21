package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.dto.OaLevelintegrate;
import java.util.List;

import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;

public interface OaLevelintegrateMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OaLevelintegrate record);

    int insertSelective(OaLevelintegrate record);

    List<OaLevelintegrate> select(AvidmQueryVO vo);

    List<AvidmLevelintegrate> selectTotal(AvidmQueryVO vo);

    OaLevelintegrate selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(OaLevelintegrate record);

    int updateByPrimaryKey(OaLevelintegrate record);
}