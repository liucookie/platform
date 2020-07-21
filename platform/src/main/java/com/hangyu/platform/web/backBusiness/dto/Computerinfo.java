package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class Computerinfo {
    private Integer id;

    private String uniqueid;

    private String orgid;
   //处室
   @Excel(name = "处室", width = 30, orderNum = "2")
    private String orgName;
    //部门
    @Excel(name = "部门", width = 30, orderNum = "1")
    private String deptName;


    private String inusestaffid;
    @Excel(name = "责任人", width = 20, orderNum = "3")
    private String userName;
    @Excel(name = "名称型号", width = 30, orderNum = "4")
    private String sbxh;
    @Excel(name = "设备编码", width = 30, orderNum = "5")
    private String sbbm;
    @Excel(name = "楼房名", width = 30, orderNum = "6")
    private String placement;

    private String secretlevelid;
    @Excel(name = "密级", width = 10, orderNum = "7")
    private String secretName;
    @Excel(name = "操作系统", width = 20, orderNum = "8")
    private String osname;
    @Excel(name = "系统安装时间", width = 20, orderNum = "9")
    private String osinstalldate;
    @Excel(name = "硬盘序列号", width = 30, orderNum = "10")
    private String harddiscno;

    private String ip;

    private String mac;

    private String usestateid;
    @Excel(name = "使用情况", width = 30, orderNum = "11")
    private String useStateName;

    private String switchip;

    private String switchaddress;

    private String switchport;
    @Excel(name = "备注", width = 50, orderNum = "12")
    private String computerinfomemo;

    private Integer areatype;

    private String equiptypeid;

    private String equipTypeName;

    private Integer isdelete;

    private Integer sjgrq;

    private Integer glcz;

    private String remark1;

    private String remark2;

    private String remark3;

    private String keepsecretnumber;

    private String synguidid;

    private String workid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getInusestaffid() {
        return inusestaffid;
    }

    public void setInusestaffid(String inusestaffid) {
        this.inusestaffid = inusestaffid == null ? null : inusestaffid.trim();
    }

    public String getSbxh() {
        return sbxh;
    }

    public void setSbxh(String sbxh) {
        this.sbxh = sbxh == null ? null : sbxh.trim();
    }

    public String getSbbm() {
        return sbbm;
    }

    public void setSbbm(String sbbm) {
        this.sbbm = sbbm == null ? null : sbbm.trim();
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement == null ? null : placement.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }

    public String getOsname() {
        return osname;
    }

    public void setOsname(String osname) {
        this.osname = osname == null ? null : osname.trim();
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

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getOsinstalldate() {
        return osinstalldate;
    }

    public void setOsinstalldate(String osinstalldate) {
        this.osinstalldate = osinstalldate;
    }

    public String getUseStateName() {
        return useStateName;
    }

    public void setUseStateName(String useStateName) {
        this.useStateName = useStateName;
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName;
    }

    public String getHarddiscno() {
        return harddiscno;
    }

    public void setHarddiscno(String harddiscno) {
        this.harddiscno = harddiscno == null ? null : harddiscno.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getUsestateid() {
        return usestateid;
    }

    public void setUsestateid(String usestateid) {
        this.usestateid = usestateid == null ? null : usestateid.trim();
    }

    public String getSwitchip() {
        return switchip;
    }

    public void setSwitchip(String switchip) {
        this.switchip = switchip == null ? null : switchip.trim();
    }

    public String getSwitchaddress() {
        return switchaddress;
    }

    public void setSwitchaddress(String switchaddress) {
        this.switchaddress = switchaddress == null ? null : switchaddress.trim();
    }

    public String getSwitchport() {
        return switchport;
    }

    public void setSwitchport(String switchport) {
        this.switchport = switchport == null ? null : switchport.trim();
    }

    public String getComputerinfomemo() {
        return computerinfomemo;
    }

    public void setComputerinfomemo(String computerinfomemo) {
        this.computerinfomemo = computerinfomemo == null ? null : computerinfomemo.trim();
    }

    public Integer getAreatype() {
        return areatype;
    }

    public void setAreatype(Integer areatype) {
        this.areatype = areatype;
    }

    public String getEquiptypeid() {
        return equiptypeid;
    }

    public void setEquiptypeid(String equiptypeid) {
        this.equiptypeid = equiptypeid == null ? null : equiptypeid.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getSjgrq() {
        return sjgrq;
    }

    public void setSjgrq(Integer sjgrq) {
        this.sjgrq = sjgrq;
    }

    public Integer getGlcz() {
        return glcz;
    }

    public void setGlcz(Integer glcz) {
        this.glcz = glcz;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getKeepsecretnumber() {
        return keepsecretnumber;
    }

    public void setKeepsecretnumber(String keepsecretnumber) {
        this.keepsecretnumber = keepsecretnumber == null ? null : keepsecretnumber.trim();
    }

    public String getSynguidid() {
        return synguidid;
    }

    public void setSynguidid(String synguidid) {
        this.synguidid = synguidid == null ? null : synguidid.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }
}