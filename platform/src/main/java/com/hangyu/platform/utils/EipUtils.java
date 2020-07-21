package com.hangyu.platform.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.X5CommonFields;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EipUtils {

    @Autowired
    private HttpUtil httpUtil;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    private String returnToken() throws UnsupportedEncodingException {
        String account = TokenUtils.getAccount();
        BmStaffTbl staffTbl = staffTblMapper.selectByAccount(account);
        if (null == staffTbl) {
            throw new PlatException("账号不存在");
        }
        String password = DESUtil.getDecryptString(staffTbl.getPass());
        //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
        String auth = account + ":" + password;
        String token = "Basic " + Base64.getBase64(auth);
        return token;
    }

//    /**
//     * 发起流程
//     *
//     * @param flowkey
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public String startTask(String flowkey) throws UnsupportedEncodingException {
//        JSONObject paramMap = new JSONObject();
//
//        paramMap.put("account", TokenUtils.getAccount());
//        //流程id
//        paramMap.put("flowKey", flowkey);
//
//        String token = returnToken();
//        //请求启动流程的地址，url + 接口地址
//        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5Start(),
//                token, paramMap);
//
//        JSONObject jsonObj = JSONObject.parseObject(result);
//        //拿到返回的流程id，唯一不变值
//        String instanceId = jsonObj.getString("instId");
//        return instanceId;
//    }

    /**
     * 发起流程
     *
     * @param flowkey
     * @return
     * @throws UnsupportedEncodingException
     */
    public String startTask(String flowkey,String account) throws UnsupportedEncodingException {
        JSONObject paramMap = new JSONObject();

        paramMap.put("account", account);
        //流程id
        paramMap.put("flowKey", flowkey);

        String token = returnToken();
        //请求启动流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5Start(),
                token, paramMap);

        JSONObject jsonObj = JSONObject.parseObject(result);
        //拿到返回的流程id，唯一不变值
        String instanceId = jsonObj.getString("instId");
        return instanceId;
    }

    /**
     * 流程进入下一步操作(同意操作)
     */
    public boolean doNextAgree(String workFlowId, String destination, String nodeUsers,String opinion) throws UnsupportedEncodingException {
        JSONObject paramMap = new JSONObject();
        String account = TokenUtils.getAccount();
        BmStaffTbl staffTbl = staffTblMapper.selectByAccount(account);
        if (null == staffTbl) {
            throw new PlatException("账号不存在");
        }
        String password = DESUtil.getDecryptString(staffTbl.getPass());
        //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
        String auth = account + ":" + password;
        String token = "Basic " + Base64.getBase64(auth);
        paramMap.put("account", account);
        paramMap.put("actionName", "agree");
        paramMap.put("opinion", opinion);
        //下一个节点id，如果是最后一个步骤，放Null,就会直接结束任务
        paramMap.put("destination", destination);
        if (!StringUtils.isEmpty(nodeUsers)) {
            paramMap.put("nodeUsers", nodeUsers);
        }
        paramMap.put("jumpType", "free");
        paramMap.put("directHandlerSign", false);
        paramMap.put("taskId", workFlowId);

//        String token = returnToken();
        //请求下一步流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5Next(),
                token, paramMap);
        JSONObject jsonObj = JSONObject.parseObject(result);
        //返回来的是否审批
        boolean flag = jsonObj.getBooleanValue("result");
        return flag;
    }


    /**
     * 流程进入下一步操作(拒绝操作)
     */
    public boolean doNextReject(String workFlowId, String destination, String nodeUsers,String opinion) throws UnsupportedEncodingException {
        JSONObject paramMap = new JSONObject();
        String account = TokenUtils.getAccount();
        BmStaffTbl staffTbl = staffTblMapper.selectByAccount(account);
        if (null == staffTbl) {
            throw new PlatException("账号不存在");
        }
        String password = DESUtil.getDecryptString(staffTbl.getPass());
        //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
        String auth = account + ":" + password;
        String token = "Basic " + Base64.getBase64(auth);
        paramMap.put("account", account);
        paramMap.put("opinion", opinion);
        paramMap.put("actionName", "reject");
        paramMap.put("backHandMode", "normal");
        paramMap.put("destination", destination);
        paramMap.put("nodeUsers", nodeUsers);
        paramMap.put("jumpType", "reject");
        paramMap.put("directHandlerSign", false);
        paramMap.put("taskId", workFlowId);

//        String token = returnToken();
        //请求下一步流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5Next(),
                token, paramMap);
        JSONObject jsonObj = JSONObject.parseObject(result);
        //返回来的是否审批
        boolean flag = jsonObj.getBooleanValue("result");
        return flag;
    }

    /**
     * 查询已办/代办的列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws UnsupportedEncodingException
     */
    public JSONObject queryFlowList(int pageNum, int pageSize, String url, String flowKey, String startDate, String endDate) throws UnsupportedEncodingException {
        JSONObject paramMap = new JSONObject();
        paramMap.put("account", TokenUtils.getAccount());
        //流程id
        paramMap.put("currentPage", pageNum);
        paramMap.put("pageSize", pageSize);
        paramMap.put("sort", "create_time_");
        paramMap.put("order", "desc");
        paramMap.put("pageSize", pageSize);

        //增加时间，流程key去查询
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotEmpty(flowKey)) {
            map.put("Q^PROC_DEF_KEY_^S", flowKey);
        }
        if (StringUtils.isNotEmpty(startDate)) {
            map.put("Q^create_time_^DL", startDate);
        }
        if (StringUtils.isNotEmpty(endDate)) {
            map.put("Q^create_time_^DG", endDate);
        }
        if (null != map) {
            paramMap.put("paramMap", map);
        }

        String token = returnToken();
        //请求代办流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + url, token, paramMap);

        JSONObject jsonObj = JSONObject.parseObject(result);
        return jsonObj;
    }

    /**
     * 查询我发起的列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws UnsupportedEncodingException
     */
    public JSONObject queryMyFlowList(int pageNum, int pageSize, String url, String flowKey,String state, String startDate, String endDate) throws UnsupportedEncodingException {
        JSONObject paramMap = new JSONObject();
        paramMap.put("account", TokenUtils.getAccount());
        //流程id
        paramMap.put("currentPage", pageNum);
        paramMap.put("pageSize", pageSize);
        paramMap.put("sort", "create_time_");
        paramMap.put("order", "desc");

        //增加时间，流程key去查询
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotEmpty(flowKey)) {
            map.put("Q^PROC_DEF_KEY_^S", flowKey);
        }
//        if (StringUtils.isNotEmpty(state)) {
//            map.put("Q^status_^S", state);
//        }
        if (StringUtils.isNotEmpty(startDate)) {
            map.put("Q^create_time_^DL", startDate);
        }
        if (StringUtils.isNotEmpty(endDate)) {
            map.put("Q^create_time_^DG", endDate);
        }
        if (null != map) {
            paramMap.put("paramMap", map);
        }

        String token = returnToken();
        //请求代办流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + url, token, paramMap);

        JSONObject jsonObj = JSONObject.parseObject(result);
        return jsonObj;
    }




    /**
     * 终止流程
     */
    public boolean stopTask(JSONObject object) throws UnsupportedEncodingException {
        String token = returnToken();
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5StopTask(),
                token, object);
        JSONObject jsonObj = JSONObject.parseObject(result);
        //返回来的是否审批
        boolean flag = jsonObj.getBooleanValue("state");
        return flag;
    }

    /**
     * 查询某个流程的审批历史
     */
    public JSONArray queryTaskHistory(String instanceId, String taskId) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("instanId", instanceId);
        map.put("taskId", taskId);

        String token = returnToken();
        String result = httpUtil.get(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5TaskHistory(),
                map, token);
        JSONArray jsonObj = JSONArray.parseArray(result);
        return jsonObj;
    }

    /**
     * 根据实例id获取任务TaskId
     */
    public JSONObject queryTasksByInstId(String instanceId) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("instId", instanceId);
        String token = returnToken();
        String result = httpUtil.get(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5GetTasksByInstId(),
                map, token);
        JSONObject jsonObj = JSONObject.parseObject(result);
        return jsonObj;
    }


    /**
     * 增加X5员工，同步用
     *
     * @param paramMap
     * @return
     * @throws UnsupportedEncodingException
     */
    public String addX5User(JSONObject paramMap) throws UnsupportedEncodingException {

        String token = returnToken();
        //请求代办流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5AddUser(), token, paramMap);

        JSONObject jsonObj = JSONObject.parseObject(result);
        String userId = (String) jsonObj.get("value");
        return userId;
    }

    /**
     * 增加X5员工，同步用
     *
     * @param paramMap
     * @return
     * @throws UnsupportedEncodingException
     */
    public JSONObject updateX5User(JSONObject paramMap,String token) throws UnsupportedEncodingException {

        //请求代办流程的地址，url + 接口地址
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5UpdateUser(), token, paramMap);

        JSONObject jsonObj = JSONObject.parseObject(result);
        return jsonObj;
    }

//    /**
//     * 增加X5员工，同步用
//     *
//     * @param paramMap
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public JSONObject queryUserById(JSONObject paramMap) throws UnsupportedEncodingException {
//
//        String token = returnToken();
//        //请求代办流程的地址，url + 接口地址
//        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5GetTasksByInstId(), token, paramMap);
//
//        JSONObject jsonObj = JSONObject.parseObject(result);
//        return jsonObj;
//    }


    /**
     * 终止流程(审批人终止)
     */
    public boolean stopTaskByOther(JSONObject object,String token)  {
        String result = httpUtil.post(X5CommonFields.getX5HttpUrl() + X5CommonFields.getX5StopTask(),
                token, object);
        JSONObject jsonObj = JSONObject.parseObject(result);
        //返回来的是否审批
        boolean flag = jsonObj.getBooleanValue("state");
        return flag;
    }
}
