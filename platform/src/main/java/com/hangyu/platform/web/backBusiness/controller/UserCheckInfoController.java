package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.service.UserCheckInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户核对信息管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/12
 */
@Api(tags = "用户核对信息管理相关接口")
@RestController
@RequestMapping(value = "v1/userCheckInfo")
public class UserCheckInfoController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private UserCheckInfoService service;

    /**
     * 查询所有用户核对信息管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有用户核对信息管理{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(
                                      @RequestParam(value = "orgId", required = false) String orgId,
                                       @RequestParam(value = "userId", required = false) String userId,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize,orgId,userId);
        return ResponseEntity.ok(type);
    }

}