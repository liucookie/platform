package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2LeaveTypeTbl;

import java.util.List;

public interface Bm2LeaveTypeTblMapper {

    //总数据量查询
    int selectTotal();

    //保密检查未签到类型管理信息批量查询
    List<Bm2LeaveTypeTbl>  selectAll(int start, int pageSize);


    List<Bm2LeaveTypeTbl>  queryLeaveType();

    //保密检查未签到类型管理单条信息查询
    List<Bm2LeaveTypeTbl>  select(String id);

    //保密检查未签到类型管理信息添加
    void insert(Bm2LeaveTypeTbl bm2LeavetypeTbl);

    //保密检查未签到类型管理信息修改
    void update(Bm2LeaveTypeTbl bm2LeavetypeTbl);

    //保密检查未签到类型管理信息删除
    void delete(List<String> list);
}