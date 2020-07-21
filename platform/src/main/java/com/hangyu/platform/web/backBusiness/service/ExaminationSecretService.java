package com.hangyu.platform.web.backBusiness.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.X5CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.EipUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrsultTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.ExaminationsecretTbl;
import com.hangyu.platform.web.backBusiness.dto.X5User;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckresultTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckrsultTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.ExaminationsecretTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.X5UserMapper;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
import com.hangyu.platform.web.backBusiness.vo.CheckResultVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 涉密人员每月考核审批管理
 *
 * @auther liuXuan
 * @date 2020/5/18
 */
@Service
public class ExaminationSecretService {

    @Resource
    private ExaminationsecretTblMapper mapper;

    @Autowired
    private EipUtils eipUtils;

    @Autowired
    private StaffService staffService;

    @Resource
    private X5UserMapper x5UserMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private Bm2LocalcheckrsultTblMapper localcheckrsultTblMapper;

    @Resource
    private Bm2DeptcheckresultTblMapper deptcheckresultTblMapper;


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public ExaminationsecretTbl queryById(String id) {
        ExaminationsecretTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 查询单个
     *
     * @param
     * @return
     */
    public List<CheckResultVO> queryCheck(String year, String month) {
        //查询政治工作部下面的人员
        List<String> orgIds = organizationMapper.queryByParentId(CommonFields.getPoliticalDepartmentId());
        orgIds.add(CommonFields.getPoliticalDepartmentId());
        //响应体
        List<CheckResultVO> list = new ArrayList<>();
        //先查出这几个部门下面的涉密人员
        //核心涉密人员,政治工作部
        List<BmStaffTbl> coreList = staffService.selectByLevelId(CommonFields.getCoreSecretLevelId(), orgIds);
        //重要涉密人员
        List<BmStaffTbl> importantList = staffService.selectByLevelId(CommonFields.getImportantSecretLevelId(), orgIds);
        //一般涉密人员
        List<BmStaffTbl> normalList = staffService.selectByLevelId(CommonFields.getGeneralSecretLevelId(), orgIds);

        coreList.addAll(importantList);
        coreList.addAll(normalList);

        for (BmStaffTbl staffTbl : coreList) {
            CheckResultVO vo = new CheckResultVO();
            vo.setOrgName(staffTbl.getOrgName());
            vo.setOrgId(staffTbl.getDeptid());
            vo.setUserId(staffTbl.getStaffid());
            vo.setUserName(staffTbl.getUsername());
            vo.setWorkId(staffTbl.getWorkid());
            vo.setLevelName(staffTbl.getLevelName());
            list.add(vo);
        }
        String isProvide = "是";
        for (CheckResultVO vo : list) {
            //分院考核
            List<Bm2LocalcheckrsultTbl> localcheckrsultTbls = localcheckrsultTblMapper.queryFengYuanCheck(year,
                    null, vo.getUserId(), month, "1", 1);
            if (CollectionUtils.isNotEmpty(localcheckrsultTbls)) {
                Bm2LocalcheckrsultTbl result = localcheckrsultTbls.get(0);
                vo.setFengYuanDate(result.getChecktime());
                vo.setFengYuanType(result.getQuestName());
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(result.getDscore()).append(",").append("扣除保密补贴").append(result.getDconsub()).append("月");
                sb.append("扣除效益工资").append(result.getDwages()).append("元");
                vo.setFengYuanResult(sb.toString());
                isProvide = "否";
            }
            //0，部门，1个人,  查询出部门考核信息。
            List<Bm2DeptcheckresultTbl> deptcheckresultTbls = deptcheckresultTblMapper.queryDeptCheck(year, vo.getOrgId(),
                    vo.getUserId(), month, "0");
            if (CollectionUtils.isNotEmpty(deptcheckresultTbls)) {
                Bm2DeptcheckresultTbl result = deptcheckresultTbls.get(0);
                vo.setDeptDate(result.getChecktime());
                vo.setDeptType(result.getQuestName());
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(result.getDscore()).append(",").append("扣除保密补贴").append(result.getDconsub()).append("月");
                sb.append("扣除效益工资").append(result.getDwages()).append("元");
                vo.setFengYuanResult(sb.toString());
                isProvide = "否";
            }
            vo.setIsProvide(isProvide);
        }
        return list;
    }

    /**
     * 查询涉密人员数量
     *
     * @return
     */
    public Map<String, String> queryCount() {
        Map<String, String> map = new HashMap<>();
        //查询政治工作部下面的人员
        List<String> orgIds = organizationMapper.queryByParentId(CommonFields.getPoliticalDepartmentId());
        orgIds.add(CommonFields.getPoliticalDepartmentId());
        //核心涉密人员,政治工作部
        List<BmStaffTbl> coreList = staffService.selectByLevelId(CommonFields.getCoreSecretLevelId(), orgIds);
        //重要涉密人员
        List<BmStaffTbl> importantList = staffService.selectByLevelId(CommonFields.getImportantSecretLevelId(), orgIds);
        //一般涉密人员
        List<BmStaffTbl> normalList = staffService.selectByLevelId(CommonFields.getGeneralSecretLevelId(), orgIds);
        //非涉密人员
        List<BmStaffTbl> notSecretList = staffService.selectByLevelId(CommonFields.getNotSecretLevelId(), orgIds);
        map.put("coreSize", coreList.size() + "人");
        map.put("importantSize", importantList.size() + "人");
        map.put("normalSize", normalList.size() + "人");
        map.put("notSecretSize", notSecretList.size() + "人");
        map.put("allSecretSize", coreList.size() + importantList.size() + normalList.size() + "人");
        return map;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(ExaminationsecretTbl tbl) throws IOException {
        String uniqueId = CommonUtils.generateUUID();
        //生成一个表单号
        int random = (int) Math.random() * 10000;
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取当前时间并作为时间戳
        String timeStamp = simpleDateFormat.format(new Date());
        tbl.setFormid(X5CommonFields.getExamMonthSecretApproveId() + timeStamp);

        // 调用宏天工作流--启动流程（返回流程实例id）
        String instanceId = eipUtils.startTask(X5CommonFields.getExamMonthSecretApproveId(), tbl.getAccoutnamer());
        tbl.setWorkflowid(instanceId);
        tbl.setUniqueid(uniqueId);
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(ApproveVO tbl) throws IOException {

//        mapper.updateByPrimaryKey(tbl);
        //调用EIp流程进行处理
        String workFlowId = tbl.getWorkflowid();

        // 构造nodeUsers参数
        JSONArray nodeUserArray = new JSONArray();
        JSONObject nodeUserObj = new JSONObject();
        JSONArray executorsArray = new JSONArray();
        // 区别当前节点，还是下一个 节点审批。
        nodeUserObj.put("nodeId", tbl.getNodeId());
        nodeUserObj.put("executors", executorsArray);
        nodeUserArray.add(nodeUserObj);
        // nodeuser,当前节点信息
        String nodeUsers = StringUtils.EMPTY;
        if (!nodeUserArray.isEmpty()) {
            Base64.Encoder encoder = Base64.getEncoder();
            nodeUsers = encoder.encodeToString(nodeUserArray.toString().getBytes("UTF-8"));
        }
        if (tbl.getIsapproved() == 1) {
            String destination = null;
            //第一个节点审批
            if (StringUtils.equals(tbl.getNodeId(), X5CommonFields.getCountrySecMakeNode1())) {
                destination = X5CommonFields.getCountrySecMakeNode2();
            } else {
                //如果是第二个节点审批，同意的话，则表示当前流程已经通过结束
                String instanceId = tbl.getInstanceId();
                mapper.updateByInstanceId(instanceId, 1);
            }
            //定密责任人审批,选中节点，destination 目的节点;  同意
            eipUtils.doNextAgree(workFlowId, destination, nodeUsers, tbl.getOpinion());
        } else {
            //如果审批人，不同意，直接就终止流程了
            String userId = tbl.getCreatorId();
            X5User x5User = x5UserMapper.selectByX5Id(userId);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("account", x5User.getX5Account());
            jsonObject.put("endReason", tbl.getOpinion());
            jsonObject.put("taskId", tbl.getWorkflowid());
            eipUtils.stopTaskByOther(jsonObject, x5User.getX5Token());
            //设置此流程为不同意审批
            mapper.updateByInstanceId(tbl.getInstanceId(), 0);
            //定密责任人审批,选中节点，目的节点；拒绝
            // eipUtils.doNextReject(workFlowId, destination, nodeUsers,tbl.getOpinion());
        }

    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException {
        mapper.deleteByPrimaryKey(id);
    }
}
