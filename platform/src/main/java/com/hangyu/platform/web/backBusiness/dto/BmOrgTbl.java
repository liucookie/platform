package com.hangyu.platform.web.backBusiness.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BmOrgTbl {
    private Integer id;

    private String orgid;

    private String orgname;

//    private Date orgdate;
    private String orgdate;

    private String orgfunction;

    private String orgrule;

    private String orguser;

    private Integer sortorder;

    private Integer isdelete;

    private Integer stater;

    private String updatetime;
    //文件
    private MultipartFile multipartFile;

    private List<BmOrguserTbl> orguserTblList;

    private  List<BmOrgContent> bmOrgContentList;

    private List<String> deleletList;

    private BmOrgfileTbl bmOrgfileTbl;

    private List<BmStaffTbl> bmStaffTblList;

    public List<String> getDeleletList() {
        return deleletList;
    }

    public void setDeleletList(List<String> deleletList) {
        this.deleletList = deleletList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgdate() {
        return orgdate;
    }

    public void setOrgdate(String orgdate) {
        this.orgdate = orgdate;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getOrgfunction() {
        return orgfunction;
    }

    public void setOrgfunction(String orgfunction) {
        this.orgfunction = orgfunction == null ? null : orgfunction.trim();
    }

    public String getOrgrule() {
        return orgrule;
    }

    public void setOrgrule(String orgrule) {
        this.orgrule = orgrule == null ? null : orgrule.trim();
    }

    public String getOrguser() {
        return orguser;
    }

    public void setOrguser(String orguser) {
        this.orguser = orguser == null ? null : orguser.trim();
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

    public Integer getStater() {
        return stater;
    }

    public void setStater(Integer stater) {
        this.stater = stater;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public List<BmOrguserTbl> getOrguserTblList() {
        return orguserTblList;
    }

    public void setOrguserTblList(List<BmOrguserTbl> orguserTblList) {
        this.orguserTblList = orguserTblList;
    }

    public List<BmOrgContent> getBmOrgContentList() {
        return bmOrgContentList;
    }

    public void setBmOrgContentList(List<BmOrgContent> bmOrgContentList) {
        this.bmOrgContentList = bmOrgContentList;
    }

    public BmOrgfileTbl getBmOrgfileTbl() {
        return bmOrgfileTbl;
    }

    public void setBmOrgfileTbl(BmOrgfileTbl bmOrgfileTbl) {
        this.bmOrgfileTbl = bmOrgfileTbl;
    }

    public List<BmStaffTbl> getBmStaffTblList() {
        return bmStaffTblList;
    }

    public void setBmStaffTblList(List<BmStaffTbl> bmStaffTblList) {
        this.bmStaffTblList = bmStaffTblList;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}