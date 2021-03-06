package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2CreditmanagerorgsTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckplanTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2LocalCheckService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 现场检查计划管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/2/24
 */
@Api(tags = "现场检查计划管理相关接口")
@RestController
@RequestMapping(value = "v1/localCheck")
public class Bm2LocalCheckController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2LocalCheckService service;

    /**
     * 查询所有现场检查计划
     *
     * @param year
     * @param month
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有现场检查计划{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "year", required = false) String year,
                                        @RequestParam(value = "month", required = false) String month,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(year, month, name, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询所有现场检查计划
     *
     * @return
     */
    @ApiOperation(value = "查询所有现场检查计划(下拉用){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAll", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAll() {
        List<Bm2LocalcheckplanTbl> list = service.queryAll();
        return ResponseEntity.ok(list);
    }


    /**
     * 查询单个现场检查计划
     *
     * @return
     */
    @ApiOperation(value = "查询单个现场检查计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Bm2LocalcheckplanTbl softWare = service.queryById(id);
        return ResponseEntity.ok(softWare);
    }

    /**
     * 增加现场检查计划
     *
     * @return
     */
    @SystemLog(module="现场检查计划管理",methods="增加现场检查计划")
    @ApiOperation(value = "增加现场检查计划{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object>  add(@RequestParam(value = "file", required = false) MultipartFile file,
                                       @RequestParam("data") String data) throws IOException {
        Bm2LocalcheckplanTbl info = JSON.parseObject(data,Bm2LocalcheckplanTbl.class);
        service.add(info,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改现场检查计划
     *
     * @return
     */
    @SystemLog(module="现场检查计划管理",methods="修改现场检查计划")
    @ApiOperation(value = "修改现场检查计划{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object>  update(@RequestParam(value = "file", required = false) MultipartFile file,
                                       @RequestParam("data") String data) throws IOException {
        Bm2LocalcheckplanTbl info = JSON.parseObject(data,Bm2LocalcheckplanTbl.class);
        service.update(info,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除现场检查计划
     *
     * @return
     */
    @SystemLog(module="现场检查计划管理",methods="删除现场检查计划")
    @ApiOperation(value = "删除现场检查计划{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }
    /**
     * 查询所有计划负责人
     *
     */
    @ApiOperation(value = "查询所有计划负责人{author:lx}", response = Result.class)
    @RequestMapping(value = "querySecretPerson", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecretPerson() {
        List<Bm2CreditmanagerorgsTbl> type = service.querySecretPerson();
        return ResponseEntity.ok(type);
    }

}