package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmAllroundcheckTbl {
    private Integer id;

    private String allcheckid;

    private String checkdetail;

    private Integer checkres;

    private String checktime;

    private String checkgroup;

    private String dealres;

    private String fileurl;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllcheckid() {
        return allcheckid;
    }

    public void setAllcheckid(String allcheckid) {
        this.allcheckid = allcheckid == null ? null : allcheckid.trim();
    }

    public String getCheckdetail() {
        return checkdetail;
    }

    public void setCheckdetail(String checkdetail) {
        this.checkdetail = checkdetail == null ? null : checkdetail.trim();
    }

    public Integer getCheckres() {
        return checkres;
    }

    public void setCheckres(Integer checkres) {
        this.checkres = checkres;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public String getCheckgroup() {
        return checkgroup;
    }

    public void setCheckgroup(String checkgroup) {
        this.checkgroup = checkgroup == null ? null : checkgroup.trim();
    }

    public String getDealres() {
        return dealres;
    }

    public void setDealres(String dealres) {
        this.dealres = dealres == null ? null : dealres.trim();
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
}