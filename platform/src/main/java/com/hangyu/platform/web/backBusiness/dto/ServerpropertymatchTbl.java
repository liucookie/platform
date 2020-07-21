package com.hangyu.platform.web.backBusiness.dto;

public class ServerpropertymatchTbl {
    private Integer id;

    private String propertymatchid;

    private String serverequipinfoid;

    private String computerpropertyid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertymatchid() {
        return propertymatchid;
    }

    public void setPropertymatchid(String propertymatchid) {
        this.propertymatchid = propertymatchid == null ? null : propertymatchid.trim();
    }

    public String getServerequipinfoid() {
        return serverequipinfoid;
    }

    public void setServerequipinfoid(String serverequipinfoid) {
        this.serverequipinfoid = serverequipinfoid == null ? null : serverequipinfoid.trim();
    }

    public String getComputerpropertyid() {
        return computerpropertyid;
    }

    public void setComputerpropertyid(String computerpropertyid) {
        this.computerpropertyid = computerpropertyid == null ? null : computerpropertyid.trim();
    }
}