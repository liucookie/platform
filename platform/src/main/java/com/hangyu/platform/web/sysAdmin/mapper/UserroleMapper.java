package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.safeAdmin.dto.Userrole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserroleMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Userrole record);

    int insertSelective(Userrole record);


    Userrole selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Userrole record);

    int updateByPrimaryKey(Userrole record);

    int insertBatch(List<Userrole> list);

    int deleteByRoleId(Integer roleid);

    int deleteByUserId(@Param("userid") String userid);
}