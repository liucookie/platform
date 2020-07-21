package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class UsbkeyTbl {
    private Integer id;

    private String uniqueid;

    private String userid;

    private String userName;

    private String deptid;

    private String deptName;

    private String orgid;

    private String orgName;

    private String usbname;

    private String usbtype;

    private String usbsecret;

    private String secretName;

    private String factory;

    private String getdate;

    private String startusedate;

    private String usecase;

    private String remark;

    private Integer status;

    private Integer isdelete;

    private String creater;

    private String createtime;

    private String updater;

    private String updatetime;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getUsbname() {
        return usbname;
    }

    public void setUsbname(String usbname) {
        this.usbname = usbname == null ? null : usbname.trim();
    }

    public String getUsbtype() {
        return usbtype;
    }

    public void setUsbtype(String usbtype) {
        this.usbtype = usbtype == null ? null : usbtype.trim();
    }

    public String getUsbsecret() {
        return usbsecret;
    }

    public void setUsbsecret(String usbsecret) {
        this.usbsecret = usbsecret == null ? null : usbsecret.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getGetdate() {
        return getdate;
    }

    public void setGetdate(String getdate) {
        this.getdate = getdate == null ? null : getdate.trim();
    }

    public String getStartusedate() {
        return startusedate;
    }

    public void setStartusedate(String startusedate) {
        this.startusedate = startusedate == null ? null : startusedate.trim();
    }

    public String getUsecase() {
        return usecase;
    }

    public void setUsecase(String usecase) {
        this.usecase = usecase == null ? null : usecase.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

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

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}