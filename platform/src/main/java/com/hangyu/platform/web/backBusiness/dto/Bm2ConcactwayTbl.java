package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class Bm2ConcactwayTbl {
    private String concactwayid;
    @Excel(name = "部门", width = 30, orderNum = "1")
    private String deptid;
    @Excel(name = "姓名", width = 15, orderNum = "3")
    private String userid;
    @Excel(name = "座机", width = 20, orderNum = "4")
    private String telephone;
    @Excel(name = "手机", width = 20, orderNum = "5")
    private String mobilephone;
    @Excel(name = "邮箱", width = 20, orderNum = "6")
    private String email;
    @Excel(name = "备注", width = 50, orderNum = "7")
    private String remark;

    private Integer isdelete;

    private String createtime;

    private String updatetime;

    private Integer ordertax;

    private Integer typeid;
    @Excel(name = "分类", width = 15, orderNum = "2")
    private String typename;

    public String getConcactwayid() {
        return concactwayid;
    }

    public void setConcactwayid(String concactwayid) {
        this.concactwayid = concactwayid == null ? null : concactwayid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getOrdertax() {
        return ordertax;
    }

    public void setOrdertax(Integer ordertax) {
        this.ordertax = ordertax;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}