package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.InturnequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.service.InturnTypeService;
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
 * 中转机设备类型管理
 */
@RestController
@RequestMapping("v1/inturnType/")
@Api(tags = "中转机设备类型管理")
public class InturnTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private InturnTypeService inturnTypeService;

    /**
     * 查询中转机设备类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有中转机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> map = inturnTypeService.queryType(pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询中转机设备类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个中转机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        InturnequiptypeTbl type = inturnTypeService.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加中转机设备类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加中转机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody InturnequiptypeTbl type) {
        inturnTypeService.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改中转机设备类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改中转机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody InturnequiptypeTbl type) {
        inturnTypeService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除中转机设备类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除中转机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        inturnTypeService.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
