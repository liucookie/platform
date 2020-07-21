package com.hangyu.platform.web.backBusiness.vo;

public class SoftWareQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;

    private String softTypeId;

    private String startDate;

    private String endDate;

    private String keyWord;

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

    public String getSoftTypeId() {
        return softTypeId;
    }

    public void setSoftTypeId(String softTypeId) {
        this.softTypeId = softTypeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
