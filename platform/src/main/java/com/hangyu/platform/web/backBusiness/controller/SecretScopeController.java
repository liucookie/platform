package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolscopeTbl;
import com.hangyu.platform.web.backBusiness.service.SecretScopeService;
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
 * 国家秘密范围目录管理
 *
 * @auther liuXuan
 * @date 2020/2/7
 */
@Api(tags = "国家秘密范围目录管理相关接口")
@RestController
@RequestMapping(value = "v1/secretScope")
public class SecretScopeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private SecretScopeService service;

    /**
     * 查询所有国家秘密范围目录
     *
     * @return
     */
    @ApiOperation(value = "查询所有国家秘密范围目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "levelID", required = false) String levelId,
                                        @RequestParam(value = "keyWord", required = false) String keyWord,
                                        @RequestParam(value = "pageSize") int pageSize,
                                        @RequestParam(value = "pageNum") int pageNum) {
        Map<String, Object> type = service.query(levelId, keyWord, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个国家秘密范围目录
     *
     * @return
     */
    @ApiOperation(value = "查询单个国家秘密范围目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        SecretcontrolscopeTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加国家秘密范围目录
     *
     * @return
     */
    @SystemLog(module="国家秘密范围目录管理",methods="增加国家秘密范围目录")
    @ApiOperation(value = "增加国家秘密范围目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody SecretcontrolscopeTbl tbl) {
        service.add(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改国家秘密范围目录
     *
     * @return
     */
    @SystemLog(module="国家秘密范围目录管理",methods="修改国家秘密范围目录")
    @ApiOperation(value = "修改国家秘密范围目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody SecretcontrolscopeTbl avidmLevelintegrate) {
        service.update(avidmLevelintegrate);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除国家秘密范围目录
     *
     * @return
     */
    @SystemLog(module="国家秘密范围目录管理",methods="删除国家秘密范围目录")
    @ApiOperation(value = "删除国家秘密范围目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
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
    @ApiOperation(value = "导出excel{author:lx}", response = Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response, @RequestParam(value = "levelID", required = false) String levelId,
                                            @RequestParam(value = "keyWord", required = false) String keyWord){
        List<SecretcontrolscopeTbl> list = service.exportExcel(levelId, keyWord);
        MyExcelExportUtil.exportExcel(list, SecretcontrolscopeTbl.class, "国家秘密范围目录管理", "国家秘密范围目录", response);
        return ResponseEntity.ok(result);
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
        String fileName = "国家秘密范围目录.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }


    /**
     * 导入
     * @param file
     * @param
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ApiOperation(value = "导入{author:lx}", response = Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }

}