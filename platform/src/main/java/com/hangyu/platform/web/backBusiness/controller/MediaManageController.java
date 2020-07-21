package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.TzMediamanagementTbl;
import com.hangyu.platform.web.backBusiness.service.MediaManageService;
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
 * 介质管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/14
 */
@Api(tags = "介质管理相关接口")
@RestController
@RequestMapping(value = "v1/mediaManage")
public class MediaManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private MediaManageService service;

    /**
     * 查询所有介质
     *
     * @param vo 查询参数
     * @return
     */
    @ApiOperation(value = "查询所有介质{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody MediaManageQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个介质
     *
     * @return
     */
    @ApiOperation(value = "查询单个介质{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        TzMediamanagementTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询借出介质信息
     *
     * @return
     */
    @ApiOperation(value = "查询借出介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryBorrowInfo", method = RequestMethod.GET)
    public ResponseEntity<Object> queryBorrowInfo(@RequestParam(value = "name", required = false) String mediaId,
                                                                   @RequestParam("pageNum") int pageNum,
                                                                    @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.queryBorrowInfo(mediaId,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加介质
     *
     * @return
     */
    @SystemLog(module="介质管理",methods="增加介质")
    @ApiOperation(value = "增加介质{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody TzMediamanagementTbl tbl) {
         service.add(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改介质
     *
     * @return
     */
    @SystemLog(module="介质管理",methods="修改介质")
    @ApiOperation(value = "修改介质{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody TzMediamanagementTbl tbl) {
        service.update(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除介质
     *
     * @return
     */
    @SystemLog(module="介质管理",methods="删除介质")
    @ApiOperation(value = "删除介质{author:liuxuan}", response = Result.class)
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
        List<TzMediamanagementTbl> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, TzMediamanagementTbl.class,"介质管理","介质管理",response);
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
        String fileName = "介质台账模板.xls";
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