package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.ComputyequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.service.ComputerTypeService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.ComputerTypeVO;
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

/**
 * 计算机设备类型配置
 */
@RestController
@RequestMapping("v1/computerType/")
@Api(tags = "计算机设备类型配置")
public class ComputerTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private ComputerTypeService computerService;

    /**
     * 查询所有计算机设备类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有计算机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        ComputerTypeVO vo = computerService.queryType(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询计算机设备类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个计算机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        ComputyequiptypeTbl type = computerService.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加计算机设备类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加计算机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody ComputyequiptypeTbl type) {
        computerService.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改计算机设备类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改计算机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody ComputyequiptypeTbl type) {
        computerService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除计算机设备类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除计算机设备类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        computerService.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
