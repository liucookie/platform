package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrateTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2LocalCheckRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 现场检查结果汇总
 *
 * @auther liuXuan
 * @date 2020/2/25
 */
@Api(tags = "现场检查结果汇总相关接口")
@RestController
@RequestMapping(value = "v1/localCheckRate")
public class Bm2LocalCheckRateController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2LocalCheckRateService service;

    /**
     * 查询所有现场检查结果汇总
     *
     * @return
     */
    @ApiOperation(value = "查询所有现场检查结果汇总{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "orgId", required = false) String orgId,
                                                                   @RequestParam(value = "checkId", required = false) String checkId,
                                                                     @RequestParam("pageNum") int pageNum,
                                                                       @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(orgId,checkId,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }



    /**
     * 修改现场检查结果汇总
     *
     * @return
     */
    @SystemLog(module="现场检查结果汇总管理",methods="修改现场检查结果汇总")
    @ApiOperation(value = "修改现场检查结果汇总{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody List<Bm2LocalcheckrateTbl> list ) {
        service.update(list);
        return ResponseEntity.ok(result);
    }

}