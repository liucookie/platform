package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.TblTest;
import com.hangyu.platform.web.backBusiness.service.TblTestService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 试题管理
 *
 * @auther liuXuan
 * @date 2020/4/7
 */
@Api(tags = "试题管理相关接口")
@RestController
@RequestMapping(value = "v1/questions")
public class TblTestController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private TblTestService service;

    /**
     * 查询所有试题管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "type", required = false) String type,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = service.query(type, name, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个试题管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int id) {
        TblTest tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加试题管理
     *
     * @return
     */
    @SystemLog(module="试题管理管理",methods="增加试题管理")
    @ApiOperation(value = "增加试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody TblTest info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改试题管理
     *
     * @return
     */
    @SystemLog(module="试题管理管理",methods="修改试题管理")
    @ApiOperation(value = "修改试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody TblTest info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除试题管理
     *
     * @return
     */
    @SystemLog(module="试题管理管理",methods="删除试题管理")
    @ApiOperation(value = "删除试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 导出文件
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.GET)
    @ApiOperation(value = "导出excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response,@RequestParam(value = "type", required = false) String type,
                                            @RequestParam(value = "name", required = false) String name) {
        List<TblTest> list = service.exportExcel(type,name);
        MyExcelExportUtil.exportExcel(list, TblTest.class, "试题管理", "试题", response);
        return ResponseEntity.ok(result);
    }


    /**
     * 模板下载
     *
     * @param type 1下载单选题，2多选，3判断，4填空
     * @return
     */
    @ApiOperation(value = "模板下载{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "download/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response, @PathVariable("type") int type) throws IOException {
        String fileName = "";
        switch (type) {
            case 1:
                fileName = "单选题模板.xls";
                break;
            case 2:
                fileName = "多选题模板.xls";
                break;
            case 3:
                fileName = "判断题模板.xls";
                break;
            case 4:
                fileName = "填空题模板.xls";
                break;
            default:
                break;
        }
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量导入
     *
     * @param
     * @return
     */
    @ApiOperation(value = "批量导入{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "importExcel/{type}", method = RequestMethod.POST)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file,@PathVariable("type") int type) {
        service.importExcel(file,type);
        return ResponseEntity.ok(result);
    }
}