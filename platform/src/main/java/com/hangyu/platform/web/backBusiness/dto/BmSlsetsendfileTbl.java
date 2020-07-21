package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSlsetsendfileTbl {
    private Integer id;

    private String uniqueid;

    private String sendfname;

    private String sendfdate;

    private String sendfcode;

    private Integer isdelete;

    private Integer ishistory;

    private Date createtime;

    private String creater;

    private String fileName;

    private String fileUrl;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

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

    public String getSendfname() {
        return sendfname;
    }

    public void setSendfname(String sendfname) {
        this.sendfname = sendfname == null ? null : sendfname.trim();
    }

    public String getSendfdate() {
        return sendfdate;
    }

    public void setSendfdate(String sendfdate) {
        this.sendfdate = sendfdate;
    }

    public String getSendfcode() {
        return sendfcode;
    }

    public void setSendfcode(String sendfcode) {
        this.sendfcode = sendfcode == null ? null : sendfcode.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }
}