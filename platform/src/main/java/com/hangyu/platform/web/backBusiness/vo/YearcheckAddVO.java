package com.hangyu.platform.web.backBusiness.vo;

public class YearcheckAddVO {

    private Integer year;

    private Integer month;

    private Integer startMonth;

    private Integer endMonth;

    private Integer count;

    private Double checkrate;

    private String userId;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCheckrate() {
        return checkrate;
    }

    public void setCheckrate(Double checkrate) {
        this.checkrate = checkrate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}