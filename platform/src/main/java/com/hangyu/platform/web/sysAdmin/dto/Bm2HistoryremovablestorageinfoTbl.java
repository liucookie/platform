package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2HistoryremovablestorageinfoTbl {
    private String hremovablestorageid;

    private String typeid;

    private String usestarttime;

    private String useendtime;

    private String serialno;

    private String storagename;

    private String storagenumber;

    private String secretlevelid;

    private String infomemo;

    private Integer isdelete;

    private String createtime;

    private String updatetime;

    private String inuseunit;

    private String secretName;

    private String typeName;

    //历史使用时间范围
    private String timeRange;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getHremovablestorageid() {
        return hremovablestorageid;
    }

    public void setHremovablestorageid(String hremovablestorageid) {
        this.hremovablestorageid = hremovablestorageid == null ? null : hremovablestorageid.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getUsestarttime() {
        return usestarttime;
    }

    public void setUsestarttime(String usestarttime) {
        this.usestarttime = usestarttime;
    }

    public String getUseendtime() {
        return useendtime;
    }

    public void setUseendtime(String useendtime) {
        this.useendtime = useendtime;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public String getStoragename() {
        return storagename;
    }

    public void setStoragename(String storagename) {
        this.storagename = storagename == null ? null : storagename.trim();
    }

    public String getStoragenumber() {
        return storagenumber;
    }

    public void setStoragenumber(String storagenumber) {
        this.storagenumber = storagenumber == null ? null : storagenumber.trim();
    }

    public String getSecretlevelid() {
        return secretlevelid;
    }

    public void setSecretlevelid(String secretlevelid) {
        this.secretlevelid = secretlevelid == null ? null : secretlevelid.trim();
    }

    public String getInfomemo() {
        return infomemo;
    }

    public void setInfomemo(String infomemo) {
        this.infomemo = infomemo == null ? null : infomemo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getInuseunit() {
        return inuseunit;
    }

    public void setInuseunit(String inuseunit) {
        this.inuseunit = inuseunit == null ? null : inuseunit.trim();
    }
}