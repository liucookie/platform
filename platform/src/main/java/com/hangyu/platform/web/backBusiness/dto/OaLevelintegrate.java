package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class OaLevelintegrate {
    private Integer id;

    private String filename;

    private String fileno;

    private String secretleve;

    private String promoter;

    private String auditperson;

    private String approvalpeople;

    private String generatetime;

    private String startdepartment;

    private String startoffices;

    private Integer isdelete;

    private String userid;

    private String importime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno == null ? null : fileno.trim();
    }

    public String getSecretleve() {
        return secretleve;
    }

    public void setSecretleve(String secretleve) {
        this.secretleve = secretleve == null ? null : secretleve.trim();
    }

    public String getPromoter() {
        return promoter;
    }

    public void setPromoter(String promoter) {
        this.promoter = promoter == null ? null : promoter.trim();
    }

    public String getAuditperson() {
        return auditperson;
    }

    public void setAuditperson(String auditperson) {
        this.auditperson = auditperson == null ? null : auditperson.trim();
    }

    public String getApprovalpeople() {
        return approvalpeople;
    }

    public void setApprovalpeople(String approvalpeople) {
        this.approvalpeople = approvalpeople == null ? null : approvalpeople.trim();
    }



    public String getStartdepartment() {
        return startdepartment;
    }

    public void setStartdepartment(String startdepartment) {
        this.startdepartment = startdepartment == null ? null : startdepartment.trim();
    }

    public String getStartoffices() {
        return startoffices;
    }

    public void setStartoffices(String startoffices) {
        this.startoffices = startoffices == null ? null : startoffices.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getGeneratetime() {
        return generatetime;
    }

    public void setGeneratetime(String generatetime) {
        this.generatetime = generatetime;
    }

    public String getImportime() {
        return importime;
    }

    public void setImportime(String importime) {
        this.importime = importime;
    }
}