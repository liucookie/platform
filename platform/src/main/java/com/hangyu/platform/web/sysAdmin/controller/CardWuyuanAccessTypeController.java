package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.CardGuomipasstypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.CardWuyuanaccesscontroltypeTbl;
import com.hangyu.platform.web.sysAdmin.service.CardCountryTypeService;
import com.hangyu.platform.web.sysAdmin.service.CardWuYuanAccessTypeService;
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
 * 五院门禁授权证件种类管理
 */
@RestController
@RequestMapping("v1/CardCountryAccessType/")
@Api(tags = "五院门禁授权证件种类管理")
public class CardWuyuanAccessTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private CardWuYuanAccessTypeService service;

    /**
     * 查询五院门禁授权证件种类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有五院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个五院门禁授权证件种类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个五院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") int id) {
        CardWuyuanaccesscontroltypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加五院门禁授权证件种类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加五院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody CardWuyuanaccesscontroltypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改五院国密出入证证件种类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改五院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody CardWuyuanaccesscontroltypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除五院门禁授权证件种类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除五院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") int id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
