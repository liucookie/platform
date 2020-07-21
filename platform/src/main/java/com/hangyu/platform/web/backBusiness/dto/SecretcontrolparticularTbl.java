package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SecretcontrolparticularTbl {
    private Integer id;

    private String uniqueid;

    private String typenamer;
    @Excel(name = "类别", width = 20, orderNum = "2")
    private String typeName;
    @Excel(name = "名称", width = 20, orderNum = "3")
    private String namer;

    private String secretlevelid;
    @Excel(name = "密集", width = 20, orderNum = "4")
    private String secretName;
    @Excel(name = "涉密型号/课题", width = 30, orderNum = "6")
    private String secretmodel;
    @Excel(name = "控制范围", width = 30, orderNum = "7")
    private String scope;
    @Excel(name = "保密期限", width = 20, orderNum = "5")
    private String keepsecretdate;
    @Excel(name = "备注", width = 30, orderNum = "8")
    private String remarkr;

    private Integer isdelete;

    private String deptid;
    @Excel(name = "部门", width = 20, orderNum = "1")
    private String orgName;

    private String formId;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
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

    public String getTypenamer() {
        return typenamer;
    }

    public void setTypenamer(String typenamer) {
        this.typenamer = typenamer == null ? null : typenamer.trim();
    }

    public String getNamer() {
        return namer;
    }

    public void setNamer(String namer) {
        this.namer = namer == null ? null : namer.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }

    public String getSecretmodel() {
        return secretmodel;
    }

    public void setSecretmodel(String secretmodel) {
        this.secretmodel = secretmodel == null ? null : secretmodel.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getKeepsecretdate() {
        return keepsecretdate;
    }

    public void setKeepsecretdate(String keepsecretdate) {
        this.keepsecretdate = keepsecretdate == null ? null : keepsecretdate.trim();
    }

    public String getRemarkr() {
        return remarkr;
    }

    public void setRemarkr(String remarkr) {
        this.remarkr = remarkr == null ? null : remarkr.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }
}