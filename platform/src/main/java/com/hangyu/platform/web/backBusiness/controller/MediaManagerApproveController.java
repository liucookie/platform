package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Mediamanagementapproval;
import com.hangyu.platform.web.backBusiness.service.MediaManageApproveService;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 移动存储介质借用审批 管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/5/18
 */
@Api(tags = "移动存储介质借用审批管理相关接口")
@RestController
@RequestMapping(value = "v1/mediaManageApprove")
public class MediaManagerApproveController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private MediaManageApproveService service;

    /**
     * 查询单个移动存储介质借用审批
     *
     * @return
     */
    @ApiOperation(value = "查询单个移动存储介质借用审批{author:lx}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Mediamanagementapproval tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加移动存储介质借用审批
     *
     * @return
     */
    @SystemLog(module="移动存储介质借用审批管理",methods="增加移动存储介质借用")
    @ApiOperation(value = "增加移动存储介质借用审批{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Mediamanagementapproval info) throws IOException {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 处理移动存储介质借用审批
     * isapprove   1同意，0不同意
     *
     * @return
     */
//    @SystemLog(module="移动存储介质借用审批管理",methods="处理移动存储介质借用审批 ")
    @ApiOperation(value = "处理移动存储介质借用审批 author:lx}", response = Result.class)
    @RequestMapping(value = "deal", method = RequestMethod.PUT)
    public ResponseEntity<Object> deal(@RequestBody ApproveVO info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

}