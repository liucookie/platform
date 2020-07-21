package com.hangyu.platform.web.safeAdmin.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.safeAdmin.dto.Role;
import com.hangyu.platform.web.safeAdmin.dto.RoleAndMenu;
import com.hangyu.platform.web.safeAdmin.service.RoleService;
import com.hangyu.platform.web.safeAdmin.vo.RoleVO;
import com.hangyu.platform.web.safeAdmin.vo.UserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 角色管理
 */
@Api(tags = "角色管理相关接口")
@RestController
@RequestMapping(value = "v1/role")
public class RoleController {
    //响应成功状态设置
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private RoleService roleService;


    /**
     * 添加角色以及权限 role，menu
     * @param menu
     * @return
     */
    @ApiOperation(value="添加菜单以及权限{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/addRoleAndMenus", method = RequestMethod.POST)
    @SystemLog(module="角色管理",methods="添加角色")
    public ResponseEntity<Object> addRoleAndMenus(@RequestBody RoleAndMenu menu) {
        roleService.addRoleAndMenus(menu);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="修改角色以及角色关联的菜单{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/updatePermissionAndMenus",method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePermissionAndMenus(@RequestBody RoleAndMenu menu){
        roleService.updatePermissionAndMenus(menu);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value="获取所有的角色以及角色下人员{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/getAllRole",method=RequestMethod.GET)
    public ResponseEntity<Object> getAllRole(@RequestParam(value = "orgid",required = false) String orgid,
                                                               @RequestParam(value = "rolename",required = false) String rolename,
                                                               @RequestParam(value = "pageNum") int pageNum,
                                                               @RequestParam(value = "pageSize") int pageSize){
        RoleVO roleVO = roleService.selectAllRole(orgid,rolename,pageNum,pageSize);
        return new ResponseEntity<>(roleVO, HttpStatus.OK);
    }


    /**
     * 查询角色信息以及角色相关联的菜单,当前角色下的人员信息
     * @param roleId
     * @return
     */
    @ApiOperation(value="根据角色id查询角色信息{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/getRoleById",method=RequestMethod.GET)
    public ResponseEntity<Object> getRoleById(@RequestParam(value = "roleId") int roleId){
        Role role = roleService.getRoleById(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }



    /**
     * 角色下分配人员
     * @param userRoleVO
     * @return
     */
    @ApiOperation(value="权限分配用户{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/addRoleAndUser", method = RequestMethod.POST)
    @SystemLog(module="角色管理",methods="分配人员")
    public ResponseEntity<Object> addRoleAndUser(@RequestBody UserRoleVO userRoleVO) {
        //一个角色下添加多个用户
        roleService.addRoleAndUser(userRoleVO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除权限以及分配的用户，role表和roleuser表,menurole表
     * @param roleId
     * @return
     */
    @ApiOperation(value="删除权限以及分配的用户{author:liuxuan}",response=Result.class)
    @SystemLog(module="角色管理",methods="删除角色")
    @RequestMapping(value = "/delRoleAndUser", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delRoleAndUser(@RequestParam("id") Integer roleId) {

        roleService.deleteRoleAndUser(roleId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value="获取所有的角色信息{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/getRole",method=RequestMethod.GET)
    public ResponseEntity<Object> getRole(){
        List<Role> list = roleService.getRole();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @ApiOperation(value="根据用户id获取角色信息{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/getRoleByUserId/{userId}",method=RequestMethod.GET)
    public ResponseEntity<Object> getRoleByUserId(@PathVariable("userId") String userId){
        List<Role> list = roleService.getRoleByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}