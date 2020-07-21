package com.hangyu.platform.web.safeAdmin.mapper;

import com.hangyu.platform.web.safeAdmin.dto.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);


    Role selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role selectByRoleName(String roleName);

    List<Role> queryAllByPage(@Param("orgid") String orgid,@Param("rolename") String rolename,
                        @Param("start") int start,@Param("pageSize") int pageSize);

    List<Role> queryAllRole(@Param("orgid") String orgid,@Param("rolename") String rolename);

    List<String> queryUserNameByRoleId(@Param("roleid") Integer roleid);

    List<String> queryRoleByUserId(@Param("userid") String userid);

    List<Role> getRoleByUserId(String userId);

    List<String> queryUserId(@Param("roleId") Integer roleId);


}