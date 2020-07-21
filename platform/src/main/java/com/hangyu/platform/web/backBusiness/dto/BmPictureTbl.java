package com.hangyu.platform.web.backBusiness.dto;


public class BmPictureTbl {
    private Integer id;

    private String uniqueid;

    private String typeid;

    private String typeName;

    private String nativefilename;

    private String remotefilename;

    private String updatetime;


    private Integer topsign;

    private Integer sortorder;

    private Integer isdelete;

    private String remark;


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

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getNativefilename() {
        return nativefilename;
    }

    public void setNativefilename(String nativefilename) {
        this.nativefilename = nativefilename == null ? null : nativefilename.trim();
    }

    public String getRemotefilename() {
        return remotefilename;
    }

    public void setRemotefilename(String remotefilename) {
        this.remotefilename = remotefilename == null ? null : remotefilename.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}