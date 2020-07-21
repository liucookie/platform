package com.hangyu.platform.web.safeAdmin.dto;

import java.util.List;

public class RoleAndMenu extends Role {

    List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
