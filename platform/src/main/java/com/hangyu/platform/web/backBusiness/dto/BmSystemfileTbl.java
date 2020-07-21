package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSystemfileTbl {
    private Integer id;

    private String attachid;

    private String systemid;

    private String attachname;

    private String attachurl;

    private String attachremark;

    private Integer order;

    private Integer isdelete;

    private String attachver;

    private Date updatetime;

    private String operator;

    private Integer opertype;

    private Integer oldid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachid() {
        return attachid;
    }

    public void setAttachid(String attachid) {
        this.attachid = attachid == null ? null : attachid.trim();
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid == null ? null : systemid.trim();
    }

    public String getAttachname() {
        return attachname;
    }

    public void setAttachname(String attachname) {
        this.attachname = attachname == null ? null : attachname.trim();
    }

    public String getAttachurl() {
        return attachurl;
    }

    public void setAttachurl(String attachurl) {
        this.attachurl = attachurl == null ? null : attachurl.trim();
    }

    public String getAttachremark() {
        return attachremark;
    }

    public void setAttachremark(String attachremark) {
        this.attachremark = attachremark == null ? null : attachremark.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getAttachver() {
        return attachver;
    }

    public void setAttachver(String attachver) {
        this.attachver = attachver == null ? null : attachver.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getOpertype() {
        return opertype;
    }

    public void setOpertype(Integer opertype) {
        this.opertype = opertype;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }
}