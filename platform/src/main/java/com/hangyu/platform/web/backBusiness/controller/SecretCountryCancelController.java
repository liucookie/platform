package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.NationlevelremoveTbl;
import com.hangyu.platform.web.backBusiness.service.SecretCountryCancelService;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 国家秘密事项解除审批解除审批 管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/5/14
 */
@Api(tags = "国家秘密事项解除审批管理相关接口")
@RestController
@RequestMapping(value = "v1/secretCountryCancel")
public class SecretCountryCancelController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private SecretCountryCancelService service;

    /**
     * 查询单个国家秘密事项解除审批
     *
     * @return
     */
    @ApiOperation(value = "查询单个国家秘密事项解除审批{author:lx}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        NationlevelremoveTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加国家秘密事项解除审批
     *
     * @return
     */
//    @SystemLog(module="国家秘密事项解除审批管理",methods="增加国家秘密事项解除")
    @ApiOperation(value = "增加国家秘密事项解除审批{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("data") String data) throws IOException {
        NationlevelremoveTbl info = JSON.parseObject(data, NationlevelremoveTbl.class);
        service.add(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 处理国家秘密事项解除审批
     * isapprove   1同意，0不同意
     * @return
     */
//    @SystemLog(module="国家秘密事项解除审批管理",methods="处理国家秘密事项解除审批 ")
    @ApiOperation(value = "处理国家秘密事项解除审批 author:lx}", response = Result.class)
    @RequestMapping(value = "deal", method = RequestMethod.PUT)
    public ResponseEntity<Object> deal(@RequestBody ApproveVO info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

}