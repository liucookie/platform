package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SecretcontrolscopeTbl {
    private Integer id;

    private String uniqueid;

    private String typenamer;
    @Excel(name = "名称", width = 20, orderNum = "2")
    private String namer;

    private String secretlevelid;
    @Excel(name = "保密期限", width = 20, orderNum = "4")
    private String keepsecretdate;
    @Excel(name = "控制范围", width = 20, orderNum = "5")
    private String scope;

    private Integer isdelete;
    @Excel(name = "备注", width = 40, orderNum = "6")
    private String remarkr;
    @Excel(name = "类别", width = 20, orderNum = "1")
    private String typeName;
    @Excel(name = "密级", width = 20, orderNum = "3")
    private String levelName;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getKeepsecretdate() {
        return keepsecretdate;
    }

    public void setKeepsecretdate(String keepsecretdate) {
        this.keepsecretdate = keepsecretdate == null ? null : keepsecretdate.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getRemarkr() {
        return remarkr;
    }

    public void setRemarkr(String remarkr) {
        this.remarkr = remarkr == null ? null : remarkr.trim();
    }
}