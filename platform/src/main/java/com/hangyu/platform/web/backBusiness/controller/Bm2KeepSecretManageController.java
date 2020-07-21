package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Bm2KeepsecretqualificationstatisticTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2KeepSecretManageService;
import com.hangyu.platform.web.backBusiness.service.BmSecSoftManageService;
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
 * 外协单位保密资质管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/9
 */
@Api(tags = "外协单位保密资质管理相关接口")
@RestController
@RequestMapping(value = "v1/bm2KeepSecretManage")
public class Bm2KeepSecretManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2KeepSecretManageService service;

    /**
     * 查询所有外协单位保密资质
     *
     * @param orgName  单位名称
     * @param type     自制类型id
     * @param levelId  等级id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有外协单位保密资质{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam(value = "orgName", required = false) String orgName,
                                        @RequestParam(value = "type", required = false) String type,
                                        @RequestParam(value = "levelId", required = false) String levelId) {
        Map<String, Object> map = service.query(orgName, type, levelId, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }


    /**
     * 查询单个外协单位保密资质
     *
     * @return
     */
    @ApiOperation(value = "查询单个外协单位保密资质详情{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDetail(@PathVariable("id") String id) {
        Bm2KeepsecretqualificationstatisticTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加外协单位保密资质
     *
     * @return
     * @Param file 下载文件
     * @Param icon 图标
     * @Param picture 截图
     */
    @SystemLog(module="外协单位保密资质管理",methods="增加外协单位保密资质")
    @ApiOperation(value = "增加外协单位保密资质{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam(value = "picture", required = false) MultipartFile picture,
                                      @RequestParam("data") String data) throws IOException {
        Bm2KeepsecretqualificationstatisticTbl info = JSON.parseObject(data, Bm2KeepsecretqualificationstatisticTbl.class);
        service.add(info, file, picture);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改外协单位保密资质
     *
     * @return
     */
    @SystemLog(module="外协单位保密资质管理",methods="修改外协单位保密资质")
    @ApiOperation(value = "修改外协单位保密资质{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @RequestParam(value = "picture", required = false) MultipartFile picture,
                                         @RequestParam("data") String data) throws IOException {
        Bm2KeepsecretqualificationstatisticTbl info = JSON.parseObject(data, Bm2KeepsecretqualificationstatisticTbl.class);
        service.update(info, file, picture);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除外协单位保密资质
     *
     * @return
     */
    @SystemLog(module="外协单位保密资质管理",methods="删除外协单位保密资质")
    @ApiOperation(value = "删除外协单位保密资质{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.deleteDetail(id);
        }
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
    public ResponseEntity<Object> exportLog(HttpServletResponse response,
                                            @RequestParam(value = "orgName", required = false) String orgName,
                                            @RequestParam(value = "type", required = false) String type,
                                            @RequestParam(value = "levelId", required = false) String levelId) {
        List<Bm2KeepsecretqualificationstatisticTbl> list = service.exportExcel(orgName, type, levelId);
        MyExcelExportUtil.exportExcel(list, Bm2KeepsecretqualificationstatisticTbl.class, "外协单位保密资质管理", "外协单位保密资质", response);
        return ResponseEntity.ok("导出成功");
    }


}