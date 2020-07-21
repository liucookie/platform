package com.hangyu.platform.web.backBusiness.vo;

public class PostLevelQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;

    private String orgId;

    private String secretId;

    private String businessSecretId;

    private String name;

    private String content;

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

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getBusinessSecreId() {
        return businessSecretId;
    }

    public void setBusinessSecreId(String businessSecreId) {
        this.businessSecretId = businessSecreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
