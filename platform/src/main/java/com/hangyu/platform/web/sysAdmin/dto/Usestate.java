package com.hangyu.platform.web.sysAdmin.dto;


public class Usestate {
    private Integer id;

    private String uniqueid;

    private String usestatename;

    private String usestatememo;

    private Integer isdelete;

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

    public String getUsestatename() {
        return usestatename;
    }

    public void setUsestatename(String usestatename) {
        this.usestatename = usestatename == null ? null : usestatename.trim();
    }

    public String getUsestatememo() {
        return usestatememo;
    }

    public void setUsestatememo(String usestatememo) {
        this.usestatememo = usestatememo == null ? null : usestatememo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}