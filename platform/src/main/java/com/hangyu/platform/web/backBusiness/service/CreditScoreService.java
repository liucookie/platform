package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.CreditscoreTbl;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.CreditscoreTblMapper;
import com.hangyu.platform.web.sysAdmin.service.BaseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门信誉/个人积分查看管理
 *
 * @auther liuXuan
 * @date 2020/2/28
 */
@Service
public class CreditScoreService {

    @Resource
    private CreditscoreTblMapper mapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;


    /**
     * 查询所有部门信誉积分
     *
     * @return
     */
    public Map<String, Object> queryDeptScore(String orgId, String year, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<CreditscoreTbl> list = mapper.selectDeptScore(orgId, year, start, pageSize);
        int total = mapper.selectDeptScoreCount(orgId, year);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询所有个人信誉积分
     *
     * @return
     */
    public Map<String, Object> queryUserScore(String orgId, String userId, String year, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<CreditscoreTbl> list = mapper.selectUserScore(orgId, userId, year, start, pageSize);
        int total = mapper.selectUserScoreCount(orgId, userId, year);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询积分详情
     * cstype 0 部门，1个人
     * @return
     */
    public List<CreditscoreTbl> queryScoreDetail(int type, String userId, String year) {
        List<CreditscoreTbl> list = new ArrayList<>();
        if (type == 1) {
            BmStaffTbl staffTbl = staffTblMapper.selectByUserId(userId);
            list = mapper.exportDeptScore(staffTbl.getDeptid(), year);
        } else if (type == 2) {
            list = mapper.exportUserScore(null, userId, year);
        }
        return list;
    }

    /**
     * 导出部门积分excel
     *
     * @return
     */
    public List<CreditscoreTbl> exportDeptExcel(String orgId, String year) {
        List<CreditscoreTbl> list = mapper.exportDeptScore(orgId, year);
        return list;
    }

    /**
     * 导出个人积分excel
     *
     * @return
     */
    public List<CreditscoreTbl> exportUserExcel(String orgId, String year, String userId) {
        List<CreditscoreTbl> list = mapper.exportUserScore(orgId, userId, year);
        return list;
    }

}
