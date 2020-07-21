package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Basecode;
import com.hangyu.platform.web.sysAdmin.service.BaseCodeService;
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

import java.util.List;
import java.util.Map;

/**
 * 基础字典管理
 */
@RestController
@RequestMapping("v1/baseCode/")
@Api(tags = "基础字典管理")
public class BaseCodeController {
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BaseCodeService service;

    /**
     * 查询所有基础字典
     *
     * @return
     */
    @ApiOperation(value = "查询所有基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(id,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询所有基础字典
     *
     * @return
     */
    @ApiOperation(value = "查询所有基础字典-下拉用{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAll/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAll(@PathVariable("id") String id) {
        List<Basecode> list  = service.queryAll(id);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询单个基础字典
     *
     * @return
     */
    @ApiOperation(value = "查询单个基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDetail(@PathVariable("id") String id) {
        Basecode type = service.queryDetail(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加单个基础字典
     *
     * @return
     */
    @ApiOperation(value = "增加单个基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Basecode Basecode) {
         service.add(Basecode);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改单个基础字典
     *
     * @return
     */
    @ApiOperation(value = "修改单个基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Basecode Basecode) {
        service.update(Basecode);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除单个基础字典
     *
     * @return
     */
    @ApiOperation(value = "删除所有基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
         service.delete(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量删除基础字典
     *
     * @return
     */
    @ApiOperation(value = "批量删除基础字典{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteBatch", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> ids) {
        ids.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }
}
