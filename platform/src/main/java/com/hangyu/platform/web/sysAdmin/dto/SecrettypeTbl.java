package com.hangyu.platform.web.sysAdmin.dto;

public class SecrettypeTbl {
    private Integer id;

    private String uniqueid;

    private String name;

    private String remarkr;

    private Integer isdelete;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarkr() {
        return remarkr;
    }

    public void setRemarkr(String remarkr) {
        this.remarkr = remarkr == null ? null : remarkr.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}