package com.hangyu.platform.web.sysAdmin.dto;

import java.util.List;

public class BmRecordtypeTbl {
    private Integer id;

    private String typeid;

    private String classId;

    private String typename;

    private String toptypeid;

    private String typepath;

    private Integer sortorder;

    private Integer isdelete;

    private String digitalias;

    private Integer putway;

    private Integer recordtype;

    private Integer puttype;

    private Integer putcycletype;

    private Integer putcyclemonth;

    private Integer putcycleday;

    private String keyword;

    private String firstputtime;

    private String lastputtime;

    private String nextputtime;

    private String typeremark;

    private List<Bm2FilemoduleTbl> filemoduleTbls;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Bm2FilemoduleTbl> getFilemoduleTbls() {
        return filemoduleTbls;
    }

    public void setFilemoduleTbls(List<Bm2FilemoduleTbl> filemoduleTbls) {
        this.filemoduleTbls = filemoduleTbls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getToptypeid() {
        return toptypeid;
    }

    public void setToptypeid(String toptypeid) {
        this.toptypeid = toptypeid == null ? null : toptypeid.trim();
    }

    public String getTypepath() {
        return typepath;
    }

    public void setTypepath(String typepath) {
        this.typepath = typepath == null ? null : typepath.trim();
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

    public String getDigitalias() {
        return digitalias;
    }

    public void setDigitalias(String digitalias) {
        this.digitalias = digitalias == null ? null : digitalias.trim();
    }

    public Integer getPutway() {
        return putway;
    }

    public void setPutway(Integer putway) {
        this.putway = putway;
    }

    public Integer getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(Integer recordtype) {
        this.recordtype = recordtype;
    }

    public Integer getPuttype() {
        return puttype;
    }

    public void setPuttype(Integer puttype) {
        this.puttype = puttype;
    }

    public Integer getPutcycletype() {
        return putcycletype;
    }

    public void setPutcycletype(Integer putcycletype) {
        this.putcycletype = putcycletype;
    }

    public Integer getPutcyclemonth() {
        return putcyclemonth;
    }

    public void setPutcyclemonth(Integer putcyclemonth) {
        this.putcyclemonth = putcyclemonth;
    }

    public Integer getPutcycleday() {
        return putcycleday;
    }

    public void setPutcycleday(Integer putcycleday) {
        this.putcycleday = putcycleday;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public void setFirstputtime(String firstputtime) {
        this.firstputtime = firstputtime;
    }

    public void setLastputtime(String lastputtime) {
        this.lastputtime = lastputtime;
    }

    public void setNextputtime(String nextputtime) {
        this.nextputtime = nextputtime;
    }


    public String getFirstputtime() {
        return firstputtime;
    }

    public String getLastputtime() {
        return lastputtime;
    }

    public String getNextputtime() {
        return nextputtime;
    }

    public String getTyperemark() {
        return typeremark;
    }

    public void setTyperemark(String typeremark) {
        this.typeremark = typeremark == null ? null : typeremark.trim();
    }
}