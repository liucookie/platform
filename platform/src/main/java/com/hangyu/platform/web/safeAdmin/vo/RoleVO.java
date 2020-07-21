package com.hangyu.platform.web.safeAdmin.vo;

import com.hangyu.platform.web.safeAdmin.dto.Role;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class RoleVO extends Page {

    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
