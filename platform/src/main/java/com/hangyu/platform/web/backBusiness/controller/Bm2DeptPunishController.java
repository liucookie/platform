package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.service.Bm2DeptPunishService;
import com.hangyu.platform.web.backBusiness.vo.DeptPunishQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 二级部门考核处罚管理
 *
 * @auther liuXuan
 * @date 2020/2/21
 */
@Api(tags = "二级部门考核处罚管理相关接口")
@RestController
@RequestMapping(value = "v1/deptPunish")
public class Bm2DeptPunishController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private Bm2DeptPunishService service;

    /**
     * 查询所有二级部门考核处罚管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有二级部门考核处罚{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody DeptPunishQueryVO vo) {
        Map<String, Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个二级部门考核处罚管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个二级部门考核处罚{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        Bm2DeptcheckresultTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加二级部门考核处罚管理
     *
     * @return
     */
    @SystemLog(module="二级部门考核处罚管理管理",methods="增加二级部门考核处罚管理")
    @ApiOperation(value = "增加二级部门考核处罚author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2DeptcheckresultTbl info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改二级部门考核处罚管理
     *
     * @return
     */
    @SystemLog(module="二级部门考核处罚管理管理",methods="修改二级部门考核处罚管理")
    @ApiOperation(value = "修改二级部门考核处罚{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2DeptcheckresultTbl info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除二级部门考核处罚管理
     *
     * @return
     */
    @SystemLog(module="二级部门考核处罚管理管理",methods="删除二级部门考核处罚管理")
    @ApiOperation(value = "删除二级部门考核处罚{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }




}