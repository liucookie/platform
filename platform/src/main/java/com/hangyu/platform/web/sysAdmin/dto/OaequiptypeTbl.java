package com.hangyu.platform.web.sysAdmin.dto;

public class OaequiptypeTbl {
    private Integer id;

    private String uniqueid;

    private String oaequiptypename;

    private String oaequiptypedetail;

    private Integer sortorder;

    private Integer isdelete;

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

    public String getOaequiptypename() {
        return oaequiptypename;
    }

    public void setOaequiptypename(String oaequiptypename) {
        this.oaequiptypename = oaequiptypename == null ? null : oaequiptypename.trim();
    }

    public String getOaequiptypedetail() {
        return oaequiptypedetail;
    }

    public void setOaequiptypedetail(String oaequiptypedetail) {
        this.oaequiptypedetail = oaequiptypedetail == null ? null : oaequiptypedetail.trim();
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