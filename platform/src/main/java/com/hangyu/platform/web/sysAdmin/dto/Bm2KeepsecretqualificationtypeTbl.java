package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2KeepsecretqualificationtypeTbl {
    private Integer id;

    private String qualificationtypeid;

    private String qualificationtypename;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualificationtypeid() {
        return qualificationtypeid;
    }

    public void setQualificationtypeid(String qualificationtypeid) {
        this.qualificationtypeid = qualificationtypeid == null ? null : qualificationtypeid.trim();
    }

    public String getQualificationtypename() {
        return qualificationtypename;
    }

    public void setQualificationtypename(String qualificationtypename) {
        this.qualificationtypename = qualificationtypename == null ? null : qualificationtypename.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}