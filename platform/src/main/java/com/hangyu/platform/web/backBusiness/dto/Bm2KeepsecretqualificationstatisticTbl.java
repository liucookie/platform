package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class Bm2KeepsecretqualificationstatisticTbl {
    private Integer id;

    private String uniqueid;
    @Excel(name = "单位名称", width = 30, orderNum = "1")
    private String orgname;

    private String qualificationtypeid;

    private String qualificationlevelid;

    private String effectivebegindate;

    private String effectiveenddate;
    @Excel(name = "证书编号", width = 30, orderNum = "5")
    private String certificateno;
    @Excel(name = "有效期", width = 15, orderNum = "4")
    private String effectiveTime;


    private String certificatephoto;
    @Excel(name = "备注", width = 30, orderNum = "60")
    private String memo;

    private Integer isdelete;

    private String createtime;

    private String updatetime;

    private String fileurl;
    @Excel(name = "保密资质类型", width = 15, orderNum = "2")
    private String typeName;
    @Excel(name = "保密资质等级", width = 15, orderNum = "3")
    private String levelName;

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
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

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getQualificationtypeid() {
        return qualificationtypeid;
    }

    public void setQualificationtypeid(String qualificationtypeid) {
        this.qualificationtypeid = qualificationtypeid == null ? null : qualificationtypeid.trim();
    }

    public String getQualificationlevelid() {
        return qualificationlevelid;
    }

    public void setQualificationlevelid(String qualificationlevelid) {
        this.qualificationlevelid = qualificationlevelid == null ? null : qualificationlevelid.trim();
    }


    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno == null ? null : certificateno.trim();
    }

    public String getCertificatephoto() {
        return certificatephoto;
    }

    public void setCertificatephoto(String certificatephoto) {
        this.certificatephoto = certificatephoto == null ? null : certificatephoto.trim();
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

    public String getEffectivebegindate() {
        return effectivebegindate;
    }

    public void setEffectivebegindate(String effectivebegindate) {
        this.effectivebegindate = effectivebegindate;
    }

    public String getEffectiveenddate() {
        return effectiveenddate;
    }

    public void setEffectiveenddate(String effectiveenddate) {
        this.effectiveenddate = effectiveenddate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }
}