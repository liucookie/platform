package com.hangyu.platform.web.sysAdmin.dto;

public class NationlevelremoveopinionTbl {
    private Integer id;

    private String uniqueid;

    private String opionion;

    private Integer isdelete;

    private String remark;

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

    public String getOpionion() {
        return opionion;
    }

    public void setOpionion(String opionion) {
        this.opionion = opionion == null ? null : opionion.trim();
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
}