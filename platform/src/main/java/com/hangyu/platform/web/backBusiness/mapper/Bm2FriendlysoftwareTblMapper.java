package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Bm2FriendlysoftwareTbl;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;

import java.util.List;

public interface Bm2FriendlysoftwareTblMapper {

    int deleteByPrimaryKey(String softid);

    int insert(Bm2FriendlysoftwareTbl record);

    Bm2FriendlysoftwareTbl selectByPrimaryKey(String softid);

    List<Bm2FriendlysoftwareTbl> select(SoftWareQueryVO vo);

    int selectTotal(SoftWareQueryVO  vo);

    int updateByPrimaryKey(Bm2FriendlysoftwareTbl record);

    List<Bm2FriendlysoftwareTbl> exportExcel(SoftWareQueryVO vo);
}