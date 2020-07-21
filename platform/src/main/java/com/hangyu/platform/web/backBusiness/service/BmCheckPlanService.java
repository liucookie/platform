package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2PlancheckobjfoulactionstatTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanadvanceddemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplandemandTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanfinalTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckselfdeptTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2PlancheckobjfoulactionstatTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanadvanceddemandTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplandemandTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanfinalTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanpeasonTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckselfdeptTblMapper;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import com.hangyu.platform.web.sysAdmin.dto.Bm2LeaveTypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmCheckplanitemTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2LeaveTypeTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.BmCheckplanitemTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在线检查管理
 *
 * @auther liuXuan
 * @date 2020/2/19
 */
@Service
public class BmCheckPlanService {

    @Resource
    private BmCheckplanTblMapper mapper;


    @Resource
    private BmCheckplanpeasonTblMapper personMapper;

    @Resource
    private BmCheckselfdeptTblMapper deptMapper;

    @Resource
    private BmCheckplandemandTblMapper mandMapper;

    @Resource
    private BmCheckplanadvanceddemandTblMapper planMandMapper;

    @Resource
    private Bm2PlancheckobjfoulactionstatTblMapper statMapper;

    @Resource
    private Bm2LeaveTypeTblMapper leaveMapper;

    @Resource
    private BmCheckplanfinalTblMapper finalMapper;

    @Resource
    private BmCheckplanitemTblMapper itemMapper;


    /**
     * 查询所有在线检查
     *
     * @return
     */
    public Map<String, Object> query(CheckPlanQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<BmCheckplanTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询所有在线检查
     *
     * @return
     */
    public Map<String, Object> queryCheckUser(String planId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2PlancheckobjfoulactionstatTbl> list = statMapper.queryCheckUser(planId, start, pageSize);
        for (Bm2PlancheckobjfoulactionstatTbl stat : list) {
            // CheckState -1 不参加检查 0未检查 1已检查
            // checkres  1合格
            //计划检查人数
            int planCheckNum = personMapper.queryCheckUser(planId, null, null);
            stat.setPlanCheckNum(planCheckNum);
            //不检查的检查人数
            int notCheckNum = personMapper.queryCheckUser(planId, "-1", null);
            //实际检查人数
            int realCheckNum = planCheckNum - notCheckNum;
            stat.setRealCheckNum(realCheckNum);
            //已检查人数
            int checkNum = personMapper.queryCheckUser(planId, "1", null);
            stat.setCheckNum(checkNum);
            //合格人数
            int passNum = personMapper.queryCheckUser(planId, "1", "1");
            stat.setPassNum(passNum);
            //不合格人数
            int notPassNum = checkNum - passNum;
            stat.setNotPassNum(notPassNum);
            //完成率，已经检查人数/实际检查人数
            double rete = CommonUtils.roundValue(Double.valueOf(checkNum / realCheckNum), 2);
            stat.setPassRate(rete);
            //未确认数量
            stat.setNotCheckNum(notCheckNum);
            StringBuilder sb = new StringBuilder();
            sb.append("个人").append(stat.getDeductpersonscore()).append("分，部门").append(stat.getDeductdeptscore()).append("分");
            stat.setPublish(sb.toString());
        }
        int total = statMapper.queryCheckCount(planId);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询被检查人员第二层
     *
     * @param planId
     * @param orgId
     * @return
     */
    public List<BmCheckplanpeasonTbl> queryCheckUserDetail(String planId, String orgId) {
        List<BmCheckplanpeasonTbl> list = personMapper.queryCheckUserDetail(planId, orgId);
        for (BmCheckplanpeasonTbl tbl : list) {
            //根据人员id和计划id查询出违规结果表BM_CheckPlanFinal_Tbl,finaltype为0则表示不合格,1合格
            List<BmCheckplanfinalTbl> finalList = finalMapper.queryCheckResult(planId, tbl.getUserid(), "0");
            tbl.setNotPassNum(finalList.size());
            //查询出违规详情，从BM_CheckPlanItem_Tbl这个表中查询具体的违规项
            List<BmCheckplanitemTbl> itemList = new ArrayList<>();
            for (BmCheckplanfinalTbl plan : finalList) {
                BmCheckplanitemTbl item = itemMapper.queryItemId(plan.getItemid());
                itemList.add(item);
            }
            tbl.setItemList(itemList);
            //查询违规详情表扣分表
            Bm2PlancheckobjfoulactionstatTbl statTbl = statMapper.selectByUserID(tbl.getUserid(), planId);
            if (null == statTbl) {
                tbl.setPublish("无扣分");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("个人").append(statTbl.getDeductpersonscore()).append("分，部门").append(statTbl.getDeductdeptscore()).append("分");
                tbl.setPublish(sb.toString());
            }
        }
        return list;
    }

    /**
     * 查询未签到情况详情
     *
     * @param Id
     * @return
     */
    public BmCheckplanpeasonTbl queryNotCheckDetail(Integer Id) {
        BmCheckplanpeasonTbl tbl = personMapper.selectByPrimaryKey(Id);
        return tbl;
    }

    /**
     * 查询未签到情况详情
     *
     * @return
     */
    public List<Bm2LeaveTypeTbl> queryLeaveType() {
        List<Bm2LeaveTypeTbl> tbl = leaveMapper.queryLeaveType();
        return tbl;
    }

    /**
     * 查询未签到情况更新
     *
     * @param tbl
     */
    @Transactional
    public void updateNotCheck(BmCheckplanpeasonTbl tbl) {
        //checkstate -1不同意，0不参加检查
        personMapper.updateByPrimaryKey(tbl);
    }


//    /**
//     * 检查结果查看
//     *
//     * @return
//     */
//    public List<BmCheckplanfinalTbl> queryCheckResult(String planId,String userId) {
//        List<BmCheckplanfinalTbl> tbl = finalMapper.queryCheckResult(planId,userId);
//        return tbl;
//    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmCheckplanTbl queryById(String id) {
        BmCheckplanTbl tbl = mapper.selectByPrimaryKey(id);
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
    public void add(BmCheckplanTbl info) {
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
     *
     * @param info
     * @return
     */
    public int checkTime(BmCheckplanTbl info) {
        //根据时间，判断执行状态
        String startTime = info.getPlanbegindate();
        String endTime = info.getPlanenddate();
        //开始日期
        Date startDate = DateUtils.getDateByString(startTime);
        //结束日期
        Date endDate = DateUtils.getDateByString(endTime);
        Date now = new Date();
        int i = 0;
        if (endDate.getTime() < now.getTime()) {
            return 2;
        } else if (now.getTime() >= startDate.getTime() && now.getTime() <= endDate.getTime()) {
            return 1;
        } else if (startDate.getTime() > now.getTime()) {
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
    public void update(BmCheckplanTbl info) {
        //更新主表
        String orgId = info.getDept().getDeptid();
        //任务状态
        int i = checkTime(info);
        info.setPlanstate(i);
        mapper.updateByPrimaryKey(info);
        //更新处理选中的人数
        personMapper.deleteByPrimaryKey(info.getPlanid());
        if (CollectionUtils.isNotEmpty(info.getPeasons())) {
            //先删除
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
