package com.hangyu.platform.web.backBusiness.dto;

public class BmKeyplacepicmodelTbl {
    private Integer id;

    private String picmodelid;

    private String picmodelname;

    private String picmodelremark;

    private Integer sortorder;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicmodelid() {
        return picmodelid;
    }

    public void setPicmodelid(String picmodelid) {
        this.picmodelid = picmodelid == null ? null : picmodelid.trim();
    }

    public String getPicmodelname() {
        return picmodelname;
    }

    public void setPicmodelname(String picmodelname) {
        this.picmodelname = picmodelname == null ? null : picmodelname.trim();
    }

    public String getPicmodelremark() {
        return picmodelremark;
    }

    public void setPicmodelremark(String picmodelremark) {
        this.picmodelremark = picmodelremark == null ? null : picmodelremark.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}