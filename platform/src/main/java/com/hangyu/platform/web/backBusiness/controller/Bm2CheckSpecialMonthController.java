package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2CheckspecialplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2CheckSpecialMonthService;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
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

import java.util.List;
import java.util.Map;

/**
 * 部门专项检查管理
 *
 * @auther liuXuan
 * @date 2020/2/20
 */
@Api(tags = "部门专项检查管理相关接口")
@RestController
@RequestMapping(value = "v1/checkSpecialMonth")
public class Bm2CheckSpecialMonthController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2CheckSpecialMonthService service;

    /**
     * 查询所有部门专项检查管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有部门专项检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "year", required = false) String year,
                                        @RequestParam(value = "month", required = false) String month,
                                        @RequestParam(value = "status", required = false) String status,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(month, year, status, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询部门专项检查管理（根据月份查询详细的计划）
     *
     * @return
     */
    @ApiOperation(value = "查询部门下的专项检查（根据月份查询详细的计划）{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryPlan", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody CheckPlanQueryVO vo) {
        Map<String, Object> tbl = service.queryByMonthId(vo);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询检查内容
     *
     * @return
     */
    @ApiOperation(value = "查询检查内容{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryCheckDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCheckDetail(@PathVariable("id") String id) {
        Bm2CheckspecialplanTbl tbl = service.queryCheckDetail(id);
        return ResponseEntity.ok(tbl);
    }
    /**
     * 查询所有的检查类别
     *
     * @return
     */
    @ApiOperation(value = "查询所有的检查类别{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllCheckType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllCheckType() {
        List<Bm2CheckspecialtypeTbl> tbl = service.queryAllType();
        return ResponseEntity.ok(tbl);
    }


}