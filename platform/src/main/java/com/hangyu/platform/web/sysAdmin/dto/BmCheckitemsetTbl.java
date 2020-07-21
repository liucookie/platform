package com.hangyu.platform.web.sysAdmin.dto;

public class BmCheckitemsetTbl {
    private Integer id;

    private String itemname;

    private String tooldefaultval;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getTooldefaultval() {
        return tooldefaultval;
    }

    public void setTooldefaultval(String tooldefaultval) {
        this.tooldefaultval = tooldefaultval == null ? null : tooldefaultval.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}