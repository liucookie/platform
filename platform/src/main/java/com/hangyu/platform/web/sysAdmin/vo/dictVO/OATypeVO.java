package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.OaequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class OATypeVO extends Page {

    private List<OaequiptypeTbl> oaequiptypeTblList;


    public List<OaequiptypeTbl> getOaequiptypeTblList() {
        return oaequiptypeTblList;
    }

    public void setOaequiptypeTblList(List<OaequiptypeTbl> oaequiptypeTblList) {
        this.oaequiptypeTblList = oaequiptypeTblList;
    }
}
