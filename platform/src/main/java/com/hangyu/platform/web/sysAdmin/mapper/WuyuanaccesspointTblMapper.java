package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.WuyuanaccesspointTbl;
import com.hangyu.platform.web.sysAdmin.vo.WuyuanAccessPointQueryVO;

import java.util.List;

public interface WuyuanaccesspointTblMapper {


    int deleteByPrimaryKey(Integer id);

    WuyuanaccesspointTbl selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(WuyuanaccesspointTbl record);

    List<WuyuanaccesspointTbl> queryByAddition(WuyuanAccessPointQueryVO vo);

    int selectTotal(WuyuanAccessPointQueryVO vo);

    int insert(WuyuanaccesspointTbl tbl);


    int updateByPrimaryKeySelective(WuyuanaccesspointTbl record);


}