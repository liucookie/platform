package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Oaequipinfo;
import com.hangyu.platform.web.backBusiness.vo.ServerManageQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OaequipinfoMapper {


    int deleteByPrimaryKey(String id);

    int insert(Oaequipinfo record);

    int insertSelective(Oaequipinfo record);


    Oaequipinfo selectByPrimaryKey(String id);

    List<Oaequipinfo> select(ServerManageQueryVO vo);

    int selectTotal(ServerManageQueryVO vo);

    List<Oaequipinfo> queryOAInfo(@Param("userId") String userId, @Param("typeId") String typeId);

    List<Oaequipinfo> selectAll(ServerManageQueryVO vo);


    int updateByPrimaryKeySelective(Oaequipinfo record);

    int updateByPrimaryKey(Oaequipinfo record);
}