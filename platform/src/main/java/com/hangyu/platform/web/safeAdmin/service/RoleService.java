package com.hangyu.platform.web.safeAdmin.service;

import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.StringKit;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.safeAdmin.dto.Menu;
import com.hangyu.platform.web.safeAdmin.dto.Menurole;
import com.hangyu.platform.web.safeAdmin.dto.Role;
import com.hangyu.platform.web.safeAdmin.dto.RoleAndMenu;
import com.hangyu.platform.web.safeAdmin.dto.Userrole;
import com.hangyu.platform.web.safeAdmin.mapper.MenuMapper;
import com.hangyu.platform.web.safeAdmin.mapper.MenuroleMapper;
import com.hangyu.platform.web.safeAdmin.mapper.RoleMapper;
import com.hangyu.platform.web.sysAdmin.mapper.UserroleMapper;
import com.hangyu.platform.web.safeAdmin.vo.RoleVO;
import com.hangyu.platform.web.safeAdmin.vo.UserRoleVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuroleMapper menuroleMapper;

    @Resource
    private UserroleMapper userroleMapper;

    @Resource
    private MenuMapper menuMapper;


    /**
     * 增加角色以及权限
     *
     * @param roleAndMenu
     */
    @Transactional
    public void addRoleAndMenus(RoleAndMenu roleAndMenu) {

        if (roleAndMenu == null) {
            throw new PlatException("角色为空");
        }
        StringKit.checkValueIsEmpty("角色名", roleAndMenu.getRolename());

        Role role1 = roleMapper.selectByRoleName(roleAndMenu.getRolename());
        if (null != role1) {
            throw new PlatException("角色名已存在");
        }

        Role role = roleAndMenu;
        String account = TokenUtils.getUserName();

        role.setCreateperson(account);

        //先将角色加入数据库
        int i = roleMapper.insert(role);
        Role role2 = roleMapper.selectByRoleName(role.getRolename());
        List<Menurole> list = new ArrayList<>();
        //将数据加入到角色菜单表
        if (i > 0 && roleAndMenu.getMenus() != null) {
            roleAndMenu.getMenus().forEach(menu -> {
                Menurole menurole = new Menurole();
                //菜单id
                menurole.setMenuid(menu.getId());
                //角色id，一个角色对应多个菜单
                menurole.setRoleid(role2.getId());
                list.add(menurole);
            });
            //将角色菜单存储到表中
            if (CollectionUtils.isNotEmpty(list)){
                menuroleMapper.insertBatch(list);
            }
        }
    }

    /**
     * 修改角色以及菜单
     *
     * @param roleAndMenu
     */
    @Transactional
    public void updatePermissionAndMenus(RoleAndMenu roleAndMenu) {
        if (roleAndMenu == null) {
            throw new PlatException("角色为空");
        }
        StringKit.checkValueIsEmpty("角色名", roleAndMenu.getRolename());

        Role role1 = roleMapper.selectByRoleName(roleAndMenu.getRolename());
        if (null != role1 && (!role1.getId().equals(roleAndMenu.getId()))) {
            throw new PlatException("角色已存在");
        }

        Role role = roleAndMenu;
        role.setUpdateperson(TokenUtils.getUserName());
        //更新角色表
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if (i > 0 && roleAndMenu.getMenus() != null) {
            //先删除原来的角色菜单表的数据，menurole,再存储
            menuroleMapper.deleteByRoleId(role.getId());
            List<Menurole> list = new ArrayList<>();
            roleAndMenu.getMenus().forEach(menu -> {
                Menurole menurole = new Menurole();
                //菜单id
                menurole.setMenuid(menu.getId());
                //角色id，一个角色对应多个菜单
                menurole.setRoleid(role.getId());
                list.add(menurole);
            });
            //将角色菜单存储到表中
            if (CollectionUtils.isNotEmpty(list)){
                menuroleMapper.insertBatch(list);
            }
        }
    }

    /**
     * 查询所有的角色
     *
     * @param orgid
     * @param rolename
     * @param pageNum
     * @param pageSize
     */
    public RoleVO selectAllRole(String orgid, String rolename, int pageNum, int pageSize) {
        RoleVO roleVO = new RoleVO();

        //查询起始数据
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        //查询角色
        List<Role> roles = roleMapper.queryAllByPage(orgid, rolename, start, pageSize);
        List<Role> allRoles = roleMapper.queryAllRole(orgid, rolename);
        roles.forEach(role -> {
            //填充角色下的人员
            List<String> userNameList = roleMapper.queryUserNameByRoleId(role.getId());
            StringBuilder sb = new StringBuilder();
            if (CollectionUtils.isNotEmpty(userNameList)) {
                userNameList.forEach(name -> {
                    sb.append(name).append(",");
                });
                role.setPerson(sb.toString().substring(0, sb.lastIndexOf(",")));
            }
        });

        int page = allRoles.size() > 0 ? (allRoles.size() / pageSize) + 1 : 0;

        roleVO.setRoles(roles);
        roleVO.setTotalPage(page);
        roleVO.setTotalSize(allRoles.size());
        return roleVO;
    }


    /**
     * 角色下分配用户
     *
     * @param userRoleVO
     */
    @Transactional
    public void addRoleAndUser(UserRoleVO userRoleVO) {
        List<String> userIds = userRoleVO.getUserids();
        List<Userrole> list = new ArrayList<>();
        //每次分配前，先用roleId删除库里原来的数据
        userroleMapper.deleteByRoleId(userRoleVO.getRoleid());
        userIds.forEach(id -> {
            Userrole userrole = new Userrole();
            userrole.setUserid(id);
            userrole.setRoleid(userRoleVO.getRoleid());
            list.add(userrole);
        });
        if (CollectionUtils.isNotEmpty(list)){
            userroleMapper.insertBatch(list);
        }
    }

    /**
     * 根据角色id查询
     * @param roleId
     * @return
     */
    public Role getRoleById(int roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        List<Menu> menus = menuMapper.queryByRoleId(roleId);
        List<String> userIds = roleMapper.queryUserId(roleId);
        role.setMenuList(menus);
        role.setUserIds(userIds);
        return role;

    }

    /**
     * 除权限以及分配的用户，role表和roleuser表,menurole表
     *
     * @param roleId
     */
    @Transactional
    public void deleteRoleAndUser(int roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
        userroleMapper.deleteByRoleId(roleId);
        menuroleMapper.deleteByRoleId(roleId);
    }

    /**
     * 查询所有角色，员工管理分配角色用
     * @return
     */
    public List<Role> getRole(){
        List<Role> allRoles = roleMapper.queryAllRole(null, null);
        return allRoles;
    }

    /**
     * 查询所有角色，员工管理分配角色用
     * @return
     */
    public List<Role> getRoleByUserId(String userId){
        List<Role> allRoles = roleMapper.getRoleByUserId(userId);
        return allRoles;
    }
}
