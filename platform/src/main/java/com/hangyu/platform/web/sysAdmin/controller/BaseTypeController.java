package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Basetype;
import com.hangyu.platform.web.sysAdmin.service.BaseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 基础类型管理
 */
@RestController
@RequestMapping("v1/baseType/")
@Api(tags = "基础类型管理")
public class BaseTypeController {
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BaseTypeService typeService;

    /**
     * 查询所有基础类型
     *
     * @return
     */
    @ApiOperation(value = "查询所有基础类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query() {
        List<Basetype> type = typeService.query();
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个基础类型
     *
     * @return
     */
    @ApiOperation(value = "查询单个基础类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDetail(@PathVariable("id") String id) {
        Basetype type = typeService.queryDetail(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加单个基础类型
     *
     * @return
     */
    @ApiOperation(value = "增加单个基础类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Basetype basetype) {
         typeService.add(basetype);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改单个基础类型
     *
     * @return
     */
    @ApiOperation(value = "修改单个基础类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Basetype basetype) {
        typeService.update(basetype);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除单个基础类型
     *
     * @return
     */
    @ApiOperation(value = "删除所有基础类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
         typeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
