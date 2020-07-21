package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CooperationinfoTbl {
    private Integer id;

    private String uniqueid;
    @Excel(name = "项目名称", width = 20, orderNum = "1")
    private String name;
    @Excel(name = "是否涉密", width = 15, orderNum = "2")
    private String issecret;
    @Excel(name = "项目合作负责人", width = 15, orderNum = "4")
    private String person;
    @Excel(name = "所属部门", width = 15, orderNum = "3")
    private String orgname;
    @Excel(name = "外协单位是否有军工保密资质", width = 30, orderNum = "5")
    private String secrecyaptitude;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIssecret() {
        return issecret;
    }

    public void setIssecret(String issecret) {
        this.issecret = issecret == null ? null : issecret.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getSecrecyaptitude() {
        return secrecyaptitude;
    }

    public void setSecrecyaptitude(String secrecyaptitude) {
        this.secrecyaptitude = secrecyaptitude == null ? null : secrecyaptitude.trim();
    }
}