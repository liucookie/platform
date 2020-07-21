package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.List;

public class BmStaffciphertextTbl {
    private Integer id;

    private String cipid;

    private String departid;

    private String userid;
    @Excel(name = "身份证号", width = 20, orderNum = "7")
    private String useridcard;
    @Excel(name = "联系电话", width = 10, orderNum = "8")
    private String userphone;
    @Excel(name = "调入单位从事工作", width = 20, orderNum = "5")
    private String userinjob;
    @Excel(name = "原单位", width = 15, orderNum = "4")
    private String useroldunit;
    @Excel(name = "脱密期开始时间", width = 10, orderNum = "15")
    private String outsdate;
    @Excel(name = "脱密期结束时间", width = 10, orderNum = "16")
    private String outedate;

    private String outway;
    @Excel(name = "脱密期执行方式", width = 50, orderNum = "16")
    private String outwayName;

    private String file;

    private Integer isdelete;
    @Excel(name = "护照号码", width = 10, orderNum = "9")
    private String passport;
    @Excel(name = "工作时间", width = 10, orderNum = "12")
    private String jobtime;
    @Excel(name = "原单位所在部门", width = 15, orderNum = "5")
    private String oringinunit;

    private String jobsecrectlevelid;
    @Excel(name = "工作事项", width = 30, orderNum = "13")
    private String jobhistory;
    @Excel(name = "工作成果", width = 30, orderNum = "14")
    private String achievements;
    @Excel(name = "家庭详细地址", width = 25, orderNum = "10")
    private String familyaddr;
    @Excel(name = "邮编", width = 11, orderNum = "11")
    private String zipcode;
    @Excel(name = "汉族", width = 10, orderNum = "3")
    private String nation;
    @Excel(name = "姓名", width = 15, orderNum = "2")
    private String userName;
    @Excel(name = "单位", width = 25, orderNum = "1")
    private String orgName;
    @Excel(name = "岗位密级", width = 10, orderNum = "6")
    private String levelName;

    private List<String> outWayIds;

    private List<String> deleteIds;

    private List<BmStaffciphertextHf> visitRecords;

    public List<String> getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(List<String> deleteIds) {
        this.deleteIds = deleteIds;
    }



    public String getOutwayName() {
        return outwayName;
    }

    public void setOutwayName(String outwayName) {
        this.outwayName = outwayName;
    }

    public List<String> getOutWayIds() {
        return outWayIds;
    }

    public void setOutWayIds(List<String> outWayIds) {
        this.outWayIds = outWayIds;
    }

    public List<BmStaffciphertextHf> getVisitRecords() {
        return visitRecords;
    }

    public void setVisitRecords(List<BmStaffciphertextHf> visitRecords) {
        this.visitRecords = visitRecords;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCipid() {
        return cipid;
    }

    public void setCipid(String cipid) {
        this.cipid = cipid == null ? null : cipid.trim();
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid == null ? null : departid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUseridcard() {
        return useridcard;
    }

    public void setUseridcard(String useridcard) {
        this.useridcard = useridcard == null ? null : useridcard.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUserinjob() {
        return userinjob;
    }

    public void setUserinjob(String userinjob) {
        this.userinjob = userinjob == null ? null : userinjob.trim();
    }

    public String getUseroldunit() {
        return useroldunit;
    }

    public void setUseroldunit(String useroldunit) {
        this.useroldunit = useroldunit == null ? null : useroldunit.trim();
    }


    public String getOutway() {
        return outway;
    }

    public void setOutway(String outway) {
        this.outway = outway == null ? null : outway.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport == null ? null : passport.trim();
    }

    public String getOutsdate() {
        return outsdate;
    }

    public void setOutsdate(String outsdate) {
        this.outsdate = outsdate;
    }

    public String getOutedate() {
        return outedate;
    }

    public void setOutedate(String outedate) {
        this.outedate = outedate;
    }

    public String getJobtime() {
        return jobtime;
    }

    public void setJobtime(String jobtime) {
        this.jobtime = jobtime;
    }

    public String getOringinunit() {
        return oringinunit;
    }

    public void setOringinunit(String oringinunit) {
        this.oringinunit = oringinunit == null ? null : oringinunit.trim();
    }

    public String getJobsecrectlevelid() {
        return jobsecrectlevelid;
    }

    public void setJobsecrectlevelid(String jobsecrectlevelid) {
        this.jobsecrectlevelid = jobsecrectlevelid == null ? null : jobsecrectlevelid.trim();
    }

    public String getJobhistory() {
        return jobhistory;
    }

    public void setJobhistory(String jobhistory) {
        this.jobhistory = jobhistory == null ? null : jobhistory.trim();
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements == null ? null : achievements.trim();
    }

    public String getFamilyaddr() {
        return familyaddr;
    }

    public void setFamilyaddr(String familyaddr) {
        this.familyaddr = familyaddr == null ? null : familyaddr.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }
}