package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2CheckspecialtypeTbl {
    private String checktypeid;

    private String checktypename;

    private String checktypememo;

    private Integer orderno;

    private Integer isdelete;

    private Integer checkclass;

    public String getChecktypeid() {
        return checktypeid;
    }

    public void setChecktypeid(String checktypeid) {
        this.checktypeid = checktypeid == null ? null : checktypeid.trim();
    }

    public String getChecktypename() {
        return checktypename;
    }

    public void setChecktypename(String checktypename) {
        this.checktypename = checktypename == null ? null : checktypename.trim();
    }

    public String getChecktypememo() {
        return checktypememo;
    }

    public void setChecktypememo(String checktypememo) {
        this.checktypememo = checktypememo == null ? null : checktypememo.trim();
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

    public Integer getCheckclass() {
        return checkclass;
    }

    public void setCheckclass(Integer checkclass) {
        this.checkclass = checkclass;
    }
}