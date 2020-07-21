package com.hangyu.platform.web.backBusiness.dto;

public class Yirenduogang {
    private Integer id;

    private String uniqueid;

    private String staffid;

    private String deptid;

    private String gangwei;

    private String zhize;

    private Integer isdelete;

    private Integer iscommon;

    private String  orgname;

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

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

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei == null ? null : gangwei.trim();
    }

    public String getZhize() {
        return zhize;
    }

    public void setZhize(String zhize) {
        this.zhize = zhize == null ? null : zhize.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIscommon() {
        return iscommon;
    }

    public void setIscommon(Integer iscommon) {
        this.iscommon = iscommon;
    }
}