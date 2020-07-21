package com.hangyu.platform.web.safeAdmin.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.safeAdmin.dto.Menu;
import com.hangyu.platform.web.safeAdmin.mapper.MenuMapper;
import com.hangyu.platform.web.logAdmin.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 增加菜单
     *
     * @param menu
     */
    @Transactional
    public void add(Menu menu) {
        menu.setCreateperson(TokenUtils.getUserName());
        //根节点的话，parentId都是-1,也就是一级菜单
        if (-1 == menu.getParentid()) {
            menu.setLevel(1);
        } else {
            //二级菜单，type为1，则表示菜单
            if (menu.getType() == 1) {
                menu.setLevel(2);
            }
        }
        menuMapper.insert(menu);
    }

    /**
     * 批量增加按钮
     * @param object
     */
    @Transactional
    public void addButton(Object object) {
        JSONObject json = (JSONObject) JSON.toJSON(object);
        int parentId = (Integer) json.get("parentId");
        List<String> buttonNames = (List<String>)json.get("buttonNames");
        if (CollectionUtils.isNotEmpty(buttonNames)){
            buttonNames.forEach(name ->{
                Menu menu = new Menu();
                menu.setMenuname(name);
                menu.setType(2);
                menu.setParentid(parentId);
                menu.setCreateperson(TokenUtils.getUserName());
                menuMapper.insert(menu);
            });
        }
    }

    /**
     * 修改菜单
     *
     * @param menu
     */
    @Transactional
    public void update(Menu menu) {
        menu.setUpdateperson(TokenUtils.getUserName());
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 删除菜单
     *
     * @param id
     */
    @Transactional
    public void delete(int id) {
        //删除当前id的菜单
        menuMapper.deleteByPrimaryKey(id);
        //如果是父节点，删除父节点下的
        menuMapper.deleteByPId(id);
    }

    /**
     * 查询菜单（可以区分管理员和普通用户）
     *
     * @param
     */
    public List<Menu> queryMenu(String type, String level) {
        List<Menu> list ;
        String account = TokenUtils.getUserName();
        //三个管理员，再查询对应的菜单
        if (StringUtils.equals(CommonFields.getLogAdmin(), account) || StringUtils.equals(CommonFields.getSafeAdmin(), account)
                || StringUtils.equals(CommonFields.getSysAdmin(), account)) {
            list = menuMapper.queryMenuByAdmin(account, type, level);
        } else {
            //查询出用户的菜单
            String userid = TokenUtils.getCurrentId();
            list = menuMapper.queryMenuByUserId(userid, type, level);
        }
        return list;
    }

    /**
     * 递归查询菜单
     * @param type
     * @return
     */
    public List<MenuVO> queryMenuVO(String type) {
        //查询一级目录
        List<MenuVO> list = menuMapper.queryMenuD(-1, type);
        return queryMenuD(list, type);
    }

    public List<MenuVO> queryMenuD(List<MenuVO> list, String type) {
        for (MenuVO menu : list) {
            //1是菜单,页面显示文件夹用
            if (StringUtils.equals("1",menu.getType())){
                menu.setIcon(CommonFields.getMenuIcon());
            }else {
                menu.setIcon(CommonFields.getButtonIcon());
            }
            List<MenuVO> allChildList = menuMapper.queryMenuD(menu.getId(), type);
            if (null != allChildList && allChildList.size() > 0) {
                menu.setChildMenu(allChildList);
                queryMenuD(allChildList, type);
            }
        }
        return list;
    }

    /**
     * 根据父级id查询出按钮，具体到菜单栏目
     *
     * @param parentId
     * @return
     */
    public List<Menu> queryButtonByParentId(int parentId) {
        List<Menu> list = menuMapper.queryButtonByParentId(parentId);
        return list;
    }

    /**
     * 查询用户二级菜单或者按钮
     *
     * @param id
     * @return
     */
    public List<Menu> getUserMenu(int id,int type) {
        List<Menu> list = new ArrayList<>();
        String account = TokenUtils.getAccount();
        if (StringUtils.equals(CommonFields.getLogAdmin(), account) || StringUtils.equals(CommonFields.getSafeAdmin(), account)
                || StringUtils.equals(CommonFields.getSysAdmin(), account)) {
            list = menuMapper.getUserMenu(type,id);
        }else {
            String userId = TokenUtils.getCurrentId();
            //查询出当前用户的所有菜单id
            List<Integer> userMenuIds = menuMapper.queryUserMenuIds(userId);
            //查询出这个parentId下面的菜单
            List<Integer> MenuIds = menuMapper.queryMenuId(id,type);
            //得到用户菜单下的交集
            List<Integer> ids = userMenuIds.stream().filter(item -> MenuIds.contains(item)).collect(toList());
            if (CollectionUtils.isNotEmpty(ids)){
                list = menuMapper.queryByMenuId(ids);
            }
        }
        return list;
    }

    /**
     * 查询出当前菜单按钮信息
     *
     * @param id
     * @return
     */
    public Menu queryMenuById(int id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        Menu parentMenu = menuMapper.selectByPrimaryKey(menu.getParentid());
        if (null != parentMenu) {
            menu.setParentName(parentMenu.getMenuname());
        }

        return menu;
    }
}
