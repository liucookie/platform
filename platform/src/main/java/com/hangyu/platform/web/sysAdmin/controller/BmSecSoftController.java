package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.BmSecsofttypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmSecSoftService;
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
 * 信息安全软件类别管理
 */
@RestController
@RequestMapping("v1/BmSecSoft/")
@Api(tags = "信息安全软件类别管理")
public class BmSecSoftController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmSecSoftService service;

    /**
     * 查询所有信息安全软件类别
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有信息安全软件类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.queryType(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询信息安全软件类别
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个信息安全软件类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeById(@PathVariable("id") String id) {
        BmSecsofttypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加信息安全软件类别
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加信息安全软件类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody BmSecsofttypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改信息安全软件类别
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改信息安全软件类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody BmSecsofttypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信息安全软件类别
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除信息安全软件类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
