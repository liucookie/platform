package com.hangyu.platform.web.backBusiness.vo;

public class ServerManageQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;


    private String orgId;

    private String userId;

    //属性，0，1，2，3
    private String equipId;

    //密集名称
    private String secretLevelId;
    //使用情况id
    private String userStateId;
    //名称
    private String name;


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

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getSecretLevelId() {
        return secretLevelId;
    }

    public void setSecretLevelId(String secretLevelId) {
        this.secretLevelId = secretLevelId;
    }

    public String getUserStateId() {
        return userStateId;
    }

    public void setUserStateId(String userStateId) {
        this.userStateId = userStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
