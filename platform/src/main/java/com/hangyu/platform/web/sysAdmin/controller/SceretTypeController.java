package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.SecrettypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmCheckSpecialTypeService;
import com.hangyu.platform.web.sysAdmin.service.SecretTypeService;
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

import java.util.Map;

/**
 * 国家秘密类别管理
 */
@RestController
@RequestMapping("v1/secretType/")
@Api(tags = "国家秘密类别管理")
public class SceretTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private SecretTypeService service;

    /**
     * 查询国家秘密类别
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有国家秘密类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询国家秘密类别
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个国家秘密类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        SecrettypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加国家秘密类别
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加国家秘密类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody SecrettypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改国家秘密类别
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改国家秘密类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody SecrettypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除国家秘密类别
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除国家秘密类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
