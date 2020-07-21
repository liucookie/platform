package com.hangyu.platform.web.sysAdmin.dto;

public class BmLibtypeTbl {
    private Integer id;

    private String typeid;

    private String toptypeid;

    private String toptypename;

    private String typename;


    private String typepath;

    private Integer sortorder;

    private Integer isdelete;

    private String typeremark;

    public String getToptypename() {
        return toptypename;
    }

    public void setToptypename(String toptypename) {
        this.toptypename = toptypename;
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

    public String getToptypeid() {
        return toptypeid;
    }

    public void setToptypeid(String toptypeid) {
        this.toptypeid = toptypeid == null ? null : toptypeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
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

    public String getTyperemark() {
        return typeremark;
    }

    public void setTyperemark(String typeremark) {
        this.typeremark = typeremark == null ? null : typeremark.trim();
    }
}