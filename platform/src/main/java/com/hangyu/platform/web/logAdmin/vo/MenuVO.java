package com.hangyu.platform.web.logAdmin.vo;

import java.util.List;

public class MenuVO {
    private int id;
    private String menuName;
    private String type;
    private String icon;

    private List<MenuVO> childMenu;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MenuVO> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuVO> childMenu) {
        this.childMenu = childMenu;
    }
}
