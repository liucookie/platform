package com.hangyu.platform.web.backBusiness.dto;


public class Bm2YearplancomputeronlinecheckTbl {
    private Integer id;

    private String yearplanid;

    private Integer yearnum;

    private Integer monthnum;

    private Integer startMonth;

    private Integer endMonth;

    private String planname;

    private String begindate;

    private String enddate;

    private Double checkrate;

    private String rateString;

    private String personincharge;

    private String chargeName;

    private String creator;

    private String creatName;

    private String createtime;

    private Integer isdelete;

    private String groupid;

    private int  planState;

    public int getPlanState() {
        return planState;
    }

    public void setPlanState(int planState) {
        this.planState = planState;
    }

    public String getRateString() {
        return rateString;
    }

    public void setRateString(String rateString) {
        this.rateString = rateString;
    }

    public String getBegindate() {
        return begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getCreatName() {
        return creatName;
    }

    public void setCreatName(String creatName) {
        this.creatName = creatName;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYearplanid() {
        return yearplanid;
    }

    public void setYearplanid(String yearplanid) {
        this.yearplanid = yearplanid == null ? null : yearplanid.trim();
    }

    public Integer getYearnum() {
        return yearnum;
    }

    public void setYearnum(Integer yearnum) {
        this.yearnum = yearnum;
    }

    public Integer getMonthnum() {
        return monthnum;
    }

    public void setMonthnum(Integer monthnum) {
        this.monthnum = monthnum;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname == null ? null : planname.trim();
    }


    public Double getCheckrate() {
        return checkrate;
    }

    public void setCheckrate(Double checkrate) {
        this.checkrate = checkrate;
    }

    public String getPersonincharge() {
        return personincharge;
    }

    public void setPersonincharge(String personincharge) {
        this.personincharge = personincharge == null ? null : personincharge.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }
}