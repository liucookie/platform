package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class TzPortablemanagementTbl {
    private Integer id;

    private String orgid;
    @Excel(name = "单位", width = 20, orderNum = "1")
    private String orgName;

    private String staffid;
    @Excel(name = "责任人", width = 20, orderNum = "2")
    private String userName;
    @Excel(name = "资产编号", width = 20, orderNum = "3")
    private String assetnumber;
    @Excel(name = "密级", width = 10, orderNum = "4")
    private String secretlevel;
    @Excel(name = "品牌型号", width = 10, orderNum = "5")
    private String brand;
    @Excel(name = "用途", width = 10, orderNum = "6")
    private String usage;
    @Excel(name = "清点状态(0在库，1借出)", width = 25, orderNum = "7")
    private String borrowstate;
    @Excel(name = "使用状态(0在用，1停运，2报废)", width = 30, orderNum = "8")
    private String usestate;
    @Excel(name = "系统安装时间", width = 20, orderNum = "9")
    private String installationtime;
    @Excel(name = "硬盘序列号", width = 30, orderNum = "10")
    private String diskserialnumber;
    @Excel(name = "备注", width = 40, orderNum = "11")
    private String remark;

    private Integer isdeleted;

    private String uniqueid;

    private String mac;

    private String osversion;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getAssetnumber() {
        return assetnumber;
    }

    public void setAssetnumber(String assetnumber) {
        this.assetnumber = assetnumber == null ? null : assetnumber.trim();
    }

    public String getSecretlevel() {
        return secretlevel;
    }

    public void setSecretlevel(String secretlevel) {
        this.secretlevel = secretlevel == null ? null : secretlevel.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage == null ? null : usage.trim();
    }

    public String getBorrowstate() {
        return borrowstate;
    }

    public void setBorrowstate(String borrowstate) {
        this.borrowstate = borrowstate == null ? null : borrowstate.trim();
    }

    public String getUsestate() {
        return usestate;
    }

    public void setUsestate(String usestate) {
        this.usestate = usestate == null ? null : usestate.trim();
    }

    public String getInstallationtime() {
        return installationtime;
    }

    public void setInstallationtime(String installationtime) {
        this.installationtime = installationtime;
    }

    public String getDiskserialnumber() {
        return diskserialnumber;
    }

    public void setDiskserialnumber(String diskserialnumber) {
        this.diskserialnumber = diskserialnumber == null ? null : diskserialnumber.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion == null ? null : osversion.trim();
    }
}