package com.hangyu.platform.web.sysAdmin.dto;


public class FenyuanaccesspointTbl {
    private Integer id;

    private String building;

    private String floor;

    private String responsibilityorg;

    private Integer isdelete;

    private String applytime;

    private String accessname;

    private String remark;


    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getAccessname() {
        return accessname;
    }

    public void setAccessname(String accessname) {
        this.accessname = accessname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
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


}