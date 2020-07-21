package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.SystemsetTbl;
import com.hangyu.platform.web.sysAdmin.service.SystemSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统设置
 */
@RestController
@RequestMapping("v1/systemSet/")
@Api(tags = "系统设置接口")
public class SystemSetController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private SystemSetService systemSetService;

    /**
     * 查询系统设置
     *
     * @return
     */
    @ApiOperation(value = "查询系统设置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySet", method = RequestMethod.GET)
    public ResponseEntity<Object> querySet() {

        SystemsetTbl set = systemSetService.querySet();
        return ResponseEntity.ok(set);
    }

    /**
     * 修改系统设置
     *
     * @return
     */
    @ApiOperation(value = "修改系统设置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateSet", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSet(@RequestBody SystemsetTbl set) {

        systemSetService.updateSet(set);
        return ResponseEntity.ok(result);
    }



}
