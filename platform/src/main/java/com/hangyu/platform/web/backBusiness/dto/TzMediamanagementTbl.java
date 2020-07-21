package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TzMediamanagementTbl {
    private Integer id;
    @Excel(name = "介质编号", width = 20, orderNum = "3")
    private String mediaid;

    private String orgid;
    @Excel(name = "单位", width = 30, orderNum = "1")
    private String orgName;

    private String staffid;
    @Excel(name = "责任人", width = 10, orderNum = "2")
    private String userName;
    @Excel(name = "密级", width = 10, orderNum = "4")
    private String secretlevel;
    @Excel(name = "设备编号", width = 20, orderNum = "5")
    private String equipid;
    @Excel(name = "品牌", width = 20, orderNum = "6")
    private String brand;
    @Excel(name = "介质用途", width = 10, orderNum = "7")
    private String usage;
    @Excel(name = "借出状态(0在库，1借出)", width = 10, orderNum = "9")
    private String borrowstate;
    @Excel(name = "使用状态(0在用，1停运，2报废)", width = 10, orderNum = "8")
    private String usestate;
    @Excel(name = "介质容量", width = 10, orderNum = "10")
    private String mediasize;
    @Excel(name = "芯片序列号", width = 20, orderNum = "11")
    private String chipserialnumber;
    @Excel(name = "备注", width = 50, orderNum = "12")
    private String remark;

    private Integer isdeleted;

    private String uniqueid;

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

    public String getMediaid() {
        return mediaid;
    }

    public void setMediaid(String mediaid) {
        this.mediaid = mediaid == null ? null : mediaid.trim();
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

    public String getSecretlevel() {
        return secretlevel;
    }

    public void setSecretlevel(String secretlevel) {
        this.secretlevel = secretlevel == null ? null : secretlevel.trim();
    }

    public String getEquipid() {
        return equipid;
    }

    public void setEquipid(String equipid) {
        this.equipid = equipid == null ? null : equipid.trim();
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

    public String getMediasize() {
        return mediasize;
    }

    public void setMediasize(String mediasize) {
        this.mediasize = mediasize == null ? null : mediasize.trim();
    }

    public String getChipserialnumber() {
        return chipserialnumber;
    }

    public void setChipserialnumber(String chipserialnumber) {
        this.chipserialnumber = chipserialnumber == null ? null : chipserialnumber.trim();
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
}