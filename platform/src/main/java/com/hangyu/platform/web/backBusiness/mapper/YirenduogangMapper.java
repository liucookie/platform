package com.hangyu.platform.web.backBusiness.mapper;


import com.hangyu.platform.web.backBusiness.dto.Yirenduogang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YirenduogangMapper {

    //数据量查询
    int selectTotal(Yirenduogang yirenduogang);

    //批量和条件查询
    List<Yirenduogang> selectAllFactor(@Param("factor") Yirenduogang yirenduogang,@Param("star") int start, @Param("pgSize") int pageSize);

    //单条查询
    Yirenduogang select(String id);

    List<Yirenduogang> selectByUserId(String userId);

    //批量删除
    void delete(List<String> list);

    //信息添加
    void insert(Yirenduogang yirenduogang);

    //信息修改
    void update(Yirenduogang yirenduogang);

    //Excel导入：部门ID查询
    String  selectOrgId(String orgName);
}