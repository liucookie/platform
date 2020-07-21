package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2FoulactiontypeTbl {
    private String foulactiontypeid;

    private String foulactiontypename;

    private String foulactiontypememo;

    private Integer orderno;

    private Integer isdelete;

    public String getFoulactiontypeid() {
        return foulactiontypeid;
    }

    public void setFoulactiontypeid(String foulactiontypeid) {
        this.foulactiontypeid = foulactiontypeid == null ? null : foulactiontypeid.trim();
    }

    public String getFoulactiontypename() {
        return foulactiontypename;
    }

    public void setFoulactiontypename(String foulactiontypename) {
        this.foulactiontypename = foulactiontypename == null ? null : foulactiontypename.trim();
    }

    public String getFoulactiontypememo() {
        return foulactiontypememo;
    }

    public void setFoulactiontypememo(String foulactiontypememo) {
        this.foulactiontypememo = foulactiontypememo == null ? null : foulactiontypememo.trim();
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}