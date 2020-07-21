package com.hangyu.platform.web.backBusiness.dto;

import java.util.Date;
import java.util.List;

public class Bm2CheckspecialplanTbl {
    private String planid;

    private String monthlyplanid;

    private String planname;

    private String planchecktypeid;

    private String checkTypeName;

    private String planbegindate;

    private String planenddate;

    private Integer planstate;

    private String planremark;

    private Integer isdelete;

    private Integer isyearplan;

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

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid == null ? null : planid.trim();
    }

    public String getMonthlyplanid() {
        return monthlyplanid;
    }

    public void setMonthlyplanid(String monthlyplanid) {
        this.monthlyplanid = monthlyplanid == null ? null : monthlyplanid.trim();
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname == null ? null : planname.trim();
    }

    public String getPlanchecktypeid() {
        return planchecktypeid;
    }

    public void setPlanchecktypeid(String planchecktypeid) {
        this.planchecktypeid = planchecktypeid == null ? null : planchecktypeid.trim();
    }

    public String getCheckTypeName() {
        return checkTypeName;
    }

    public void setCheckTypeName(String checkTypeName) {
        this.checkTypeName = checkTypeName;
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

    public String getPlanremark() {
        return planremark;
    }

    public void setPlanremark(String planremark) {
        this.planremark = planremark == null ? null : planremark.trim();
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
}