package com.hangyu.platform.web.backBusiness.vo;

import java.util.List;

public class OrganizationVO {

    /**
     * id
     */
    private String id;

    /**
     * 名字
     */
    private String organizationName;

    private List<OrganizationVO> childOrganization;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<OrganizationVO> getChildOrganization() {
        return childOrganization;
    }

    public void setChildOrganization(List<OrganizationVO> childOrganization) {
        this.childOrganization = childOrganization;
    }
}
