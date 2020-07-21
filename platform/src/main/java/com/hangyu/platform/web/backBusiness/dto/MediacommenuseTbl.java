package com.hangyu.platform.web.backBusiness.dto;


public class MediacommenuseTbl {
    private Integer id;

    private String uniqueid;

    private String mediaid;

    private Integer isborrow;

    private Integer isreturn;

    private Integer isfinished;

    private String borrowtime;

    private String returntime;

    private long day;

    private String applyuser;

    private String userName;

    private String expectedreturntime;

    private Integer overtime;

    private Integer formtype;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
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

    public String getMediaid() {
        return mediaid;
    }

    public void setMediaid(String mediaid) {
        this.mediaid = mediaid == null ? null : mediaid.trim();
    }

    public Integer getIsborrow() {
        return isborrow;
    }

    public void setIsborrow(Integer isborrow) {
        this.isborrow = isborrow;
    }

    public Integer getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(Integer isreturn) {
        this.isreturn = isreturn;
    }

    public Integer getIsfinished() {
        return isfinished;
    }

    public void setIsfinished(Integer isfinished) {
        this.isfinished = isfinished;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    public String getExpectedreturntime() {
        return expectedreturntime;
    }

    public void setExpectedreturntime(String expectedreturntime) {
        this.expectedreturntime = expectedreturntime;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser == null ? null : applyuser.trim();
    }


    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public Integer getFormtype() {
        return formtype;
    }

    public void setFormtype(Integer formtype) {
        this.formtype = formtype;
    }
}