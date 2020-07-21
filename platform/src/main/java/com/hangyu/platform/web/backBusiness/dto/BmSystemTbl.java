package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.List;

//保密制度基本信息表实体
public class BmSystemTbl implements Serializable {
    private Integer id;

    private String sysid;

    private String deptid;

    private String systype;
    @Excel(name = "制度名称",width = 60,orderNum = "3")
    private String sysname;

    private String definetypeid;
    @Excel(name = "建立日期",width = 20,orderNum = "6")
    private String sysdate;
    @Excel(name = "适用范围",width = 30,orderNum = "7")
    private String sysrange;

    private String sysuserid;

    private Integer sortorder;

    private Integer isdelete;

    private Integer dscore;

    private Integer dconsub;

    private Integer dwages;
    @Excel(name = "文号",width = 30,orderNum = "5")
    private String refdeptid;

    private String refnum;

    private Integer ishistory;

    private String updatetime;

    private String  sysremark;
    @Excel(name = "处室",width = 30,orderNum = "2")
    private String orgName;
    @Excel(name = "部门名称",width = 30,orderNum = "1")
    private String deptName;
    @Excel(name = "发文单位",width = 30,orderNum = "4")
    private String publishName;


    private String fileName;

    private String fileUrl;

    private List<BmSystemfileTbl> sysFiles;


    private String syscontent;

    public List<BmSystemfileTbl> getSysFiles() {
        return sysFiles;
    }

    public void setSysFiles(List<BmSystemfileTbl> sysFiles) {
        this.sysFiles = sysFiles;
    }

    public String getSyscontent() {
        return syscontent;
    }

    public void setSyscontent(String syscontent) {
        this.syscontent = syscontent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getSysremark() {
        return sysremark;
    }

    public void setSysremark(String sysremark) {
        this.sysremark = sysremark;
    }

    public String getSysrange() {
        return sysrange;
    }

    public void setSysrange(String sysrange) {
        this.sysrange = sysrange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getSystype() {
        return systype;
    }

    public void setSystype(String systype) {
        this.systype = systype == null ? null : systype.trim();
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname == null ? null : sysname.trim();
    }

    public String getDefinetypeid() {
        return definetypeid;
    }

    public void setDefinetypeid(String definetypeid) {
        this.definetypeid = definetypeid == null ? null : definetypeid.trim();
    }

    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }

    public String getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(String sysuserid) {
        this.sysuserid = sysuserid == null ? null : sysuserid.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getDscore() {
        return dscore;
    }

    public void setDscore(Integer dscore) {
        this.dscore = dscore;
    }

    public Integer getDconsub() {
        return dconsub;
    }

    public void setDconsub(Integer dconsub) {
        this.dconsub = dconsub;
    }

    public Integer getDwages() {
        return dwages;
    }

    public void setDwages(Integer dwages) {
        this.dwages = dwages;
    }

    public String getRefdeptid() {
        return refdeptid;
    }

    public void setRefdeptid(String refdeptid) {
        this.refdeptid = refdeptid == null ? null : refdeptid.trim();
    }

    public String getRefnum() {
        return refnum;
    }

    public void setRefnum(String refnum) {
        this.refnum = refnum == null ? null : refnum.trim();
    }

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}