package com.hangyu.platform.web.sysAdmin.dto;

public class BmCheckplanitemTbl {
    private Integer id;

    private Integer itemtype;

    private String itemid;

    private String itemname;

    private String itemdemand;

    private String itemanswer;

    private Integer sortorder;

    private Integer isdelete;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemdemand() {
        return itemdemand;
    }

    public void setItemdemand(String itemdemand) {
        this.itemdemand = itemdemand == null ? null : itemdemand.trim();
    }

    public String getItemanswer() {
        return itemanswer;
    }

    public void setItemanswer(String itemanswer) {
        this.itemanswer = itemanswer == null ? null : itemanswer.trim();
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