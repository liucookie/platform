package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmAllroundcheckTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.service.BmAllRoundCheckService;
import com.hangyu.platform.web.backBusiness.service.FriendlySoftService;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
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
 * 全面检查管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/21
 */
@Api(tags = "全面检查管理相关接口")
@RestController
@RequestMapping(value = "v1/allRoundCheck")
public class BmAllRoundCheckController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmAllRoundCheckService service;

    /**
     * 查询所有全面检查
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有全面检查{author:acc}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个全面检查
     *
     * @return
     */
    @ApiOperation(value = "查询单个全面检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmAllroundcheckTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加全面检查
     *
     * @return
     */
    @SystemLog(module="全面检查管理",methods="增加全面检查")
    @ApiOperation(value = "增加全面检查{author:acc}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam("data") String data) throws IOException {
        BmAllroundcheckTbl tbl = JSON.parseObject(data, BmAllroundcheckTbl.class);
         service.add(tbl,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改全面检查
     *
     * @return
     */
    @SystemLog(module="全面检查管理",methods="修改全面检查")
    @ApiOperation(value = "修改全面检查{author:acc}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam("data") String data) throws IOException {
        BmAllroundcheckTbl tbl = JSON.parseObject(data, BmAllroundcheckTbl.class);
        service.update(tbl,file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除全面检查
     *
     * @return
     */
    @SystemLog(module="全面检查管理",methods="删除全面检查")
    @ApiOperation(value = "删除全面检查{author:acc}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }




}