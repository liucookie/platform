package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class Bm2FriendlysoftwareTbl {
    private String softid;

    private String typeid;
    @Excel(name = "软件类型", width = 20, orderNum = "1")
    private String typeName;
    @Excel(name = "软件名称", width = 20, orderNum = "2")
    private String softname;
    @Excel(name = "软件版本", width = 10, orderNum = "3")
    private String softver;
    @Excel(name = "生产商", width = 20, orderNum = "4")
    private String manufacturer;
    @Excel(name = "软件来源", width = 20, orderNum = "5")
    private String sourcefrom;
    @Excel(name = "启用时间", width = 15, orderNum = "6")
    private String usedate;
    @Excel(name = "用途", width = 20, orderNum = "7")
    private String useage;
    @Excel(name = "备注", width = 30, orderNum = "10")
    private String softremark;

    private Integer isdelete;

    private Date createtime;

    private Date updatetime;
    @Excel(name = "关键字", width = 30, orderNum = "8")
    private String keyword;
    @Excel(name = "授权使用范围", width = 20, orderNum = "9")
    private String authorizationuse;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSoftid() {
        return softid;
    }

    public void setSoftid(String softid) {
        this.softid = softid == null ? null : softid.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getSoftname() {
        return softname;
    }

    public void setSoftname(String softname) {
        this.softname = softname == null ? null : softname.trim();
    }

    public String getSoftver() {
        return softver;
    }

    public void setSoftver(String softver) {
        this.softver = softver == null ? null : softver.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getSourcefrom() {
        return sourcefrom;
    }

    public void setSourcefrom(String sourcefrom) {
        this.sourcefrom = sourcefrom == null ? null : sourcefrom.trim();
    }

    public String getUsedate() {
        return usedate;
    }

    public void setUsedate(String usedate) {
        this.usedate = usedate;
    }

    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage == null ? null : useage.trim();
    }

    public String getSoftremark() {
        return softremark;
    }

    public void setSoftremark(String softremark) {
        this.softremark = softremark == null ? null : softremark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getAuthorizationuse() {
        return authorizationuse;
    }

    public void setAuthorizationuse(String authorizationuse) {
        this.authorizationuse = authorizationuse == null ? null : authorizationuse.trim();
    }
}