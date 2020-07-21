package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.CooperationinfoTbl;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;

import java.util.List;

public interface CooperationinfoTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(CooperationinfoTbl record);

    int insertSelective(CooperationinfoTbl record);

    CooperationinfoTbl selectByPrimaryKey(String id);

    List<CooperationinfoTbl> select(CooperationQueryVO vo);

    List<CooperationinfoTbl> selectTotal(CooperationQueryVO vo);

    int updateByPrimaryKey(CooperationinfoTbl record);
}