package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
import java.util.List;

public class Serverequipinfo {
    private Integer id;

    private String uniqueid;

    private String orgid;
    @Excel(name = "处室", width = 30, orderNum = "5")
    private String orgName;
    @Excel(name = "部门", width = 30, orderNum = "4")
    private String deptName;

    private String inusestaffid;
    @Excel(name = "责任人", width = 15, orderNum = "6")
    private String userName;
    @Excel(name = "名称型号", width = 20, orderNum = "3")
    private String sbxh;
    @Excel(name = "设备编码", width = 20, orderNum = "7")
    private String sbbm;
    @Excel(name = "房间号", width = 20, orderNum = "8")
    private String placement;

    private String secretlevelid;
    @Excel(name = "密级", width = 8, orderNum = "9")
    private String secretName;
    @Excel(name = "操作系统", width = 15, orderNum = "10")
    private String osname;
    @Excel(name = "系统安装时间", width = 30, orderNum = "11")
    private String osinstalldate;
    @Excel(name = "内置服务名称", width = 15, orderNum = "12")
    private String harddiscno;
    @Excel(name = "ip地址", width = 30, orderNum = "13")
    private String ip;
    @Excel(name = "mac地址", width = 30, orderNum = "14")
    private String mac;

    private String usestateid;

    List<String> propertyIds;
    @Excel(name = "使用情况", width = 15, orderNum = "17")
    private String useStateName;
    @Excel(name = "备注", width = 50, orderNum = "18")
    private String serverequipinfomemo;

    private Integer areatype;

    private String equiptypeid;

    private Integer isdelete;

    private Integer sjgrq;

    private Integer glcz;
    @Excel(name = "机柜号", width = 30, orderNum = "1")
    private String equipboxnum;
    @Excel(name = "柜内位置", width = 30, orderNum = "2")
    private String boxplace;
    @Excel(name = "虚拟ip地址", width = 30, orderNum = "15")
    private String vmip;
    @Excel(name = "虚拟mac地址", width = 30, orderNum = "16")
    private String vmmac;

    private String keepsecretnumber;

    public List<String> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(List<String> propertyIds) {
        this.propertyIds = propertyIds;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getOsinstalldate() {
        return osinstalldate;
    }

    public void setOsinstalldate(String osinstalldate) {
        this.osinstalldate = osinstalldate;
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

    public String getServerequipinfomemo() {
        return serverequipinfomemo;
    }

    public void setServerequipinfomemo(String serverequipinfomemo) {
        this.serverequipinfomemo = serverequipinfomemo == null ? null : serverequipinfomemo.trim();
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

    public String getEquipboxnum() {
        return equipboxnum;
    }

    public void setEquipboxnum(String equipboxnum) {
        this.equipboxnum = equipboxnum == null ? null : equipboxnum.trim();
    }

    public String getBoxplace() {
        return boxplace;
    }

    public void setBoxplace(String boxplace) {
        this.boxplace = boxplace == null ? null : boxplace.trim();
    }

    public String getVmip() {
        return vmip;
    }

    public void setVmip(String vmip) {
        this.vmip = vmip == null ? null : vmip.trim();
    }

    public String getVmmac() {
        return vmmac;
    }

    public void setVmmac(String vmmac) {
        this.vmmac = vmmac == null ? null : vmmac.trim();
    }

    public String getKeepsecretnumber() {
        return keepsecretnumber;
    }

    public void setKeepsecretnumber(String keepsecretnumber) {
        this.keepsecretnumber = keepsecretnumber == null ? null : keepsecretnumber.trim();
    }
}