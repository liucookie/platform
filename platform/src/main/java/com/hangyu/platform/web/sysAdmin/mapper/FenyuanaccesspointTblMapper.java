package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.FenyuanaccesspointTbl;
import com.hangyu.platform.web.sysAdmin.vo.WuyuanAccessPointQueryVO;

import java.util.List;

public interface FenyuanaccesspointTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(FenyuanaccesspointTbl record);


    FenyuanaccesspointTbl selectByPrimaryKey(Integer id);

    List<FenyuanaccesspointTbl> queryByAddition(WuyuanAccessPointQueryVO vo);

    int selectTotal(WuyuanAccessPointQueryVO vo);

    int updateByPrimaryKeySelective(FenyuanaccesspointTbl record);


    int updateByPrimaryKey(FenyuanaccesspointTbl record);
}