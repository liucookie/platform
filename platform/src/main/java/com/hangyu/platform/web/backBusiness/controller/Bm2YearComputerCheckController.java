package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2YearplancomputeronlinecheckTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2YearComputerCheckService;
import com.hangyu.platform.web.backBusiness.vo.YearcheckAddVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 年度计算机在线检查管理
 *
 * @auther liuXuan
 * @date 2020/2/26
 */
@Api(tags = "年度计算机在线检查管理相关接口")
@RestController
@RequestMapping(value = "v1/yearComputerCheck")
public class Bm2YearComputerCheckController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2YearComputerCheckService service;

    /**
     * 查询所有年度计算机在线检查管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有年度计算机在线检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "year", required = false) String year,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query( year, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }


    /**
     * 增加年度计算机在线检查,添加计划
     *
     * @return
     */
    @SystemLog(module="年度计算机在线检查管理",methods="增加年度计算机在线检查")
    @ApiOperation(value = "增加年度计算机在线检查（添加计划）{author:lx}", response = Result.class)
    @RequestMapping(value = "addPlan", method = RequestMethod.POST)
    public ResponseEntity<Object> addPlan(@RequestBody YearcheckAddVO tbl) {
        List<Bm2YearplancomputeronlinecheckTbl> list =  service.addPlan(tbl);
        return ResponseEntity.ok(list);
    }

    /**
     * 增加年度计算机在线检查,保存设置
     *
     * @return
     */
    @SystemLog(module="年度计算机在线检查管理",methods="增加年度计算机在线检查")
    @ApiOperation(value = "增加年度计算机在线检查（保存设置）{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody List<Bm2YearplancomputeronlinecheckTbl> list) {
         service.add(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改年度计算机在线检查
     *
     * @return
     */
    @SystemLog(module="年度计算机在线检查管理",methods="修改年度计算机在线检查")
    @ApiOperation(value = "修改年度计算机在线检查{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody List<Bm2YearplancomputeronlinecheckTbl> list) {
        service.update(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除年度计算机在线检查
     *
     * @return
     */
    @SystemLog(module="年度计算机在线检查管理",methods="删除年度计算机在线检查")
    @ApiOperation(value = "删除年度计算机在线检查{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }



}