package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class BmSystemitemTbl {
    private Integer id;

    private String sysName;

    private Integer sysType;

    private String itemid;

    private String sysid;

    private Integer dscore;

    private Integer dconsub;

    private Integer dwages;

    private Integer sortorder;

    private Integer isdelete;

    private Integer ishistory;

    private String createrid;

    private Date createtime;

    private Integer oldid;

    private String itemcontent;

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
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

    public Integer getIshistory() {
        return ishistory;
    }

    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public String getItemcontent() {
        return itemcontent;
    }

    public void setItemcontent(String itemcontent) {
        this.itemcontent = itemcontent == null ? null : itemcontent.trim();
    }
}