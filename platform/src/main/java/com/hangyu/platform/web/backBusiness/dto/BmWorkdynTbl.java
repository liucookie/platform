package com.hangyu.platform.web.backBusiness.dto;


public class BmWorkdynTbl {
    private Integer id;

    private String workdynid;

    private String infoname;

    private String showName;

    private String infocontent;

    private String keyword;

    private String updatetime;

    private String fileurl;

    private String inforemark;

    private Integer topsign;

    private Integer sortorder;

    private Integer readnum;

    private Integer isdelete;

    private Integer ispublish;

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkdynid() {
        return workdynid;
    }

    public void setWorkdynid(String workdynid) {
        this.workdynid = workdynid == null ? null : workdynid.trim();
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

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }
}