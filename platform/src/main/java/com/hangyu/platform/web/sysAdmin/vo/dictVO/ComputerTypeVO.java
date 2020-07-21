package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.ComputyequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class ComputerTypeVO extends Page {
    private List<ComputyequiptypeTbl> computyequiptypeTblList;

    public List<ComputyequiptypeTbl> getComputyequiptypeTblList() {
        return computyequiptypeTblList;
    }

    public void setComputyequiptypeTblList(List<ComputyequiptypeTbl> computyequiptypeTblList) {
        this.computyequiptypeTblList = computyequiptypeTblList;
    }
}
