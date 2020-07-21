package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Bm2FriendlysoftwareTbl;
import com.hangyu.platform.web.backBusiness.dto.CooperationinfoTbl;
import com.hangyu.platform.web.backBusiness.service.FriendlySoftService;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
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
 * 软件白名单管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/5
 */
@Api(tags = "软件白名单管理相关接口")
@RestController
@RequestMapping(value = "v1/softWare")
public class FriendlySoftController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private FriendlySoftService service;

    /**
     * 查询所有软件白名单
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询所有软件白名单{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody SoftWareQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个软件白名单
     *
     * @return
     */
    @ApiOperation(value = "查询单个软件白名单{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Bm2FriendlysoftwareTbl softWare = service.queryById(id);
        return ResponseEntity.ok(softWare);
    }

    /**
     * 增加软件白名单
     *
     * @return
     */
    @SystemLog(module="软件白名单管理",methods="增加软件白名单")
    @ApiOperation(value = "增加软件白名单{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2FriendlysoftwareTbl softWare) {
         service.add(softWare);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改软件白名单
     *
     * @return
     */
    @SystemLog(module="软件白名单管理",methods="修改软件白名单")
    @ApiOperation(value = "修改软件白名单{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2FriendlysoftwareTbl softWare) {
        service.update(softWare);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除软件白名单
     *
     * @return
     */
    @SystemLog(module="软件白名单管理",methods="删除软件白名单")
    @ApiOperation(value = "删除软件白名单{author:lx}", response = Result.class)
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
    @ApiOperation(value="导出excel{author:lx}",response= Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response, @RequestBody SoftWareQueryVO vo){
        List<Bm2FriendlysoftwareTbl> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, Bm2FriendlysoftwareTbl.class,"软件白名单管理","软件白名单",response);
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
        String fileName = "软件白名单.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(),fileName);
        return ResponseEntity.ok(result);
    }



    /**
     * 导入软件白名单
     * @param file
     * @param
     * @return
     */
    @RequestMapping(value = "import",method = RequestMethod.POST)
    @ApiOperation(value="导入软件白名单{author:lx}",response= Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }
}