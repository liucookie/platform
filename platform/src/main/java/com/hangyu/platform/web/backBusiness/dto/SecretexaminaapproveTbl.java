package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class SecretexaminaapproveTbl {
    private Integer id;

    private String uniqueid;

    private String name;

    private String content;

    private String departname;

    private String secretlevelyj;

    private String yjname;

    private String yjsecretlevel;

    private String yjdeadline;

    private String ejxmname;

    private String extype;

    private String secretlevel;

    private Date deadline;

    private String scope;

    private String examina;

    private String workflowid;

    private Integer operation;

    private Integer isapproved;

    private Integer isdelete;

    private String formid;

    private String applytime;

    private String accoutnamer;

    private String organizationnamer;

    private String applyUserName;

    private String jobnumber;

    private String secretlevelnamer;

    private String staffnamer;

    private String loginuserid;

    private String loginuserorgname;

    private String loginusersecretlevel;

    private String loginuseraccount;

    private String rfileurl;

    private String applyuserphone;

    private String nodeId;

    private String opinion;

    private String instanceId;

    private String creatorId;

    private List<SecretcontrolparticularTbl> list;

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<SecretcontrolparticularTbl> getList() {
        return list;
    }

    public void setList(List<SecretcontrolparticularTbl> list) {
        this.list = list;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
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

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
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