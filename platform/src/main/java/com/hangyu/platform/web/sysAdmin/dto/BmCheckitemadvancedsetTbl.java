package com.hangyu.platform.web.sysAdmin.dto;

public class BmCheckitemadvancedsetTbl {
    private Integer id;

    private String itemid;

    private String tooldefaultval;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
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