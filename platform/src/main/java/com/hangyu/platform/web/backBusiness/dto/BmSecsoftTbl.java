package com.hangyu.platform.web.backBusiness.dto;

public class BmSecsoftTbl {
    private Integer id;

    private String uniqueid;

    private String softname;

    private String softclassify;

    private String typeName;

    private String desc;

    private String version;


    private Integer sortorder;

    private Integer isdelete;

    private Integer topsign;

    private String updateDate;

    private BmSecsoftverTbl secSoft;

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BmSecsoftverTbl getSecSoft() {
        return secSoft;
    }

    public void setSecSoft(BmSecsoftverTbl secSoft) {
        this.secSoft = secSoft;
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

    public String getSoftname() {
        return softname;
    }

    public void setSoftname(String softname) {
        this.softname = softname == null ? null : softname.trim();
    }

    public String getSoftclassify() {
        return softclassify;
    }

    public void setSoftclassify(String softclassify) {
        this.softclassify = softclassify == null ? null : softclassify.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getTopsign() {
        return topsign;
    }

    public void setTopsign(Integer topsign) {
        this.topsign = topsign;
    }
}