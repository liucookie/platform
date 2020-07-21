package com.hangyu.platform.web.sysAdmin.dto;

public class Bm2CreditrulesettingTbl {
    private String creditrulesettingid;

    private Double defaultdeptscore;

    private Double defaultpersonscore;

    private Double dpaddup;

    private Double dpdeduct;

    private Double dlquarteraddup;

    private Double dlquarterdeduct;

    private Double dlyearlimited;

    private Double dlyearaddup;

    private Double dlyeardeduct;

    private Integer examnieyear;

    public String getCreditrulesettingid() {
        return creditrulesettingid;
    }

    public void setCreditrulesettingid(String creditrulesettingid) {
        this.creditrulesettingid = creditrulesettingid == null ? null : creditrulesettingid.trim();
    }

    public Double getDefaultdeptscore() {
        return defaultdeptscore;
    }

    public void setDefaultdeptscore(Double defaultdeptscore) {
        this.defaultdeptscore = defaultdeptscore;
    }

    public Double getDefaultpersonscore() {
        return defaultpersonscore;
    }

    public void setDefaultpersonscore(Double defaultpersonscore) {
        this.defaultpersonscore = defaultpersonscore;
    }

    public Double getDpaddup() {
        return dpaddup;
    }

    public void setDpaddup(Double dpaddup) {
        this.dpaddup = dpaddup;
    }

    public Double getDpdeduct() {
        return dpdeduct;
    }

    public void setDpdeduct(Double dpdeduct) {
        this.dpdeduct = dpdeduct;
    }

    public Double getDlquarteraddup() {
        return dlquarteraddup;
    }

    public void setDlquarteraddup(Double dlquarteraddup) {
        this.dlquarteraddup = dlquarteraddup;
    }

    public Double getDlquarterdeduct() {
        return dlquarterdeduct;
    }

    public void setDlquarterdeduct(Double dlquarterdeduct) {
        this.dlquarterdeduct = dlquarterdeduct;
    }

    public Double getDlyearlimited() {
        return dlyearlimited;
    }

    public void setDlyearlimited(Double dlyearlimited) {
        this.dlyearlimited = dlyearlimited;
    }

    public Double getDlyearaddup() {
        return dlyearaddup;
    }

    public void setDlyearaddup(Double dlyearaddup) {
        this.dlyearaddup = dlyearaddup;
    }

    public Double getDlyeardeduct() {
        return dlyeardeduct;
    }

    public void setDlyeardeduct(Double dlyeardeduct) {
        this.dlyeardeduct = dlyeardeduct;
    }

    public Integer getExamnieyear() {
        return examnieyear;
    }

    public void setExamnieyear(Integer examnieyear) {
        this.examnieyear = examnieyear;
    }
}