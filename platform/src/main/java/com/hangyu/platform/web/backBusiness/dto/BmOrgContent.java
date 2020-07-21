package com.hangyu.platform.web.backBusiness.dto;



public class BmOrgContent {
    private Integer id;

    private Integer contenttype;

    private String contentremark;

    private String updatetime;

    private String attfile;

    private String orgid;

    private Integer isdelete;

    private String userid;

    private String contentid;

    private String userName;



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

    public Integer getContenttype() {
        return contenttype;
    }

    public void setContenttype(Integer contenttype) {
        this.contenttype = contenttype;
    }

    public String getContentremark() {
        return contentremark;
    }

    public void setContentremark(String contentremark) {
        this.contentremark = contentremark == null ? null : contentremark.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getAttfile() {
        return attfile;
    }

    public void setAttfile(String attfile) {
        this.attfile = attfile == null ? null : attfile.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
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

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid == null ? null : contentid.trim();
    }


}