package com.hangyu.platform.web.sysAdmin.dto;

import java.io.Serializable;
import java.util.Date;

public class Bm2FriendlySoftTypeTbl {
    private String typeid;

    private String typename;

    private Integer isdelete;

    private Date createtime;

    private String updatetime;

    private String typeremark;

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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getTyperemark() {
        return typeremark;
    }

    public void setTyperemark(String typeremark) {
        this.typeremark = typeremark == null ? null : typeremark.trim();
    }
}