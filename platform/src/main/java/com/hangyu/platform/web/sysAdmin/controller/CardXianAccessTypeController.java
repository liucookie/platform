package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.CardFenyuanaccesscontroltypeTbl;
import com.hangyu.platform.web.sysAdmin.service.CardXianAccessTypeService;
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
 * 西安分院门禁授权证件种类管理
 */
@RestController
@RequestMapping("v1/CardXianAccessType/")
@Api(tags = "西安分院门禁授权证件种类管理")
public class CardXianAccessTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private CardXianAccessTypeService service;

    /**
     * 查询西安分院院门禁授权证件种类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有西安分院院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个西安分院院门禁授权证件种类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个西安分院院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") int id) {
        CardFenyuanaccesscontroltypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加西安分院院门禁授权证件种类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加西安分院院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody CardFenyuanaccesscontroltypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改西安分院院门禁授权证件种类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改西安分院院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody CardFenyuanaccesscontroltypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除西安分院院门禁授权证件种类
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除西安分院院门禁授权证件种类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@RequestBody List<Integer> list) {
        list.forEach(id ->{
            service.deleteType(id);
        });
        return ResponseEntity.ok(result);
    }

}
