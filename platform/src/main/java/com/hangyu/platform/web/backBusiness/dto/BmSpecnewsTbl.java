package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class BmSpecnewsTbl {
    private Integer id;

    private String specnewsid;

    private String infoname;

    private String infocontent;

    private String keyword;

    private String updatetime;

    private String specpic;

    private String fileurl;


    private String inforemark;

    private Integer topsign;

    private Integer sortorder;

    private Integer readnum;

    private Integer isdelete;

    private String importpictures;

    List<BmPictureTbl> pictureTblList;

    private Integer ispublish;

    public List<BmPictureTbl> getPictureTblList() {
        return pictureTblList;
    }


    public void setPictureTblList(List<BmPictureTbl> pictureTblList) {
        this.pictureTblList = pictureTblList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecnewsid() {
        return specnewsid;
    }

    public void setSpecnewsid(String specnewsid) {
        this.specnewsid = specnewsid == null ? null : specnewsid.trim();
    }

    public String getInfoname() {
        return infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname == null ? null : infoname.trim();
    }

    public String getInfocontent() {
        return infocontent;
    }

    public void setInfocontent(String infocontent) {
        this.infocontent = infocontent == null ? null : infocontent.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getSpecpic() {
        return specpic;
    }

    public void setSpecpic(String specpic) {
        this.specpic = specpic == null ? null : specpic.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getInforemark() {
        return inforemark;
    }

    public void setInforemark(String inforemark) {
        this.inforemark = inforemark == null ? null : inforemark.trim();
    }

    public Integer getTopsign() {
        return topsign;
    }

    public void setTopsign(Integer topsign) {
        this.topsign = topsign;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getImportpictures() {
        return importpictures;
    }

    public void setImportpictures(String importpictures) {
        this.importpictures = importpictures == null ? null : importpictures.trim();
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }
}