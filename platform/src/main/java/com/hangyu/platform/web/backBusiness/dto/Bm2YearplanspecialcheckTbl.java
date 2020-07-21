package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class Bm2YearplanspecialcheckTbl {
    private Integer id;

    private String yearplanid;

    private Integer yearnum;

    private Integer monthnum;

    private String planname;

    private String begindate;

    private String enddate;

    private Double checkrate;

    private String chargerorgid;


    private String planchargerid;

    private String chargeName;

    private String creatorid;

    private String creatName;

    private String createtime;

    private Integer isdelete;

    private String planchecktypeid;

    private String typeName;

    private List<String> typeList;

    private String plancheckorgid;

    private List<String> orgIds;

    private String orgName;

    private int planState;

    public int getPlanState() {
        return planState;
    }

    public void setPlanState(int planState) {
        this.planState = planState;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public List<String> getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(List<String> orgIds) {
        this.orgIds = orgIds;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
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

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid == null ? null : creatorid.trim();
    }


    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
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
}