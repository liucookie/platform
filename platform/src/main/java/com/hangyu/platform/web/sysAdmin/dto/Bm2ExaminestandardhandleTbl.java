package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2ExaminestandardhandleTbl {
    private String exstdhandleid;

    private Integer handletype;

    private String handlecontent;

    private Double scoreupper;

    private Double scorelower;

    public String getExstdhandleid() {
        return exstdhandleid;
    }

    public void setExstdhandleid(String exstdhandleid) {
        this.exstdhandleid = exstdhandleid == null ? null : exstdhandleid.trim();
    }

    public Integer getHandletype() {
        return handletype;
    }

    public void setHandletype(Integer handletype) {
        this.handletype = handletype;
    }

    public String getHandlecontent() {
        return handlecontent;
    }

    public void setHandlecontent(String handlecontent) {
        this.handlecontent = handlecontent == null ? null : handlecontent.trim();
    }

    public Double getScoreupper() {
        return scoreupper;
    }

    public void setScoreupper(Double scoreupper) {
        this.scoreupper = scoreupper;
    }

    public Double getScorelower() {
        return scorelower;
    }

    public void setScorelower(Double scorelower) {
        this.scorelower = scorelower;
    }
}