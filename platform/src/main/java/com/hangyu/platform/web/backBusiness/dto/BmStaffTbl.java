package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.List;

public class BmStaffTbl {
    private Integer id;

    private String staffid;

    private String deptid;

    @Excel(name = "姓名", width = 15, orderNum = "3")
    private String username;
    @Excel(name = "性别", width = 10, orderNum = "4")
    private String usersex;
    @Excel(name = "出生日期", width = 15, orderNum = "6")
    private String borthdate;
    @Excel(name = "政治面貌", width = 10, orderNum = "7")
    private String userface;
    @Excel(name = "职位", width = 15, orderNum = "8")
    private String userjob;
    @Excel(name = "职称", width = 15, orderNum = "9")
    private String useroffice;

    private String secretlevelid;

    private String usertypeid;

    private String userstateid;

    private Integer secretprovide;

    private Integer isdelete;

    private String hrsynid;

    private String gangWei;

    private String staffphoto;
    @Excel(name = "工作岗位", width = 15, orderNum = "10")
    private String jobpost;

    private String adminpost;
    @Excel(name = "行政岗位", width = 15, orderNum = "11")
    private String injobtime;
    @Excel(name = "签密日期", width = 15, orderNum = "12")
    private String signsecrettime;

    private String staffmemo;
    @Excel(name = "账号", width = 15, orderNum = "16")
    private String accoutname;

    private String userphone;

    private Integer logintype;

    private String pass;

    private String staffemail;

    private String staffocs;

    private String starttime;

    private String sysid;

    private String superior;

    private Integer posttypeid;

    private String createtime;

    private String updatetime;

    private String roletypeids;
    @Excel(name = "工号", width = 15, orderNum = "18")
    private String workid;
    @Excel(name = "身份证号", width = 20, orderNum = "5")
    private String idcard;

    private Integer iscanapprove;

    private String nativeplace;

    private String censusregister;

    private String homeadd;

    private String education;

    private String officephone;

    private String indate;

    private String isoutstu;

    private String isouthome;

    private String isoutsub;

    private byte[] userphoto;
    @Excel(name = "密级", width = 10, orderNum = "13")
    private String levelName;
    @Excel(name = "类型", width = 10, orderNum = "14")
    private String userTypeName;
    @Excel(name = "状态", width = 10, orderNum = "15")
    private String userStateName;

    //查询出的机构名称
    @Excel(name = "处室", width = 30, orderNum = "2")
    private String orgName;
    //处室名称
    @Excel(name = "部门", width = 30, orderNum = "1")
    private String deptName;

    //查询出的角色名称
    private String roleName;

    //保密员工家庭人员
    List<BmStafffamilyTbl> stafffamilyList;
    //学习经历
    List<BmStaffstudyTbl> staffstudyTbls;
    //工作经历
    List<BmStaffworkTbl> staffworkTbls;

    public String getGangWei() {
        return gangWei;
    }

    public void setGangWei(String gangWei) {
        this.gangWei = gangWei;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getBorthdate() {
        return borthdate;
    }

    public void setBorthdate(String borthdate) {
        this.borthdate = borthdate;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getUserjob() {
        return userjob;
    }

    public void setUserjob(String userjob) {
        this.userjob = userjob;
    }

    public String getUseroffice() {
        return useroffice;
    }

    public void setUseroffice(String useroffice) {
        this.useroffice = useroffice;
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid;
    }

    public String getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(String usertypeid) {
        this.usertypeid = usertypeid;
    }

    public String getUserstateid() {
        return userstateid;
    }

    public void setUserstateid(String userstateid) {
        this.userstateid = userstateid;
    }

    public Integer getSecretprovide() {
        return secretprovide;
    }

    public void setSecretprovide(Integer secretprovide) {
        this.secretprovide = secretprovide;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getHrsynid() {
        return hrsynid;
    }

    public void setHrsynid(String hrsynid) {
        this.hrsynid = hrsynid;
    }

    public String getStaffphoto() {
        return staffphoto;
    }

    public void setStaffphoto(String staffphoto) {
        this.staffphoto = staffphoto;
    }

    public String getJobpost() {
        return jobpost;
    }

    public void setJobpost(String jobpost) {
        this.jobpost = jobpost;
    }

    public String getAdminpost() {
        return adminpost;
    }

    public void setAdminpost(String adminpost) {
        this.adminpost = adminpost;
    }

    public String getInjobtime() {
        return injobtime;
    }

    public void setInjobtime(String injobtime) {
        this.injobtime = injobtime;
    }

    public String getSignsecrettime() {
        return signsecrettime;
    }

    public void setSignsecrettime(String signsecrettime) {
        this.signsecrettime = signsecrettime;
    }

    public String getStaffmemo() {
        return staffmemo;
    }

    public void setStaffmemo(String staffmemo) {
        this.staffmemo = staffmemo;
    }

    public String getAccoutname() {
        return accoutname;
    }

    public void setAccoutname(String accoutname) {
        this.accoutname = accoutname;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getStaffocs() {
        return staffocs;
    }

    public void setStaffocs(String staffocs) {
        this.staffocs = staffocs;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public Integer getPosttypeid() {
        return posttypeid;
    }

    public void setPosttypeid(Integer posttypeid) {
        this.posttypeid = posttypeid;
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

    public String getRoletypeids() {
        return roletypeids;
    }

    public void setRoletypeids(String roletypeids) {
        this.roletypeids = roletypeids;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getIscanapprove() {
        return iscanapprove;
    }

    public void setIscanapprove(Integer iscanapprove) {
        this.iscanapprove = iscanapprove;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getCensusregister() {
        return censusregister;
    }

    public void setCensusregister(String censusregister) {
        this.censusregister = censusregister;
    }

    public String getHomeadd() {
        return homeadd;
    }

    public void setHomeadd(String homeadd) {
        this.homeadd = homeadd;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getIsoutstu() {
        return isoutstu;
    }

    public void setIsoutstu(String isoutstu) {
        this.isoutstu = isoutstu;
    }

    public String getIsouthome() {
        return isouthome;
    }

    public void setIsouthome(String isouthome) {
        this.isouthome = isouthome;
    }

    public String getIsoutsub() {
        return isoutsub;
    }

    public void setIsoutsub(String isoutsub) {
        this.isoutsub = isoutsub;
    }

    public byte[] getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(byte[] userphoto) {
        this.userphoto = userphoto;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserStateName() {
        return userStateName;
    }

    public void setUserStateName(String userStateName) {
        this.userStateName = userStateName;
    }


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<BmStafffamilyTbl> getStafffamilyList() {
        return stafffamilyList;
    }

    public void setStafffamilyList(List<BmStafffamilyTbl> stafffamilyList) {
        this.stafffamilyList = stafffamilyList;
    }

    public List<BmStaffstudyTbl> getStaffstudyTbls() {
        return staffstudyTbls;
    }

    public void setStaffstudyTbls(List<BmStaffstudyTbl> staffstudyTbls) {
        this.staffstudyTbls = staffstudyTbls;
    }

    public List<BmStaffworkTbl> getStaffworkTbls() {
        return staffworkTbls;
    }

    public void setStaffworkTbls(List<BmStaffworkTbl> staffworkTbls) {
        this.staffworkTbls = staffworkTbls;
    }
}