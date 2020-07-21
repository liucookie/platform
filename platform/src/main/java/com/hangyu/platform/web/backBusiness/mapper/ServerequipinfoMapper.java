package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Serverequipinfo;
import com.hangyu.platform.web.backBusiness.vo.ServerManageQueryVO;

import java.util.List;

public interface ServerequipinfoMapper {


    int deleteByPrimaryKey(String id);

    int insert(Serverequipinfo record);

    int insertSelective(Serverequipinfo record);


    Serverequipinfo selectByPrimaryKey(String id);

    List<Serverequipinfo> select(ServerManageQueryVO vo);

    int  selectTotal(ServerManageQueryVO vo);

    List<Serverequipinfo> selectAll(ServerManageQueryVO vo);


    int updateByPrimaryKey(Serverequipinfo record);
}