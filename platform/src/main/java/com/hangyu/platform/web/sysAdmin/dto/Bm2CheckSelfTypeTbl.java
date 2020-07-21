package com.hangyu.platform.web.sysAdmin.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bm2CheckSelfTypeTbl {
    private Integer id;

    private String typeid;

    private String typename;

    private Integer isinvolve;

    private Integer isdelete;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String createtime;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String endtime;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String updatetime;

    private String creatorid;

    private Integer sortorder;

    private String remark;

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getIsinvolve() {
        return isinvolve;
    }

    public void setIsinvolve(Integer isinvolve) {
        this.isinvolve = isinvolve;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid == null ? null : creatorid.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}