package com.hangyu.platform.web.backBusiness.dto;

public class BmCheckplanadvanceddemandTbl {
    private Integer id;

    private String demandid;

    private String planid;

    private String itemid;

    private String itemdemand;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemandid() {
        return demandid;
    }

    public void setDemandid(String demandid) {
        this.demandid = demandid == null ? null : demandid.trim();
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

    public String getItemdemand() {
        return itemdemand;
    }

    public void setItemdemand(String itemdemand) {
        this.itemdemand = itemdemand == null ? null : itemdemand.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}