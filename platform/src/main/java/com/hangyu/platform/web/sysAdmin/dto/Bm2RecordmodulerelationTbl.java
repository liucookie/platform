package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2RecordmodulerelationTbl {
    private Integer id;

    private String recordtypeid;

    private String moduleid;

    private Integer sortorder;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecordtypeid() {
        return recordtypeid;
    }

    public void setRecordtypeid(String recordtypeid) {
        this.recordtypeid = recordtypeid == null ? null : recordtypeid.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
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
}