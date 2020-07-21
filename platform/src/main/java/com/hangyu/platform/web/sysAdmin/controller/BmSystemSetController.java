package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.BmSettingTbl;
import com.hangyu.platform.web.sysAdmin.service.BmSystemSetService;
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
 * 系统参数配置
 */
@RestController
    @RequestMapping("v1/BmSystemSet/")
@Api(tags = "系统参数配置")
public class BmSystemSetController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private BmSystemSetService systemSetService;

    /**
     * 查询系统参数配置
     *
     * @return
     */
    @ApiOperation(value = "查询系统参数配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySet", method = RequestMethod.GET)
    public ResponseEntity<Object> querySet(@RequestParam("pageNum") int pageNum,
                                                @RequestParam("pageSize") int pageSize) {
        Map<String,Object> map = systemSetService.querySet(pageNum, pageSize);
        return ResponseEntity.ok(map);
    }




    /**
     * 查询单个系统参数配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个系统参数配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySetById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> querySetById(@PathVariable("id") Integer id) {
        BmSettingTbl settingTbl = systemSetService.queryById(id);
        return ResponseEntity.ok(settingTbl);
    }

    /**
     * 增加系统参数配置
     *
     * @param settingTbl
     * @return
     */
    @ApiOperation(value = "增加系统参数配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addSet", method = RequestMethod.POST)
    public ResponseEntity<Object> addSet(@RequestBody BmSettingTbl settingTbl) {
        systemSetService.addSet(settingTbl);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改系统参数配置
     *
     * @param settingTbl
     * @return
     */
    @ApiOperation(value = "修改系统参数配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateSet", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSet(@RequestBody BmSettingTbl settingTbl) {
        systemSetService.updateSet(settingTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除系统参数配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除系统参数配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteSet/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSet(@PathVariable("id") Integer id) {
        systemSetService.deleteSet(id);
        return ResponseEntity.ok(result);
    }



}
