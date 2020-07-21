package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2HistoryremovablestoragecolorTbl {
    private String colorid;

    private String colorname;

    private String colormemo;

    private String colorcode;

    private Integer isdelete;

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid == null ? null : colorid.trim();
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname == null ? null : colorname.trim();
    }

    public String getColormemo() {
        return colormemo;
    }

    public void setColormemo(String colormemo) {
        this.colormemo = colormemo == null ? null : colormemo.trim();
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode == null ? null : colorcode.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}