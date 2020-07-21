package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2ViolationrectificationinstructionTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmCheckplanitemTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2ViolationConfigService;
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
 * 违规项整改指导配置
 */
@RestController
@RequestMapping("v1/violationConfig/")
@Api(tags = "违规项整改指导配置")
public class Bm2ViolationConfigController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2ViolationConfigService service;

    /**
     * 查询所有违规项整改指导配置
     *
     * @param pageNum
     * @param pageSize
     * @param itemId
     * @return
     */
    @ApiOperation(value = "查询所有违规项整改指导配置{author:acc}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam(value = "itemId",required = false) String itemId) {
        Map<String,Object> type = service.query(pageNum, pageSize,itemId);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个违规项整改指导配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个违规项整改指导配置{author:acc}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        Bm2ViolationrectificationinstructionTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }


    /**
     * 增加违规项整改指导配置
     *
     * @param tbl
     * @return
     */
    @ApiOperation(value = "增加违规项整改指导配置{author:acc}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2ViolationrectificationinstructionTbl tbl) {
        service.add(tbl);
        return ResponseEntity.ok(result);
    }




    /**
     * 修改违规项整改指导配置
     *
     * @param tbl
     * @return
     */
    @ApiOperation(value = "修改违规项整改指导配置{author:acc}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAffiche(@RequestBody Bm2ViolationrectificationinstructionTbl tbl) {
        service.update(tbl);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除违规项整改指导配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除违规项整改指导配置{author:acc}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询所有的检查项
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有的检查项{author:acc}", response = Result.class)
    @RequestMapping(value = "queryItem", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById() {
        List<BmCheckplanitemTbl> list = service.queryItem();
        return ResponseEntity.ok(list);
    }

    /**
     * 查询所有的检查项
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有的检查项{author:acc}", response = Result.class)
    @RequestMapping(value = "queryItem/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryItemById(@PathVariable("id") int id) {
        List<BmCheckplanitemTbl> list = service.queryItemById(id);
        return ResponseEntity.ok(list);
    }

}
