package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Bm2ConcactwayTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2ConcactWayService;
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
 * 保密通讯录管理
 *
 * @auther liuXuan
 * @date 2020/3/10
 */
@Api(tags = "保密通讯录管理相关接口")
@RestController
@RequestMapping(value = "v1/concactWay")
public class Bm2ConcactWayController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2ConcactWayService service;

    /**
     * 查询所有保密通讯录管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有保密通讯录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "orgName", required = false) String orgName,
                                                                   @RequestParam(value = "userName", required = false) String userName,
                                                                    @RequestParam(value = "typeName", required = false) String typeName,
                                                                     @RequestParam("pageNum") int pageNum,
                                                                       @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(orgName,userName,typeName,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个保密通讯录管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个保密通讯录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Bm2ConcactwayTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加保密通讯录管理
     *
     * @return
     */
    @SystemLog(module="保密通讯录管理管理",methods="增加保密通讯录管理")
    @ApiOperation(value = "增加保密通讯录author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2ConcactwayTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改保密通讯录管理
     *
     * @return
     */
    @SystemLog(module="保密通讯录管理管理",methods="修改保密通讯录管理")
    @ApiOperation(value = "修改保密通讯录{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2ConcactwayTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除保密通讯录管理
     *
     * @return
     */
//    @SystemLog(module="保密通讯录管理管理",methods="删除保密通讯录管理")
    @ApiOperation(value = "删除保密通讯录{author:liuxuan}", response = Result.class)
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
    public ResponseEntity<Object> exportLog(HttpServletResponse response,@RequestParam(value = "orgName", required = false) String orgName,
                                            @RequestParam(value = "userName", required = false) String userName) {
        List<Bm2ConcactwayTbl> list = service.exportExcel(orgName,userName);
        MyExcelExportUtil.exportExcel(list, Bm2ConcactwayTbl.class, "保密通讯录管理", "保密通讯录", response);
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
        String fileName = "保密通信录.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(),fileName);
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