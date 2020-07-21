package com.hangyu.platform.web.sysAdmin.dto;

public class BmSettingTbl {
    private Integer id;

    private String keyname;

    private String keyvalue;

    private String keyremark;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue == null ? null : keyvalue.trim();
    }

    public String getKeyremark() {
        return keyremark;
    }

    public void setKeyremark(String keyremark) {
        this.keyremark = keyremark == null ? null : keyremark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}