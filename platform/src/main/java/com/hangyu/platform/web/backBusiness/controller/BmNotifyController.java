package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import com.hangyu.platform.web.backBusiness.service.BmNotifyService;
import com.hangyu.platform.web.backBusiness.service.BmPublishService;
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
 * 通知公告管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Api(tags = "通知公告管理相关接口")
@RestController
@RequestMapping(value = "v1/bmNotify")
public class BmNotifyController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmNotifyService service;

    /**
     * 查询所有通知公告管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "keyWords", required = false) String keyWords,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize, name, keyWords, startDate, endDate);
        return ResponseEntity.ok(type);
    }


    /**
     * 查询单个通知公告管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个通知公告管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmNotifyTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加通知公告管理
     *
     * @return
     */
    @SystemLog(module="通知公告管理",methods="增加通知公告管理")
    @ApiOperation(value = "增加通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam("data") String data) throws IOException {
        BmNotifyTbl info = JSON.parseObject(data, BmNotifyTbl.class);
        service.add(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改通知公告管理
     *
     * @return
     */
    @SystemLog(module="通知公告管理",methods="修改通知公告管理")
    @ApiOperation(value = "修改通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @RequestParam("data") String data) throws IOException {
        BmNotifyTbl info = JSON.parseObject(data, BmNotifyTbl.class);
        service.update(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除通知公告管理
     *
     * @return
     */
    @SystemLog(module="通知公告管理",methods="删除通知公告管理")
    @ApiOperation(value = "删除通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.delete(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 发布通知公告管理
     *
     * @return
     */
    @SystemLog(module="通知公告管理",methods="删除通知公告管理")
    @ApiOperation(value = "发布通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "publish", method = RequestMethod.PATCH)
    public ResponseEntity<Object> publish(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.isPublish(id, 1);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 撤销通知公告管理
     *
     * @return
     */
    @SystemLog(module="通知公告管理",methods="删除通知公告管理")
    @ApiOperation(value = "撤销通知公告管理{author:lx}", response = Result.class)
    @RequestMapping(value = "cancelPublish", method = RequestMethod.PATCH)
    public ResponseEntity<Object> cancelPublish(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.isPublish(id, 0);
        });
        return ResponseEntity.ok(result);
    }

}