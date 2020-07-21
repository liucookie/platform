package com.hangyu.platform.web.sysAdmin.dto;

import java.util.Date;

public class AdminTbl {
    private Integer id;

    private String uniqueid;

    private String adminid;

    private String pass;

    private Integer roletype;

    private String changepasswdtime;

    private String lastlogintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid == null ? null : adminid.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }

    public String getChangepasswdtime() {
        return changepasswdtime;
    }

    public void setChangepasswdtime(String changepasswdtime) {
        this.changepasswdtime = changepasswdtime;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
}