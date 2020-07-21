package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.TblExam;
import com.hangyu.platform.web.backBusiness.dto.TblTest;
import com.hangyu.platform.web.backBusiness.service.TblExamService;
import com.hangyu.platform.web.backBusiness.vo.ExamBody;
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
 * 试卷管理
 *
 * @auther liuXuan
 * @date 2020/4/8
 */
@Api(tags = "试卷管理相关接口")
@RestController
@RequestMapping(value = "v1/exam")
public class TblExamController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private TblExamService examService;

    /**
     * 查询所有试卷管理
     *
     * @return
     */
    @ApiOperation(value = "查询所有试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "minScore", required = false) Integer minScore,
                                        @RequestParam(value = "maxScore", required = false) Integer maxScore,
                                        @RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = examService.query(name, minScore,maxScore, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个试卷管理
     *
     * @return
     */
    @ApiOperation(value = "查询单个试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") int id) {
        TblExam tbl = examService.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询所有的试卷
     *
     * @return
     */
    @ApiOperation(value = "查询所有的试卷(添加考试计划查询用){author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllExam", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllExam() {
        List<TblExam> tbl = examService.queryAllExam();
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查看试卷里的试题
     *  id  试卷id
     * @return
     */
    @ApiOperation(value = "查看试卷里的试题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTest/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTest(@PathVariable("id") int id) {
        List<TblTest> tbl = examService.queryTest(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 自测考试随机抽题
     *
     * @return
     */
    @ApiOperation(value = "自测/新员工考试随机抽题{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "randomExam/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> randomExam(@PathVariable("userId") String userId,
                                             @RequestParam(value = "isNewStaff",required = false) Integer isNewStaff) {
        Map<String,Object>  tbl = examService.randomExam(userId,isNewStaff);
        return ResponseEntity.ok(tbl);
    }



    /**
     * 提交试卷，答卷
     *
     * @return
     */
    @ApiOperation(value = "提交试卷，答卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "handExam", method = RequestMethod.POST)
    public ResponseEntity<Object> handExam(@RequestBody ExamBody examBody) {
        Map<String,Object>  tbl = examService.handExam(examBody);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查看考试计划（首页），进入考试
     * @return
     */
    @ApiOperation(value = "查看考试计划（首页），进入考试{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "planExam/{planId}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> planExam(@PathVariable("planId") int planId,@PathVariable("userId") String userId) {
        Map<String,Object>  tbl = examService.planExam(planId,userId);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查看试卷记录，已经答过的考卷
     * @return
     */
    @ApiOperation(value = "查看试卷记录，已经答过的考卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryExamDetail/{examineeId}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryExamDetail(@PathVariable("examineeId") int examineeId,@PathVariable("userId") String userId) {
        Map<String,Object>  tbl = examService.queryExamDetail(examineeId,userId);
        return ResponseEntity.ok(tbl);
    }



    /**
     * 增加试卷管理
     *
     * @return
     */
    @SystemLog(module="试卷管理管理",methods="增加试卷")
    @ApiOperation(value = "增加试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody TblExam info) {
        examService.add(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改试卷管理
     *
     * @return
     */
    @SystemLog(module="试卷管理管理",methods="修改试卷")
    @ApiOperation(value = "修改试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody TblExam info) {
        examService.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除试卷管理
     *
     * @return
     */
    @SystemLog(module="试卷管理管理",methods="删除试卷")
    @ApiOperation(value = "删除试卷{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<Integer> list) {
        list.forEach(id -> {
            examService.delete(id);
        });
        return ResponseEntity.ok(result);
    }


}