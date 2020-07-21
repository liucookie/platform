package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class AffairsexerciseinfoUsers {
    private Integer id;

    private String staffid;

    private String username;

    private String linkname;

    private String usersex;

    private String nationality;

    private String unitname;

    private String userjob;

    private String idcard;

    private String visitorstallname;

    private String visitorstalljod;

    private Date updatetime;

    private Integer isdelete;

    private String userid;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname == null ? null : linkname.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getUserjob() {
        return userjob;
    }

    public void setUserjob(String userjob) {
        this.userjob = userjob == null ? null : userjob.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getVisitorstallname() {
        return visitorstallname;
    }

    public void setVisitorstallname(String visitorstallname) {
        this.visitorstallname = visitorstallname == null ? null : visitorstallname.trim();
    }

    public String getVisitorstalljod() {
        return visitorstalljod;
    }

    public void setVisitorstalljod(String visitorstalljod) {
        this.visitorstalljod = visitorstalljod == null ? null : visitorstalljod.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}