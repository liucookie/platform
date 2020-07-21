package com.hangyu.platform.web.backBusiness.dto;

import java.util.List;

public class PostsecretlevelTbl {
    private Integer id;

    private String uniqueid;

    private String staffid;

    private String deptid;

    private String deptName;

    private String gangwei;

    private Integer isdelete;

    private String secretcontent;

    private String remark;

    private String secretlevelname;

    private String secretName;

    private String bsecretlevelid;

    private String businessSecretName;

    private List<BmStaffTbl> staffTblList;

    public List<BmStaffTbl> getStaffTblList() {
        return staffTblList;
    }

    public void setStaffTblList(List<BmStaffTbl> staffTblList) {
        this.staffTblList = staffTblList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getBusinessSecretName() {
        return businessSecretName;
    }

    public void setBusinessSecretName(String businessSecretName) {
        this.businessSecretName = businessSecretName;
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

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei == null ? null : gangwei.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getSecretcontent() {
        return secretcontent;
    }

    public void setSecretcontent(String secretcontent) {
        this.secretcontent = secretcontent == null ? null : secretcontent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSecretlevelname() {
        return secretlevelname;
    }

    public void setSecretlevelname(String secretlevelname) {
        this.secretlevelname = secretlevelname == null ? null : secretlevelname.trim();
    }

    public String getBsecretlevelid() {
        return bsecretlevelid;
    }

    public void setBsecretlevelid(String bsecretlevelid) {
        this.bsecretlevelid = bsecretlevelid == null ? null : bsecretlevelid.trim();
    }
}