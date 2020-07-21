package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Portablemanagementapproval;
import com.hangyu.platform.web.backBusiness.service.MediaManageApproveService;
import com.hangyu.platform.web.backBusiness.service.PortableManageApproveService;
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
 * 便携机借用审批 管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/5/19
 */
@Api(tags = "便携机借用审批管理相关接口")
@RestController
@RequestMapping(value = "v1/portableManageApprove")
public class PortableManagerApproveController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private PortableManageApproveService service;

    /**
     * 查询单个便携机借用审批
     *
     * @return
     */
    @ApiOperation(value = "查询单个便携机借用审批{author:lx}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Portablemanagementapproval tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加便携机借用审批
     *
     * @return
     */
//    @SystemLog(module="便携机借用审批管理",methods="增加便携机借用")
    @ApiOperation(value = "增加便携机借用审批{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Portablemanagementapproval info) throws IOException {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 处理便携机借用审批
     * isapprove   1同意，0不同意
     *
     * @return
     */
//    @SystemLog(module="便携机借用审批管理",methods="处理便携机借用审批 ")
    @ApiOperation(value = "处理便携机借用审批 author:lx}", response = Result.class)
    @RequestMapping(value = "deal", method = RequestMethod.PUT)
    public ResponseEntity<Object> deal(@RequestBody ApproveVO info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

}