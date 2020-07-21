package com.hangyu.platform.web.backBusiness.vo;

import java.util.List;

public class PlanExamAddVO {
    private String orgId;

    private List<PlanStaff> staffList;

    public static class PlanStaff{
        private String staffid;
        private String username;

        public String getStaffid() {
            return staffid;
        }

        public void setStaffid(String staffid) {
            this.staffid = staffid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }



    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<PlanStaff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<PlanStaff> staffList) {
        this.staffList = staffList;
    }
}
