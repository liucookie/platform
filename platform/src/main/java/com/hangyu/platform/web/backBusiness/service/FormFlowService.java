package com.hangyu.platform.web.backBusiness.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.X5CommonFields;
import com.hangyu.platform.utils.EipUtils;
import com.hangyu.platform.web.backBusiness.dto.ExaminationsecretTbl;
import com.hangyu.platform.web.backBusiness.dto.Mediamanagementapproval;
import com.hangyu.platform.web.backBusiness.dto.NationlevelalterTbl;
import com.hangyu.platform.web.backBusiness.dto.NationlevelfilealterTbl;
import com.hangyu.platform.web.backBusiness.dto.NationlevelremoveTbl;
import com.hangyu.platform.web.backBusiness.dto.Portablemanagementapproval;
import com.hangyu.platform.web.backBusiness.dto.SecretexaminaapproveTbl;
import com.hangyu.platform.web.backBusiness.dto.TechnologythesissecrecyTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.ExaminationsecretTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.MediamanagementapprovalMapper;
import com.hangyu.platform.web.backBusiness.mapper.NationlevelalterTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.NationlevelfilealterTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.NationlevelremoveTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.PortablemanagementapprovalMapper;
import com.hangyu.platform.web.backBusiness.mapper.SecretexaminaapproveTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.TechnologythesissecrecyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.X5UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 表单流程管理
 *
 * @auther liuXuan
 * @date 2020/4/29
 */
@Service
public class FormFlowService {
    //国家秘密事项审定
    private static final String secretCountryApproveId = "gjmmsxsp";
    private static final String secretCountryApproveName = "国家秘密事项审定";
    //国家秘密事项解除审定
    private static final String secretCountryCancelApproveId = "gjmmsxjcsp";
    private static final String secretCountryCancelApproveIdName = "国家秘密事项解除审批";
    //国家秘密事项变更审批
    private static final String secretCountryAlterApproveId = "gjmmsxbgsp";
    private static final String secretCountryAlterName = "国家秘密事项变更审批";
    //馆藏文件变更审批
    private static final String nationFileAlterApproveId = "gzwjbgsp";
    private static final String nationFileAlterName = "馆藏文件变更审批";
    //涉密人员每月考核审批
    private static final String examMonthSecretApproveId = "smrymykh";
    private static final String examMonthSecretName = "涉密人员每月考核审批";
    //移动存储介质借用审批
    private static final String mediaManageApproveId = "ydccjzjysp";
    private static final String mediaManageName = "移动存储介质借用审批";
    //便携机借用审批审批
    private static final String portableManageApproveId = "bxjjysp";
    private static final String portableManageName = "便携机借用审批";
    //科技论文保密审查
    private static final String technologyCheckApproveId = "kjlwbmsc";
    private static final String technologyCheckName = "科技论文保密审查审批";

    @Autowired
    private EipUtils eipUtils;

    @Resource
    private X5UserMapper x5UserMapper;

    @Resource
    private SecretexaminaapproveTblMapper secretexaminaapproveTblMapper;
    @Resource
    private NationlevelremoveTblMapper removeMapper;
    @Resource
    private NationlevelalterTblMapper alterMapper;
    @Resource
    private NationlevelfilealterTblMapper nationFileMapper;
    @Resource
    private ExaminationsecretTblMapper examSecretMapper;
    @Resource
    private MediamanagementapprovalMapper mediaManageMapper;
    @Resource
    private PortablemanagementapprovalMapper portableManageMapper;
    @Resource
    private TechnologythesissecrecyTblMapper technologyMapper;

    /**
     * 查询代办列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public JSONObject queryTodoList(int pageNum, int pageSize, String flowKey, String state, String startDate, String endDate) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();

        // 获取工作流中的代办列表，且根据流程实例id获取业务信息
        JSONObject jsonObj = eipUtils.queryFlowList(pageNum, pageSize, X5CommonFields.getX5TodoList(), flowKey, startDate, endDate);
        //总条数
        int totalSize = (Integer) jsonObj.get("totals");

        //取出代办事项列表
        JSONArray todoArray = jsonObj.getJSONArray("rows");
        for (Object json : todoArray) {
            JSONObject object = (JSONObject) json;
            //实例id，唯一不变的
            String instanceId = String.valueOf(object.get("procInstId"));
            //当前流程id
            String workFlowId = String.valueOf(object.get("taskId"));
            //审批状态
            String status = String.valueOf(object.get("running"));
            //流程key,区分是哪个流程下的
            String procDefKey = String.valueOf(object.get("procDefKey"));
            //当前节点名称，比如 定密责任人审批
            String taskName = String.valueOf(object.get("name"));
            //procDefKey 处理是哪种流程相对应得数据去查询哪张表
            dealFlowKey(procDefKey, instanceId, object);

        }
        map.put(CommonFields.getTotal(), totalSize);
        map.put(CommonFields.getData(), todoArray);
        return jsonObj;
    }


    /**
     * 查询已办列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public JSONObject queryDoneList(int pageNum, int pageSize, String flowKey, String state, String startDate, String endDate) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();

        String url = X5CommonFields.getX5DoneList();
        // 获取工作流中的代办列表，且根据流程实例id获取业务信息
        if (StringUtils.isNotEmpty(state)) {
            url = X5CommonFields.getX5DoneList() + "?status=" + state;
        }
        JSONObject jsonObj = eipUtils.queryFlowList(pageNum, pageSize, url, flowKey, startDate, endDate);
        //总条数
        int totalSize = (Integer) jsonObj.get("totals");

        //取出代办事项列表
        JSONArray todoArray = jsonObj.getJSONArray("rows");
        for (Object json : todoArray) {
            JSONObject object = (JSONObject) json;
            //实例id，唯一不变的
            String instanceId = String.valueOf(object.get("id"));
            //当前流程id
            String workFlowId = String.valueOf(object.get("taskId"));
            //审批状态
            String status = String.valueOf(object.get("running"));
            //流程key,区分是哪个流程下的
            String procDefKey = String.valueOf(object.get("procDefKey"));
            //当前节点名称，比如 定密责任人审批
            String taskName = String.valueOf(object.get("name"));
            //procDefKey 处理是哪种流程相对应得数据去查询哪张表
            dealFlowKey(procDefKey, instanceId, object);

        }
        map.put(CommonFields.getTotal(), totalSize);
        map.put(CommonFields.getData(), todoArray);
        return jsonObj;
    }


    /**
     * 查看我发起的事项
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public JSONObject queryMyList(int pageNum, int pageSize, String flowKey, String state, String startDate, String endDate) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();

        String url = X5CommonFields.getX5MyList();
        // 获取工作流中的代办列表，且根据流程实例id获取业务信息
//        if (StringUtils.isNotEmpty(state)){
//            url = X5CommonFields.getX5MyList() + "?status=" + state;
//        }
        // 获取工作流中的代办列表，且根据流程实例id获取业务信息
        JSONObject jsonObj = eipUtils.queryMyFlowList(pageNum, pageSize, url, flowKey, state, startDate, endDate);
        //总条数
        int totalSize = (Integer) jsonObj.get("totals");

        //取出代办事项列表
        JSONArray todoArray = jsonObj.getJSONArray("rows");
        for (Object json : todoArray) {
            JSONObject object = (JSONObject) json;
            //实例id，唯一不变的
            String instanceId = String.valueOf(object.get("id"));
            //当前流程id
            String workFlowId = String.valueOf(object.get("taskId"));
            //审批状态
            String status = String.valueOf(object.get("running"));
            //流程key,区分是哪个流程下的
            String procDefKey = String.valueOf(object.get("procDefKey"));
            //当前节点名称，比如 定密责任人审批
            String taskName = String.valueOf(object.get("name"));
            //procDefKey 处理是哪种流程相对应得数据去查询哪张表
            dealFlowKey(procDefKey, instanceId, object);

        }
        map.put(CommonFields.getTotal(), totalSize);
        map.put(CommonFields.getData(), todoArray);
        return jsonObj;
    }

    /**
     * 处理流程
     *
     * @param key
     * @param instanceId
     * @param object
     * @return
     */
    private void dealFlowKey(String key, String instanceId, JSONObject object) {
        switch (key) {
            //国家秘密事项审定
            case secretCountryApproveId:
                SecretexaminaapproveTbl tbl = secretexaminaapproveTblMapper.selectByInstanceId(instanceId);
                if (null != tbl) {
                    object.put("uniqueId", tbl.getUniqueid());
                    object.put("formId", tbl.getFormid());
                    object.put("applyUserName", tbl.getApplyUserName());
                    object.put("department", tbl.getDepartname());
                    object.put("applyTime", tbl.getApplytime());
                    object.put("fileUrl", tbl.getRfileurl());
                    object.put("formName", secretCountryApproveName);
                }
                break;
            //国家秘密事项审定
            case secretCountryCancelApproveId:
                NationlevelremoveTbl removeTbl = removeMapper.selectByInstanceId(instanceId);
                if (null != removeTbl) {
                    object.put("uniqueId", removeTbl.getUniqueid());
                    object.put("formId", removeTbl.getFormid());
                    object.put("applyUserName", removeTbl.getStaffnamer());
                    object.put("department", removeTbl.getOrganizationnamer());
                    object.put("applyTime", removeTbl.getApplytime());
                    object.put("fileUrl", removeTbl.getRfileurl());
                    object.put("formName", secretCountryCancelApproveIdName);
                }
                break;
            //国家秘密事项变更审批
            case secretCountryAlterApproveId:
                NationlevelalterTbl alterTbl = alterMapper.selectByInstanceId(instanceId);
                if (null != alterTbl) {
                    object.put("uniqueId", alterTbl.getUniqueid());
                    object.put("formId", alterTbl.getFormid());
                    object.put("applyUserName", alterTbl.getStaffnamer());
                    object.put("department", alterTbl.getOrganizationnamer());
                    object.put("applyTime", alterTbl.getApplytime());
                    object.put("fileUrl", alterTbl.getRfileurl());
                    object.put("formName", secretCountryAlterName);
                }
                break;
            //国家秘密事项变更审批
            case nationFileAlterApproveId:
                NationlevelfilealterTbl fileTbl = nationFileMapper.selectByInstanceId(instanceId);
                if (null != fileTbl) {
                    object.put("uniqueId", fileTbl.getUniqueid());
                    object.put("formId", fileTbl.getFormid());
                    object.put("applyUserName", fileTbl.getStaffnamer());
                    object.put("department", fileTbl.getOrganizationnamer());
                    object.put("applyTime", fileTbl.getApplytime());
                    object.put("fileUrl", fileTbl.getRfileurl());
                    object.put("formName", nationFileAlterName);
                }
                break;
            case examMonthSecretApproveId: //涉密人员每月考核审批
                ExaminationsecretTbl examSecretTbl = examSecretMapper.selectByInstanceId(instanceId);
                if (null != examSecretTbl) {
                    object.put("uniqueId", examSecretTbl.getUniqueid());
                    object.put("formId", examSecretTbl.getFormid());
                    object.put("applyUserName", examSecretTbl.getStaffnamer());
                    object.put("department", examSecretTbl.getOrganizationnamer());
                    object.put("applyTime", examSecretTbl.getApplytime());
                    object.put("formName", examMonthSecretName);
                }
                break;
            case mediaManageApproveId:  //移动存储介质借用审批
                Mediamanagementapproval mediaManageTbl = mediaManageMapper.selectByInstanceId(instanceId);
                if (null != mediaManageTbl) {
                    object.put("uniqueId", mediaManageTbl.getUniqueid());
                    object.put("formId", mediaManageTbl.getFormid());
                    object.put("applyUserName", mediaManageTbl.getStaffnamer());
                    object.put("department", mediaManageTbl.getOrganizationnamer());
                    object.put("applyTime", mediaManageTbl.getApplytime());
                    object.put("formName", mediaManageName);
                }
                break;
            case portableManageApproveId:  //便携机借用审批
                Portablemanagementapproval portableManageTbl = portableManageMapper.selectByInstanceId(instanceId);
                if (null != portableManageTbl) {
                    object.put("uniqueId", portableManageTbl.getUniqueid());
                    object.put("formId", portableManageTbl.getFormid());
                    object.put("applyUserName", portableManageTbl.getStaffnamer());
                    object.put("department", portableManageTbl.getOrganizationnamer());
                    object.put("applyTime", portableManageTbl.getApplytime());
                    object.put("formName", portableManageName);
                }
                break;
            case technologyCheckApproveId:  //科技论文审查
                TechnologythesissecrecyTbl technology = technologyMapper.selectByInstanceId(instanceId);
                if (null != technology) {
                    object.put("uniqueId", technology.getUniqueid());
                    object.put("formId", technology.getFormid());
                    object.put("applyUserName", technology.getStaffnamer());
                    object.put("department", technology.getOrganizationnamer());
                    object.put("applyTime", technology.getApplytime());
                    object.put("formName", technologyCheckName);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 人工终止流程
     *
     * @param object
     */
    @Transactional
    public void stopTask(JSONObject object) throws UnsupportedEncodingException {
        boolean flag = eipUtils.stopTask(object);
        if (!flag) {
            throw new PlatException("流程终止失败");
        }
    }

    /**
     * 查询某个流程的审批历史
     *
     * @param instanceId
     * @param taskId
     */
    public JSONArray queryTaskHistory(String instanceId, String taskId) throws UnsupportedEncodingException {
        JSONArray object = eipUtils.queryTaskHistory(instanceId, taskId);
        return object;
    }

    /**
     * 根据实例id获取任务TaskId
     *
     * @param instanceId
     * @param instanceId
     */
    public JSONObject queryTasksByInstId(String instanceId) throws UnsupportedEncodingException {
        JSONObject object = eipUtils.queryTasksByInstId(instanceId);
        return object;
    }

    /**
     * 查看所有得事项总数
     *
     * @return
     */
    public Map<String, Object> queryCount() throws UnsupportedEncodingException {
        // 获取工作流中的代办列表，且根据流程实例id获取业务信息
        JSONObject jsonObj = eipUtils.queryFlowList(1, 10, X5CommonFields.getX5TodoList(), null, null, null);
        //总条数
        int todoSize = (Integer) jsonObj.get("totals");

        // 获取工作流中的已办列表，且根据流程实例id获取业务信息
        JSONObject jsonObj1 = eipUtils.queryFlowList(1, 10, X5CommonFields.getX5DoneList(), null, null, null);
        //总条数
        int doneSize = (Integer) jsonObj1.get("totals");

        // 获取工作流中的我发起的列表，且根据流程实例id获取业务信息
        JSONObject jsonObj2 = eipUtils.queryFlowList(1, 10, X5CommonFields.getX5MyList(), null, null, null);
        //总条数
        int myRequestSize = (Integer) jsonObj2.get("totals");

        Map<String, Object> map = new HashMap<>();
        map.put("todoSize", todoSize);
        map.put("doneSize", doneSize);
        map.put("myRequestSize", myRequestSize);
        return map;
    }

}
