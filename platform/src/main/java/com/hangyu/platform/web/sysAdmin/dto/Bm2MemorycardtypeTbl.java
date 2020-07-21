package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2MemorycardtypeTbl {
    private Integer id;

    private String uniqueid;

    private String memorycardname;

    private Integer isdelete;

    private Integer ordertax;

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

    public String getMemorycardname() {
        return memorycardname;
    }

    public void setMemorycardname(String memorycardname) {
        this.memorycardname = memorycardname == null ? null : memorycardname.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getOrdertax() {
        return ordertax;
    }

    public void setOrdertax(Integer ordertax) {
        this.ordertax = ordertax;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}