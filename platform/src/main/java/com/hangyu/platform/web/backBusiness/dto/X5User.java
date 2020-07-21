package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;

public class X5User {
    private Integer id;

    private String bmStaffId;

    private String bmStaffAccount;

    private String x5StaffName;

    private String x5UserId;

    private String x5Account;

    private String x5Token;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBmStaffId() {
        return bmStaffId;
    }

    public void setBmStaffId(String bmStaffId) {
        this.bmStaffId = bmStaffId == null ? null : bmStaffId.trim();
    }

    public String getBmStaffAccount() {
        return bmStaffAccount;
    }

    public void setBmStaffAccount(String bmStaffAccount) {
        this.bmStaffAccount = bmStaffAccount == null ? null : bmStaffAccount.trim();
    }

    public String getX5StaffName() {
        return x5StaffName;
    }

    public void setX5StaffName(String x5StaffName) {
        this.x5StaffName = x5StaffName == null ? null : x5StaffName.trim();
    }

    public String getX5UserId() {
        return x5UserId;
    }

    public void setX5UserId(String x5UserId) {
        this.x5UserId = x5UserId == null ? null : x5UserId.trim();
    }

    public String getX5Account() {
        return x5Account;
    }

    public void setX5Account(String x5Account) {
        this.x5Account = x5Account == null ? null : x5Account.trim();
    }

    public String getX5Token() {
        return x5Token;
    }

    public void setX5Token(String x5Token) {
        this.x5Token = x5Token == null ? null : x5Token.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}