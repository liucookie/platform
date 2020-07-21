package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2KeepsecretqualificationlevelTbl {
    private Integer id;

    private String qualificationlevelid;

    private String qualificationlevelname;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualificationlevelid() {
        return qualificationlevelid;
    }

    public void setQualificationlevelid(String qualificationlevelid) {
        this.qualificationlevelid = qualificationlevelid == null ? null : qualificationlevelid.trim();
    }

    public String getQualificationlevelname() {
        return qualificationlevelname;
    }

    public void setQualificationlevelname(String qualificationlevelname) {
        this.qualificationlevelname = qualificationlevelname == null ? null : qualificationlevelname.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}