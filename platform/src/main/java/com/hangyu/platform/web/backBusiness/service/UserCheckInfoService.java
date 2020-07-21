package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Userhz;
import com.hangyu.platform.web.backBusiness.mapper.UserhzMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户核对信息管理
 *
 * @auther liuXuan
 * @date 2020/3/12
 */
@Service
public class UserCheckInfoService {

    @Resource
    private UserhzMapper mapper;


    /**
     * 查询所有用户核对信息管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize,String orgId,String userId) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Userhz> list = mapper.select(start, pageSize,orgId,userId);
        int total = mapper.selectTotal(orgId,userId);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

}
