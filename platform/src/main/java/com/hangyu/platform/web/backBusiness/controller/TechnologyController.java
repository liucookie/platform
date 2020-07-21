package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.OaLevelintegrate;
import com.hangyu.platform.web.backBusiness.service.OALevelService;
import com.hangyu.platform.web.backBusiness.service.TechnologyService;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.math3.geometry.spherical.oned.S1Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 论文发表管理
 * @auther  liuXuan
 * @date 2020/2/7
 */
@Api(tags = "论文发表管理相关接口")
@RestController
@RequestMapping(value = "v1/technology")
public class TechnologyController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private TechnologyService service;
    /**
     * 查询所有论文发表
     *
     * @return
     */
    @ApiOperation(value = "查询所有论文发表{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageSize") int pageSize,
                                       @RequestParam("pageNum") int pageNum,
                                       @RequestParam(value = "formId", required = false) String formId,
                                       @RequestParam(value = "type", required = false) String type){
        Map<String, Object> map = service.query(pageSize,pageNum,formId,type);
        return ResponseEntity.ok(map);
    }


}