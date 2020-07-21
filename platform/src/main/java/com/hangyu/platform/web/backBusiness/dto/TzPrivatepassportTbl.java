package com.hangyu.platform.web.backBusiness.dto;

public class TzPrivatepassportTbl {
    private Integer id;

    private String uniqueid;

    private String staffid;

    private String userName;

    private String orgName;

    private String deptName;

    private String orgid;

    private String passportnumber;

    private Integer usestate;

    private Integer isdeleted;

    private String remark;

    private String posttype;

    private String zhiwu;

    private String miji;

    private String secretName;

    private String qfdate;

    private String qfplace;

    private String youxiaoqi;

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

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

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber == null ? null : passportnumber.trim();
    }

    public Integer getUsestate() {
        return usestate;
    }

    public void setUsestate(Integer usestate) {
        this.usestate = usestate;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype == null ? null : posttype.trim();
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu == null ? null : zhiwu.trim();
    }

    public String getMiji() {
        return miji;
    }

    public void setMiji(String miji) {
        this.miji = miji == null ? null : miji.trim();
    }

    public String getQfdate() {
        return qfdate;
    }

    public void setQfdate(String qfdate) {
        this.qfdate = qfdate == null ? null : qfdate.trim();
    }

    public String getQfplace() {
        return qfplace;
    }

    public void setQfplace(String qfplace) {
        this.qfplace = qfplace == null ? null : qfplace.trim();
    }

    public String getYouxiaoqi() {
        return youxiaoqi;
    }

    public void setYouxiaoqi(String youxiaoqi) {
        this.youxiaoqi = youxiaoqi == null ? null : youxiaoqi.trim();
    }
}