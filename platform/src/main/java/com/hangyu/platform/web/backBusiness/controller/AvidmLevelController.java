package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.service.AvidmService;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * AVIDM定密集成管理
 * @auther  liuXuan
 * @date 2020/1/15
 */
@Api(tags = "AVIDM定密集成管理相关接口")
@RestController
@RequestMapping(value = "v1/avidmLevel")
public class AvidmLevelController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private AvidmService avidmService;
    /**
     * 查询所有AVIDM定密集成
     *
     * @return
     */
    @ApiOperation(value = "查询所有AVIDM定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody AvidmQueryVO vo) {
        Map<String, Object> type = avidmService.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个AVIDM定密集成
     *
     * @return
     */
    @ApiOperation(value = "查询单个AVIDM定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int id) {
        AvidmLevelintegrate avidmLevelintegrate = avidmService.queryById(id);
        return ResponseEntity.ok(avidmLevelintegrate);
    }

    /**
     * 增加AVIDM定密集成
     *
     * @return
     */
    @SystemLog(module="AVIDM定密集成管理",methods="增加AVIDM定密集成")
    @ApiOperation(value = "增加AVIDM定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody AvidmLevelintegrate avidmLevelintegrate) {
         avidmService.add(avidmLevelintegrate);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改AVIDM定密集成
     *
     * @return
     */
    @SystemLog(module="AVIDM定密集成管理",methods="修改AVIDM定密集成")
    @ApiOperation(value = "修改AVIDM定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody AvidmLevelintegrate avidmLevelintegrate) {
        avidmService.update(avidmLevelintegrate);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除AVIDM定密集成
     *
     * @return
     */
    @SystemLog(module="AVIDM定密集成管理",methods="删除AVIDM定密集成")
    @ApiOperation(value = "删除AVIDM定密集成{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach( id ->{
            avidmService.delete(id);
        });
        return ResponseEntity.ok(result);
    }

}