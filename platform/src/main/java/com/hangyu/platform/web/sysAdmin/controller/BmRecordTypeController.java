package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FilemoduleTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmRecordtypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmRecordTypeService;
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
 * 保密档案管理
 */
@RestController
@RequestMapping("v1/recordType/")
@Api(tags = "保密档案管理(一级或者二级)")
public class BmRecordTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmRecordTypeService service;

    /**
     * 查询保密档案管理(一级或者二级)
     * @param type   0为一级目录，1二级保密目录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有保密档案管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("type") int type,
                                        @RequestParam(value = "topId",required = false) String topId,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String,Object>  map = service.query(type,topId,pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询所有的归档栏目(一级或者二级)
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "查询所有的归档栏目{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryModule/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("type") int type) {
        List<Bm2FilemoduleTbl> list = service.selectByType(type);
        return ResponseEntity.ok(list);
    }


    /**
     * 查询保密档案管理
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个保密档案管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        BmRecordtypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加保密档案管理
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加保密档案管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody BmRecordtypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改保密档案管理
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改保密档案管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody BmRecordtypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除保密档案管理
     *
     * @param
     * @return
     */
    @ApiOperation(value = "删除保密档案管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@RequestBody List<String> ids) {
        service.deleteType(ids);
        return ResponseEntity.ok(result);
    }



    /**
     * 保密档案顺序管理
     *
     * @param
     * @return
     */
    @ApiOperation(value = "保密档案顺序管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "changeOrder", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeOrder(@RequestBody List<BmRecordtypeTbl> list) {
        list.forEach(record -> {
            service.updateType(record);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 查询保密档案管理名称(回显用)(一级或者二级)
     * @param type   0为一级目录，1二级保密目录
     * @return
     */
    @ApiOperation(value = "查询保密档案管理名称(修改回显用){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryName/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("type") int type,
                                        @RequestParam(value = "topId",required = false) String topId) {
        List<BmRecordtypeTbl> list   = service.queryName(type,topId);
        return ResponseEntity.ok(list);
    }

}
