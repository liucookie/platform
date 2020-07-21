package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class Bm2LocalcheckplanTbl {
    private Integer id;

    private String planid;



    private Integer yearnum;

    private Integer monthnum;

    private Date begindate;

    private Date enddate;

    private String planname;

    private String chargerorgid;

    private String planchargerid;

    private String planChargeName;

    private String fileName;

    private String planchecktypeid;

    private List<String> checkTypeIds;

    private String planCheckName;

    private String plancheckorgid;

    private Integer isdelete;

    private Integer ishistory;

    private Date createtime;

    private String creatorid;

    private String creatName;

    private Integer isfinish;

    public List<String> getCheckTypeIds() {
        return checkTypeIds;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCheckTypeIds(List<String> checkTypeIds) {
        this.checkTypeIds = checkTypeIds;
    }

    public String getPlanChargeName() {
        return planChargeName;
    }

    public void setPlanChargeName(String planChargeName) {
        this.planChargeName = planChargeName;
    }

    public String getPlanCheckName() {
        return planCheckName;
    }

    public void setPlanCheckName(String planCheckName) {
        this.planCheckName = planCheckName;
    }

    public String getCreatName() {
        return creatName;
    }

    public void setCreatName(String creatName) {
        this.creatName = creatName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
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

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname == null ? null : planname.trim();
    }

    public String getChargerorgid() {
        return chargerorgid;
    }

    public void setChargerorgid(String chargerorgid) {
        this.chargerorgid = chargerorgid == null ? null : chargerorgid.trim();
    }

    public String getPlanchargerid() {
        return planchargerid;
    }

    public void setPlanchargerid(String planchargerid) {
        this.planchargerid = planchargerid == null ? null : planchargerid.trim();
    }

    public String getPlanchecktypeid() {
        return planchecktypeid;
    }

    public void setPlanchecktypeid(String planchecktypeid) {
        this.planchecktypeid = planchecktypeid == null ? null : planchecktypeid.trim();
    }

    public String getPlancheckorgid() {
        return plancheckorgid;
    }

    public void setPlancheckorgid(String plancheckorgid) {
        this.plancheckorgid = plancheckorgid == null ? null : plancheckorgid.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid == null ? null : creatorid.trim();
    }

    public Integer getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(Integer isfinish) {
        this.isfinish = isfinish;
    }
}