package com.hangyu.platform.web.logAdmin.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class Loginfo {
    private Integer id;

    private String uniqueid;
    @Excel(name = "账号", width = 20, orderNum = "3")
    private String staffaccoutname;
    @Excel(name = "操作日期", width = 20, orderNum = "5")
    private String operatedate;

    private String operateentitytype;

    private String operateentityid;
    @Excel(name = "操作内容", width = 40, orderNum = "7")
    private String operateaction;

    private String operatecontent;
    @Excel(name = "状态", width = 20, orderNum = "8")
    private String status;
    @Excel(name = "操作模块", width = 20, orderNum = "6")
    private String module;
    @Excel(name = "姓名", width = 20, orderNum = "4")
    private String username;
    @Excel(name = "部门", width = 30, orderNum = "1")
    private String orgName;
    @Excel(name = "单位", width = 30, orderNum = "2")
    private String orgMemo;

    private String deptId;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    private String ip;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgMemo() {
        return orgMemo;
    }

    public void setOrgMemo(String orgMemo) {
        this.orgMemo = orgMemo;
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

    public String getStaffaccoutname() {
        return staffaccoutname;
    }

    public void setStaffaccoutname(String staffaccoutname) {
        this.staffaccoutname = staffaccoutname == null ? null : staffaccoutname.trim();
    }

    public String getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(String operatedate) {
        this.operatedate = operatedate;
    }

    public String getOperateentitytype() {
        return operateentitytype;
    }

    public void setOperateentitytype(String operateentitytype) {
        this.operateentitytype = operateentitytype == null ? null : operateentitytype.trim();
    }

    public String getOperateentityid() {
        return operateentityid;
    }

    public void setOperateentityid(String operateentityid) {
        this.operateentityid = operateentityid == null ? null : operateentityid.trim();
    }

    public String getOperateaction() {
        return operateaction;
    }

    public void setOperateaction(String operateaction) {
        this.operateaction = operateaction == null ? null : operateaction.trim();
    }

    public String getOperatecontent() {
        return operatecontent;
    }

    public void setOperatecontent(String operatecontent) {
        this.operatecontent = operatecontent == null ? null : operatecontent.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}