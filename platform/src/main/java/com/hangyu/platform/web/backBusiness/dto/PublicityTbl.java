package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class PublicityTbl {
    private Integer id;

    private String uniqueid;

    private String title;

    private String showTitle;

    private String attachment;

    private String remark;

    private Date beginworktime;

    private Date endworktime;

    private Integer isdelete;

    private String addtime;

    private Integer ispublish;

    private Integer pubtype;

    private String content;

    private String fileUrl;

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getBeginworktime() {
        return beginworktime;
    }

    public void setBeginworktime(Date beginworktime) {
        this.beginworktime = beginworktime;
    }

    public Date getEndworktime() {
        return endworktime;
    }

    public void setEndworktime(Date endworktime) {
        this.endworktime = endworktime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    public Integer getPubtype() {
        return pubtype;
    }

    public void setPubtype(Integer pubtype) {
        this.pubtype = pubtype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}