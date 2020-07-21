package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.UsbkeyTbl;
import com.hangyu.platform.web.backBusiness.vo.UsbKeyQueryVO;

import java.util.List;

public interface UsbkeyTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(UsbkeyTbl record);

    int insertSelective(UsbkeyTbl record);


    UsbkeyTbl selectByPrimaryKey(String  id);

    List<UsbkeyTbl> select(UsbKeyQueryVO vo);

    int selectTotal(UsbKeyQueryVO  vo);


    int updateByPrimaryKeySelective(UsbkeyTbl record);

    int updateByPrimaryKey(UsbkeyTbl record);
}