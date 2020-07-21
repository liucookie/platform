package com.hangyu.platform.web.backBusiness.vo;

public class CheckPlanQueryVO {

    //总页数
    private int pageNum;
    //总条数
    private int pageSize;

    private String name;
    //计划状态，或者检查id
    private String checkType;

    private String monthPlanId;
   //计划状态
    private String status;

    private String startDate;

    private String endDate;

    public String getMonthPlanId() {
        return monthPlanId;
    }

    public void setMonthPlanId(String monthPlanId) {
        this.monthPlanId = monthPlanId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
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
}
