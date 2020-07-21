package com.hangyu.platform.web.sysAdmin.dto;

public class ComputyequiptypeTbl {
    private Integer id;

    private String uniqueid;

    private Integer areatype;

    private String equiptypename;

    private String equiptyperemark;

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

    public Integer getAreatype() {
        return areatype;
    }

    public void setAreatype(Integer areatype) {
        this.areatype = areatype;
    }

    public String getEquiptypename() {
        return equiptypename;
    }

    public void setEquiptypename(String equiptypename) {
        this.equiptypename = equiptypename == null ? null : equiptypename.trim();
    }

    public String getEquiptyperemark() {
        return equiptyperemark;
    }

    public void setEquiptyperemark(String equiptyperemark) {
        this.equiptyperemark = equiptyperemark == null ? null : equiptyperemark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}