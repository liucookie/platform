package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.BmInfotypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmInfoTypeService;
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
 * 保密知识库分类
 */
@RestController
@RequestMapping("v1/BmInfo/")
@Api(tags = "保密知识库分类")
public class BmInfoTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmInfoTypeService typeService;

    /**
     * 查询所有保密知识库分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有保密知识库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = typeService.queryType(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询保密知识库分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询保密知识库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        BmInfotypeTbl type = typeService.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加保密知识库分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加保密知识库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody BmInfotypeTbl type) {
        typeService.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改保密知识库分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改保密知识库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody BmInfotypeTbl type) {
        typeService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除保密知识库分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除保密知识库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        typeService.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
