package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TzPrivatepassportTbl;
import com.hangyu.platform.web.backBusiness.vo.UsbKeyQueryVO;

import java.util.List;

public interface TzPrivatepassportTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(TzPrivatepassportTbl record);

    int insertSelective(TzPrivatepassportTbl record);


    TzPrivatepassportTbl selectByPrimaryKey(String id);

    List<TzPrivatepassportTbl> select(UsbKeyQueryVO vo);

    int selectTotal(UsbKeyQueryVO  vo);

    int updateByPrimaryKeySelective(TzPrivatepassportTbl record);

    int updateByPrimaryKey(TzPrivatepassportTbl record);
}