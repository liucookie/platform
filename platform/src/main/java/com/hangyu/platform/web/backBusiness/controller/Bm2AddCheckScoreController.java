package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrsultTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2AddCheckScoreService;
import com.hangyu.platform.web.backBusiness.service.Bm2CheckResultService;
import com.hangyu.platform.web.backBusiness.vo.DeptPunishQueryVO;
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
 * 信誉积分加分管理
 *
 * @auther liuXuan
 * @date 2020/2/26
 */
@Api(tags = "信誉积分加分管理相关接口")
@RestController
@RequestMapping(value = "v1/addCheckScore")
public class Bm2AddCheckScoreController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2AddCheckScoreService service;

    /**
     * 查询所有信誉积分加分管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有信誉积分加分{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody DeptPunishQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个信誉积分加分管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个信誉积分加分{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Bm2LocalcheckrsultTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 分院考核，加分明细
     *
     * @param deptId
     * @param userId
     * @param year
     * @param year
     * @return type 为1部门，2个人
     */
    @ApiOperation(value = "分院考核{author:lx}", response = Result.class)
    @RequestMapping(value = "queryPublishResult/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPublishResult(@RequestParam(value = "deptId", required = false) String deptId,
                                              @RequestParam(value = "userId", required = false) String userId,
                                              @RequestParam(value = "year", required = false) String year,
                                              @RequestParam(value = "month", required = false) String month,
                                              @PathVariable("type") int type) {
        List<Bm2LocalcheckrsultTbl> data = service.queryFengYuanCheck(year, deptId, userId,month,type);
        return ResponseEntity.ok(data);
    }

    /**
     * 加分明细
     *
     * @param deptId
     * @param userId
     * @param year
     * @param year
     * @return type 为1部门，2个人
     */
    @ApiOperation(value = "加分明细{author:lx}", response = Result.class)
    @RequestMapping(value = "queryAddResult/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAddResult(@RequestParam(value = "deptId", required = false) String deptId,
                                              @RequestParam(value = "userId", required = false) String userId,
                                              @RequestParam(value = "year", required = false) String year,
                                              @RequestParam(value = "month", required = false) String month,
                                              @PathVariable("type") int type) {
        List<Bm2LocalcheckrsultTbl> data = service.queryAddResult(year, deptId, userId,month,type);
        return ResponseEntity.ok(data);
    }

    /**
     * 部门考核
     *
     * @param deptId
     * @param userId
     * @param year
     * @param year
     * @return type 为1部门，2个人
     */
    @ApiOperation(value = "部门考核{author:lx}", response = Result.class)
    @RequestMapping(value = "queryDeptResult/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDeptResult(@RequestParam(value = "deptId", required = false) String deptId,
                                              @RequestParam(value = "userId", required = false) String userId,
                                              @RequestParam(value = "year", required = false) String year,
                                              @RequestParam(value = "month", required = false) String month,
                                              @PathVariable("type") int type) {
        List<Bm2DeptcheckresultTbl> data = service.queryDeptCheck(year, deptId, userId,month,type);
        return ResponseEntity.ok(data);
    }

    /**
     * 增加信誉积分加分管理
     *
     * @return
     */
    @SystemLog(module="信誉积分加分管理管理",methods="增加信誉积分加分管理")
    @ApiOperation(value = "增加信誉积分加分author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2LocalcheckrsultTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信誉积分加分管理
     *
     * @return
     */
    @SystemLog(module="信誉积分加分管理管理",methods="修改信誉积分加分管理")
    @ApiOperation(value = "修改信誉积分加分{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2LocalcheckrsultTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信誉积分加分管理
     *
     * @return
     */
    @SystemLog(module="信誉积分加分管理管理",methods="删除信誉积分加分管理")
    @ApiOperation(value = "删除信誉积分加分{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }


}