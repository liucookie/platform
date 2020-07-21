package com.hangyu.platform.web.safeAdmin.vo;

import java.util.List;

public class UserRoleVO {

    private Integer roleid;

    private List<String> userids;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public List<String> getUserids() {
        return userids;
    }

    public void setUserids(List<String> userids) {
        this.userids = userids;
    }
}
