package com.hangyu.platform.web.backBusiness.dto;


import com.hangyu.platform.web.backBusiness.vo.PlanExamAddVO;

import java.util.List;

public class TblPlan {
    private Integer id;

    private String starttime;

    private String endtime;

    private String name;

    private String applytime;

    private Integer examTime;

    private Integer examTiptime;

    private Integer examIds;

    private Integer passScore;

    private Integer wellScore;

    private Integer goodScore;

    private Integer examcount;

    private Integer examdonecount;

    private Integer isdelete;

    private String status;

    private List<PlanExamAddVO> planExamAddList;

    private TblExam tblExam;

    private String scope;

    private String isTest;


    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public TblExam getTblExam() {
        return tblExam;
    }

    public void setTblExam(TblExam tblExam) {
        this.tblExam = tblExam;
    }

    public List<PlanExamAddVO> getPlanExamAddList() {
        return planExamAddList;
    }

    public void setPlanExamAddList(List<PlanExamAddVO> planExamAddList) {
        this.planExamAddList = planExamAddList;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    public Integer getExamTiptime() {
        return examTiptime;
    }

    public void setExamTiptime(Integer examTiptime) {
        this.examTiptime = examTiptime;
    }

    public Integer getExamIds() {
        return examIds;
    }

    public void setExamIds(Integer examIds) {
        this.examIds = examIds;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getWellScore() {
        return wellScore;
    }

    public void setWellScore(Integer wellScore) {
        this.wellScore = wellScore;
    }

    public Integer getGoodScore() {
        return goodScore;
    }

    public void setGoodScore(Integer goodScore) {
        this.goodScore = goodScore;
    }

    public Integer getExamcount() {
        return examcount;
    }

    public void setExamcount(Integer examcount) {
        this.examcount = examcount;
    }

    public Integer getExamdonecount() {
        return examdonecount;
    }

    public void setExamdonecount(Integer examdonecount) {
        this.examdonecount = examdonecount;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}