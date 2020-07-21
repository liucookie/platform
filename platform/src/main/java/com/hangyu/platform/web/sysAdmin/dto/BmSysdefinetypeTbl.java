package com.hangyu.platform.web.sysAdmin.dto;

public class BmSysdefinetypeTbl {
    private Integer id;

    private String definetypeid;

    private String definetypename;

    private Integer sortorder;

    private Integer isdelete;

    private String definetyperemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefinetypeid() {
        return definetypeid;
    }

    public void setDefinetypeid(String definetypeid) {
        this.definetypeid = definetypeid == null ? null : definetypeid.trim();
    }

    public String getDefinetypename() {
        return definetypename;
    }

    public void setDefinetypename(String definetypename) {
        this.definetypename = definetypename == null ? null : definetypename.trim();
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

    public String getDefinetyperemark() {
        return definetyperemark;
    }

    public void setDefinetyperemark(String definetyperemark) {
        this.definetyperemark = definetyperemark == null ? null : definetyperemark.trim();
    }
}