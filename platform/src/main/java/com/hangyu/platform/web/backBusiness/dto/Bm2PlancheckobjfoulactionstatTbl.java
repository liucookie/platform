package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class Bm2PlancheckobjfoulactionstatTbl {
    private String uniqueid;

    private String planid;

    private String planname;

    private Integer planchecktype;

    private String checkobjid;

    private Integer checkobjtype;

    private String orgid;

    private String orgname;

    private String staffid;

    private String staffname;

    private String examineitem;

    private String foulactionname;

    private Double deductleaderallow;

    private Double deductpersonallow;

    private String adminpunish;

    private Double deductleadercash;

    private Double deductpersoncash;

    private Double deductdeptscore;

    private Double deductpersonscore;

    private Date createtime;

    private Date updatetime;

    private Integer isdelete;

    private Integer realnum;

    private int planCheckNum;

    private int realCheckNum;

    private int checkNum;

    private int passNum;

    private int notPassNum;

    private double PassRate;

    private String publish;
    //未确认
    private int notCheckNum;

    public int getPlanCheckNum() {
        return planCheckNum;
    }

    public void setPlanCheckNum(int planCheckNum) {
        this.planCheckNum = planCheckNum;
    }

    public int getRealCheckNum() {
        return realCheckNum;
    }

    public void setRealCheckNum(int realCheckNum) {
        this.realCheckNum = realCheckNum;
    }

    public int getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    public int getPassNum() {
        return passNum;
    }

    public void setPassNum(int passNum) {
        this.passNum = passNum;
    }

    public int getNotPassNum() {
        return notPassNum;
    }

    public void setNotPassNum(int notPassNum) {
        this.notPassNum = notPassNum;
    }

    public double getPassRate() {
        return PassRate;
    }

    public void setPassRate(double passRate) {
        PassRate = passRate;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getNotCheckNum() {
        return notCheckNum;
    }

    public void setNotCheckNum(int notCheckNum) {
        this.notCheckNum = notCheckNum;
    }

    public Integer getRealnum() {
        return realnum;
    }

    public void setRealnum(Integer realnum) {
        this.realnum = realnum;
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

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname == null ? null : planname.trim();
    }

    public Integer getPlanchecktype() {
        return planchecktype;
    }

    public void setPlanchecktype(Integer planchecktype) {
        this.planchecktype = planchecktype;
    }

    public String getCheckobjid() {
        return checkobjid;
    }

    public void setCheckobjid(String checkobjid) {
        this.checkobjid = checkobjid == null ? null : checkobjid.trim();
    }

    public Integer getCheckobjtype() {
        return checkobjtype;
    }

    public void setCheckobjtype(Integer checkobjtype) {
        this.checkobjtype = checkobjtype;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getExamineitem() {
        return examineitem;
    }

    public void setExamineitem(String examineitem) {
        this.examineitem = examineitem == null ? null : examineitem.trim();
    }

    public String getFoulactionname() {
        return foulactionname;
    }

    public void setFoulactionname(String foulactionname) {
        this.foulactionname = foulactionname == null ? null : foulactionname.trim();
    }

    public Double getDeductleaderallow() {
        return deductleaderallow;
    }

    public void setDeductleaderallow(Double deductleaderallow) {
        this.deductleaderallow = deductleaderallow;
    }

    public Double getDeductpersonallow() {
        return deductpersonallow;
    }

    public void setDeductpersonallow(Double deductpersonallow) {
        this.deductpersonallow = deductpersonallow;
    }

    public String getAdminpunish() {
        return adminpunish;
    }

    public void setAdminpunish(String adminpunish) {
        this.adminpunish = adminpunish == null ? null : adminpunish.trim();
    }

    public Double getDeductleadercash() {
        return deductleadercash;
    }

    public void setDeductleadercash(Double deductleadercash) {
        this.deductleadercash = deductleadercash;
    }

    public Double getDeductpersoncash() {
        return deductpersoncash;
    }

    public void setDeductpersoncash(Double deductpersoncash) {
        this.deductpersoncash = deductpersoncash;
    }

    public Double getDeductdeptscore() {
        return deductdeptscore;
    }

    public void setDeductdeptscore(Double deductdeptscore) {
        this.deductdeptscore = deductdeptscore;
    }

    public Double getDeductpersonscore() {
        return deductpersonscore;
    }

    public void setDeductpersonscore(Double deductpersonscore) {
        this.deductpersonscore = deductpersonscore;
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

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}