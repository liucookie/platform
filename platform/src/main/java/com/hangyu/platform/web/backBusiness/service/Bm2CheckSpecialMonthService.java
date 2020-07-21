package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2CheckspecialmonthlyplanTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2CheckspecialplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanadvanceddemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplandemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckselfdeptTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2CheckspecialmonthlyplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2CheckspecialplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplandemandTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanpeasonTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckselfdeptTblMapper;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门专项检查管理
 *
 * @auther liuXuan
 * @date 2020/2/20
 */
@Service
public class Bm2CheckSpecialMonthService {

    @Resource
    private Bm2CheckspecialmonthlyplanTblMapper mapper;

    @Resource
    private Bm2CheckspecialplanTblMapper planMapper;

    @Resource
    private Bm2CheckspecialtypeTblMapper typeMapper;


    @Resource
    private BmCheckplanpeasonTblMapper personMapper;

    @Resource
    private BmCheckselfdeptTblMapper deptMapper;

    @Resource
    private BmCheckplandemandTblMapper mandMapper;




    /**
     * 查询所有部门专项检查
     *
     * @return
     */
    public Map<String, Object> query(String month, String year, String status, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2CheckspecialmonthlyplanTbl> list = mapper.select(month, year, status, start, pageSize);
        for (Bm2CheckspecialmonthlyplanTbl plan : list) {
            String name = plan.getMonthlyplanyear() + "年" + plan.getMonthlyplanmonth() + "月份";
            //拼接名称
            plan.setName(name);
            //设置数量
            plan.setNumber(planMapper.selectNumber(plan.getMonthlyplanid()));
        }
        int total = mapper.selectTotal(month, year, status);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询月份下的计划
     *
     * @param vo
     * @return
     */
    public Map<String, Object> queryByMonthId(CheckPlanQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2CheckspecialplanTbl> tbl = planMapper.queryByMonthId(vo);
        int total = planMapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", tbl);
        return map;
    }


    /**
     * 查询月份下的计划
     *
     * @return
     */
    public List<Bm2CheckspecialtypeTbl> queryAllType() {
        List<Bm2CheckspecialtypeTbl> tbl = typeMapper.queryAllType();
        return tbl;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Bm2CheckspecialplanTbl queryCheckDetail(String id) {
        Bm2CheckspecialplanTbl tbl = planMapper.selectByPrimaryKey(id);
        //查询部门
        BmCheckselfdeptTbl dept = deptMapper.selectByPrimaryKey(id);
        tbl.setDept(dept);
        //查询处理选中的人数
        List<BmCheckplanpeasonTbl> peasons = personMapper.selectByPlanId(id);
        tbl.setPeasons(peasons);
        //查询账户密码那些
        List<BmCheckplandemandTbl> mand = mandMapper.selectByPlanId(id);
        tbl.setMand(mand);
        return tbl;
    }



}
