package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.dto.OaLevelintegrate;
import com.hangyu.platform.web.backBusiness.service.AvidmService;
import com.hangyu.platform.web.backBusiness.service.OALevelService;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * OA定密集成管理
 * @auther  liuXuan
 * @date 2020/2/10
 */
@Api(tags = "OA定密集成管理相关接口")
@RestController
@RequestMapping(value = "v1/OALevel")
public class OALevelController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private OALevelService service;
    /**
     * 查询所有OA定密集成
     *
     * @return
     */
    @ApiOperation(value = "查询所有OA定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody AvidmQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个OA定密集成
     *
     * @return
     */
    @ApiOperation(value = "查询单个OA定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int id) {
        OaLevelintegrate oaLevel = service.queryById(id);
        return ResponseEntity.ok(oaLevel);
    }

    /**
     * 增加OA定密集成
     *
     * @return
     */
    @SystemLog(module="OA定密集成管理",methods="增加OA定密集成")
    @ApiOperation(value = "增加OA定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody OaLevelintegrate level) {
         service.add(level);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改OA定密集成
     *
     * @return
     */
    @SystemLog(module="OA定密集成管理",methods="修改OA定密集成")
    @ApiOperation(value = "修改OA定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody OaLevelintegrate level) {
        service.update(level);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除OA定密集成
     *
     * @return
     */
    @SystemLog(module="OA定密集成管理",methods="删除OA定密集成")
    @ApiOperation(value = "删除OA定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

}