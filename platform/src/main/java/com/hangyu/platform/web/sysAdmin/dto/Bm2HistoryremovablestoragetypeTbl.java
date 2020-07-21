package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2HistoryremovablestoragetypeTbl {
    private String typeid;

    private String typename;

    private String typememo;

    private Integer isdelete;

    private String inuseunit;

    private String typecolorid;

    private String colorName;

    private String colorCode;


    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getTypememo() {
        return typememo;
    }

    public void setTypememo(String typememo) {
        this.typememo = typememo == null ? null : typememo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getInuseunit() {
        return inuseunit;
    }

    public void setInuseunit(String inuseunit) {
        this.inuseunit = inuseunit == null ? null : inuseunit.trim();
    }

    public String getTypecolorid() {
        return typecolorid;
    }

    public void setTypecolorid(String typecolorid) {
        this.typecolorid = typecolorid == null ? null : typecolorid.trim();
    }
}