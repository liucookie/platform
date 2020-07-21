package com.hangyu.platform.web.backBusiness.dto;


import java.util.List;

public class BmCheckplanTbl {
    private Integer id;

    private String planid;

    private String planname;

    private Integer planchecktype;

    private String planbegindate;

    private String planenddate;

    private Integer planstate;

    private String fileurl;

    private Integer isdelete;

    private Integer isyearplan;

    private String planremark;

    private List<BmCheckplanpeasonTbl> peasons;

    private List<BmCheckplandemandTbl> mand;

    private List<BmCheckplanadvanceddemandTbl> planMand;

    private BmCheckselfdeptTbl dept;

    public List<BmCheckplanpeasonTbl> getPeasons() {
        return peasons;
    }

    public void setPeasons(List<BmCheckplanpeasonTbl> peasons) {
        this.peasons = peasons;
    }

    public List<BmCheckplandemandTbl> getMand() {
        return mand;
    }

    public void setMand(List<BmCheckplandemandTbl> mand) {
        this.mand = mand;
    }

    public List<BmCheckplanadvanceddemandTbl> getPlanMand() {
        return planMand;
    }

    public void setPlanMand(List<BmCheckplanadvanceddemandTbl> planMand) {
        this.planMand = planMand;
    }

    public BmCheckselfdeptTbl getDept() {
        return dept;
    }

    public void setDept(BmCheckselfdeptTbl dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname == null ? null : planname.trim();
    }

    public Integer getPlanchecktype() {
        return planchecktype;
    }

    public void setPlanchecktype(Integer planchecktype) {
        this.planchecktype = planchecktype;
    }

    public String getPlanbegindate() {
        return planbegindate;
    }

    public void setPlanbegindate(String planbegindate) {
        this.planbegindate = planbegindate;
    }

    public String getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(String planenddate) {
        this.planenddate = planenddate;
    }

    public Integer getPlanstate() {
        return planstate;
    }

    public void setPlanstate(Integer planstate) {
        this.planstate = planstate;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIsyearplan() {
        return isyearplan;
    }

    public void setIsyearplan(Integer isyearplan) {
        this.isyearplan = isyearplan;
    }

    public String getPlanremark() {
        return planremark;
    }

    public void setPlanremark(String planremark) {
        this.planremark = planremark == null ? null : planremark.trim();
    }
}