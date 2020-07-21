package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.TblDataset;
import com.hangyu.platform.web.backBusiness.dto.TblExam;
import com.hangyu.platform.web.backBusiness.dto.TblPlan;
import com.hangyu.platform.web.backBusiness.dto.TblPlanexaminee;
import com.hangyu.platform.web.backBusiness.dto.TblPlanorganization;
import com.hangyu.platform.web.backBusiness.mapper.TblDatasetMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblExamMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblPlanMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblPlanexamineeMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblPlanorganizationMapper;
import com.hangyu.platform.web.backBusiness.vo.ExamResultVO;
import com.hangyu.platform.web.backBusiness.vo.PlanExamAddVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class TblExamPlanService {

    @Resource
    private TblPlanMapper mapper;

    @Resource
    private TblExamMapper examMapper;

    @Resource
    private TblPlanorganizationMapper orgMapper;

    @Resource
    private TblPlanexamineeMapper examineeMapper;

    @Resource
    private TblDatasetMapper setMapper;


    /**
     * 查询所有考试计划
     *
     * @return
     */
    public Map<String, Object> query(String name, String startDate, String endDate, Integer status, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<TblPlan> list = mapper.select(name, startDate, endDate, status, start, pageSize);
        for (TblPlan plan : list) {
            //计划执行状态
            String isFinish = "";
            //处理考试的时间，状态
            Date now = new Date();
            Date startTime = DateUtils.getDateByString1(plan.getStarttime());
            Date endTime = DateUtils.getDateByString1(plan.getEndtime());
            if (now.getTime() < startTime.getTime()) {
                isFinish = "未开始";
            } else if (now.getTime() >= startTime.getTime() && now.getTime() <= endTime.getTime()) {
                isFinish = "进行中";
            } else {
                isFinish = "已结束";
            }
            plan.setStatus(isFinish);
            //计算已经考试的人数
            List<TblPlanexaminee> tblPlanexamineList = examineeMapper.selectYetExam(plan.getId());
            plan.setExamdonecount(tblPlanexamineList.size());
        }
        int total = mapper.selectTotal(name, startDate, endDate, status);
        map.put(CommonFields.getData(), list);
        map.put(CommonFields.getTotal(), total);
        return map;
    }


    /**
     * 查询自测试卷
     *
     * @return
     */
    public Map<String, Object> querySelfTest(String examName, String userName,Integer isNewStaffExam,Integer isTest,
                                             String startDate, String endDate, Integer status, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<TblPlanexaminee> list = examineeMapper.querySelfTest(examName, userName, isNewStaffExam,isTest,startDate, endDate, status, start, pageSize);
        int total = examineeMapper.querySelfTestCount(examName, userName, isNewStaffExam,isTest, startDate, endDate, status);
        map.put(CommonFields.getData(), list);
        map.put(CommonFields.getTotal(), total);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TblPlan queryById(int id) {
        TblPlan tbl = mapper.selectByPrimaryKey(id);
        Date now = new Date();
        Date startTime = DateUtils.getDateByString1(tbl.getStarttime());
        Date endTime = DateUtils.getDateByString1(tbl.getEndtime());
        if (now.getTime() >= startTime.getTime() && now.getTime() <= endTime.getTime()
                || now.getTime() > endTime.getTime()) {
            throw new PlatException("只有未开始的考试计划才能修改!");
        }
        //查询出试卷信息
        TblExam tblExam = examMapper.selectByPrimaryKey(tbl.getExamIds());
        tbl.setTblExam(tblExam);
        //查询出机构和考试人员信息
        List<TblPlanorganization> planorganizations = orgMapper.selectByPlanId(id);
        List<PlanExamAddVO> voList = new ArrayList<>();
        //计算本次考试计划，共有多少人参加
        for (TblPlanorganization org : planorganizations) {
            PlanExamAddVO planExamAddVO = new PlanExamAddVO();
            planExamAddVO.setOrgId(org.getOrganizationuniqueid());
            //查询出人员id和名称
            List<PlanExamAddVO.PlanStaff> staffList = examineeMapper.selectByOrgId(org.getId());
            planExamAddVO.setStaffList(staffList);
            voList.add(planExamAddVO);
        }
        tbl.setPlanExamAddList(voList);
        return tbl;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TblPlan queryDetail(int id) {
        TblPlan tbl = mapper.selectByPrimaryKey(id);
        //查询出机构和考试人员信息
        List<TblPlanorganization> planorganizations = orgMapper.selectByPlanId(id);
        StringBuilder sb = new StringBuilder();
        //计算本次考试计划，共有多少人参加
        for (TblPlanorganization org : planorganizations) {
            sb.append(org.getOrganizationName()).append(",");
        }
        //考试范围
        StringBuilder scope = new StringBuilder();
        scope.append("本次计划共考试").append("\u3000").append(sb.toString()).append(planorganizations.size()).append("个处室;").
                append("涉及").append(tbl.getExamcount()).append("位人员");
        tbl.setScope(scope.toString());
        return tbl;
    }

    /**
     * 查询考试人员（第一层）
     *
     * @param planId
     * @return
     */
    public List<ExamResultVO> queryFirstInfo(int planId) {
        //根据计划查询计划下的考试部门
        List<TblPlanorganization> planorganizations = orgMapper.selectByPlanId(planId);
        List<ExamResultVO> examResultVOList = new ArrayList<>();
        for (TblPlanorganization org : planorganizations) {
            //查询考生表的情况
            List<TblPlanexaminee> allExam = examineeMapper.selectAllByOrgId(org.getId(), null, null);
            //已经考试人数
            List<TblPlanexaminee> alreadyExam = examineeMapper.selectAllByOrgId(org.getId(), 1, null);
            //不及格人数
            List<TblPlanexaminee> notPassExam = examineeMapper.selectAllByOrgId(org.getId(), 1, 0);
            //及格人数就是。考试人数减去不及格
            int passCount = alreadyExam.size() - notPassExam.size();
            ExamResultVO vo = new ExamResultVO(org.getId(), org.getOrganizationName(), allExam.size(), allExam.size(), alreadyExam.size(),
                    passCount, notPassExam.size());
            examResultVOList.add(vo);
        }
        return examResultVOList;
    }

    /**
     * 查询考试人员（第二层）
     *
     * @param orgId 机构id
     * @return
     */
    public List<TblPlanexaminee> querySecondInfo(int orgId) {
        List<TblPlanexaminee> tblPlanexamineeList = examineeMapper.selectDetailByOrgId(orgId);
        return tblPlanexamineeList;
    }


    /**
     * 查询选择试卷（第一层）
     *
     * @param planId
     * @return
     */
    public TblExam queryFirstExam(int planId) {
        TblPlan tbl = mapper.selectByPrimaryKey(planId);
        //根据计划id查询出试卷信息
        TblExam exam = examMapper.selectByPrimaryKey(tbl.getExamIds());
        return exam;
    }

    /**
     * 查询选择试卷（第一层）
     *
     * @param planId
     * @param examId
     * @return
     */
    public List<TblPlanexaminee> querySecondExam(int planId, int examId) {
        List<TblPlanexaminee> tblPlanexamineeList = examineeMapper.selectDetailByExamId(planId, examId);
        return tblPlanexamineeList;
    }

    /**
     * 查询及格率设置
     *
     * @return
     */
    public TblDataset querySet() {
        TblDataset set = setMapper.selectByPrimaryKey();
        return set;
    }


    /**
     * 增加
     * 卷子暂时只选一个卷子
     *
     * @param info
     */
    @Transactional
    public void add(TblPlan info) {
        //计算考试总人数
        int totalCount = dealTotalStaff(info);
        info.setExamcount(totalCount);
        checkTime(info);
        //先增加主表 tbl_exam
        mapper.insert(info);
        int planId = info.getId();
        addOrgAndStaff(info, planId);
    }

    /**
     * 增加考试计划时，结束日期必须大于开始日期一天以上
     */
    private void checkTime(TblPlan plan) {
        Date endTime = DateUtils.getDateByString1(plan.getEndtime());
        Date now = new Date();
        long time = endTime.getTime() - now.getTime();
        if (time < 24 * 3600 * 1000) {
            throw new PlatException("计划结束时间必须大于当前时间一天以上!");
        }
    }

    /**
     * 增加考试机构和员工
     */
    private void addOrgAndStaff(TblPlan info, int planId) {
        //抽取到的卷子数量+1
        int examId = info.getExamIds();
        checkTime(info);
        examMapper.updateCount(examId);
        //考试部门和人员信息
        List<PlanExamAddVO> addList = info.getPlanExamAddList();
        addList.forEach(org -> {
            //增加考试部门信息
            TblPlanorganization tblPlanorganization = new TblPlanorganization(planId, org.getOrgId());
            orgMapper.insert(tblPlanorganization);
            //考试部门表的主键
            int planOrgId = tblPlanorganization.getId();
            //机构下的人员
            List<PlanExamAddVO.PlanStaff> staffList = org.getStaffList();
            staffList.forEach(staff -> {
                //添加人员信息
                TblPlanexaminee tblPlanexaminee = new TblPlanexaminee();
                tblPlanexaminee.setBmStaffTblStaffid(staff.getStaffid());
                tblPlanexaminee.setUsername(staff.getUsername());
                tblPlanexaminee.setTblPlanorganizationid(planOrgId);
                tblPlanexaminee.setIsenter(0);
                //是否是自测考试，0 不是，1是
                tblPlanexaminee.setIsTest(0);
                //设置试卷id
                tblPlanexaminee.setTblExamid(info.getExamIds());
                tblPlanexaminee.setPlanId(planId);
                examineeMapper.insert(tblPlanexaminee);
            });
        });
    }


    private Integer dealTotalStaff(TblPlan info) {
        //计算考试人数
        List<PlanExamAddVO> addList = info.getPlanExamAddList();
        int totalCount = 0;
        for (PlanExamAddVO vo : addList) {
            List<PlanExamAddVO.PlanStaff> staffList = vo.getStaffList();
            //计算总人数
            totalCount += staffList.size();
        }
        return totalCount;
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(TblPlan info) {
        //计算总数
        int totalCount = dealTotalStaff(info);
        info.setExamcount(totalCount);
        //更新主表
        mapper.updateByPrimaryKey(info);
        //删除
        deleteOrgAndStaff(info.getId());
        //重新增加
        addOrgAndStaff(info, info.getId());
    }

    private void deleteOrgAndStaff(int planId) {
        List<TblPlanorganization> tblPlanorganizations = orgMapper.selectByPlanId(planId);
        tblPlanorganizations.forEach(org -> {
            //用orgId删除考生表的数据
            examineeMapper.deleteByOrgId(org.getId());
        });
        //用planId删除org表
        orgMapper.deleteByPlanId(planId);
    }

    /**
     * 删除
     *
     * @param id 考试计划id
     */
    @Transactional
    public void delete(int id) {
        TblPlan tbl = mapper.selectByPrimaryKey(id);
        Date now = new Date();
        Date startTime = DateUtils.getDateByString1(tbl.getStarttime());
        Date endTime = DateUtils.getDateByString1(tbl.getEndtime());
        if (now.getTime() >= startTime.getTime() && now.getTime() <= endTime.getTime()
                || now.getTime() > endTime.getTime()) {
            throw new PlatException("只有未开始的考试计划才能修改!");
        }
        mapper.deleteByPrimaryKey(id);
        deleteOrgAndStaff(id);
    }

    /**
     * 查询个人计划考试（首页模块）
     *
     * @param userId userId
     * @return
     */
    public List<TblPlan> queryMyExam(String userId) {
        //先查询正式和自测考试,当前时刻以后的考试
        List<TblPlan> list = mapper.selectByIsTest(null, 1);
        Iterator<TblPlan> iterator = list.iterator();
        while (iterator.hasNext()) {
            TblPlan plan = iterator.next();
            //找出符合考试相关的考试
            TblPlanexaminee tblPlanexaminees = examineeMapper.selectByUserId(plan.getId(), userId, plan.getExamIds());
            if (null == tblPlanexaminees) {
                iterator.remove();
            }
        }
        return list;
    }

}
