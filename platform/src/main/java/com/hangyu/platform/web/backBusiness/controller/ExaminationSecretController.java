package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.ExaminationsecretTbl;
import com.hangyu.platform.web.backBusiness.service.ExaminationSecretService;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
import com.hangyu.platform.web.backBusiness.vo.CheckResultVO;
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

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 涉密人员每月考核审批 管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/5/18
 */
@Api(tags = "涉密人员每月考核审批管理相关接口")
@RestController
@RequestMapping(value = "v1/examSecretUser")
public class ExaminationSecretController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private ExaminationSecretService service;

    /**
     * 查询单个涉密人员每月考核审批
     *
     * @return
     */
    @ApiOperation(value = "查询单个涉密人员每月考核审批{author:lx}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        ExaminationsecretTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询涉密人员考核
     *
     * @return
     */
    @ApiOperation(value = "查询涉密人员考核{author:lx}", response = Result.class)
    @RequestMapping(value = "queryCheck", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCheck(@RequestParam("year") String year,@RequestParam("month") String month) {
        List<CheckResultVO> tbl = service.queryCheck(year,month);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询涉密人员数量
     *
     * @return
     */
    @ApiOperation(value = "查询涉密人员数量{author:lx}", response = Result.class)
    @RequestMapping(value = "queryCount", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCount() {
        Map<String, String> map = service.queryCount();
        return ResponseEntity.ok(map);
    }

    /**
     * 增加涉密人员每月考核审批
     *
     * @return
     */
    @SystemLog(module="涉密人员每月考核审批管理",methods="增加涉密人员每月考核")
    @ApiOperation(value = "增加涉密人员每月考核审批{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody ExaminationsecretTbl info) throws IOException {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 处理涉密人员每月考核审批
     * isapprove   1同意，0不同意
     *
     * @return
     */
    @SystemLog(module="涉密人员每月考核审批管理",methods="处理涉密人员每月考核审批 ")
    @ApiOperation(value = "处理涉密人员每月考核审批 author:lx}", response = Result.class)
    @RequestMapping(value = "deal", method = RequestMethod.PUT)
    public ResponseEntity<Object> deal(@RequestBody ApproveVO info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

}