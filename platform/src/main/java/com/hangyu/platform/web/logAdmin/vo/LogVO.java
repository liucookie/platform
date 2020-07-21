package com.hangyu.platform.web.logAdmin.vo;

import com.hangyu.platform.web.logAdmin.dto.Loginfo;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class LogVO extends Page {
    private List<Loginfo> logInfoList;

    public List<Loginfo> getLogInfoList() {
        return logInfoList;
    }

    public void setLogInfoList(List<Loginfo> logInfoList) {
        this.logInfoList = logInfoList;
    }
}
