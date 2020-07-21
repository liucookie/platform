package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactiontypeTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2FoulactionlTypeService;
import com.hangyu.platform.web.sysAdmin.service.BmCheckSpecialTypeService;
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
 * 违规分类管理
 */
@RestController
@RequestMapping("v1/foulactionType/")
@Api(tags = "违规分类管理")
public class Bm2FoulactionTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2FoulactionlTypeService service;

    /**
     * 查询违规分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有违规分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询违规分类(下拉用)
     *
     * @return
     */
    @ApiOperation(value = "查询所有违规分类(下拉用){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAll() {
        List<Bm2FoulactiontypeTbl> list = service.queryAll();
        return ResponseEntity.ok(list);
    }

    /**
     * 查询违规分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个违规分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        Bm2FoulactiontypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加违规分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加违规分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody Bm2FoulactiontypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改违规分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改违规分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Bm2FoulactiontypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除违规分类
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除违规分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        service.deleteType(list);
        return ResponseEntity.ok(result);
    }

}
