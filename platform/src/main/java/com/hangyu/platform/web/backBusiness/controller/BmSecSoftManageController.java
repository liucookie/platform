package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.service.BmSecSoftManageService;
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
 * 信息安全软件管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/9
 */
@Api(tags = "信息安全软件管理相关接口")
@RestController
@RequestMapping(value = "v1/bmSoftManage")
public class BmSecSoftManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmSecSoftManageService service;

    /**
     * 查询所有信息安全软件
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有信息安全软件(首页){author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询安全软件下的列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询安全软件下的列表{author:lx}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id,
                                                                          @RequestParam("pageNum") int pageNum,
                                                                           @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.queryById(id,pageNum, pageSize);
        return ResponseEntity.ok(type);
    }


    /**
     * 查询单个信息安全软件
     *
     * @return
     */
    @ApiOperation(value = "查询单个信息安全软件详情{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDetail(@PathVariable("id") String id) {
        BmSecsoftverTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加信息安全软件
     * @Param  file 下载文件
     * @Param  icon 图标
     * @Param  picture 截图
     * @return
     */
    @SystemLog(module="信息安全软件管理",methods="增加信息安全软件")
    @ApiOperation(value = "增加信息安全软件{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam(value = "picture", required = false) MultipartFile picture,
                                      @RequestParam(value = "icon", required = false) MultipartFile icon,
                                      @RequestParam("data") String data) throws IOException {
        BmSecsoftTbl info = JSON.parseObject(data, BmSecsoftTbl.class);
        service.add(info, file, picture,icon);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信息安全软件
     *
     * @return
     */
    @SystemLog(module="信息安全软件管理",methods="修改信息安全软件")
    @ApiOperation(value = "修改信息安全软件{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @RequestParam(value = "picture", required = false) MultipartFile picture,
                                         @RequestParam(value = "icon", required = false) MultipartFile icon,
                                         @RequestParam("data") String data) throws IOException {
        BmSecsoftTbl info = JSON.parseObject(data, BmSecsoftTbl.class);
        service.update(info, file, picture,icon);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信息安全软件
     *
     * @return
     */
    @SystemLog(module="信息安全软件管理",methods="删除信息安全软件")
    @ApiOperation(value = "删除信息安全软件{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.delete(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信息安全软件
     *
     * @return
     */
    @SystemLog(module="信息安全软件管理",methods="删除信息安全软件")
    @ApiOperation(value = "删除信息安全软件(详情列表删除){author:lx}", response = Result.class)
    @RequestMapping(value = "deleteDetail", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDetail(@RequestBody List<String> list) throws IOException{
        for (String id : list) {
            service.deleteDetail(id);
        }
        return ResponseEntity.ok(result);
    }


}