package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSlsetofficerTbl {
    private Integer id;

    private String uniqueid;
    //部门名称
    private String deptName;

    private String orgid;

    private String orgName;

    private String userid;

    private String userName;

    private String post;

    private String range;

    private String istrain;

    private String traindate;

    private String valid;

    private String certificate;

    private String sltype;

    private String typeName;

    private Integer isdelete;

    private Date createtime;

    private String creater;

    private String validsdate;

    private String validedate;

    private String secretrange;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range == null ? null : range.trim();
    }

    public String getIstrain() {
        return istrain;
    }

    public void setIstrain(String istrain) {
        this.istrain = istrain == null ? null : istrain.trim();
    }

    public String getTraindate() {
        return traindate;
    }

    public void setTraindate(String traindate) {
        this.traindate = traindate;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getSltype() {
        return sltype;
    }

    public void setSltype(String sltype) {
        this.sltype = sltype == null ? null : sltype.trim();
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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getValidsdate() {
        return validsdate;
    }

    public void setValidsdate(String validsdate) {
        this.validsdate = validsdate;
    }

    public String getValidedate() {
        return validedate;
    }

    public void setValidedate(String validedate) {
        this.validedate = validedate;
    }

    public String getSecretrange() {
        return secretrange;
    }

    public void setSecretrange(String secretrange) {
        this.secretrange = secretrange == null ? null : secretrange.trim();
    }
}