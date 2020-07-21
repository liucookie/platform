package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.WuyuanaccesspointTbl;
import com.hangyu.platform.web.sysAdmin.service.FiveCourtAccessPointService;
import com.hangyu.platform.web.sysAdmin.vo.WuyuanAccessPointQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 五院门禁点位管理
 */
@RestController
@RequestMapping("v1/FiveCourtPoint/")
@Api(tags = "五院门禁点位管理")
public class FiveCourtAccessPointController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private FiveCourtAccessPointService service;

    /**
     * 查询五院门禁点
     *
     * @param vo
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询所有五院门禁点{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody WuyuanAccessPointQueryVO vo) {
        Map<String,Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个五院门禁点
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个五院门禁点{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") Integer id) {
        WuyuanaccesspointTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加五院门禁点
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加五院门禁点{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody WuyuanaccesspointTbl type) {
        service.add(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改五院门禁点
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改五院门禁点{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody WuyuanaccesspointTbl type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除五院门禁点
     * @param
     * @return
     */
    @ApiOperation(value = "删除五院门禁点{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

}
