package com.hangyu.platform.web.sysAdmin.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class Bm2FoulactionTbl {
    private String foulactionid;

    private String foulactiontypeid;
    @Excel(name = "违规分类", width = 30, orderNum = "1")
    private String foulactiontypename;
    @Excel(name = "违规行为名称", width = 30, orderNum = "1")
    private String foulactionname;
    @Excel(name = "扣除保密补贴（部门责任人）", width = 20, orderNum = "3")
    private Double deductleaderallow;
    @Excel(name = "扣除保密补贴（当事人）", width = 20, orderNum = "4")
    private Double deductpersonallow;
    @Excel(name = "行政处分", width = 30, orderNum = "5")
    private String adminpunish;
    @Excel(name = "扣发现金（部门责任人）", width = 30, orderNum = "6")
    private Double deductleadercash;
    @Excel(name = "扣发现金（当事人）", width = 30, orderNum = "7")
    private Double deductpersoncash;
    @Excel(name = "部门扣分", width = 10, orderNum = "8")
    private Double deductdeptscore;

    private Integer deductpersontype;
    @Excel(name = "个人扣分", width = 10, orderNum = "9")
    private Double deductpersonscore;
    @Excel(name = "备注", width = 50, orderNum = "10")
    private String memo;

    private Integer isdelete;

    private Date createtime;

    private Date updatetime;

    public String getFoulactiontypename() {
        return foulactiontypename;
    }

    public void setFoulactiontypename(String foulactiontypename) {
        this.foulactiontypename = foulactiontypename;
    }

    public String getFoulactionid() {
        return foulactionid;
    }

    public void setFoulactionid(String foulactionid) {
        this.foulactionid = foulactionid == null ? null : foulactionid.trim();
    }

    public String getFoulactiontypeid() {
        return foulactiontypeid;
    }

    public void setFoulactiontypeid(String foulactiontypeid) {
        this.foulactiontypeid = foulactiontypeid == null ? null : foulactiontypeid.trim();
    }

    public String getFoulactionname() {
        return foulactionname;
    }

    public void setFoulactionname(String foulactionname) {
        this.foulactionname = foulactionname == null ? null : foulactionname.trim();
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
        this.adminpunish = adminpunish == null ? null : adminpunish.trim();
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

    public Integer getDeductpersontype() {
        return deductpersontype;
    }

    public void setDeductpersontype(Integer deductpersontype) {
        this.deductpersontype = deductpersontype;
    }

    public Double getDeductpersonscore() {
        return deductpersonscore;
    }

    public void setDeductpersonscore(Double deductpersonscore) {
        this.deductpersonscore = deductpersonscore;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}