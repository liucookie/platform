package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoTbl;
import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoUsers;
import com.hangyu.platform.web.backBusiness.mapper.AffairsexerciseinfoTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 外事活动报备管理
 *
 * @auther liuXuan
 * @date 2020/2/11
 */
@Service
public class AffairInfoService {

    @Resource
    private AffairsexerciseinfoTblMapper mapper;

    @Autowired
    private AffairUserService userService;

    /**
     * 查询所有外事活动报备
     *
     * @return
     */
    public Map<String, Object> query(String orgName, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<AffairsexerciseinfoTbl> list = mapper.select(orgName, start, pageSize);
        int total = mapper.selectTotal(orgName).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @param orgId
     * @return
     */
    public List<AffairsexerciseinfoTbl> exportExcel(String orgId) {
        List<AffairsexerciseinfoTbl> list = mapper.selectTotal(orgId);
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public AffairsexerciseinfoTbl queryById(String id) {
        //外事活动信息
        AffairsexerciseinfoTbl tbl = mapper.selectByPrimaryKey(id);
        //查询出活动人员
        List<AffairsexerciseinfoUsers> list = userService.query(id);
        tbl.setAffairUsers(list);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(AffairsexerciseinfoTbl info) {
        String uniqueId = CommonUtils.generateUUID();
        info.setUniqueid(uniqueId);
        mapper.insert(info);
        //将外事活动人员信息加进表
        if (CollectionUtils.isNotEmpty(info.getAffairUsers())) {
            userService.add(info.getAffairUsers(), uniqueId);
        }
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(AffairsexerciseinfoTbl info) {
        mapper.updateByPrimaryKey(info);
        //更新外事活动人员
        if (CollectionUtils.isNotEmpty(info.getAffairUsers())) {
            userService.update(info.getAffairUsers(), info.getUniqueid());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
        //删除外事活动人员信息
        userService.delete(id);
    }
}
