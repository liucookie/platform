package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmStafffamilyTbl {
    private Integer id;

    private String famid;

    private String staffid;

    private String famrelation;

    private String famname;

    private String borthdate;

    private String famface;

    private String famunit;

    private String famjob;

    private String famwork;

    private Integer sortorder;

    private Integer isdelete;

    private Integer sid;

    private String famphone;

    private String isout;

    private String idcard;

    private String famremark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamid() {
        return famid;
    }

    public void setFamid(String famid) {
        this.famid = famid == null ? null : famid.trim();
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getFamrelation() {
        return famrelation;
    }

    public void setFamrelation(String famrelation) {
        this.famrelation = famrelation == null ? null : famrelation.trim();
    }

    public String getFamname() {
        return famname;
    }

    public void setFamname(String famname) {
        this.famname = famname == null ? null : famname.trim();
    }

    public String getBorthdate() {
        return borthdate;
    }

    public void setBorthdate(String borthdate) {
        this.borthdate = borthdate;
    }

    public String getFamface() {
        return famface;
    }

    public void setFamface(String famface) {
        this.famface = famface == null ? null : famface.trim();
    }

    public String getFamunit() {
        return famunit;
    }

    public void setFamunit(String famunit) {
        this.famunit = famunit == null ? null : famunit.trim();
    }

    public String getFamjob() {
        return famjob;
    }

    public void setFamjob(String famjob) {
        this.famjob = famjob == null ? null : famjob.trim();
    }

    public String getFamwork() {
        return famwork;
    }

    public void setFamwork(String famwork) {
        this.famwork = famwork == null ? null : famwork.trim();
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFamphone() {
        return famphone;
    }

    public void setFamphone(String famphone) {
        this.famphone = famphone == null ? null : famphone.trim();
    }

    public String getIsout() {
        return isout;
    }

    public void setIsout(String isout) {
        this.isout = isout == null ? null : isout.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getFamremark() {
        return famremark;
    }

    public void setFamremark(String famremark) {
        this.famremark = famremark == null ? null : famremark.trim();
    }
}