package com.hangyu.platform.web.sysAdmin.dto;

import java.util.Date;

public class Bm2MessagebasicinfoTbl {
    private Integer id;

    private String uniqueid;

    private Integer strategytype;

    private String smtpserveraddress;

    private String serveraddress;

    private Integer mailserverport;

    private String serverloginaccount;

    private String serverloginpassword;

    private String defaultsendaccount;

    private Integer isdelete;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public Integer getStrategytype() {
        return strategytype;
    }

    public void setStrategytype(Integer strategytype) {
        this.strategytype = strategytype;
    }

    public String getSmtpserveraddress() {
        return smtpserveraddress;
    }

    public void setSmtpserveraddress(String smtpserveraddress) {
        this.smtpserveraddress = smtpserveraddress == null ? null : smtpserveraddress.trim();
    }

    public String getServeraddress() {
        return serveraddress;
    }

    public void setServeraddress(String serveraddress) {
        this.serveraddress = serveraddress == null ? null : serveraddress.trim();
    }

    public Integer getMailserverport() {
        return mailserverport;
    }

    public void setMailserverport(Integer mailserverport) {
        this.mailserverport = mailserverport;
    }

    public String getServerloginaccount() {
        return serverloginaccount;
    }

    public void setServerloginaccount(String serverloginaccount) {
        this.serverloginaccount = serverloginaccount == null ? null : serverloginaccount.trim();
    }

    public String getServerloginpassword() {
        return serverloginpassword;
    }

    public void setServerloginpassword(String serverloginpassword) {
        this.serverloginpassword = serverloginpassword == null ? null : serverloginpassword.trim();
    }

    public String getDefaultsendaccount() {
        return defaultsendaccount;
    }

    public void setDefaultsendaccount(String defaultsendaccount) {
        this.defaultsendaccount = defaultsendaccount == null ? null : defaultsendaccount.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}