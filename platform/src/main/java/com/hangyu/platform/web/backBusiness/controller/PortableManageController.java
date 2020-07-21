package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.TzPortablemanagementTbl;
import com.hangyu.platform.web.backBusiness.service.PortableManageService;
import com.hangyu.platform.web.backBusiness.vo.MediaManageQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 便携机管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/17
 */
@Api(tags = "便携机管理相关接口")
@RestController
@RequestMapping(value = "v1/portableManage")
public class PortableManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private PortableManageService service;

    /**
     * 查询所有便携机
     *
     * @param vo 查询参数
     * @return
     */
    @ApiOperation(value = "查询所有便携机{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody MediaManageQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个便携机
     *
     * @return
     */
    @ApiOperation(value = "查询单个便携机{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        TzPortablemanagementTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加便携机
     *
     * @return
     */
    @SystemLog(module="便携机管理",methods="增加便携机")
    @ApiOperation(value = "增加便携机{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody TzPortablemanagementTbl tbl) {
         service.add(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改便携机
     *
     * @return
     */
    @SystemLog(module="便携机管理",methods="修改便携机")
    @ApiOperation(value = "修改便携机{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody TzPortablemanagementTbl tbl) {
        service.update(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除便携机
     *
     * @return
     */
    @SystemLog(module="便携机管理",methods="删除便携机")
    @ApiOperation(value = "删除便携机{author:liuxuan}", response = Result.class)
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
    public ResponseEntity<Object> exportLog(HttpServletResponse response, @RequestBody MediaManageQueryVO vo){
        List<TzPortablemanagementTbl> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, TzPortablemanagementTbl.class,"便携机管理","便携机管理",response);
        return ResponseEntity.ok("导出成功");
    }
    /**
     * 模板下载
     *
     * @param
     * @return
     */
    @ApiOperation(value = "模板下载{author:lx}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String fileName = "便携机管理模板.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }


    /**
     * 导入
     * @param file
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ApiOperation(value = "导入{author:lx}", response = Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }

}