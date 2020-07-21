package com.hangyu.platform.web.backBusiness.dto;

public class TblExamineereply {
    private Integer id;

    private String bmStaffTblStaffid;

    private Integer specifictestid;

    private Integer tbExamplanid;

    private String replycontent;

    private String testtype;

    private Integer examId;

    private int examineerId;

    public int getExamineerId() {
        return examineerId;
    }

    public void setExamineerId(int examineerId) {
        this.examineerId = examineerId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public TblExamineereply() {
    }

    public TblExamineereply(String bmStaffTblStaffid, Integer specifictestid, Integer tbExamplanid,
                            String replycontent, String testtype,Integer examId,Integer examineerId) {
        this.bmStaffTblStaffid = bmStaffTblStaffid;
        this.specifictestid = specifictestid;
        this.tbExamplanid = tbExamplanid;
        this.replycontent = replycontent;
        this.testtype = testtype;
        this.examId = examId;
        this.examineerId = examineerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBmStaffTblStaffid() {
        return bmStaffTblStaffid;
    }

    public void setBmStaffTblStaffid(String bmStaffTblStaffid) {
        this.bmStaffTblStaffid = bmStaffTblStaffid == null ? null : bmStaffTblStaffid.trim();
    }

    public Integer getSpecifictestid() {
        return specifictestid;
    }

    public void setSpecifictestid(Integer specifictestid) {
        this.specifictestid = specifictestid;
    }

    public Integer getTbExamplanid() {
        return tbExamplanid;
    }

    public void setTbExamplanid(Integer tbExamplanid) {
        this.tbExamplanid = tbExamplanid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype == null ? null : testtype.trim();
    }
}