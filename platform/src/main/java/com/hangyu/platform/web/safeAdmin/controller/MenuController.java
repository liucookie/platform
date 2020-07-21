package com.hangyu.platform.web.safeAdmin.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.safeAdmin.dto.Menu;
import com.hangyu.platform.web.safeAdmin.service.MenuService;
import com.hangyu.platform.web.logAdmin.vo.MenuVO;
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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 菜单管理
 */
@Api(tags = "菜单按钮相关接口")
@RestController
@RequestMapping(value = "v1/menu")
public class MenuController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private MenuService menuService;



    /**
     * 增加菜单,(管理员)
     * @param menu
     * @return
     */
    @ApiOperation(value="添加菜单{author:liuxuan}",response=Result.class)
    @SystemLog(module="菜单管理",methods="增加菜单")
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public ResponseEntity<Object> add( @RequestBody Menu menu) {
        menuService.add(menu);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 增加按钮,(管理员)
     * @param object
     * @return
     */
    @ApiOperation(value="增加按钮{author:liuxuan}",response=Result.class)
    @SystemLog(module="菜单管理",methods="添加按钮")
    @RequestMapping(value = "/addButton", method = RequestMethod.POST)
    public ResponseEntity<Object> addButton(@RequestBody Object object) {
        menuService.addButton(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改菜单(管理员)
     * @param menu
     * @return
     */
    @ApiOperation(value="修改菜单{author:liuxuan}",response=Result.class)
    @SystemLog(module="菜单管理",methods="修改菜单")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMenu(@RequestBody Menu menu) {
        menuService.update(menu);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 删除菜单(管理员)
     * @param parentId
     * @return
     */
    @ApiOperation(value="删除菜单{author:liuxuan}",response=Result.class)
    @SystemLog(module="菜单管理",methods="删除菜单")
    @RequestMapping(value = "/deleteMenu/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMenu( @PathVariable("id") int parentId) {
        menuService.delete(parentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 加载菜单(管理员)
     * @param type
     * @return
     */
    @ApiOperation(value="查询菜单(递归查询){author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/queryAllMenuVO", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllMenuVO(@RequestParam(value = "type",required = false) String type) {

        List<MenuVO> list = menuService.queryMenuVO(type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * 查询所有菜单不包含按钮 new(管理员)
     * @param type
     * @return
     */
    @ApiOperation(value="查询菜单{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/queryMenuWithOutButton", method = RequestMethod.GET)
    public ResponseEntity<Object> queryMenuWithOutButton(@RequestParam(value = "type",required = false) String type) {

        List<MenuVO> list = menuService.queryMenuVO("1");
        return ResponseEntity.ok(list);
    }

    /**
     * 查询菜单旗下按钮(管理员)
     * @param parentId
     * @return
     */
    @ApiOperation(value = "根据菜单id获取按钮{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/getButtonByMenuId", method =  RequestMethod.GET)
    public Object getButtonByMenuId(@RequestParam(value = "parentid") int parentId) {
        List<Menu> list = menuService.queryButtonByParentId(parentId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 查询当前菜单信息（管理员）
     * @param id
     * @return
     */
    @ApiOperation(value = "根据菜单Id获取当前信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/getInfoById", method =  RequestMethod.GET)
    public Object getInfoById(@RequestParam(value = "id") int id) {
        Menu list = menuService.queryMenuById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




    /**
     * 根据用户登录后加载一级菜单
     * @param level  1，一级菜单，2二级菜单
     * @param type 1菜单，2按钮
     * @return
     */
    @ApiOperation(value="根据用户登录后加载一级菜单{author:liuxuan}",response=Result.class)
    @RequestMapping(value = "/queryAllMenu", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllMenu(@RequestParam(value = "type",required = false) String type,
                                               @RequestParam(value = "level",required = false) String level) {

        List<Menu> list = menuService.queryMenu(type,level);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 根据用户登录后，查询二级菜单和按钮
     * @param id  当前菜单id
     * @param type 1菜单，2按钮
     * @return
     */
    @ApiOperation(value = "查询用户二级菜单和按钮{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/getUserMenu", method =  RequestMethod.GET)
    public Object getUserMenu(@RequestParam(value = "id") int id,
                              @RequestParam(value = "type",required = false) int type){
        List<Menu> list = menuService.getUserMenu(id,type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }






}