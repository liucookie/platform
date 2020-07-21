package com.hangyu.platform.web.logAdmin.mapper;

import com.hangyu.platform.web.logAdmin.dto.Loginfo;
import com.hangyu.platform.web.logAdmin.vo.LogQueryVO;

import java.util.List;


public interface LoginfoMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Loginfo record);

    int insertSelective(Loginfo record);

    Loginfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginfo record);

    int updateByPrimaryKey(Loginfo record);
    //查询用户和系统日志，分页
    List<Loginfo> selectByPage( LogQueryVO queryVO);
    //查询用户和系统日志，总数, excel导出要用此查询方法
    List<Loginfo> selectAllLog(LogQueryVO queryVO);

}