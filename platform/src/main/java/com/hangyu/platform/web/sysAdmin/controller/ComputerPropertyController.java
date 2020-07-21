package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.ComputerpropertyTbl;
import com.hangyu.platform.web.sysAdmin.service.ComputerPerportyService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.ComputerPerportyVO;
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
 * 计算机属性配置
 */
@RestController
@RequestMapping("v1/computeProperty/")
@Api(tags = "计算机属性管理")
public class ComputerPropertyController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private ComputerPerportyService computerService;

    /**
     * 查询所有计算机属性
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有计算机属性{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryProperty", method = RequestMethod.GET)
    public ResponseEntity<Object> queryProperty(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        ComputerPerportyVO vo = computerService.queryProperty(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询计算机属性
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个计算机属性{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryPropertyById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPropertyById(@PathVariable("id") String id) {
        ComputerpropertyTbl type = computerService.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加计算机属性
     *
     * @param computer
     * @return
     */
    @ApiOperation(value = "增加计算机属性{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addProperty", method = RequestMethod.POST)
    public ResponseEntity<Object> addProperty(@RequestBody ComputerpropertyTbl computer) {
        computerService.addProperty(computer);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改计算机属性
     *
     * @param computer
     * @return
     */
    @ApiOperation(value = "修改计算机属性{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateProperty", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProperty(@RequestBody ComputerpropertyTbl computer) {
        computerService.updateProperty(computer);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除计算机属性
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除计算机属性{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteProperty/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProperty(@PathVariable("id") String id) {
        computerService.deleteProperty(id);
        return ResponseEntity.ok(result);
    }

}
