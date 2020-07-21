package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class NationalsecurityTbl {
    private Integer id;

    private String uniqueid;

    private String rfilename;
    @Excel(name = "检测日期", width = 30, orderNum = "1")
    private String jcdate;
    @Excel(name = "检测内容", width = 50, orderNum = "2")
    private String jccontent;

    private String jcdept;
    @Excel(name = "检测单位", width = 20, orderNum = "3")
    private String jcdeptname;

    private String jcuser;
    @Excel(name = "检测人员", width = 20, orderNum = "4")
    private String jcusername;
    @Excel(name = "检测位置", width = 30, orderNum = "5")
    private String bjcdepartment;
    @Excel(name = "检测结论", width = 50, orderNum = "6")
    private String jcresult;

    private String remark;

    private Integer isdelete;

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

    public String getRfilename() {
        return rfilename;
    }

    public void setRfilename(String rfilename) {
        this.rfilename = rfilename == null ? null : rfilename.trim();
    }

    public String getJcdate() {
        return jcdate;
    }

    public void setJcdate(String jcdate) {
        this.jcdate = jcdate;
    }

    public String getJccontent() {
        return jccontent;
    }

    public void setJccontent(String jccontent) {
        this.jccontent = jccontent == null ? null : jccontent.trim();
    }

    public String getJcdept() {
        return jcdept;
    }

    public void setJcdept(String jcdept) {
        this.jcdept = jcdept == null ? null : jcdept.trim();
    }

    public String getJcdeptname() {
        return jcdeptname;
    }

    public void setJcdeptname(String jcdeptname) {
        this.jcdeptname = jcdeptname == null ? null : jcdeptname.trim();
    }

    public String getJcuser() {
        return jcuser;
    }

    public void setJcuser(String jcuser) {
        this.jcuser = jcuser == null ? null : jcuser.trim();
    }

    public String getJcusername() {
        return jcusername;
    }

    public void setJcusername(String jcusername) {
        this.jcusername = jcusername == null ? null : jcusername.trim();
    }

    public String getBjcdepartment() {
        return bjcdepartment;
    }

    public void setBjcdepartment(String bjcdepartment) {
        this.bjcdepartment = bjcdepartment == null ? null : bjcdepartment.trim();
    }

    public String getJcresult() {
        return jcresult;
    }

    public void setJcresult(String jcresult) {
        this.jcresult = jcresult == null ? null : jcresult.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}