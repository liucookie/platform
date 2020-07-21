package com.hangyu.platform.web.sysAdmin.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Bm2FoulactionMappingVO {
    private String id;
    @Excel(name = "检查内容", width = 50, orderNum = "1")
    private String checkItemName;
    //违规分类
    @Excel(name = "违规分类", width = 50, orderNum = "2")
    private String violationType;
    //违规名称
    @Excel(name = "违规名称", width = 30, orderNum = "3")
    private String violationName;
    @Excel(name = "扣除保密补贴（部门责任人）", width = 20, orderNum = "4")
    private Double deductleaderallow;
    @Excel(name = "扣除保密补贴（当事人）", width = 20, orderNum = "5")
    private Double deductpersonallow;

    @Excel(name = "行政处分", width = 30, orderNum = "6")
    private String adminpunish;
    @Excel(name = "扣发现金（部门责任人）", width = 30, orderNum = "7")
    private Double deductleadercash;
    @Excel(name = "扣发现金（当事人）", width = 30, orderNum = "8")
    private Double deductpersoncash;
    @Excel(name = "部门扣分", width = 10, orderNum = "9")
    private Double deductdeptscore;
    @Excel(name = "个人扣分", width = 10, orderNum = "10")
    private Double deductpersonscore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getViolationName() {
        return violationName;
    }

    public void setViolationName(String violationName) {
        this.violationName = violationName;
    }

    public Double getDeductleaderallow() {
        return deductleaderallow;
    }

    public void setDeductleaderallow(Double deductleaderallow) {
        this.deductleaderallow = deductleaderallow;
    }

    public Double getDeductpersonallow() {
        return deductpersonallow;
    }

    public void setDeductpersonallow(Double deductpersonallow) {
        this.deductpersonallow = deductpersonallow;
    }

    public String getAdminpunish() {
        return adminpunish;
    }

    public void setAdminpunish(String adminpunish) {
        this.adminpunish = adminpunish;
    }

    public Double getDeductleadercash() {
        return deductleadercash;
    }

    public void setDeductleadercash(Double deductleadercash) {
        this.deductleadercash = deductleadercash;
    }

    public Double getDeductpersoncash() {
        return deductpersoncash;
    }

    public void setDeductpersoncash(Double deductpersoncash) {
        this.deductpersoncash = deductpersoncash;
    }

    public Double getDeductdeptscore() {
        return deductdeptscore;
    }

    public void setDeductdeptscore(Double deductdeptscore) {
        this.deductdeptscore = deductdeptscore;
    }

    public Double getDeductpersonscore() {
        return deductpersonscore;
    }

    public void setDeductpersonscore(Double deductpersonscore) {
        this.deductpersonscore = deductpersonscore;
    }
}
