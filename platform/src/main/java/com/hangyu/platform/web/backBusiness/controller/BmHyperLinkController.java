package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.service.BmHyperLinkService;
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

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 平台链接管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Api(tags = "平台链接管理相关接口")
@RestController
@RequestMapping(value = "v1/bmHyperLink")
public class BmHyperLinkController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmHyperLinkService service;

    /**
     * 查询所有平台链接管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有平台链接管理{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }


    /**
     * 查询单个平台链接管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个平台链接管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmHyperlinkTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加平台链接管理
     *
     * @return
     */
    @SystemLog(module="平台链接管理",methods="增加平台链接管理")
    @ApiOperation(value = "增加平台链接管理{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody BmHyperlinkTbl info) throws IOException {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改平台链接管理
     *
     * @return
     */
    @SystemLog(module="平台链接管理",methods="修改平台链接管理")
    @ApiOperation(value = "修改平台链接管理{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody BmHyperlinkTbl info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除平台链接管理
     *
     * @return
     */
    @SystemLog(module="平台链接管理",methods="删除平台链接管理")
    @ApiOperation(value = "删除平台链接管理{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }


}