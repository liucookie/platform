package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2LeaveTypeTbl {
    private String id;

    private String leavetypename;

    private Integer isdelete;

    private Integer leavetypemode;

    private String leavetyperemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLeavetypename() {
        return leavetypename;
    }

    public void setLeavetypename(String leavetypename) {
        this.leavetypename = leavetypename == null ? null : leavetypename.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getLeavetypemode() {
        return leavetypemode;
    }

    public void setLeavetypemode(Integer leavetypemode) {
        this.leavetypemode = leavetypemode;
    }

    public String getLeavetyperemark() {
        return leavetyperemark;
    }

    public void setLeavetyperemark(String leavetyperemark) {
        this.leavetyperemark = leavetyperemark == null ? null : leavetyperemark.trim();
    }
}