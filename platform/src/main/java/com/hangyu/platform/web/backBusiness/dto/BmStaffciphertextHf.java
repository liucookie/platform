package com.hangyu.platform.web.backBusiness.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class BmStaffciphertextHf {
    private Integer id;

    private String uniqueid;

    private String hfdate;

    private String hfcotent;

    private String hfatt;

    private Integer isdelete;

    private Date updatetime;

    private String tbid;



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

    public String getHfdate() {
        return hfdate;
    }

    public void setHfdate(String hfdate) {
        this.hfdate = hfdate;
    }

    public String getHfcotent() {
        return hfcotent;
    }

    public void setHfcotent(String hfcotent) {
        this.hfcotent = hfcotent == null ? null : hfcotent.trim();
    }

    public String getHfatt() {
        return hfatt;
    }

    public void setHfatt(String hfatt) {
        this.hfatt = hfatt == null ? null : hfatt.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getTbid() {
        return tbid;
    }

    public void setTbid(String tbid) {
        this.tbid = tbid == null ? null : tbid.trim();
    }
}