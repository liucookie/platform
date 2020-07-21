package com.hangyu.platform.web.backBusiness.dto;

import java.io.Serializable;

public class Organization implements Serializable {
    private Integer id;

    private String uniqueid;

    private String parentid;

    private String orgname;

    private String orgmemo;

    private Integer isdelete;

    private String orgpath;

    private Integer ordertax;

    private String synid;

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

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgmemo() {
        return orgmemo;
    }

    public void setOrgmemo(String orgmemo) {
        this.orgmemo = orgmemo == null ? null : orgmemo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getOrgpath() {
        return orgpath;
    }

    public void setOrgpath(String orgpath) {
        this.orgpath = orgpath == null ? null : orgpath.trim();
    }

    public Integer getOrdertax() {
        return ordertax;
    }

    public void setOrdertax(Integer ordertax) {
        this.ordertax = ordertax;
    }

    public String getSynid() {
        return synid;
    }

    public void setSynid(String synid) {
        this.synid = synid == null ? null : synid.trim();
    }
}