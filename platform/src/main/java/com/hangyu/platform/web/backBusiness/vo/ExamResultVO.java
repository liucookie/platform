package com.hangyu.platform.web.backBusiness.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ExamResultVO {
    private Integer id;
    @Excel(name = "处室", width = 30, orderNum = "1")
    private String organizationName;
    @Excel(name = "计划考试人数", width = 20, orderNum = "2")
    private int allCheckCount;
    @Excel(name = "需要考试人数", width = 20, orderNum = "3")
    private int requiredCount;
    @Excel(name = "已考试人数", width = 20, orderNum = "4")
    private int alreadyCount;
    @Excel(name = "及格人数", width = 20, orderNum = "5")
    private int passCount;
    @Excel(name = "不及格人数", width = 20, orderNum = "6")
    private int notPassCount;

    public ExamResultVO(Integer id, String organizationName, int allCheckCount, int requiredCount, int alreadyCount, int passCount, int notPassCount) {
        this.id = id;
        this.organizationName = organizationName;
        this.allCheckCount = allCheckCount;
        this.requiredCount = requiredCount;
        this.alreadyCount = alreadyCount;
        this.passCount = passCount;
        this.notPassCount = notPassCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getAllCheckCount() {
        return allCheckCount;
    }

    public void setAllCheckCount(int allCheckCount) {
        this.allCheckCount = allCheckCount;
    }

    public int getRequiredCount() {
        return requiredCount;
    }

    public void setRequiredCount(int requiredCount) {
        this.requiredCount = requiredCount;
    }

    public int getAlreadyCount() {
        return alreadyCount;
    }

    public void setAlreadyCount(int alreadyCount) {
        this.alreadyCount = alreadyCount;
    }

    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public int getNotPassCount() {
        return notPassCount;
    }

    public void setNotPassCount(int notPassCount) {
        this.notPassCount = notPassCount;
    }
}
