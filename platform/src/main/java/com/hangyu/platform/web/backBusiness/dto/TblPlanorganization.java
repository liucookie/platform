package com.hangyu.platform.web.backBusiness.dto;

public class TblPlanorganization {
    private Integer id;

    private Integer tblPlanid;

    private String organizationuniqueid;

    private String organizationName;

    public TblPlanorganization() {
    }

    public TblPlanorganization(Integer tblPlanid, String organizationuniqueid) {
        this.tblPlanid = tblPlanid;
        this.organizationuniqueid = organizationuniqueid;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTblPlanid() {
        return tblPlanid;
    }

    public void setTblPlanid(Integer tblPlanid) {
        this.tblPlanid = tblPlanid;
    }

    public String getOrganizationuniqueid() {
        return organizationuniqueid;
    }

    public void setOrganizationuniqueid(String organizationuniqueid) {
        this.organizationuniqueid = organizationuniqueid == null ? null : organizationuniqueid.trim();
    }
}