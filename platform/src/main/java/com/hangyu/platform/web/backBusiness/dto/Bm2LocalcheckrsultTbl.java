package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class Bm2LocalcheckrsultTbl {
    private Integer id;

    private int year;

    private int month;

    private String uniqueid;

    private String planid;

    private String planName;

    private String checkorgid;

    private String checkuser;

    private String checktime;

    private String result;

    private String deptid;

    private String deptName;

    private String officeid;

    private String orgName;

    private String userid;

    private String userName;

    private String quesclass;

    private String questName;

    private String question;

    private String deregulation;

    private String punishbasis;

    private Integer dscore;

    private Integer dconsub;

    private Integer dwages;

    private Integer isdelete;

    private String createtime;

    private String creatorid;

    private Integer ishistory;

    private Integer checktype;

    private Integer isadd;

    private Integer ischeck;

    private String rechecktime;

    List<BmSystemitemTbl> deregulationList;

    List<BmSystemitemTbl> publishList;

    public List<BmSystemitemTbl> getPublishList() {
        return publishList;
    }

    public void setPublishList(List<BmSystemitemTbl> publishList) {
        this.publishList = publishList;
    }

    public List<BmSystemitemTbl> getDeregulationList() {
        return deregulationList;
    }

    public void setDeregulationList(List<BmSystemitemTbl> deregulationList) {
        this.deregulationList = deregulationList;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getCheckorgid() {
        return checkorgid;
    }

    public void setCheckorgid(String checkorgid) {
        this.checkorgid = checkorgid == null ? null : checkorgid.trim();
    }

    public String getCheckuser() {
        return checkuser;
    }

    public void setCheckuser(String checkuser) {
        this.checkuser = checkuser == null ? null : checkuser.trim();
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getQuesclass() {
        return quesclass;
    }

    public void setQuesclass(String quesclass) {
        this.quesclass = quesclass == null ? null : quesclass.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getDeregulation() {
        return deregulation;
    }

    public void setDeregulation(String deregulation) {
        this.deregulation = deregulation == null ? null : deregulation.trim();
    }

    public String getPunishbasis() {
        return punishbasis;
    }

    public void setPunishbasis(String punishbasis) {
        this.punishbasis = punishbasis == null ? null : punishbasis.trim();
    }

    public Integer getDscore() {
        return dscore;
    }

    public void setDscore(Integer dscore) {
        this.dscore = dscore;
    }

    public Integer getDconsub() {
        return dconsub;
    }

    public void setDconsub(Integer dconsub) {
        this.dconsub = dconsub;
    }

    public Integer getDwages() {
        return dwages;
    }

    public void setDwages(Integer dwages) {
        this.dwages = dwages;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }


    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid == null ? null : creatorid.trim();
    }

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public Integer getIsadd() {
        return isadd;
    }

    public void setIsadd(Integer isadd) {
        this.isadd = isadd;
    }

    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

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

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRechecktime() {
        return rechecktime;
    }

    public void setRechecktime(String rechecktime) {
        this.rechecktime = rechecktime;
    }
}