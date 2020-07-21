package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSlsetofficerTbl;
import com.hangyu.platform.web.backBusiness.service.BmSetOfficerService;
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
 * 定密责任人
 * @auther  liuXuan
 * @date 2020/2/12
 */
@Api(tags = "定密责任人相关接口")
@RestController
@RequestMapping(value = "v1/bmSetOfficer")
public class BmSetOfficerController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmSetOfficerService service;

    /**查询所有定密责任人
     *
     * @param typeId  分类id
     * @param orgId 处室id
     * @param userId 人员id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有定密责任人", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "typeId", required = false) String typeId,
                                        @RequestParam(value = "orgId", required = false) String orgId,
                                        @RequestParam(value = "userId", required = false) String userId,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(typeId,orgId,userId,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个定密责任人
     *
     * @return
     */
    @ApiOperation(value = "查询单个定密责任人{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmSlsetofficerTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加定密责任人
     *
     * @return
     */
    @SystemLog(module="定密责任人管理",methods="增加定密责任人")
    @ApiOperation(value = "增加定密责任人", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody BmSlsetofficerTbl info) {
         service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改定密责任人
     *
     * @return
     */
    @SystemLog(module="定密责任人管理",methods="修改定密责任人")
    @ApiOperation(value = "修改定密责任人{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody BmSlsetofficerTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除定密责任人
     *
     * @return
     */
    @SystemLog(module="定密责任人管理",methods="删除定密责任人")
    @ApiOperation(value = "删除定密责任人{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.delete(id);
        });
        return ResponseEntity.ok(result);
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
        String fileName = "定密责任人.xls";
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