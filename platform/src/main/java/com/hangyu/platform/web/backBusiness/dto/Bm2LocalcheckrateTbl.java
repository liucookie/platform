package com.hangyu.platform.web.backBusiness.dto;

public class Bm2LocalcheckrateTbl {
    private Integer id;

    private int year;
    private int month;
    private String planName;

    private String uniqueid;

    private String planid;

    private String deptid;

    private String deptName;

    private int deptQuestNum;

    private int personQuestNum;

    private String officeid;

    private Integer count;

    private Integer checknum;

    private Double violationrate;

    private Integer isdelete;

    public int getDeptQuestNum() {
        return deptQuestNum;
    }

    public void setDeptQuestNum(int deptQuestNum) {
        this.deptQuestNum = deptQuestNum;
    }

    public int getPersonQuestNum() {
        return personQuestNum;
    }

    public void setPersonQuestNum(int personQuestNum) {
        this.personQuestNum = personQuestNum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getOfficeid() {
        return officeid;
    }

    public void setOfficeid(String officeid) {
        this.officeid = officeid == null ? null : officeid.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getChecknum() {
        return checknum;
    }

    public void setChecknum(Integer checknum) {
        this.checknum = checknum;
    }

    public Double getViolationrate() {
        return violationrate;
    }

    public void setViolationrate(Double violationrate) {
        this.violationrate = violationrate;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}