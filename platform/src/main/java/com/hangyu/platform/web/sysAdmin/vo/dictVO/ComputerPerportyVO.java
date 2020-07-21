package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.ComputerpropertyTbl;
import com.hangyu.platform.web.sysAdmin.vo.Page;
import java.util.List;

public class ComputerPerportyVO extends Page {
    private List<ComputerpropertyTbl> propertyList;


    public List<ComputerpropertyTbl> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<ComputerpropertyTbl> propertyList) {
        this.propertyList = propertyList;
    }
}
