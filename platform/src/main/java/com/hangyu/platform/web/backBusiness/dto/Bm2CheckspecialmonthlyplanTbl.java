package com.hangyu.platform.web.backBusiness.dto;

public class Bm2CheckspecialmonthlyplanTbl {
    private String monthlyplanid;

    private Integer monthlyplanyear;

    private String name;

    private Integer monthlyplanmonth;

    private Integer monthlyplanstate;

    private String fileurl;

    private Integer isdelete;

    private Integer number;

    private String monthlyplanremark;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthlyplanid() {
        return monthlyplanid;
    }

    public void setMonthlyplanid(String monthlyplanid) {
        this.monthlyplanid = monthlyplanid == null ? null : monthlyplanid.trim();
    }

    public Integer getMonthlyplanyear() {
        return monthlyplanyear;
    }

    public void setMonthlyplanyear(Integer monthlyplanyear) {
        this.monthlyplanyear = monthlyplanyear;
    }

    public Integer getMonthlyplanmonth() {
        return monthlyplanmonth;
    }

    public void setMonthlyplanmonth(Integer monthlyplanmonth) {
        this.monthlyplanmonth = monthlyplanmonth;
    }

    public Integer getMonthlyplanstate() {
        return monthlyplanstate;
    }

    public void setMonthlyplanstate(Integer monthlyplanstate) {
        this.monthlyplanstate = monthlyplanstate;
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

    public String getMonthlyplanremark() {
        return monthlyplanremark;
    }

    public void setMonthlyplanremark(String monthlyplanremark) {
        this.monthlyplanremark = monthlyplanremark == null ? null : monthlyplanremark.trim();
    }
}