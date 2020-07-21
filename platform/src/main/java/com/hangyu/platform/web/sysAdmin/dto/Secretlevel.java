package com.hangyu.platform.web.sysAdmin.dto;

public class Secretlevel {
    private Integer id;

    private String uniqueid;

    private String secretlevelname;

    private String secretlevelweight;

    private String secretlevelmemo;

    private Integer isdelete;

    private Integer secrettype;

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

    public String getSecretlevelname() {
        return secretlevelname;
    }

    public void setSecretlevelname(String secretlevelname) {
        this.secretlevelname = secretlevelname == null ? null : secretlevelname.trim();
    }

    public String getSecretlevelweight() {
        return secretlevelweight;
    }

    public void setSecretlevelweight(String secretlevelweight) {
        this.secretlevelweight = secretlevelweight == null ? null : secretlevelweight.trim();
    }

    public String getSecretlevelmemo() {
        return secretlevelmemo;
    }

    public void setSecretlevelmemo(String secretlevelmemo) {
        this.secretlevelmemo = secretlevelmemo == null ? null : secretlevelmemo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getSecrettype() {
        return secrettype;
    }

    public void setSecrettype(Integer secrettype) {
        this.secrettype = secrettype;
    }
}