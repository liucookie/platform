package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmSecsofttypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.Orgvirtuallist;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrgvirtuallistMapper {

    int deleteByPrimaryKey(String id);

    int insert(Orgvirtuallist record);


    Orgvirtuallist selectByPrimaryKey(String id);

    List<Orgvirtuallist> query(@Param("start") int start, @Param("pageSize") int pageSize,@Param("name") String name);

    int selectTotal(@Param("name") String name);

    int updateByPrimaryKey(Orgvirtuallist record);
}