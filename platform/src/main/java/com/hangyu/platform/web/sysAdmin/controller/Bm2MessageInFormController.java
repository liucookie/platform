package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MessagebasicinfoTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MessageinformstrTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2MessageInFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "消息通知机制策略配置")
@RequestMapping("/v1/Bm2MessageInform")
@RestController
public class Bm2MessageInFormController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private Bm2MessageInFormService bm2MessageinformService;

    /**
     * 邮件基本设置查询
     * @param type
     * @return
     */
    @ApiOperation(value = "邮件基本设置查询",response = Result.class)
    @RequestMapping(value = "/basicSelect/{type}",method = RequestMethod.GET)
    public ResponseEntity<Object> basicSelect(@PathVariable("type") int type){
        return  ResponseEntity.ok(bm2MessageinformService.basicSelect(type));
    }

    /**
     * 邮件基本信息修改
     * @param bm2MessagebasicinfoTbl
     * @return
     */
    @ApiOperation(value = "邮件基本信息修改",response = Result.class)
    @RequestMapping(value = "/basicUpdate",method = RequestMethod.POST)
    public ResponseEntity<Object> basicUpdate(@RequestBody Bm2MessagebasicinfoTbl bm2MessagebasicinfoTbl){
        bm2MessageinformService.basicUpdate(bm2MessagebasicinfoTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 消息通知机制策略批量查询
     * @param pageNum
     * @param pageSize
     * @param type
     * @return
     */
    @ApiOperation(value = "消息通知机制策略批量查询",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize,
                                            @RequestParam("strategyType") int type){
        return ResponseEntity.ok(bm2MessageinformService.selectAll(pageNum,pageSize,type));
    }

    /**
     * 添加
     * @param bm2MessageinformstrTbl
     * @return
     */
    @ApiOperation(value = "添加",response = Result.class)
    //@SystemLog(module = "消息通知机制策略配置",methods = "添加")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Bm2MessageinformstrTbl bm2MessageinformstrTbl){
        bm2MessageinformService.insert(bm2MessageinformstrTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除
     * @param list
     * @return
     */
    @ApiOperation(value = "删除",response = Result.class)
    //@SystemLog(module = "消息通知机制策略配置",methods = "删除")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list){
        bm2MessageinformService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 单条查询
     * @param id
     * @return
     */
    @ApiOperation(value = "单条查询",response = Result.class)
    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> select(@PathVariable("id") String id){
        return ResponseEntity.ok(bm2MessageinformService.select(id));
    }

    /**
     * 修改
     * @param bm2MessageinformstrTbl
     * @return
     */
    @ApiOperation(value = "修改",response = Result.class)
    //@SystemLog(module = "消息通知机制策略配置",methods = "修改")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<Object> update(@RequestBody Bm2MessageinformstrTbl bm2MessageinformstrTbl){
        bm2MessageinformService.update(bm2MessageinformstrTbl);
        return ResponseEntity.ok(result);
    }

}
