package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.BmLibtypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmLibraryService;
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
 * 文化资源库分类管理
 */
@RestController
@RequestMapping("v1/BmLibrary/")
@Api(tags = "文化资源库分类管理")
public class BmLibTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmLibraryService service;

    /**
     * 查询所有文化资源库分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有文化资源库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.queryType(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询文化资源库分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个文化资源库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        BmLibtypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加文化资源库分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加文化资源库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody BmLibtypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改文化资源库分类
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改文化资源库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody BmLibtypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除文化资源库分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除文化资源库分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
