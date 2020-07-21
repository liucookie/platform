package com.hangyu.platform.web.backBusiness.vo;

public class UsbKeyQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;

    private String orgId;

    private String userId;

    //密集名称
    private String secretLevelId;
    //借出情况
    private String borrowId;

    //名称
    private String name;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

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



    public String getSecretLevelId() {
        return secretLevelId;
    }

    public void setSecretLevelId(String secretLevelId) {
        this.secretLevelId = secretLevelId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
