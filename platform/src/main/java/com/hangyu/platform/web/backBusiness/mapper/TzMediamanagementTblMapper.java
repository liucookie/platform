package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TzMediamanagementTbl;
import com.hangyu.platform.web.backBusiness.dto.TzPortablemanagementTbl;
import com.hangyu.platform.web.backBusiness.vo.MediaManageQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TzMediamanagementTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(TzMediamanagementTbl record);

    int insertSelective(TzMediamanagementTbl record);


    TzMediamanagementTbl selectByPrimaryKey(String id);

    List<TzMediamanagementTbl> select(MediaManageQueryVO vo);

    List<TzMediamanagementTbl> selectAll(MediaManageQueryVO vo);

    int selectTotal(MediaManageQueryVO  vo);

    List<TzMediamanagementTbl> queryByUserId(@Param("userId") String userId);


    int updateByPrimaryKeySelective(TzMediamanagementTbl record);

    int updateByPrimaryKey(TzMediamanagementTbl record);
}