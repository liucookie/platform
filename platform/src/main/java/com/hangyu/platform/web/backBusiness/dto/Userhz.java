package com.hangyu.platform.web.backBusiness.dto;

public class Userhz {
    private Integer id;

    private String userid;

    private String userName;

    private String deptName;

    private String orgName;

    private Integer hzyear;

    private Integer hzmonth;

    private Integer hztype;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getHzyear() {
        return hzyear;
    }

    public void setHzyear(Integer hzyear) {
        this.hzyear = hzyear;
    }

    public Integer getHzmonth() {
        return hzmonth;
    }

    public void setHzmonth(Integer hzmonth) {
        this.hzmonth = hzmonth;
    }

    public Integer getHztype() {
        return hztype;
    }

    public void setHztype(Integer hztype) {
        this.hztype = hztype;
    }
}