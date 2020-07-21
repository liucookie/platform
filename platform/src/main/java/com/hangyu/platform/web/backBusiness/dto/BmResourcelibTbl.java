package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmResourcelibTbl {
    private Integer id;

    private String reslibid;

    private String typeid;

    private String typeName;


    private String resname;

    private String keyword;

    private String respic;

    private String updatetime;

    private String fileurl;

    private String resremark;

    private Integer isdelete;

    private String content;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReslibid() {
        return reslibid;
    }

    public void setReslibid(String reslibid) {
        this.reslibid = reslibid == null ? null : reslibid.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname == null ? null : resname.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getRespic() {
        return respic;
    }

    public void setRespic(String respic) {
        this.respic = respic == null ? null : respic.trim();
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

    public String getResremark() {
        return resremark;
    }

    public void setResremark(String resremark) {
        this.resremark = resremark == null ? null : resremark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}