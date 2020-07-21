package com.hangyu.platform.web.sysAdmin.dto;

public class SystemsetTbl {
    private Integer id;

    private String syssetid;

    private Integer computershowsign;

    private Integer logkeepmonth;

    private Integer selfcheckbegindate;

    private Integer selfcheckenddate;

    private Integer selfcheckcreateoption;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSyssetid() {
        return syssetid;
    }

    public void setSyssetid(String syssetid) {
        this.syssetid = syssetid == null ? null : syssetid.trim();
    }

    public Integer getComputershowsign() {
        return computershowsign;
    }

    public void setComputershowsign(Integer computershowsign) {
        this.computershowsign = computershowsign;
    }

    public Integer getLogkeepmonth() {
        return logkeepmonth;
    }

    public void setLogkeepmonth(Integer logkeepmonth) {
        this.logkeepmonth = logkeepmonth;
    }

    public Integer getSelfcheckbegindate() {
        return selfcheckbegindate;
    }

    public void setSelfcheckbegindate(Integer selfcheckbegindate) {
        this.selfcheckbegindate = selfcheckbegindate;
    }

    public Integer getSelfcheckenddate() {
        return selfcheckenddate;
    }

    public void setSelfcheckenddate(Integer selfcheckenddate) {
        this.selfcheckenddate = selfcheckenddate;
    }

    public Integer getSelfcheckcreateoption() {
        return selfcheckcreateoption;
    }

    public void setSelfcheckcreateoption(Integer selfcheckcreateoption) {
        this.selfcheckcreateoption = selfcheckcreateoption;
    }
}