package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2LeaveTypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2LeaveTypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmLeaveTypeManageService {

    @Resource
    private Bm2LeaveTypeTblMapper bm2LeavetypeTblMapper;

    //保密检查未签到类型管理信息批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start= CommonUtils.getPageStart(pageNum,pageSize);
        List<Bm2LeaveTypeTbl> list = bm2LeavetypeTblMapper.selectAll(start,pageSize);
        int total = bm2LeavetypeTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //保密检查未签到类型管理单条信息查询
    public List<Bm2LeaveTypeTbl>  select(String id){
        return  bm2LeavetypeTblMapper.select(id);
    }

    //保密检查未签到类型管理信息添加
    @Transactional
    public void  insert(Bm2LeaveTypeTbl bm2LeavetypeTbl){
        bm2LeavetypeTblMapper.insert(bm2LeavetypeTbl);
    }

    //保密检查未签到类型管理信息修改
    @Transactional
    public void  update(Bm2LeaveTypeTbl bm2LeavetypeTbl){
        bm2LeavetypeTblMapper.update(bm2LeavetypeTbl);
    }

    //保密检查未签到类型管理信息删除
    @Transactional
    public void  delete(List<String> list){
        bm2LeavetypeTblMapper.delete(list);
    }

}
