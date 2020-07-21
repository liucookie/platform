package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Secretlevel;

import java.util.List;

public interface SecretlevelMapper {

    int deleteByPrimaryKey(String id);

    int insert(Secretlevel record);

    int insertSelective(Secretlevel record);

    Secretlevel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Secretlevel record);

    int updateByPrimaryKey(Secretlevel record);

    List<Secretlevel> selectAllSecret(int start,int pageSize);

    List<Secretlevel> querySecret();

    int selectTotal();
}