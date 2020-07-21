package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.NationlevelremoveopinionTbl;
import com.hangyu.platform.web.sysAdmin.service.NationSecretRemoveService;
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
 * 国家秘密事项变更解除表承办人意见管理
 */
@RestController
@RequestMapping("v1/nationSecretRemove/")
@Api(tags = "国家秘密事项变更解除表承办人意见管理")
public class NationSecretRemoveController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private NationSecretRemoveService service;

    /**
     * 查询国家秘密事项变更解除表承办人意见
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有国家秘密事项变更解除表承办人意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询国家秘密事项变更解除表承办人意见
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个国家秘密事项变更解除表承办人意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        NationlevelremoveopinionTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加国家秘密事项变更解除表承办人意见
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加国家秘密事项变更解除表承办人意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody NationlevelremoveopinionTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改国家秘密事项变更解除表承办人意见
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改国家秘密事项变更解除表承办人意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody NationlevelremoveopinionTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除国家秘密事项变更解除表承办人意见
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除国家秘密事项变更解除表承办人意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
