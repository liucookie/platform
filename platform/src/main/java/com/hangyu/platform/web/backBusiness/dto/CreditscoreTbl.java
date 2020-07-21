package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class CreditscoreTbl {
    private Integer id;

    private String uniqueid;

    private String fkeyid;
    @Excel(name = "部门名称", width = 30, orderNum = "1")
    private String deptName;
    @Excel(name = "处室名称", width = 30, orderNum = "2")
    private String orgName;
    @Excel(name = "人员", width = 15, orderNum = "3")
    private String userName;

    private Integer cstype;
    @Excel(name = "年份", width = 10, orderNum = "4")
    private Integer year;
    @Excel(name = "信誉积分", width = 10, orderNum = "5")
    private Double yearscore;
    @Excel(name = "一月积分变化", width = 10, orderNum = "6")
    private Double monthscore1;
    @Excel(name = "二月积分变化", width = 10, orderNum = "7")
    private Double monthscore2;
    @Excel(name = "三月积分变化", width = 10, orderNum = "8")
    private Double monthscore3;
    @Excel(name = "四月积分变化", width = 10, orderNum = "9")
    private Double monthscore4;
    @Excel(name = "五月积分变化", width = 10, orderNum = "10")
    private Double monthscore5;
    @Excel(name = "六月积分变化", width = 10, orderNum = "11")
    private Double monthscore6;
    @Excel(name = "七月积分变化", width = 10, orderNum = "12")
    private Double monthscore7;
    @Excel(name = "八月积分变化", width = 10, orderNum = "13")
    private Double monthscore8;
    @Excel(name = "九月积分变化", width = 10, orderNum = "14")
    private Double monthscore9;
    @Excel(name = "十月积分变化", width = 10, orderNum = "15")
    private Double monthscore10;
    @Excel(name = "十一月积分变化", width = 10, orderNum = "16")
    private Double monthscore11;
    @Excel(name = "十二月积分变化", width = 10, orderNum = "17")
    private Double monthscore12;

    private Integer isdelete;

    private Date createtime;

    private Date updatetime;

    private Integer start;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getFkeyid() {
        return fkeyid;
    }

    public void setFkeyid(String fkeyid) {
        this.fkeyid = fkeyid == null ? null : fkeyid.trim();
    }

    public Integer getCstype() {
        return cstype;
    }

    public void setCstype(Integer cstype) {
        this.cstype = cstype;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getYearscore() {
        return yearscore;
    }

    public void setYearscore(Double yearscore) {
        this.yearscore = yearscore;
    }

    public Double getMonthscore1() {
        return monthscore1;
    }

    public void setMonthscore1(Double monthscore1) {
        this.monthscore1 = monthscore1;
    }

    public Double getMonthscore2() {
        return monthscore2;
    }

    public void setMonthscore2(Double monthscore2) {
        this.monthscore2 = monthscore2;
    }

    public Double getMonthscore3() {
        return monthscore3;
    }

    public void setMonthscore3(Double monthscore3) {
        this.monthscore3 = monthscore3;
    }

    public Double getMonthscore4() {
        return monthscore4;
    }

    public void setMonthscore4(Double monthscore4) {
        this.monthscore4 = monthscore4;
    }

    public Double getMonthscore5() {
        return monthscore5;
    }

    public void setMonthscore5(Double monthscore5) {
        this.monthscore5 = monthscore5;
    }

    public Double getMonthscore6() {
        return monthscore6;
    }

    public void setMonthscore6(Double monthscore6) {
        this.monthscore6 = monthscore6;
    }

    public Double getMonthscore7() {
        return monthscore7;
    }

    public void setMonthscore7(Double monthscore7) {
        this.monthscore7 = monthscore7;
    }

    public Double getMonthscore8() {
        return monthscore8;
    }

    public void setMonthscore8(Double monthscore8) {
        this.monthscore8 = monthscore8;
    }

    public Double getMonthscore9() {
        return monthscore9;
    }

    public void setMonthscore9(Double monthscore9) {
        this.monthscore9 = monthscore9;
    }

    public Double getMonthscore10() {
        return monthscore10;
    }

    public void setMonthscore10(Double monthscore10) {
        this.monthscore10 = monthscore10;
    }

    public Double getMonthscore11() {
        return monthscore11;
    }

    public void setMonthscore11(Double monthscore11) {
        this.monthscore11 = monthscore11;
    }

    public Double getMonthscore12() {
        return monthscore12;
    }

    public void setMonthscore12(Double monthscore12) {
        this.monthscore12 = monthscore12;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}