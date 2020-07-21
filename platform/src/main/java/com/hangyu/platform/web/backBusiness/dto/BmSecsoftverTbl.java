package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSecsoftverTbl {
    private Integer id;

    private String uniqueid;

    private String softid;

    private String version;

    private String softicon;

    private String softkey;

    private String updatedate;

    private String softdesc;

    private String softpics;

    private String linkurl;

    private Integer isdelete;

    private Integer downloadtype;

    private String fileurl;

    private String softfunc;

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

    public String getSoftid() {
        return softid;
    }

    public void setSoftid(String softid) {
        this.softid = softid == null ? null : softid.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSofticon() {
        return softicon;
    }

    public void setSofticon(String softicon) {
        this.softicon = softicon == null ? null : softicon.trim();
    }

    public String getSoftkey() {
        return softkey;
    }

    public void setSoftkey(String softkey) {
        this.softkey = softkey == null ? null : softkey.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getSoftdesc() {
        return softdesc;
    }

    public void setSoftdesc(String softdesc) {
        this.softdesc = softdesc == null ? null : softdesc.trim();
    }

    public String getSoftpics() {
        return softpics;
    }

    public void setSoftpics(String softpics) {
        this.softpics = softpics == null ? null : softpics.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getDownloadtype() {
        return downloadtype;
    }

    public void setDownloadtype(Integer downloadtype) {
        this.downloadtype = downloadtype;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getSoftfunc() {
        return softfunc;
    }

    public void setSoftfunc(String softfunc) {
        this.softfunc = softfunc == null ? null : softfunc.trim();
    }
}