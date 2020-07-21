package com.hangyu.platform.web.backBusiness.dto;

public class BmCheckselfdeptTbl {
    private Integer id;

    private String checkselfid;

    private String selfplanid;

    private String deptid;

    private String deptname;

    private Integer staffnum;

    private Integer isdelete;

    private Integer examinestatus;

    private Integer withoutcomputernum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckselfid() {
        return checkselfid;
    }

    public void setCheckselfid(String checkselfid) {
        this.checkselfid = checkselfid == null ? null : checkselfid.trim();
    }

    public String getSelfplanid() {
        return selfplanid;
    }

    public void setSelfplanid(String selfplanid) {
        this.selfplanid = selfplanid == null ? null : selfplanid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getStaffnum() {
        return staffnum;
    }

    public void setStaffnum(Integer staffnum) {
        this.staffnum = staffnum;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getExaminestatus() {
        return examinestatus;
    }

    public void setExaminestatus(Integer examinestatus) {
        this.examinestatus = examinestatus;
    }

    public Integer getWithoutcomputernum() {
        return withoutcomputernum;
    }

    public void setWithoutcomputernum(Integer withoutcomputernum) {
        this.withoutcomputernum = withoutcomputernum;
    }
}