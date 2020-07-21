package com.hangyu.platform.web.backBusiness.dto;

public class TblClasssify {
    private Integer id;

    private Integer tblExamid;

    private String tblType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblExamid() {
        return tblExamid;
    }

    public void setTblExamid(Integer tblExamid) {
        this.tblExamid = tblExamid;
    }

    public String getTblType() {
        return tblType;
    }

    public void setTblType(String tblType) {
        this.tblType = tblType == null ? null : tblType.trim();
    }
}