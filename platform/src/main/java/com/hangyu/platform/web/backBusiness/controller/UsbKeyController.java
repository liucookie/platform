package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.UsbkeyTbl;
import com.hangyu.platform.web.backBusiness.service.OaManageService;
import com.hangyu.platform.web.backBusiness.service.UsbKeyService;
import com.hangyu.platform.web.backBusiness.vo.UsbKeyQueryVO;
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
 * usbkey台账(后台接口)
 * @auther  liuXuan
 * @date 2020/2/18
 */
@Api(tags = "usbkey台账相关接口")
@RestController
@RequestMapping(value = "v1/usbKey")
public class UsbKeyController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private UsbKeyService service;

    /**
     * 查询所有usbkey台账
     *
     * @param vo 查询参数
     * @return
     */
    @ApiOperation(value = "查询所有usbkey台账{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody UsbKeyQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个usbkey台账
     *
     * @return
     */
    @ApiOperation(value = "查询单个usbkey台账{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        UsbkeyTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加usbkey台账
     *
     * @return
     */
    @SystemLog(module="usbkey台账",methods="增加usbkey台账")
    @ApiOperation(value = "增加usbkey台账{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody UsbkeyTbl tbl) {
         service.add(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改usbkey台账
     *
     * @return
     */
    @SystemLog(module="usbkey台账",methods="修改usbkey台账")
    @ApiOperation(value = "修改usbkey台账{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody UsbkeyTbl tbl) {
        service.update(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除usbkey台账
     *
     * @return
     */
    @SystemLog(module="usbkey台账",methods="删除usbkey台账")
    @ApiOperation(value = "删除usbkey台账{author:liuxuan}", response = Result.class)
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
    @ApiOperation(value = "模板下载{author:lx}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String fileName = "Usbkey台账.xls";
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