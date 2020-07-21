package com.hangyu.platform.web.sysAdmin.dto;

public class ComputerotherpropertyTbl {
    private Integer id;

    private String computerpropertyid;

    private String propertyname;

    private Integer sortorder;

    private String propertyremark;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComputerpropertyid() {
        return computerpropertyid;
    }

    public void setComputerpropertyid(String computerpropertyid) {
        this.computerpropertyid = computerpropertyid == null ? null : computerpropertyid.trim();
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname == null ? null : propertyname.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public String getPropertyremark() {
        return propertyremark;
    }

    public void setPropertyremark(String propertyremark) {
        this.propertyremark = propertyremark == null ? null : propertyremark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}