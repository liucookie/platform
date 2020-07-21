package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.CreditscoreTbl;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.service.CreditScoreService;
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
 * 部门信誉/个人积分查看管理
 *
 * @auther liuXuan
 * @date 2020/2/28
 */
@Api(tags = "部门信誉/个人积分查看管理相关接口")
@RestController
@RequestMapping(value = "v1/creditScore")
public class CreditScoreController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private CreditScoreService service;

    /**
     * 查询所有部门信誉管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有部门信誉{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryDeptScore", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDeptScore(@RequestParam(value = "orgId", required = false) String orgId,
                                                 @RequestParam(value = "year", required = false) String year,
                                                 @RequestParam("pageNum") int pageNum,
                                                 @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.queryDeptScore(orgId, year, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询所有个人积分查看管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有涉密人员信誉{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryUserScore", method = RequestMethod.GET)
    public ResponseEntity<Object> queryUserScore(@RequestParam(value = "orgId", required = false) String orgId,
                                                 @RequestParam(value = "year", required = false) String year,
                                                 @RequestParam(value = "userId", required = false) String userId,
                                                 @RequestParam("pageNum") int pageNum,
                                                 @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.queryUserScore(orgId, userId, year, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询积分详情
     * type 1部门年度，2部门本月，3个人
     *
     * @return
     */
    @ApiOperation(value = "查询积分详情{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryScoreDetail/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryScoreDetail(@PathVariable("type") int type,
                                                  @RequestParam(value = "year", required = false) String year,
                                                 @RequestParam(value = "userId", required = false) String userId) {
        List<CreditscoreTbl> list = service.queryScoreDetail(type, userId, year);
        return ResponseEntity.ok(list);
    }

    /**
     * 导出文件
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "exportDeptExcel", method = RequestMethod.GET)
    @ApiOperation(value = "导出部门积分excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportDeptExcel(HttpServletResponse response, @RequestParam(value = "orgId", required = false) String orgId,
                                                  @RequestParam(value = "year", required = false) String year) {
        List<CreditscoreTbl> list = service.exportDeptExcel(orgId, year);
        MyExcelExportUtil.exportExcel(list, CreditscoreTbl.class, "部门信誉积分管理", "部门信誉积分", response);
        return ResponseEntity.ok("导出成功");
    }

    /**
     * 导出文件
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "exportUserExcel", method = RequestMethod.GET)
    @ApiOperation(value = "导出个人积分excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportUserExcel(HttpServletResponse response, @RequestParam(value = "orgId", required = false) String orgId,
                                                  @RequestParam(value = "year", required = false) String year,
                                                  @RequestParam(value = "userId", required = false) String userId) {
        List<CreditscoreTbl> list = service.exportUserExcel(orgId, year,userId);
        MyExcelExportUtil.exportExcel(list, CreditscoreTbl.class, "个人信誉积分管理", "个人信誉积分", response);
        return ResponseEntity.ok("导出成功");
    }



}