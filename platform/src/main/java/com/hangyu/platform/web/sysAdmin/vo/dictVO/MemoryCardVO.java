package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.Bm2MemorycardtypeTbl;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class MemoryCardVO extends Page {
    private List<Bm2MemorycardtypeTbl> typeList;

    public List<Bm2MemorycardtypeTbl> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Bm2MemorycardtypeTbl> typeList) {
        this.typeList = typeList;
    }
}
