package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmDeptSpecialService;
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
 * 部门专项类型检查管理
 */
@RestController
@RequestMapping("v1/BmDeptSpecial/")
@Api(tags = "部门专项类型检查管理")
public class BmDeptSpecialController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmDeptSpecialService service;

    /**
     * 查询所有部门专项类型检查
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.queryType(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询部门专项类型检查
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        Bm2CheckspecialtypeTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加部门专项类型检查
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody Bm2CheckspecialtypeTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改部门专项类型检查
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Bm2CheckspecialtypeTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除部门专项类型检查
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除部门专项类型检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
