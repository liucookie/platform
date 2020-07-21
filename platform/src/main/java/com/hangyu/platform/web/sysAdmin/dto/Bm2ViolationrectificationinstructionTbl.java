package com.hangyu.platform.web.sysAdmin.dto;

import java.util.Date;

public class Bm2ViolationrectificationinstructionTbl {
    private String instructionid;

    private Integer checktype;

    private String itemid;

    private String remark;

    private Integer ordertax;

    private Integer isdelete;

    private Date createtime;

    private Date updatetime;

    private String htmlitemid;

    private String instructioncontent;

    public String getInstructionid() {
        return instructionid;
    }

    public void setInstructionid(String instructionid) {
        this.instructionid = instructionid == null ? null : instructionid.trim();
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrdertax() {
        return ordertax;
    }

    public void setOrdertax(Integer ordertax) {
        this.ordertax = ordertax;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getHtmlitemid() {
        return htmlitemid;
    }

    public void setHtmlitemid(String htmlitemid) {
        this.htmlitemid = htmlitemid == null ? null : htmlitemid.trim();
    }

    public String getInstructioncontent() {
        return instructioncontent;
    }

    public void setInstructioncontent(String instructioncontent) {
        this.instructioncontent = instructioncontent == null ? null : instructioncontent.trim();
    }
}