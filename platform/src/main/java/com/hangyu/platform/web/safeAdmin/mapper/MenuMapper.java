package com.hangyu.platform.web.safeAdmin.mapper;

import com.hangyu.platform.web.safeAdmin.dto.Menu;
import com.hangyu.platform.web.logAdmin.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuMapper {


    int deleteByPrimaryKey(Integer id);


    int insert(Menu record);


    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    List<Menu> queryByRoleId(Integer roleId);


    //admin角色查询所有的菜单
    List<Menu> queryAllMenu(@Param("type") String type);

    //用户角色查询所有的菜单
    List<Menu> queryMenuByUserId(@Param("userid")String userid,@Param("type") String type,@Param("level") String level);


    List<Menu> queryMenuByAdmin(@Param("account")String account,@Param("type") String type,@Param("level") String level);

    int deleteByPId(int pId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> queryButtonByParentId(@Param("parentid") int parentid);

    List<Menu> getUserMenu(@Param("type") int type,@Param("id") int id);

    //递归查询
    List<MenuVO> queryMenuD(@Param("parentId") int parentId,@Param("type") String type);

    List<Menu> queryByMenuId(List<Integer> list);

    List<Integer> queryUserMenuIds(String userId);

    List<Integer> queryMenuId(int id,int type);

}