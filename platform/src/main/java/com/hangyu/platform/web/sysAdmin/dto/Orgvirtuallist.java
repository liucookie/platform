package com.hangyu.platform.web.sysAdmin.dto;

import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;

import java.util.List;

public class Orgvirtuallist {
    private Integer id;

    private String appovorname;

    private Integer isdelete;

    private String uniqueid;

    private String usernameids;

    private List<BmStaffTbl> userList;

    public List<BmStaffTbl> getUserList() {
        return userList;
    }

    public void setUserList(List<BmStaffTbl> userList) {
        this.userList = userList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppovorname() {
        return appovorname;
    }

    public void setAppovorname(String appovorname) {
        this.appovorname = appovorname == null ? null : appovorname.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getUsernameids() {
        return usernameids;
    }

    public void setUsernameids(String usernameids) {
        this.usernameids = usernameids == null ? null : usernameids.trim();
    }
}