package com.hangyu.platform.web.sysAdmin.dto;

import java.util.Date;

public class Bm2MessageinformstrTbl {
    private Integer id;

    private String uniqueid;

    private String basicinfoid;

    private Integer strategytype;

    private Integer sendtype;

    private String sendobject;

    private Integer sendtimeIsplanbegin;

    private Integer sendtimePlanbeginDaynum;

    private String sendtimePlanbeginExacttime;

    private Integer sendtimeIsplanend;

    private Integer sendtimePlanendDaynum;

    private String sendtimePlanendExacttime;

    private Integer sendtimeIsdevicereturn;

    private Integer sendtimeDevicereturnDaynum;

    private String sendtimeDevicereturnExacttime;

    private String sendcontent;

    private Integer isdelete;

    private Date createtime;

    private String sendtitle;

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

    public String getBasicinfoid() {
        return basicinfoid;
    }

    public void setBasicinfoid(String basicinfoid) {
        this.basicinfoid = basicinfoid == null ? null : basicinfoid.trim();
    }

    public Integer getStrategytype() {
        return strategytype;
    }

    public void setStrategytype(Integer strategytype) {
        this.strategytype = strategytype;
    }

    public Integer getSendtype() {
        return sendtype;
    }

    public void setSendtype(Integer sendtype) {
        this.sendtype = sendtype;
    }

    public String getSendobject() {
        return sendobject;
    }

    public void setSendobject(String sendobject) {
        this.sendobject = sendobject == null ? null : sendobject.trim();
    }

    public Integer getSendtimeIsplanbegin() {
        return sendtimeIsplanbegin;
    }

    public void setSendtimeIsplanbegin(Integer sendtimeIsplanbegin) {
        this.sendtimeIsplanbegin = sendtimeIsplanbegin;
    }

    public Integer getSendtimePlanbeginDaynum() {
        return sendtimePlanbeginDaynum;
    }

    public void setSendtimePlanbeginDaynum(Integer sendtimePlanbeginDaynum) {
        this.sendtimePlanbeginDaynum = sendtimePlanbeginDaynum;
    }

    public String getSendtimePlanbeginExacttime() {
        return sendtimePlanbeginExacttime;
    }

    public void setSendtimePlanbeginExacttime(String sendtimePlanbeginExacttime) {
        this.sendtimePlanbeginExacttime = sendtimePlanbeginExacttime == null ? null : sendtimePlanbeginExacttime.trim();
    }

    public Integer getSendtimeIsplanend() {
        return sendtimeIsplanend;
    }

    public void setSendtimeIsplanend(Integer sendtimeIsplanend) {
        this.sendtimeIsplanend = sendtimeIsplanend;
    }

    public Integer getSendtimePlanendDaynum() {
        return sendtimePlanendDaynum;
    }

    public void setSendtimePlanendDaynum(Integer sendtimePlanendDaynum) {
        this.sendtimePlanendDaynum = sendtimePlanendDaynum;
    }

    public String getSendtimePlanendExacttime() {
        return sendtimePlanendExacttime;
    }

    public void setSendtimePlanendExacttime(String sendtimePlanendExacttime) {
        this.sendtimePlanendExacttime = sendtimePlanendExacttime == null ? null : sendtimePlanendExacttime.trim();
    }

    public Integer getSendtimeIsdevicereturn() {
        return sendtimeIsdevicereturn;
    }

    public void setSendtimeIsdevicereturn(Integer sendtimeIsdevicereturn) {
        this.sendtimeIsdevicereturn = sendtimeIsdevicereturn;
    }

    public Integer getSendtimeDevicereturnDaynum() {
        return sendtimeDevicereturnDaynum;
    }

    public void setSendtimeDevicereturnDaynum(Integer sendtimeDevicereturnDaynum) {
        this.sendtimeDevicereturnDaynum = sendtimeDevicereturnDaynum;
    }

    public String getSendtimeDevicereturnExacttime() {
        return sendtimeDevicereturnExacttime;
    }

    public void setSendtimeDevicereturnExacttime(String sendtimeDevicereturnExacttime) {
        this.sendtimeDevicereturnExacttime = sendtimeDevicereturnExacttime == null ? null : sendtimeDevicereturnExacttime.trim();
    }

    public String getSendcontent() {
        return sendcontent;
    }

    public void setSendcontent(String sendcontent) {
        this.sendcontent = sendcontent == null ? null : sendcontent.trim();
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

    public String getSendtitle() {
        return sendtitle;
    }

    public void setSendtitle(String sendtitle) {
        this.sendtitle = sendtitle == null ? null : sendtitle.trim();
    }
}