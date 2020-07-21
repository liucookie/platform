package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TzPortablemanagementTbl;
import com.hangyu.platform.web.backBusiness.vo.MediaManageQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TzPortablemanagementTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(TzPortablemanagementTbl record);

    int insertSelective(TzPortablemanagementTbl record);

    TzPortablemanagementTbl selectByPrimaryKey(String id);

    List<TzPortablemanagementTbl> select(MediaManageQueryVO vo);

    List<TzPortablemanagementTbl> selectAll(MediaManageQueryVO vo);

    List<TzPortablemanagementTbl> queryByUserId(@Param("userId") String userId);

    int  selectTotal(MediaManageQueryVO vo);



    int updateByPrimaryKeySelective(TzPortablemanagementTbl record);

    int updateByPrimaryKey(TzPortablemanagementTbl record);
}