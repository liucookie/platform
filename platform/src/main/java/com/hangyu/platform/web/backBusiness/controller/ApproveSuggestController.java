package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.ApprovesuggestionselectTbl;
import com.hangyu.platform.web.backBusiness.service.ApproveSuggestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 表单审批意见管理
 *
 * @auther liuXuan
 * @date 2020/2/6
 */
@Api(tags = "表单审批意见管理相关接口")
@RestController
@RequestMapping(value = "v1/ApproveSuggest")
public class ApproveSuggestController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private ApproveSuggestService service;

    /**
     * 查询所有表单审批意见
     *
     * @return
     */
    @ApiOperation(value = "查询所有表单审批意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "formID", required = false) String formId,
                                        @RequestParam(value = "orgName", required = false) String orgName,
                                        @RequestParam(value = "pageSize") int  pageSize,
                                        @RequestParam(value = "pageNum") int  pageNum) {
        Map<String, Object> type = service.query(formId,orgName,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个表单审批意见
     *
     * @return
     */
    @ApiOperation(value = "查询单个表单审批意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int  id) {
        ApprovesuggestionselectTbl approve = service.queryById(id);
        return ResponseEntity.ok(approve);
    }

    /**
     * 增加表单审批意见
     *
     * @return
     */
    @SystemLog(module="表单审批意见管理",methods="增加表单审批意见")
    @ApiOperation(value = "增加表单审批意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody ApprovesuggestionselectTbl approve) {
        service.add(approve);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改表单审批意见
     *
     * @return
     */
    @SystemLog(module="表单审批意见管理",methods="修改表单审批意见")
    @ApiOperation(value = "修改表单审批意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody ApprovesuggestionselectTbl approve) {
        service.update(approve);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除表单审批意见
     *
     * @return
     */
    @SystemLog(module="表单审批意见管理",methods="删除表单审批意见")
    @ApiOperation(value = "删除表单审批意见{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

}