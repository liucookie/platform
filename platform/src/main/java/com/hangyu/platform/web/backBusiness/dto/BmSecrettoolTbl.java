package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSecrettoolTbl {
    private Integer id;

    private String toolid;

    private String toolname;

    private String updatetime;

    private String fileurl;

    private String remark;

    private Integer topsign;

    private Integer sortorder;

    private Integer isdelete;

    private String linkurl;

    private Integer downloadtype;

    private String tooldesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToolid() {
        return toolid;
    }

    public void setToolid(String toolid) {
        this.toolid = toolid == null ? null : toolid.trim();
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname == null ? null : toolname.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public Integer getDownloadtype() {
        return downloadtype;
    }

    public void setDownloadtype(Integer downloadtype) {
        this.downloadtype = downloadtype;
    }

    public String getTooldesc() {
        return tooldesc;
    }

    public void setTooldesc(String tooldesc) {
        this.tooldesc = tooldesc == null ? null : tooldesc.trim();
    }
}