package com.hangyu.platform.web.sysAdmin.dto;

public class BmSecsofttypeTbl {
    private Integer id;

    private String uniqueid;

    private String typename;

    private String farthertypeid;

    private String typepath;

    private Integer sortorder;

    private Integer isdelete;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getFarthertypeid() {
        return farthertypeid;
    }

    public void setFarthertypeid(String farthertypeid) {
        this.farthertypeid = farthertypeid == null ? null : farthertypeid.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}