package com.hangyu.platform.web.backBusiness.vo;

public class MediaManageQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;


    private String orgId;

    private String userId;
    //介质编号
    private String mediaId;
    //介质-设备编号；b便携机管理是资产编号
    private String equipId;
    //品牌
    private String brand;
    //密集名称
    private String secretName;
    //0,1,2表示 使用状态 0在用，1停运，2报废
    private String userStateId;
    //设备用途
    private String usage;
    //0,1,表示 借出状态 0在库，1借出
    private String borrowStateId;
    //介质容量
    private String mediaSize;

    //介质管理芯片序列号；便携机管理是硬盘编号
    private String chipNumber;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }



    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getUserStateId() {
        return userStateId;
    }

    public void setUserStateId(String userStateId) {
        this.userStateId = userStateId;
    }

    public String getBorrowStateId() {
        return borrowStateId;
    }

    public void setBorrowStateId(String borrowStateId) {
        this.borrowStateId = borrowStateId;
    }

    public String getMediaSize() {
        return mediaSize;
    }

    public void setMediaSize(String mediaSize) {
        this.mediaSize = mediaSize;
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(String chipNumber) {
        this.chipNumber = chipNumber;
    }
}
