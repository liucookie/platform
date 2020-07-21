package com.hangyu.platform.web.backBusiness.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.List;

public class BmKeydeptTbl {
    private Integer id;
    //内防还是外放
    private String picModelId;

    private String deptid;
    @Excel(name = "部门名称", width = 35, orderNum = "1")
    private String deptname;
    @Excel(name = "责任人", width = 10, orderNum = "2")
    private String deptmanager;
    @Excel(name = "位置", width = 80, orderNum = "3")
    private String deptposition;
    @Excel(name = "涉密人员数", width = 10, orderNum = "4")
    private Integer deptpeoplenum;
    @Excel(name = "批准时间", width = 30, orderNum = "5")
    private String deptpassdate;

    private String deptcanceldate;

    private Integer sortorder;

    private Integer isdelete;

    private String positionuser;

    private Integer iscancel;

    private String cancelcause;

    private String altertohisdate;

    private String artpro;

    private String phypro;

    private String techpro;

    private Integer ishistory;

    private String updatetime;

    private List<BmKeyfileTbl> bmKeyfileTbls;

    private List<BmStaffTbl> staffTbls;

    private String[] deleteFileIds;

    public String[] getDeleteFileIds() {
        return deleteFileIds;
    }

    public void setDeleteFileIds(String[] deleteFileIds) {
        this.deleteFileIds = deleteFileIds;
    }

    public List<BmKeyfileTbl> getBmKeyfileTbls() {
        return bmKeyfileTbls;
    }

    public void setBmKeyfileTbls(List<BmKeyfileTbl> bmKeyfileTbls) {
        this.bmKeyfileTbls = bmKeyfileTbls;
    }

    public String getPicModelId() {
        return picModelId;
    }

    public void setPicModelId(String picModelId) {
        this.picModelId = picModelId;
    }

    public String getAltertohisdate() {
        return altertohisdate;
    }

    public void setAltertohisdate(String altertohisdate) {
        this.altertohisdate = altertohisdate;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public List<BmStaffTbl> getStaffTbls() {
        return staffTbls;
    }

    public void setStaffTbls(List<BmStaffTbl> staffTbls) {
        this.staffTbls = staffTbls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getDeptmanager() {
        return deptmanager;
    }

    public void setDeptmanager(String deptmanager) {
        this.deptmanager = deptmanager == null ? null : deptmanager.trim();
    }

    public String getDeptposition() {
        return deptposition;
    }

    public void setDeptposition(String deptposition) {
        this.deptposition = deptposition == null ? null : deptposition.trim();
    }

    public Integer getDeptpeoplenum() {
        return deptpeoplenum;
    }

    public void setDeptpeoplenum(Integer deptpeoplenum) {
        this.deptpeoplenum = deptpeoplenum;
    }

    public String getDeptpassdate() {
        return deptpassdate;
    }

    public void setDeptpassdate(String deptpassdate) {
        this.deptpassdate = deptpassdate;
    }

    public String getDeptcanceldate() {
        return deptcanceldate;
    }

    public void setDeptcanceldate(String deptcanceldate) {
        this.deptcanceldate = deptcanceldate;
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

    public String getPositionuser() {
        return positionuser;
    }

    public void setPositionuser(String positionuser) {
        this.positionuser = positionuser == null ? null : positionuser.trim();
    }

    public Integer getIscancel() {
        return iscancel;
    }

    public void setIscancel(Integer iscancel) {
        this.iscancel = iscancel;
    }

    public String getCancelcause() {
        return cancelcause;
    }

    public void setCancelcause(String cancelcause) {
        this.cancelcause = cancelcause == null ? null : cancelcause.trim();
    }



    public String getArtpro() {
        return artpro;
    }

    public void setArtpro(String artpro) {
        this.artpro = artpro == null ? null : artpro.trim();
    }

    public String getPhypro() {
        return phypro;
    }

    public void setPhypro(String phypro) {
        this.phypro = phypro == null ? null : phypro.trim();
    }

    public String getTechpro() {
        return techpro;
    }

    public void setTechpro(String techpro) {
        this.techpro = techpro == null ? null : techpro.trim();
    }

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }


}