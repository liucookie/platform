package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmKeyfileTbl {
    private Integer id;

    private String fileid;

    private String deporplaid;

    private Integer deporplatype;

    private Integer filetype;

    private String filename;

    private String filedetail;

    private String fileurl;

    private Date filedate;

    private Integer sortorder;

    private Integer isdelete;

    private String picmodelid;

    private Integer oid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getDeporplaid() {
        return deporplaid;
    }

    public void setDeporplaid(String deporplaid) {
        this.deporplaid = deporplaid == null ? null : deporplaid.trim();
    }

    public Integer getDeporplatype() {
        return deporplatype;
    }

    public void setDeporplatype(Integer deporplatype) {
        this.deporplatype = deporplatype;
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiledetail() {
        return filedetail;
    }

    public void setFiledetail(String filedetail) {
        this.filedetail = filedetail == null ? null : filedetail.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public Date getFiledate() {
        return filedate;
    }

    public void setFiledate(Date filedate) {
        this.filedate = filedate;
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

    public String getPicmodelid() {
        return picmodelid;
    }

    public void setPicmodelid(String picmodelid) {
        this.picmodelid = picmodelid == null ? null : picmodelid.trim();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}