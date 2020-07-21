package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmCheckitemadvancedsetTbl;
import java.util.List;

public interface BmCheckitemadvancedsetTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmCheckitemadvancedsetTbl record);

    int insertSelective(BmCheckitemadvancedsetTbl record);



    BmCheckitemadvancedsetTbl selectByPrimaryKey(Integer id);

    List<BmCheckitemadvancedsetTbl> query();

    int updateByPrimaryKeySelective(BmCheckitemadvancedsetTbl record);

    int updateByPrimaryKey(BmCheckitemadvancedsetTbl record);

    int updateBatch(List<BmCheckitemadvancedsetTbl> list);
}