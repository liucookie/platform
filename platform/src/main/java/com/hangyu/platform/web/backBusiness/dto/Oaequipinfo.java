package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Oaequipinfo {
    private Integer id;

    private String uniqueid;

    private String orgid;
    @Excel(name = "处室", width = 35, orderNum = "6")
    private String orgName;
    @Excel(name = "部门", width = 35, orderNum = "5")
    private String deptName;

    private String staffid;
    @Excel(name = "责任人", width = 15, orderNum = "7")
    private String userName;
    @Excel(name = "名称型号", width = 20, orderNum = "2")
    private String sbxh;
    @Excel(name = "设备编码", width = 20, orderNum = "3")
    private String sbbm;

    private String oaequipname;

    private String secretlevelid;
    @Excel(name = "密级", width = 8, orderNum = "4")
    private String secretName;
    @Excel(name = "楼名", width = 15, orderNum = "8")
    private String placement;

    private String usestateid;
    @Excel(name = "使用情况", width = 10, orderNum = "9")
    private String useStateName;
    @Excel(name = "备注", width = 35, orderNum = "11")
    private String infomemo;

    private Integer isdelete;

    private Integer sjgrq;

    private Integer glcz;
    @Excel(name = "ip地址", width = 20, orderNum = "10")
    private String ip;

    private String gateway;

    private String subaddr;

    private String mac;

    private String floornum;

    private String roomnum;

    private String equiptypeid;

    private Integer areatype;

    private String switchip;

    private String switchport;

    private String switchaddress;

    private String keepsecretnumber;

    private String ztequipno;
    @Excel(name = "设备类型", width = 20, orderNum = "1")
    private String equipname;

    private String deptname;

    private String equipuser;

    private String typename;

    private String bangongxlh;

    private String levelname;

    private String harddisksn;

    private Integer state;

    private String workid;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getUseStateName() {
        return useStateName;
    }

    public void setUseStateName(String useStateName) {
        this.useStateName = useStateName;
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

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
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

    public String getOaequipname() {
        return oaequipname;
    }

    public void setOaequipname(String oaequipname) {
        this.oaequipname = oaequipname == null ? null : oaequipname.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement == null ? null : placement.trim();
    }

    public String getUsestateid() {
        return usestateid;
    }

    public void setUsestateid(String usestateid) {
        this.usestateid = usestateid == null ? null : usestateid.trim();
    }

    public String getInfomemo() {
        return infomemo;
    }

    public void setInfomemo(String infomemo) {
        this.infomemo = infomemo == null ? null : infomemo.trim();
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    public String getSubaddr() {
        return subaddr;
    }

    public void setSubaddr(String subaddr) {
        this.subaddr = subaddr == null ? null : subaddr.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getFloornum() {
        return floornum;
    }

    public void setFloornum(String floornum) {
        this.floornum = floornum == null ? null : floornum.trim();
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum == null ? null : roomnum.trim();
    }

    public String getEquiptypeid() {
        return equiptypeid;
    }

    public void setEquiptypeid(String equiptypeid) {
        this.equiptypeid = equiptypeid == null ? null : equiptypeid.trim();
    }

    public Integer getAreatype() {
        return areatype;
    }

    public void setAreatype(Integer areatype) {
        this.areatype = areatype;
    }

    public String getSwitchip() {
        return switchip;
    }

    public void setSwitchip(String switchip) {
        this.switchip = switchip == null ? null : switchip.trim();
    }

    public String getSwitchport() {
        return switchport;
    }

    public void setSwitchport(String switchport) {
        this.switchport = switchport == null ? null : switchport.trim();
    }

    public String getSwitchaddress() {
        return switchaddress;
    }

    public void setSwitchaddress(String switchaddress) {
        this.switchaddress = switchaddress == null ? null : switchaddress.trim();
    }

    public String getKeepsecretnumber() {
        return keepsecretnumber;
    }

    public void setKeepsecretnumber(String keepsecretnumber) {
        this.keepsecretnumber = keepsecretnumber == null ? null : keepsecretnumber.trim();
    }

    public String getZtequipno() {
        return ztequipno;
    }

    public void setZtequipno(String ztequipno) {
        this.ztequipno = ztequipno == null ? null : ztequipno.trim();
    }

    public String getEquipname() {
        return equipname;
    }

    public void setEquipname(String equipname) {
        this.equipname = equipname == null ? null : equipname.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getEquipuser() {
        return equipuser;
    }

    public void setEquipuser(String equipuser) {
        this.equipuser = equipuser == null ? null : equipuser.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getBangongxlh() {
        return bangongxlh;
    }

    public void setBangongxlh(String bangongxlh) {
        this.bangongxlh = bangongxlh == null ? null : bangongxlh.trim();
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname == null ? null : levelname.trim();
    }

    public String getHarddisksn() {
        return harddisksn;
    }

    public void setHarddisksn(String harddisksn) {
        this.harddisksn = harddisksn == null ? null : harddisksn.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }
}