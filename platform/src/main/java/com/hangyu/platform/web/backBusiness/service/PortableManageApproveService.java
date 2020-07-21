package com.hangyu.platform.web.backBusiness.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.X5CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.EipUtils;
import com.hangyu.platform.web.backBusiness.dto.Portablemanagementapproval;
import com.hangyu.platform.web.backBusiness.dto.X5User;
import com.hangyu.platform.web.backBusiness.mapper.PortablemanagementapprovalMapper;
import com.hangyu.platform.web.backBusiness.mapper.X5UserMapper;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * 便携机借用审批管理
 *
 * @auther liuXuan
 * @date 2020/5/19
 */
@Service
public class PortableManageApproveService {

    @Resource
    private PortablemanagementapprovalMapper mapper;

    @Autowired
    private EipUtils eipUtils;

    @Resource
    private X5UserMapper x5UserMapper;

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Portablemanagementapproval queryById(String id) {
        Portablemanagementapproval tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Portablemanagementapproval tbl) throws IOException {
        String uniqueId = CommonUtils.generateUUID();
        //生成一个表单号
        int random = (int) Math.random() * 10000;
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取当前时间并作为时间戳
        String timeStamp = simpleDateFormat.format(new Date());
        tbl.setFormid(X5CommonFields.getProtableManageApproveId() + timeStamp);

        // 调用宏天工作流--启动流程（返回流程实例id）
        String instanceId = eipUtils.startTask(X5CommonFields.getProtableManageApproveId(), tbl.getAccoutnamer());
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
            //第一个节点审批，usertask3
            if (StringUtils.equals(tbl.getNodeId(), X5CommonFields.getCountrySecMakeNode1())) {
                if (StringUtils.equals("分院外", tbl.getType())) {
                    //usertask4
                    destination = X5CommonFields.getCountrySecMakeNode4();
                }else {
                    //usertask5
                    destination = X5CommonFields.getCountrySecMakeNode2();
                }
            }//node4节点
            else if (StringUtils.equals(tbl.getNodeId(), X5CommonFields.getCountrySecMakeNode4())){
                destination = X5CommonFields.getCountrySecMakeNode2();
            }else {//node5节点
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
