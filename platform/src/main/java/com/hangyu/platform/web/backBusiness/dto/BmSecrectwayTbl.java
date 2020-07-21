package com.hangyu.platform.web.backBusiness.dto;

public class BmSecrectwayTbl {
    private Integer id;

    private String outwayid;

    private Integer outwaytype;

    private String outwayname;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutwayid() {
        return outwayid;
    }

    public void setOutwayid(String outwayid) {
        this.outwayid = outwayid == null ? null : outwayid.trim();
    }

    public Integer getOutwaytype() {
        return outwaytype;
    }

    public void setOutwaytype(Integer outwaytype) {
        this.outwaytype = outwaytype;
    }

    public String getOutwayname() {
        return outwayname;
    }

    public void setOutwayname(String outwayname) {
        this.outwayname = outwayname == null ? null : outwayname.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}