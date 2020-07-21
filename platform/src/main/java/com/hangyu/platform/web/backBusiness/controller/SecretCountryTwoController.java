package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.service.CooperationService;
import com.hangyu.platform.web.backBusiness.service.SecretCountryTwoService;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;
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
 * 国家秘密二级目录管理
 *
 * @auther liuXuan
 * @date 2020/2/12
 */
@Api(tags = "国家秘密二级目录管理相关接口")
@RestController
@RequestMapping(value = "v1/secretCountry")
public class SecretCountryTwoController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private SecretCountryTwoService service;

    /**
     * 查询所有国家秘密二级目录管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有国家秘密二级目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "levelId", required = false) String levelId,
                                                                   @RequestParam(value = "name", required = false) String name,
                                                                     @RequestParam("pageNum") int pageNum,
                                                                       @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(levelId,name,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个国家秘密二级目录管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个国家秘密二级目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        SecretcontrolparticularTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加国家秘密二级目录管理
     *
     * @return
     */
    @SystemLog(module="国家秘密二级目录管理管理",methods="增加国家秘密二级目录管理")
    @ApiOperation(value = "增加国家秘密二级目录author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody SecretcontrolparticularTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改国家秘密二级目录管理
     *
     * @return
     */
    @SystemLog(module="国家秘密二级目录管理管理",methods="修改国家秘密二级目录管理")
    @ApiOperation(value = "修改国家秘密二级目录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody SecretcontrolparticularTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除国家秘密二级目录管理
     *
     * @return
     */
    @SystemLog(module="国家秘密二级目录管理管理",methods="删除国家秘密二级目录管理")
    @ApiOperation(value = "删除国家秘密二级目录{author:liuxuan}", response = Result.class)
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
    @ApiOperation(value = "导出excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response,@RequestParam(value = "levelId", required = false) String levelId,
                                            @RequestParam(value = "name", required = false) String name) {
        List<SecretcontrolparticularTbl> list = service.exportExcel(levelId,name);
        MyExcelExportUtil.exportExcel(list, SecretcontrolparticularTbl.class, "国家秘密二级目录管理", "国家秘密二级目录", response);
        return ResponseEntity.ok("导出成功");
    }

    /**
     * 模板下载
     *
     * @param
     * @return
     */
    @ApiOperation(value = "模板下载{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String path = "src/main/resources/templates/";
        String fileName = "国家秘密二级细目.xls";
        FileUtils.download(response,path,fileName);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量导入
     *
     * @param
     * @return
     */
    @ApiOperation(value = "批量导入{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }
}