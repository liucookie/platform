package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.dto.BmWorkdynTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmHyperlinkTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmHyperlinkTbl record);

    BmHyperlinkTbl selectByPrimaryKey(String id);

    List<BmHyperlinkTbl> select(@Param("start")int start, @Param("pageSize") int pageSize);

    List<BmHyperlinkTbl> queryHyperLink(@Param("topSign") String topSign);

    int selectTotal();

    int updateByPrimaryKey(BmHyperlinkTbl record);
}