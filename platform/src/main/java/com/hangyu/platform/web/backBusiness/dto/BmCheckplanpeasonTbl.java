package com.hangyu.platform.web.backBusiness.dto;

import com.hangyu.platform.web.sysAdmin.dto.BmCheckplanitemTbl;

import java.util.Date;
import java.util.List;

public class BmCheckplanpeasonTbl {
    private Integer id;

    private String planid;

    private String deptid;

    private String userid;

    private Integer checkstate;

    private Integer checkres;

    private String checktime;

    private String recheckres;

    private String rechecktime;

    private String recheckuser;

    private String checkUserName;

    private Integer isdelete;

    private String userip;

    private String deptname;

    private String username;

    private String accountname;

    private String absencedesc;

    private String descuser;

    private Date desctime;

    private Integer examinestatus;

    private String leavetypeid;

    private String absencetypeid;

    private String publish;

    private Integer notPassNum;

    private String violation;

    private List<BmCheckplanitemTbl> itemList;

    public List<BmCheckplanitemTbl> getItemList() {
        return itemList;
    }

    public void setItemList(List<BmCheckplanitemTbl> itemList) {
        this.itemList = itemList;
    }

    public Integer getNotPassNum() {
        return notPassNum;
    }

    public void setNotPassNum(Integer notPassNum) {
        this.notPassNum = notPassNum;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
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

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(Integer checkstate) {
        this.checkstate = checkstate;
    }

    public Integer getCheckres() {
        return checkres;
    }

    public void setCheckres(Integer checkres) {
        this.checkres = checkres;
    }


    public String getRecheckres() {
        return recheckres;
    }

    public void setRecheckres(String recheckres) {
        this.recheckres = recheckres == null ? null : recheckres.trim();
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public String getRechecktime() {
        return rechecktime;
    }

    public void setRechecktime(String rechecktime) {
        this.rechecktime = rechecktime;
    }

    public String getRecheckuser() {
        return recheckuser;
    }

    public void setRecheckuser(String recheckuser) {
        this.recheckuser = recheckuser == null ? null : recheckuser.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAbsencedesc() {
        return absencedesc;
    }

    public void setAbsencedesc(String absencedesc) {
        this.absencedesc = absencedesc == null ? null : absencedesc.trim();
    }

    public String getDescuser() {
        return descuser;
    }

    public void setDescuser(String descuser) {
        this.descuser = descuser == null ? null : descuser.trim();
    }

    public Date getDesctime() {
        return desctime;
    }

    public void setDesctime(Date desctime) {
        this.desctime = desctime;
    }

    public Integer getExaminestatus() {
        return examinestatus;
    }

    public void setExaminestatus(Integer examinestatus) {
        this.examinestatus = examinestatus;
    }

    public String getLeavetypeid() {
        return leavetypeid;
    }

    public void setLeavetypeid(String leavetypeid) {
        this.leavetypeid = leavetypeid == null ? null : leavetypeid.trim();
    }

    public String getAbsencetypeid() {
        return absencetypeid;
    }

    public void setAbsencetypeid(String absencetypeid) {
        this.absencetypeid = absencetypeid == null ? null : absencetypeid.trim();
    }
}