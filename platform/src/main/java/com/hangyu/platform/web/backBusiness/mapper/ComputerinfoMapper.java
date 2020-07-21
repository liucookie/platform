package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import java.util.List;

import com.hangyu.platform.web.backBusiness.vo.ComputerQueryVO;
import org.apache.ibatis.annotations.Param;

public interface ComputerinfoMapper {


    int deleteByPrimaryKey(String id);

    int insert(Computerinfo record);

    int insertSelective(Computerinfo record);


    Computerinfo selectByPrimaryKey(String id);

    List<Computerinfo> select(ComputerQueryVO vo);

    List<Computerinfo> selectAll(ComputerQueryVO vo);

    List<Computerinfo> queryComputerInfo(@Param("userId") String userId,@Param("typeId") String typeId);

    int selectTotal(ComputerQueryVO  vo);


    int updateByPrimaryKeySelective(Computerinfo record);

    int updateByPrimaryKey(Computerinfo record);
}