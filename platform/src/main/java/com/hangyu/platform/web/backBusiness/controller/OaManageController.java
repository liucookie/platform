package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Oaequipinfo;
import com.hangyu.platform.web.backBusiness.service.OaManageService;
import com.hangyu.platform.web.backBusiness.vo.ServerManageQueryVO;
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
 * 打印机设备-绘图仪管理(后台接口)
 * @auther  liuXuan
 * @date 2020/2/18
 */
@Api(tags = "打印机设备-绘图仪管理相关接口")
@RestController
@RequestMapping(value = "v1/oaManage")
public class OaManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private OaManageService service;

    /**
     * 查询所有打印机设备-绘图仪
     *
     * @param vo 查询参数
     * @return
     */
    @ApiOperation(value = "查询所有打印机设备-绘图仪{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody ServerManageQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个打印机设备-绘图仪
     *
     * @return
     */
    @ApiOperation(value = "查询单个打印机设备-绘图仪{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Oaequipinfo tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加打印机设备-绘图仪
     *
     * @return
     */
    @SystemLog(module="打印机设备-绘图仪管理",methods="增加打印机设备-绘图仪")
    @ApiOperation(value = "增加打印机设备-绘图仪{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Oaequipinfo tbl) {
         service.add(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改打印机设备-绘图仪
     *
     * @return
     */
//    @SystemLog(module="打印机设备-绘图仪管理",methods="修改打印机设备-绘图仪")
    @ApiOperation(value = "修改打印机设备-绘图仪{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Oaequipinfo tbl) {
        service.update(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除打印机设备-绘图仪
     *
     * @return
     */
    @SystemLog(module="打印机设备-绘图仪管理",methods="删除打印机设备-绘图仪")
    @ApiOperation(value = "删除打印机设备-绘图仪{author:liuxuan}", response = Result.class)
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
    public ResponseEntity<Object> export(HttpServletResponse response, @RequestBody ServerManageQueryVO vo){
        List<Oaequipinfo> list = service.exportExcel(vo);
        MyExcelExportUtil.exportExcel(list, Oaequipinfo.class,"设备台账管理","设备信息",response);
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
        String fileName = "设备台账.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }


    /**
     * 导入
     * @param file
     * @param typeId l类型，区分照相机那些
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ApiOperation(value = "导入{author:lx}", response = Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file,
                                                                             @RequestParam("typeId") String typeId) {
        service.importExcel(file,typeId);
        return ResponseEntity.ok(result);
    }
}