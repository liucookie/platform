package com.hangyu.platform.web.backBusiness.dto;

public class Bm2CreditmanagerorgsTbl {
    private Integer id;

    private String staffid;

    private String staffname;

    private Integer roletype;

    private String orgsname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }

    public String getOrgsname() {
        return orgsname;
    }

    public void setOrgsname(String orgsname) {
        this.orgsname = orgsname == null ? null : orgsname.trim();
    }
}