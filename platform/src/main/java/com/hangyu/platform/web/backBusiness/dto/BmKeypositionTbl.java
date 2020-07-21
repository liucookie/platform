package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
import java.util.List;

public class BmKeypositionTbl {
    private Integer id;

    //外防还是内防
    private String picModelId;

    private String positionid;
    @Excel(name = "部位名称", width = 35, orderNum = "1")
    private String positionname;
    @Excel(name = "责任人", width = 10, orderNum = "2")
    private String positionmanager;
    @Excel(name = "位置", width = 40, orderNum = "3")
    private String positionaddr;

    private String secretlevelid;
    @Excel(name = "批准时间", width = 30, orderNum = "4")
    private String positionpassdate;

    private String positioncanceldate;

    private String positionuser;

    private Integer sortorder;

    private Integer isdelete;

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

    public String getPicModelId() {
        return picModelId;
    }

    public void setPicModelId(String picModelId) {
        this.picModelId = picModelId;
    }

    public List<BmStaffTbl> getStaffTbls() {
        return staffTbls;
    }

    public void setStaffTbls(List<BmStaffTbl> staffTbls) {
        this.staffTbls = staffTbls;
    }

    public String getPositionpassdate() {
        return positionpassdate;
    }

    public void setPositionpassdate(String positionpassdate) {
        this.positionpassdate = positionpassdate;
    }

    public String getPositioncanceldate() {
        return positioncanceldate;
    }

    public void setPositioncanceldate(String positioncanceldate) {
        this.positioncanceldate = positioncanceldate;
    }

    public List<BmKeyfileTbl> getBmKeyfileTbls() {
        return bmKeyfileTbls;
    }

    public void setBmKeyfileTbls(List<BmKeyfileTbl> bmKeyfileTbls) {
        this.bmKeyfileTbls = bmKeyfileTbls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid == null ? null : positionid.trim();
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

    public String getPositionmanager() {
        return positionmanager;
    }

    public void setPositionmanager(String positionmanager) {
        this.positionmanager = positionmanager == null ? null : positionmanager.trim();
    }

    public String getPositionaddr() {
        return positionaddr;
    }

    public void setPositionaddr(String positionaddr) {
        this.positionaddr = positionaddr == null ? null : positionaddr.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }


    public String getPositionuser() {
        return positionuser;
    }

    public void setPositionuser(String positionuser) {
        this.positionuser = positionuser == null ? null : positionuser.trim();
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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}