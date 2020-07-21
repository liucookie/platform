package com.hangyu.platform.web.backBusiness.dto;


public class TblPlanexaminee {
    private Integer id;

    private Integer tblPlanorganizationid;

    private String bmStaffTblStaffid;

    private String account;

    private String username;


    private String orgName;

    private Integer tblExamid;

    private Integer state;

    private Integer isenter;

    private Integer score;

    //得分，总得分
    private String scoreResult;

    private Integer examresult;

    private String handintime;

    private Integer examleftsecond;

    private String entertime;

    //试卷名称
    private String examName;
    //是否时新员工考试，0不是，1是
    private int isNewStaffExam;

    //是否是自测考试，0不是，1是
    private int isTest;

    private Integer planId;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public int getIsTest() {
        return isTest;
    }

    public void setIsTest(int isTest) {
        this.isTest = isTest;
    }

    public int getIsNewStaffExam() {
        return isNewStaffExam;
    }

    public void setIsNewStaffExam(int isNewStaffExam) {
        this.isNewStaffExam = isNewStaffExam;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScoreResult() {
        return scoreResult;
    }

    public void setScoreResult(String scoreResult) {
        this.scoreResult = scoreResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblPlanorganizationid() {
        return tblPlanorganizationid;
    }

    public void setTblPlanorganizationid(Integer tblPlanorganizationid) {
        this.tblPlanorganizationid = tblPlanorganizationid;
    }

    public String getBmStaffTblStaffid() {
        return bmStaffTblStaffid;
    }

    public void setBmStaffTblStaffid(String bmStaffTblStaffid) {
        this.bmStaffTblStaffid = bmStaffTblStaffid == null ? null : bmStaffTblStaffid.trim();
    }

    public Integer getTblExamid() {
        return tblExamid;
    }

    public void setTblExamid(Integer tblExamid) {
        this.tblExamid = tblExamid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsenter() {
        return isenter;
    }

    public void setIsenter(Integer isenter) {
        this.isenter = isenter;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getExamresult() {
        return examresult;
    }

    public void setExamresult(Integer examresult) {
        this.examresult = examresult;
    }



    public Integer getExamleftsecond() {
        return examleftsecond;
    }

    public void setExamleftsecond(Integer examleftsecond) {
        this.examleftsecond = examleftsecond;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getHandintime() {
        return handintime;
    }

    public void setHandintime(String handintime) {
        this.handintime = handintime;
    }

    public String getEntertime() {
        return entertime;
    }

    public void setEntertime(String entertime) {
        this.entertime = entertime;
    }
}