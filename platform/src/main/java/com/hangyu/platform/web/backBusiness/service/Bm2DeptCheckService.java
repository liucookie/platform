package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanadvanceddemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplandemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckselfdeptTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanadvanceddemandTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplandemandTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanpeasonTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckselfdeptTblMapper;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二级部门检查管理
 *
 * @auther liuXuan
 * @date 2020/2/20
 */
@Service
public class Bm2DeptCheckService {

    @Resource
    private Bm2DeptcheckplanTblMapper mapper;

    @Resource
    private BmCheckplanpeasonTblMapper personMapper;

    @Resource
    private BmCheckselfdeptTblMapper deptMapper;

    @Resource
    private BmCheckplandemandTblMapper mandMapper;

    @Resource
    private BmCheckplanadvanceddemandTblMapper planMandMapper;


    /**
     * 查询所有二级部门检查
     *
     * @return
     */
    public Map<String, Object> query(CheckPlanQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2DeptcheckplanTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Bm2DeptcheckplanTbl queryById(String id) {
        Bm2DeptcheckplanTbl tbl = mapper.selectByPrimaryKey(id);
        //查询部门
        BmCheckselfdeptTbl dept = deptMapper.selectByPrimaryKey(id);
        tbl.setDept(dept);
        //查询处理选中的人数
        List<BmCheckplanpeasonTbl> peasons = personMapper.selectByPlanId(id);
        tbl.setPeasons(peasons);
        //查询账户密码那些
        List<BmCheckplandemandTbl> mand = mandMapper.selectByPlanId(id);
        tbl.setMand(mand);
        //查询指定日期和指定部门
        List<BmCheckplanadvanceddemandTbl> planMand = planMandMapper.selectByPlanId(id);
        tbl.setPlanMand(planMand);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(Bm2DeptcheckplanTbl info) {
        //生成计划id
        String planId = CommonUtils.generateUUID();
        info.setPlanid(planId);
        String orgId = info.getDept().getDeptid();
        //任务状态
        int i = checkTime(info);
        info.setPlanstate(i);
        //加入主表
        mapper.insert(info);
        //处理选中的人数
        if (CollectionUtils.isNotEmpty(info.getPeasons())) {
            addPerson(info.getPeasons(), planId, orgId);
        }
        //增加部门信息
        BmCheckselfdeptTbl dept = info.getDept();
        dept.setCheckselfid(CommonUtils.generateUUID());
        dept.setSelfplanid(planId);
        deptMapper.insert(dept);
        //增加账户密码那些
        List<BmCheckplandemandTbl> mands = info.getMand();
        for (BmCheckplandemandTbl mand : mands) {
            mand.setPlanid(planId);
            mand.setDemandid(CommonUtils.generateUUID());
            mandMapper.insert(mand);
        }
        //增加指定日期和指定部门
        List<BmCheckplanadvanceddemandTbl> planMands = info.getPlanMand();
        for (BmCheckplanadvanceddemandTbl mand : planMands) {
            mand.setPlanid(planId);
            mand.setDemandid(CommonUtils.generateUUID());
            planMandMapper.insert(mand);
        }
    }

    /**
     * 根据计划开始时间结束时间，返回执行状态
     * @param info
     * @return
     */
    public int checkTime(Bm2DeptcheckplanTbl info){
        //根据时间，判断执行状态
        String startTime = info.getPlanbegindate();
        String endTime = info.getPlanenddate();
        //开始日期
        Date startDate = DateUtils.getDateByString(startTime);
        //结束日期
        Date endDate = DateUtils.getDateByString(endTime);
        Date now = new Date();
        int i = 0;
        if (endDate.getTime() < now.getTime()){
            return 2;
        }else if (now.getTime() >= startDate.getTime() && now.getTime() <= endDate.getTime() ){
            return 1;
        }else if(startDate.getTime() > now.getTime()){
            return 0;
        }
        return i;
    }

    /**
     * 增加员工信息
     *
     * @param persons
     * @param planId
     * @param orgId
     */
    private void addPerson(List<BmCheckplanpeasonTbl> persons, String planId, String orgId) {
        for (BmCheckplanpeasonTbl person : persons) {
            person.setDeptid(orgId);
            person.setPlanid(planId);
            personMapper.insert(person);
        }

    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(Bm2DeptcheckplanTbl info) {
        //更新主表
        String orgId = info.getDept().getDeptid();
        //任务状态
        int i = checkTime(info);
        info.setPlanstate(i);
        mapper.updateByPrimaryKey(info);
        //更新处理选中的人数
        if (CollectionUtils.isNotEmpty(info.getPeasons())) {
            //先删除
            personMapper.deleteByPrimaryKey(info.getPlanid());
            addPerson(info.getPeasons(), info.getPlanid(), orgId);
        }
        //修改部门信息
        BmCheckselfdeptTbl dept = info.getDept();
        deptMapper.updateByPrimaryKey(dept);
        //更新账户密码那些
        List<BmCheckplandemandTbl> mands = info.getMand();
        for (BmCheckplandemandTbl mand : mands) {
            mandMapper.updateByPrimaryKey(mand);
        }
        //增加指定日期和指定部门
        List<BmCheckplanadvanceddemandTbl> planMands = info.getPlanMand();
        for (BmCheckplanadvanceddemandTbl mand : planMands) {
            planMandMapper.updateByPrimaryKey(mand);
        }

    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        //删除主表
        mapper.deleteByPrimaryKey(id);
        //删除部门
        deptMapper.deleteByPrimaryKey(id);
        //处理选中的人数
        personMapper.deleteByPrimaryKey(id);
        //删除账户密码那些
        mandMapper.deleteByPrimaryKey(id);
        //增加指定日期和指定部门
        planMandMapper.deleteByPrimaryKey(id);

    }
}
