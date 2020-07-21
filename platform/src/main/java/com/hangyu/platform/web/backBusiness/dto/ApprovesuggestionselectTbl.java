package com.hangyu.platform.web.backBusiness.dto;


public class ApprovesuggestionselectTbl {
    private Integer id;

    private String fromid;

    private String approveorg;

    private String approvesuggestion;

    private String formname;

    private Integer isdeleted;

    private String modifytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid == null ? null : fromid.trim();
    }

    public String getApproveorg() {
        return approveorg;
    }

    public void setApproveorg(String approveorg) {
        this.approveorg = approveorg == null ? null : approveorg.trim();
    }

    public String getApprovesuggestion() {
        return approvesuggestion;
    }

    public void setApprovesuggestion(String approvesuggestion) {
        this.approvesuggestion = approvesuggestion == null ? null : approvesuggestion.trim();
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname == null ? null : formname.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }
}