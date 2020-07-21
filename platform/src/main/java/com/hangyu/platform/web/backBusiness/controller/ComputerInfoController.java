package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import com.hangyu.platform.web.backBusiness.service.ConputerInfoService;
import com.hangyu.platform.web.backBusiness.vo.ComputerQueryVO;
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
 * 信息化设备-台账管理管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/14
 */
@Api(tags = "信息化设备-便携机管理管理相关接口")
@RestController
@RequestMapping(value = "v1/computerInfo")
public class ComputerInfoController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private ConputerInfoService service;

    /**
     * 查询所有信息化设备-台账管理
     *
     * @param vo typeId(设备类型)
     * @return
     */
    @ApiOperation(value = "查询所有信息化设备-台账管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody ComputerQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个信息化设备-台账管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个信息化设备-台账管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Computerinfo softWare = service.queryById(id);
        return ResponseEntity.ok(softWare);
    }

    /**
     * 增加信息化设备-台账管理
     *
     * @return
     */
    @SystemLog(module="信息化设备-台账管理管理",methods="增加信息化设备-台账管理")
    @ApiOperation(value = "增加信息化设备-台账管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Computerinfo softWare) {
         service.add(softWare);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信息化设备-台账管理
     *
     * @return
     */
    @SystemLog(module="信息化设备-台账管理管理",methods="修改信息化设备-台账管理")
    @ApiOperation(value = "修改信息化设备-台账管理{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Computerinfo softWare) {
        service.update(softWare);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信息化设备-台账管理
     *
     * @return
     */
    @SystemLog(module="信息化设备-台账管理管理",methods="删除信息化设备-台账管理")
    @ApiOperation(value = "删除信息化设备-台账管理{author:liuxuan}", response = Result.class)
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
    public ResponseEntity<Object> exportLog(HttpServletResponse response, @RequestBody ComputerQueryVO vo){
        List<Computerinfo> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, Computerinfo.class,"计算机台账管理","台账",response);
        return ResponseEntity.ok("导出成功");
    }


}