package com.hangyu.platform.web.backBusiness.dto;

public class BmSlsetsendfilefileTbl {
    private Integer id;

    private String uniqueid;

    private String sendfid;

    private String filename;

    private String fileurl;

    private Integer isdelete;

    private Integer oldid;

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

    public String getSendfid() {
        return sendfid;
    }

    public void setSendfid(String sendfid) {
        this.sendfid = sendfid == null ? null : sendfid.trim();
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

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }
}