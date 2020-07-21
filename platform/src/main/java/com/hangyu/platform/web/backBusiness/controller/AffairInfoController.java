package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoTbl;
import com.hangyu.platform.web.backBusiness.service.AffairInfoService;
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

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 外事活动报备管理
 *
 * @auther liuXuan
 * @date 2020/2/11
 */
@Api(tags = "外事活动报备管理相关接口")
@RestController
@RequestMapping(value = "v1/affairInfo")
public class AffairInfoController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private AffairInfoService service;

    /**
     * 查询所有外事活动报备管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有外事活动报备{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "orgName",required = false) String orgName,
                                                                  @RequestParam("pageNum") int pageNum,
                                                                  @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(orgName,pageNum,pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个外事活动报备管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个外事活动报备{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        AffairsexerciseinfoTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加外事活动报备管理
     *
     * @return
     */
    @SystemLog(module="外事活动报备管理管理",methods="增加外事活动报备管理")
    @ApiOperation(value = "增加外事活动报备author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody AffairsexerciseinfoTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改外事活动报备管理
     *
     * @return
     */
    @SystemLog(module="外事活动报备管理管理",methods="修改外事活动报备管理")
    @ApiOperation(value = "修改外事活动报备{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody AffairsexerciseinfoTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除外事活动报备管理
     *
     * @return
     */
    @SystemLog(module="外事活动报备管理管理",methods="删除外事活动报备管理")
    @ApiOperation(value = "删除外事活动报备{author:liuxuan}", response = Result.class)
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
     * @param orgId
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.GET)
    @ApiOperation(value = "导出excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response, @RequestParam(value = "orgId",required = false) String orgId) {
        List<AffairsexerciseinfoTbl> list = service.exportExcel(orgId);
        MyExcelExportUtil.exportExcel(list, AffairsexerciseinfoTbl.class, "外事活动报备管理", "外事活动报备管理", response);
        return ResponseEntity.ok("导出成功");
    }

}