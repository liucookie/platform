package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.ZptypeTbl;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZptypeTblMapper {

    //总数据量
    int selectTotal();

    //单条查询
    List<ZptypeTbl> select(int id);

    //批量查询
    List<ZptypeTbl> selectAll(int start,int pageSize);

    //添加信息
    void insert(ZptypeTbl zptypeTbl);

    //删除信息
    void delete(List<Integer> list);

    //修改信息
    void update(ZptypeTbl zptypeTbl);

}