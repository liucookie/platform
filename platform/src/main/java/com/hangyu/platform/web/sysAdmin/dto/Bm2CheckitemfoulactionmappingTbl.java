package com.hangyu.platform.web.sysAdmin.dto;

import java.util.List;

public class Bm2CheckitemfoulactionmappingTbl {
    private String mappingid;

    private Integer checktype;

    private String checkitem;

    private String foulactionid;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getMappingid() {
        return mappingid;
    }

    public void setMappingid(String mappingid) {
        this.mappingid = mappingid == null ? null : mappingid.trim();
    }

    public Integer getChecktype() {
        return checktype;
    }

    public void setChecktype(Integer checktype) {
        this.checktype = checktype;
    }

    public String getCheckitem() {
        return checkitem;
    }

    public void setCheckitem(String checkitem) {
        this.checkitem = checkitem == null ? null : checkitem.trim();
    }

    public String getFoulactionid() {
        return foulactionid;
    }

    public void setFoulactionid(String foulactionid) {
        this.foulactionid = foulactionid == null ? null : foulactionid.trim();
    }
}