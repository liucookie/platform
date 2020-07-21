package com.hangyu.platform.web.sysAdmin.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

public class SecretexaminaapproveTbl {
    private Long id;

    private String uniqueid;

    @Excel(name = "事项名称",width = 30,orderNum = "7")
    private String name_;

    @Excel(name = "基本内容",width = 30,orderNum = "8")
    private String content;

    private String departname;

    private String secretlevelyj;

    private String yjname;

    private String yjsecretlevel;

    private String yjdeadline;

    private String ejxmname;

    private String extype;

    private String secretlevel;

    private String deadline;

    private String scope;

    private String examina;

    private String workflowid;

    private Integer operation;

    private Integer isapproved;

    private Integer isdelete;

    @Excel(name = "表单编号",width = 30,orderNum = "1")
    private String formid;

    @Excel(name = "申请时间",width = 25,orderNum = "2")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String applytime;

    private String applyendtime;

    private String accoutnamer;

    private String organizationnamer;

    private String chushi;

    private String jobnumber;

    @Excel(name = "密级",width = 15,orderNum = "5")
    private String secretlevelnamer;

    private String staffnamer;

    private String loginuserid;

    @Excel(name = "申请部门",width = 15,orderNum = "3")
    private String loginuserorgname;

    private String loginusersecretlevel;

    private String loginuseraccount;

    private String rfileurl;

    @Excel(name = "申请人联系方式",width = 30,orderNum = "6")
    private String applyuserphone;

    @Excel(name = "申请人",width = 10,orderNum = "4")
    private String username;

    public String getApplyendtime() {
        return applyendtime;
    }

    public void setApplyendtime(String applyendtime) {
        this.applyendtime = applyendtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_ == null ? null : name_.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getSecretlevelyj() {
        return secretlevelyj;
    }

    public void setSecretlevelyj(String secretlevelyj) {
        this.secretlevelyj = secretlevelyj == null ? null : secretlevelyj.trim();
    }

    public String getYjname() {
        return yjname;
    }

    public void setYjname(String yjname) {
        this.yjname = yjname == null ? null : yjname.trim();
    }

    public String getYjsecretlevel() {
        return yjsecretlevel;
    }

    public void setYjsecretlevel(String yjsecretlevel) {
        this.yjsecretlevel = yjsecretlevel == null ? null : yjsecretlevel.trim();
    }

    public String getYjdeadline() {
        return yjdeadline;
    }

    public void setYjdeadline(String yjdeadline) {
        this.yjdeadline = yjdeadline;
    }

    public String getEjxmname() {
        return ejxmname;
    }

    public void setEjxmname(String ejxmname) {
        this.ejxmname = ejxmname == null ? null : ejxmname.trim();
    }

    public String getExtype() {
        return extype;
    }

    public void setExtype(String extype) {
        this.extype = extype == null ? null : extype.trim();
    }

    public String getSecretlevel() {
        return secretlevel;
    }

    public void setSecretlevel(String secretlevel) {
        this.secretlevel = secretlevel == null ? null : secretlevel.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getExamina() {
        return examina;
    }

    public void setExamina(String examina) {
        this.examina = examina == null ? null : examina.trim();
    }

    public String getWorkflowid() {
        return workflowid;
    }

    public void setWorkflowid(String workflowid) {
        this.workflowid = workflowid == null ? null : workflowid.trim();
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Integer getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Integer isapproved) {
        this.isapproved = isapproved;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid == null ? null : formid.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getAccoutnamer() {
        return accoutnamer;
    }

    public void setAccoutnamer(String accoutnamer) {
        this.accoutnamer = accoutnamer == null ? null : accoutnamer.trim();
    }

    public String getOrganizationnamer() {
        return organizationnamer;
    }

    public void setOrganizationnamer(String organizationnamer) {
        this.organizationnamer = organizationnamer == null ? null : organizationnamer.trim();
    }

    public String getChushi() {
        return chushi;
    }

    public void setChushi(String chushi) {
        this.chushi = chushi == null ? null : chushi.trim();
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber == null ? null : jobnumber.trim();
    }

    public String getSecretlevelnamer() {
        return secretlevelnamer;
    }

    public void setSecretlevelnamer(String secretlevelnamer) {
        this.secretlevelnamer = secretlevelnamer == null ? null : secretlevelnamer.trim();
    }

    public String getStaffnamer() {
        return staffnamer;
    }

    public void setStaffnamer(String staffnamer) {
        this.staffnamer = staffnamer == null ? null : staffnamer.trim();
    }

    public String getLoginuserid() {
        return loginuserid;
    }

    public void setLoginuserid(String loginuserid) {
        this.loginuserid = loginuserid == null ? null : loginuserid.trim();
    }

    public String getLoginuserorgname() {
        return loginuserorgname;
    }

    public void setLoginuserorgname(String loginuserorgname) {
        this.loginuserorgname = loginuserorgname == null ? null : loginuserorgname.trim();
    }

    public String getLoginusersecretlevel() {
        return loginusersecretlevel;
    }

    public void setLoginusersecretlevel(String loginusersecretlevel) {
        this.loginusersecretlevel = loginusersecretlevel == null ? null : loginusersecretlevel.trim();
    }

    public String getLoginuseraccount() {
        return loginuseraccount;
    }

    public void setLoginuseraccount(String loginuseraccount) {
        this.loginuseraccount = loginuseraccount == null ? null : loginuseraccount.trim();
    }

    public String getRfileurl() {
        return rfileurl;
    }

    public void setRfileurl(String rfileurl) {
        this.rfileurl = rfileurl == null ? null : rfileurl.trim();
    }

    public String getApplyuserphone() {
        return applyuserphone;
    }

    public void setApplyuserphone(String applyuserphone) {
        this.applyuserphone = applyuserphone == null ? null : applyuserphone.trim();
    }
}