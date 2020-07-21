package com.hangyu.platform.web.sysAdmin.dto;

public class MediauseTbl {
    private Integer id;

    private String uniqueid;

    private Integer isdelete;

    private String mediauseremark;

    private String mediause;

    private Integer usetype;

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

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getMediauseremark() {
        return mediauseremark;
    }

    public void setMediauseremark(String mediauseremark) {
        this.mediauseremark = mediauseremark == null ? null : mediauseremark.trim();
    }

    public String getMediause() {
        return mediause;
    }

    public void setMediause(String mediause) {
        this.mediause = mediause == null ? null : mediause.trim();
    }

    public Integer getUsetype() {
        return usetype;
    }

    public void setUsetype(Integer usetype) {
        this.usetype = usetype;
    }
}