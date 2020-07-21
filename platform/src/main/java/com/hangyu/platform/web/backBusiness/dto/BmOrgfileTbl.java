package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmOrgfileTbl {
    private Integer id;

    private String orgfileid;

    private String orgid;

    private String filename;

    private String fileurl;

    private String remark;

    private Integer sortorder;

    private Integer isdelete;

    private Date orgtime;

    private Integer oid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgfileid() {
        return orgfileid;
    }

    public void setOrgfileid(String orgfileid) {
        this.orgfileid = orgfileid == null ? null : orgfileid.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getOrgtime() {
        return orgtime;
    }

    public void setOrgtime(Date orgtime) {
        this.orgtime = orgtime;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}