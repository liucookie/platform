package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Orgvirtuallist;
import com.hangyu.platform.web.sysAdmin.service.BmSecSoftService;
import com.hangyu.platform.web.sysAdmin.service.OrgVirtualService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 虚拟部门管理
 */
@RestController
@RequestMapping("v1/virtual/")
@Api(tags = "虚拟部门管理")
public class OrgVirtualController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private OrgVirtualService service;

    /**
     * 查询所有虚拟部门
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有虚拟部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "name",required = false) String name,
                                               @RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.queryType(pageNum, pageSize,name);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询虚拟部门
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个虚拟部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeById(@PathVariable("id") String id) {
        Orgvirtuallist type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加虚拟部门
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加虚拟部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Orgvirtuallist type) {
        service.add(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改虚拟部门
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改虚拟部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Orgvirtuallist type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除虚拟部门
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除虚拟部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

}
