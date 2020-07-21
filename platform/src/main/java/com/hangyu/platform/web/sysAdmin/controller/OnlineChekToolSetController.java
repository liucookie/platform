package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.service.OnlineCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 在线检查工具参数设置
 */
@RestController
@RequestMapping("v1/OnlineCheck/")
@Api(tags = "在线检查工具参数设置")
public class OnlineChekToolSetController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private OnlineCheckService service;

    /**
     * 查询在线检查工具参数设置
     *
     * @return
     */
    @ApiOperation(value = "查询在线检查工具参数设置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType() {
        Map<String,Object> type = service.query();
        return ResponseEntity.ok(type);
    }


    /**
     * 修改部门专项类型检查
     *
     * @param map
     * @return
     */
    @ApiOperation(value = "修改部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Map<String,Object> map) {
        service.update(map);
        return ResponseEntity.ok(result);
    }



}
