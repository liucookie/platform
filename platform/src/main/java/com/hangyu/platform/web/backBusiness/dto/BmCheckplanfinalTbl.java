package com.hangyu.platform.web.backBusiness.dto;

public class BmCheckplanfinalTbl {
    private Integer id;

    private String staffid;

    private String finalid;

    private String planid;

    private String itemid;

    private String checkdetail;

    private Integer isdelete;

    private Integer checkfinal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getFinalid() {
        return finalid;
    }

    public void setFinalid(String finalid) {
        this.finalid = finalid == null ? null : finalid.trim();
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getCheckdetail() {
        return checkdetail;
    }

    public void setCheckdetail(String checkdetail) {
        this.checkdetail = checkdetail == null ? null : checkdetail.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getCheckfinal() {
        return checkfinal;
    }

    public void setCheckfinal(Integer checkfinal) {
        this.checkfinal = checkfinal;
    }
}