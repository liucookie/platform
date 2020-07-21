package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import com.hangyu.platform.web.backBusiness.dto.TblDataset;
import com.hangyu.platform.web.backBusiness.dto.TblExam;
import com.hangyu.platform.web.backBusiness.dto.TblPlan;
import com.hangyu.platform.web.backBusiness.dto.TblPlanexaminee;
import com.hangyu.platform.web.backBusiness.service.TblExamPlanService;
import com.hangyu.platform.web.backBusiness.vo.ComputerQueryVO;
import com.hangyu.platform.web.backBusiness.vo.ExamResultVO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考试计划管理
 *
 * @auther liuXuan
 * @date 2020/4/9
 */
@Api(tags = "考试计划管理相关接口")
@RestController
@RequestMapping(value = "v1/examPlan")
public class TblExamPlanController {


    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private TblExamPlanService service;

    /**
     * 查询所有考试计划管理
     * <p>
     * status 0. 未开始，1进行中 2已结束
     *
     * @return
     */
    @ApiOperation(value = "查询所有考试计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "startDate", required = false) String startDate,
                                        @RequestParam(value = "endDate", required = false) String endDate,
                                        @RequestParam(value = "status", required = false) Integer status,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = service.query(name, startDate, endDate, status, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }


    /**
     * 查询自测试卷
     * @param examName  试卷名称
     * @param userName  用户名称
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param status 状态 0不及格 1及格 2 良好 3 优秀 4未考试
     * @param isNewStaffExam 是否新员工考试 0不是，1是
     * @param isTest  是否自测考试  0不是，1是
     * @param pageNum 当前页
     * @param pageSize 条数
     * @return
     */
    @ApiOperation(value = "查询自测试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySelfTest", method = RequestMethod.GET)
    public ResponseEntity<Object> querySelfTest(@RequestParam(value = "examName", required = false) String examName,
                                                @RequestParam(value = "userName", required = false) String userName,
                                                @RequestParam(value = "startDate", required = false) String startDate,
                                                @RequestParam(value = "endDate", required = false) String endDate,
                                                @RequestParam(value = "status", required = false) Integer status,
                                                @RequestParam(value = "isNewStaffExam", required = false) Integer isNewStaffExam,
                                                @RequestParam(value = "isTest", required = false) Integer isTest,
                                                @RequestParam("pageNum") int pageNum,
                                                @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = service.querySelfTest(examName, userName,isNewStaffExam,isTest, startDate, endDate, status, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个考试计划管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个考试计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int id) {
        TblPlan tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询考试计划详情
     *
     * @return
     */
    @ApiOperation(value = "查询考试计划详情{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDetail(@PathVariable("id") int id) {
        TblPlan tbl = service.queryDetail(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询考试人员（第一层）
     * planId 计划id
     *
     * @return
     */
    @ApiOperation(value = "查询考试人员(第一层){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryFirstInfo/{planId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryFirstInfo(@PathVariable("planId") int planId) {
        List<ExamResultVO> tbl = service.queryFirstInfo(planId);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 导出文件
     * @param response
     * @param  planId 计划id
     * @return
     */
    @RequestMapping(value = "exportExcel/{planId}",method = RequestMethod.GET)
    @ApiOperation(value="导出excel{author:liuxuan}",response= Result.class)
    public ResponseEntity<Object> exportExcel(HttpServletResponse response, @PathVariable("planId") int planId){
        List<ExamResultVO> list = service.queryFirstInfo(planId);
        MyExcelExportUtil.exportExcel(list, ExamResultVO.class,"考试统计","考试统计",response);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询考试人员（第二层）
     * orgId 机构id
     *
     * @return
     */
    @ApiOperation(value = "查询考试人员(第二层){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySecondInfo/{orgId}", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecondInfo(@PathVariable("orgId") int orgId) {
        List<TblPlanexaminee> tbl = service.querySecondInfo(orgId);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询选择试卷（第一层）
     * planId 计划id
     *
     * @return
     */
    @ApiOperation(value = "查询选择试卷(第一层){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryFirstExam/{planId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryFirstExam(@PathVariable("planId") int planId) {
        TblExam tbl = service.queryFirstExam(planId);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询选择试卷（第二层）
     * planId 计划id
     * examId 试卷id
     *
     * @return
     */
    @ApiOperation(value = "查询选择试卷(第二层){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySecondExam/{planId}/{examId}", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecondExam(@PathVariable("planId") int planId,
                                                  @PathVariable("examId") int examId) {
        List<TblPlanexaminee> tbl = service.querySecondExam(planId, examId);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询及格率设置
     *
     * @return
     */
    @ApiOperation(value = "查询及格率设置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySet", method = RequestMethod.GET)
    public ResponseEntity<Object> querySet() {
        TblDataset set = service.querySet();
        return ResponseEntity.ok(set);
    }

    /**
     * 增加考试计划管理
     *
     * @return
     */
    @SystemLog(module="考试计划管理管理",methods="增加考试计划管理")
    @ApiOperation(value = "增加考试计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody TblPlan info) {
        service.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改考试计划管理
     *
     * @return
     */
    @SystemLog(module="考试计划管理管理",methods="修改考试计划管理")
    @ApiOperation(value = "修改考试计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody TblPlan info) {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除考试计划管理
     *
     * @return
     */
    @SystemLog(module="考试计划管理管理",methods="删除考试计划管理")
    @ApiOperation(value = "删除考试计划{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }


    /**
     * 查询个人计划考试列表（首页模块）
     *
     * @return
     */
    @ApiOperation(value = "查询个人计划考试列表（首页模块）{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryMyExam/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryMyExam(@PathVariable("userId") String userId) {
        List<TblPlan> list = service.queryMyExam(userId);
        return ResponseEntity.ok(list);
    }

}
