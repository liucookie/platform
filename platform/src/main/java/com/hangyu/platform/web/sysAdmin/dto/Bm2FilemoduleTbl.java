package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2FilemoduleTbl {
    private Integer id;

    private String moduleid;

    private String modulename;

    private String topmoduleid;

    private String moduletemp;

    private Integer sortorder;

    private Integer isdelete;

    private Integer recordtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getTopmoduleid() {
        return topmoduleid;
    }

    public void setTopmoduleid(String topmoduleid) {
        this.topmoduleid = topmoduleid == null ? null : topmoduleid.trim();
    }

    public String getModuletemp() {
        return moduletemp;
    }

    public void setModuletemp(String moduletemp) {
        this.moduletemp = moduletemp == null ? null : moduletemp.trim();
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

    public Integer getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(Integer recordtype) {
        this.recordtype = recordtype;
    }
}