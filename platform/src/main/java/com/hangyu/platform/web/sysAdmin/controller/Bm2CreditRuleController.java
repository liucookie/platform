package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CreditrulesettingTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2CreditRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 保密信用积分规则配置管理
 */
@RestController
@RequestMapping("v1/CreditRule/")
@Api(tags = "保密信用积分规则配置管理")
public class Bm2CreditRuleController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2CreditRuleService service;

    /**
     * 查询保密信用积分规则配置
     *
     * @param year
     * @param year
     * @return
     */
    @ApiOperation(value = "查询所有现场检查问题类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{year}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("year") int year) {
        Bm2CreditrulesettingTbl tbl = service.query(year);
        return ResponseEntity.ok(tbl);
    }



    /**
     * 修改保密信用积分规则配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改保密信用积分规则配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2CreditrulesettingTbl type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }



}
