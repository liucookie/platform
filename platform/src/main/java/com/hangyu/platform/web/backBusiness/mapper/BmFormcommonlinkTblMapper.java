package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmFormcommonlinkTbl;
import com.hangyu.platform.web.backBusiness.dto.BmPunishTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmFormcommonlinkTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmFormcommonlinkTbl record);


    BmFormcommonlinkTbl selectByPrimaryKey(String id);

    List<BmFormcommonlinkTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal();

    int updateByPrimaryKey(BmFormcommonlinkTbl record);
}