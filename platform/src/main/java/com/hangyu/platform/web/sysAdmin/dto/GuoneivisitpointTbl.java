package com.hangyu.platform.web.sysAdmin.dto;



public class GuoneivisitpointTbl {
    private Integer id;

    private String accessname;

    private String responsibilityorg;

    private Integer isdelete;

    private String remark;

    private String applytime;

    private String uniqueid;

    private Integer isapprove;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessname() {
        return accessname;
    }

    public void setAccessname(String accessname) {
        this.accessname = accessname == null ? null : accessname.trim();
    }

    public String getResponsibilityorg() {
        return responsibilityorg;
    }

    public void setResponsibilityorg(String responsibilityorg) {
        this.responsibilityorg = responsibilityorg == null ? null : responsibilityorg.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public Integer getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Integer isapprove) {
        this.isapprove = isapprove;
    }
}