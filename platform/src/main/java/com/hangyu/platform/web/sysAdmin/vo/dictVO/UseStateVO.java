package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.Usestate;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class UseStateVO extends Page {
    private List<Usestate> useStateList;

    public List<Usestate> getUseStateList() {
        return useStateList;
    }

    public void setUseStateList(List<Usestate> useStateList) {
        this.useStateList = useStateList;
    }
}
