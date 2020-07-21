package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmSlsetsendfileTbl;
import com.hangyu.platform.web.backBusiness.service.BmSetFileService;
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
 * 定密责任人发文
 * @auther  liuXuan
 * @date 2020/2/13
 */
@Api(tags = "定密责任人发文相关接口")
@RestController
@RequestMapping(value = "v1/bmSetFile")
public class BmSetFileController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmSetFileService service;

    /**查询所有定密责任人发文
     *
     * @param name  发文名称
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有定密责任人发文", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(name,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个定密责任人发文
     *
     * @return
     */
    @ApiOperation(value = "查询单个定密责任人发文{author:acc}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmSlsetsendfileTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询历史定密责任人发文
     *
     * @return
     */
    @ApiOperation(value = "查询单个定密责任人发文{author:acc}", response = Result.class)
    @RequestMapping(value = "queryHistory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryHistory(@PathVariable("id") String id) {
        List<BmSlsetsendfileTbl> tbl = service.queryHistoryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 删除历史定密责任人发文
     *
     * @return
     */
    @ApiOperation(value = "查询单个定密责任人发文{author:acc}", response = Result.class)
    @RequestMapping(value = "deleteHistory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHistory(@PathVariable("id") String id) {
        service.deleteHistory(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 增加定密责任人发文
     *
     * @return
     */
    @SystemLog(module="定密责任人发文管理",methods="增加定密责任人发文")
    @ApiOperation(value = "增加定密责任人发文", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam("data") String data) throws IOException {
        BmSlsetsendfileTbl info = JSON.parseObject(data,BmSlsetsendfileTbl.class);
         service.add(info,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改定密责任人发文
     * type 0 历史版本，1 非历史版本
     * @return
     */
    @SystemLog(module="定密责任人发文管理",methods="修改定密责任人发文")
    @ApiOperation(value = "修改定密责任人发文{author:acc}", response = Result.class)
    @RequestMapping(value = "update/{type}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @PathVariable("type") int type,
                                         @RequestParam("data") String data) throws IOException {
        BmSlsetsendfileTbl info = JSON.parseObject(data,BmSlsetsendfileTbl.class);
        service.update(info,type,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除定密责任人发文
     *
     * @return
     */
    @SystemLog(module="定密责任人发文管理",methods="删除定密责任人发文")
    @ApiOperation(value = "删除定密责任人发文{author:acc}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }




}