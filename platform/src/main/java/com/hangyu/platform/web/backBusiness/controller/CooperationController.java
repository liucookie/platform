package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.CooperationinfoTbl;
import com.hangyu.platform.web.backBusiness.service.CooperationService;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 协作配套管理
 * @auther  liuXuan
 * @date 2020/2/10
 */
@Api(tags = "协作配套管理相关接口")
@RestController
@RequestMapping(value = "v1/cooperation")
public class CooperationController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private CooperationService service;
    /**
     * 查询所有协作配套管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有协作配套{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody CooperationQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个协作配套管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个协作配套{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        CooperationinfoTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加协作配套管理
     *
     * @return
     */
    @SystemLog(module="协作配套管理管理",methods="增加协作配套管理")
    @ApiOperation(value = "增加协作配套author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody CooperationinfoTbl info) {
         service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改协作配套管理
     *
     * @return
     */
    @SystemLog(module="协作配套管理管理",methods="修改协作配套管理")
    @ApiOperation(value = "修改协作配套{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody CooperationinfoTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除协作配套管理
     *
     * @return
     */
    @SystemLog(module="协作配套管理管理",methods="删除协作配套管理")
    @ApiOperation(value = "删除协作配套{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 导出文件
     * @param response
     * @param  vo
     * @return
     */
    @RequestMapping(value = "exportExcel",method = RequestMethod.POST)
    @ApiOperation(value="导出excel{author:liuxuan}",response= Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response,@RequestBody CooperationQueryVO vo){
        List<CooperationinfoTbl> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, CooperationinfoTbl.class,"协作配套管理","协作配套管理",response);
        return ResponseEntity.ok("导出成功");
    }

}