package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.sysAdmin.dto.Orgvirtuallist;
import com.hangyu.platform.web.sysAdmin.mapper.OrgvirtuallistMapper;
import com.hangyu.platform.web.sysAdmin.mapper.OrgvirtuallistMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrgVirtualService {


    @Resource
    private OrgvirtuallistMapper mapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;


    /**
     * 查询虚拟部门
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryType(int pageNum, int pageSize, String name) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Orgvirtuallist> list = mapper.query(start, pageSize, name);
        int total = mapper.selectTotal(name);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个虚拟部门
     *
     * @param id
     * @return
     */
    public Orgvirtuallist queryById(String id) {
        Orgvirtuallist info = mapper.selectByPrimaryKey(id);
        //查询出员工
        if (StringUtils.isNotEmpty(info.getUsernameids())){
            List<String> userIds = Arrays.asList(StringUtils.split(info.getUsernameids(), ","));
            List<BmStaffTbl> list = staffTblMapper.selectBatch(userIds);
            info.setUserList(list);
        }
        return info;
    }

    /**
     * 添加虚拟部门
     *
     * @param info
     */
    @Transactional
    public void add(Orgvirtuallist info) {
        info.setUniqueid(CommonUtils.generateUUID());
        dealUser(info);
        mapper.insert(info);
    }

    private void dealUser(Orgvirtuallist info){
        List<BmStaffTbl> userList = info.getUserList();
        //处理人员id,变成字符串，用，分割
        if (CollectionUtils.isNotEmpty(userList)) {
            StringBuilder sb = new StringBuilder();
            for (BmStaffTbl staffTbl : userList) {
                sb.append(staffTbl.getStaffid()).append(",");
            }
            info.setUsernameids(sb.toString().substring(0,sb.lastIndexOf(",")));
        }
    }

    /**
     * 修改虚拟部门
     *
     * @param info
     */
    @Transactional
    public void update(Orgvirtuallist info) {
        dealUser(info);
        mapper.updateByPrimaryKey(info);
    }


    /**
     * 删除虚拟部门
     *
     * @param id
     */
    @Transactional
    public void delete( String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
