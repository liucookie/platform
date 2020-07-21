package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmCheckthingTbl;
import com.hangyu.platform.web.backBusiness.service.BmCheckThingService;
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
 * 检查情况通报(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/5
 */
@Api(tags = "检查情况通报相关接口")
@RestController
@RequestMapping(value = "v1/bmCheckThing")
public class BmCheckThingController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmCheckThingService service;

    /**
     * 查询所有检查情况通报
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize,null);
        return ResponseEntity.ok(type);
    }


    /**
     * 查询单个检查情况通报
     *
     * @return
     */
    @ApiOperation(value = "查询单个检查情况通报{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmCheckthingTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加检查情况通报
     *
     * @return
     */
    @SystemLog(module="检查情况通报",methods="增加检查情况通报")
    @ApiOperation(value = "增加检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam("data") String data) throws IOException {
        BmCheckthingTbl info = JSON.parseObject(data, BmCheckthingTbl.class);
        service.add(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改检查情况通报
     *
     * @return
     */
    @SystemLog(module="检查情况通报",methods="修改检查情况通报")
    @ApiOperation(value = "修改检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @RequestParam("data") String data) throws IOException {
        BmCheckthingTbl info = JSON.parseObject(data, BmCheckthingTbl.class);
        service.update(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除检查情况通报
     *
     * @return
     */
    @SystemLog(module="检查情况通报",methods="删除检查情况通报")
    @ApiOperation(value = "删除检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }
    /**
     * 发布检查情况通报
     *
     * @return
     */
    @SystemLog(module="检查情况通报",methods="删除检查情况通报")
    @ApiOperation(value = "发布检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "publish", method = RequestMethod.PATCH)
    public ResponseEntity<Object> publish(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.isPublish(id,1);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 撤销检查情况通报
     *
     * @return
     */
    @SystemLog(module="检查情况通报",methods="删除检查情况通报")
    @ApiOperation(value = "撤销检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "cancelPublish", method = RequestMethod.PATCH)
    public ResponseEntity<Object> cancelPublish(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.isPublish(id,0);
        });
        return ResponseEntity.ok(result);
    }

}