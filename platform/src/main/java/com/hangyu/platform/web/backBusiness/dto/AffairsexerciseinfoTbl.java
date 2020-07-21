package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
import java.util.List;

public class AffairsexerciseinfoTbl {
    private Integer id;

    private String uniqueid;
    @Excel(name = "来访时间", width = 30, orderNum = "4")
    private String visitordate;
    @Excel(name = "接待参观接触部位", width = 30, orderNum = "7")
    private String contactpart;

    private String keepstaff;

    private String keepsupervise;

    private String secretlevelid;
    @Excel(name = "外宾人数", width = 10, orderNum = "3")
    private Integer customercount;

    private String visitordeptid;
    @Excel(name = "洽谈交流地点", width = 23, orderNum = "6")
    private String visitoraddress;
    @Excel(name = "联系电话", width = 20, orderNum = "9")
    private String linkphone;
    @Excel(name = "接待事由", width = 30, orderNum = "10")
    private String visitorresion;

    private Integer isdelete;

    private Date updatetime;
    @Excel(name = "安全保密负责人", width = 10, orderNum = "8")
    private String keepstaffname;
    @Excel(name = "涉密等级", width = 10, orderNum = "2")
    private String secretlevel;
    @Excel(name = "接待部门", width = 30, orderNum = "1")
    private String visitordeptname;
    @Excel(name = "结束时间", width = 30, orderNum = "5")
    private String visitoredate;

    private String remark;



    private List<AffairsexerciseinfoUsers> affairUsers;

    public List<AffairsexerciseinfoUsers> getAffairUsers() {
        return affairUsers;
    }

    public void setAffairUsers(List<AffairsexerciseinfoUsers> affairUsers) {
        this.affairUsers = affairUsers;
    }

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


    public String getContactpart() {
        return contactpart;
    }

    public void setContactpart(String contactpart) {
        this.contactpart = contactpart == null ? null : contactpart.trim();
    }

    public String getKeepstaff() {
        return keepstaff;
    }

    public void setKeepstaff(String keepstaff) {
        this.keepstaff = keepstaff == null ? null : keepstaff.trim();
    }

    public String getKeepsupervise() {
        return keepsupervise;
    }

    public void setKeepsupervise(String keepsupervise) {
        this.keepsupervise = keepsupervise == null ? null : keepsupervise.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }

    public Integer getCustomercount() {
        return customercount;
    }

    public void setCustomercount(Integer customercount) {
        this.customercount = customercount;
    }

    public String getVisitordeptid() {
        return visitordeptid;
    }

    public void setVisitordeptid(String visitordeptid) {
        this.visitordeptid = visitordeptid == null ? null : visitordeptid.trim();
    }

    public String getVisitoraddress() {
        return visitoraddress;
    }

    public void setVisitoraddress(String visitoraddress) {
        this.visitoraddress = visitoraddress == null ? null : visitoraddress.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public String getVisitorresion() {
        return visitorresion;
    }

    public void setVisitorresion(String visitorresion) {
        this.visitorresion = visitorresion == null ? null : visitorresion.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getKeepstaffname() {
        return keepstaffname;
    }

    public void setKeepstaffname(String keepstaffname) {
        this.keepstaffname = keepstaffname == null ? null : keepstaffname.trim();
    }

    public String getSecretlevel() {
        return secretlevel;
    }

    public void setSecretlevel(String secretlevel) {
        this.secretlevel = secretlevel == null ? null : secretlevel.trim();
    }

    public String getVisitordeptname() {
        return visitordeptname;
    }

    public void setVisitordeptname(String visitordeptname) {
        this.visitordeptname = visitordeptname == null ? null : visitordeptname.trim();
    }

    public String getVisitordate() {
        return visitordate;
    }

    public void setVisitordate(String visitordate) {
        this.visitordate = visitordate;
    }

    public String getVisitoredate() {
        return visitoredate;
    }

    public void setVisitoredate(String visitoredate) {
        this.visitoredate = visitoredate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}