package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.service.FormFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 表单流程管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/4/29
 */
@Api(tags = "表单流程管理相关接口")
@RestController
@RequestMapping(value = "v1/formFlow")
public class FormFlowController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private FormFlowService service;

    /**
     * 查看代办事项
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查看代办事项{author:lx}", response = Result.class)
    @RequestMapping(value = "queryTodoList", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTodoList(@RequestParam("pageNum") int pageNum,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestParam(value = "state", required = false) String state,
                                                @RequestParam(value = "flowKey", required = false) String flowKey,
                                                @RequestParam(value = "startDate", required = false) String startDate,
                                                @RequestParam(value = "endDate", required = false) String endDate) throws UnsupportedEncodingException {
        Map<String, Object> type = service.queryTodoList(pageNum, pageSize, flowKey,state, startDate, endDate);
        return ResponseEntity.ok(type);
    }

    /**
     * 查看已办事项
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查看已办事项{author:lx}", response = Result.class)
    @RequestMapping(value = "queryDoneList", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDoneList(@RequestParam("pageNum") int pageNum,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestParam(value = "flowKey", required = false) String flowKey,
                                                @RequestParam(value = "state", required = false) String state,
                                                @RequestParam(value = "startDate", required = false) String startDate,
                                                @RequestParam(value = "endDate", required = false) String endDate) throws UnsupportedEncodingException {
        Map<String, Object> type = service.queryDoneList(pageNum, pageSize, flowKey,state, startDate, endDate);
        return ResponseEntity.ok(type);
    }


    /**
     * 查看我发起的事项
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查看我发起的事项{author:lx}", response = Result.class)
    @RequestMapping(value = "queryMyList", method = RequestMethod.GET)
    public ResponseEntity<Object> queryMyList(@RequestParam("pageNum") int pageNum,
                                              @RequestParam("pageSize") int pageSize,
                                              @RequestParam(value = "state", required = false) String state,
                                              @RequestParam(value = "flowKey", required = false) String flowKey,
                                              @RequestParam(value = "startDate", required = false) String startDate,
                                              @RequestParam(value = "endDate", required = false) String endDate) throws UnsupportedEncodingException {
        Map<String, Object> type = service.queryMyList(pageNum, pageSize, flowKey, state,startDate, endDate);
        return ResponseEntity.ok(type);
    }


    /**
     * 人工终止流程
     *
     * @param object
     * @return
     */
    @ApiOperation(value = "人工终止流程{author:lx}", response = Result.class)
    @RequestMapping(value = "stopTask", method = RequestMethod.POST)
    public ResponseEntity<Object> stopTask(@RequestBody JSONObject object) throws UnsupportedEncodingException {
        service.stopTask(object);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询某个流程的审批历史
     *
     * @param instanceId 实例id唯一不变的
     * @param taskId     任务id，每次不变
     * @return
     */
    @ApiOperation(value = "查询某个流程的审批历史{author:lx}", response = Result.class)
    @RequestMapping(value = "queryTaskHistory", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTaskHistory(@RequestParam("instanceId") String instanceId,
                                                   @RequestParam(value = "taskId", required = false) String taskId) throws UnsupportedEncodingException {
        JSONArray object = service.queryTaskHistory(instanceId, taskId);
        return ResponseEntity.ok(object);
    }

    /**
     * 根据实例id获取任务TaskId
     *
     * @param instanceId 实例id唯一不变的
     * @return
     */
    @ApiOperation(value = "根据实例id获取任务TaskId{author:lx}", response = Result.class)
    @RequestMapping(value = "queryTasksByInstId/{instanceId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTasksByInstId(@PathVariable("instanceId") String instanceId) throws UnsupportedEncodingException {
        JSONObject object = service.queryTasksByInstId(instanceId);
        return ResponseEntity.ok(object);
    }

    /**
     * 查看所有得事项总数
     *
     * @return
     */
    @ApiOperation(value = "查看所有得事项总数{author:lx}", response = Result.class)
    @RequestMapping(value = "queryCount", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCount() throws UnsupportedEncodingException {
        Map<String, Object> type = service.queryCount();
        return ResponseEntity.ok(type);
    }

}