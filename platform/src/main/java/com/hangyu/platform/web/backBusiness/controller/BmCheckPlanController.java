package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanfinalTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import com.hangyu.platform.web.backBusiness.service.BmCheckPlanService;
import com.hangyu.platform.web.backBusiness.vo.CheckPlanQueryVO;
import com.hangyu.platform.web.sysAdmin.dto.Bm2LeaveTypeTbl;
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
 * 在线检查管理
 *
 * @auther liuXuan
 * @date 2020/2/19
 */
@Api(tags = "在线检查管理相关接口")
@RestController
@RequestMapping(value = "v1/bmCheckPlan")
public class BmCheckPlanController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmCheckPlanService service;

    /**
     * 查询所有在线检查管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有在线检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody CheckPlanQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个在线检查管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个在线检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmCheckplanTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加在线检查管理
     *
     * @return
     */
    @SystemLog(module="在线检查管理管理",methods="增加在线检查管理")
    @ApiOperation(value = "增加在线检查author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody BmCheckplanTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改在线检查管理
     *
     * @return
     */
    @SystemLog(module="在线检查管理管理",methods="修改在线检查管理")
    @ApiOperation(value = "修改在线检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody BmCheckplanTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除在线检查管理
     *
     * @return
     */
    @SystemLog(module="在线检查管理管理",methods="删除在线检查管理")
    @ApiOperation(value = "删除在线检查{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }


    /**
     * 查询被检查人员首页
     *
     * @return
     */
    @ApiOperation(value = "查询被检查人员首页{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryCheckUser/{planId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCheckUser(@PathVariable("planId") String planId,
                                                 @RequestParam("pageNum") int pageNum,
                                                 @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.queryCheckUser(planId, pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询被检查人员第二层
     *
     * @return
     */
    @ApiOperation(value = "查询被检查人员第二层{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryCheckUserDetail/{planId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCheckUserDetail(@PathVariable("planId") String planId,
                                                       @RequestParam("orgId") String orgId) {
        List<BmCheckplanpeasonTbl> list = service.queryCheckUserDetail(planId, orgId);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询未签到情况详情
     *
     * @return
     */
    @ApiOperation(value = "查询未签到情况详情{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryNotCheckDetail/{Id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryNotCheckDetail(@PathVariable("Id") Integer Id) {
        BmCheckplanpeasonTbl tbl = service.queryNotCheckDetail(Id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询未签到情况更新
     *
     * @return
     */
    @ApiOperation(value = "查询未签到情况更新{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateNotCheck", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateNotCheck(@RequestBody BmCheckplanpeasonTbl tbl) {
        service.updateNotCheck(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询未签到类型
     *
     * @return
     */
    @ApiOperation(value = "查询未签到类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryLeaveType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryLeaveType() {
        List<Bm2LeaveTypeTbl> tbl = service.queryLeaveType();
        return ResponseEntity.ok(tbl);
    }


//    /**
//     * 检查结果查看
//     *
//     * @return
//     */
//    @ApiOperation(value = "检查结果查看{author:liuxuan}", response = Result.class)
//    @RequestMapping(value = "queryCheckResult", method = RequestMethod.GET)
//    public ResponseEntity<Object> queryCheckResult( @RequestParam("planId") String planId,
//                                                                                         @RequestParam("userId") String userId) {
//        List<BmCheckplanfinalTbl> tbl = service.queryCheckResult(planId,userId);
//        return ResponseEntity.ok(tbl);
//    }
}