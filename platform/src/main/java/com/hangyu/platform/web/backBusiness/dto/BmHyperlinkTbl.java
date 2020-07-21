package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmHyperlinkTbl {
    private Integer id;

    private String uniqueid;

    private String hyperlinktext;

    private String linkurl;

    private Integer isdelete;

    private Integer sortorder;

    private Integer topsign;

    private String remark;

    private String updatetime;

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

    public String getHyperlinktext() {
        return hyperlinktext;
    }

    public void setHyperlinktext(String hyperlinktext) {
        this.hyperlinktext = hyperlinktext == null ? null : hyperlinktext.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getTopsign() {
        return topsign;
    }

    public void setTopsign(Integer topsign) {
        this.topsign = topsign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}