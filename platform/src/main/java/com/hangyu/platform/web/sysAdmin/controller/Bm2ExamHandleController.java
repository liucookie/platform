package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2ExaminestandardhandleTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2ExamHandleService;
import com.hangyu.platform.web.sysAdmin.vo.ExamHandleQueryVO;
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
 * 考核处理措施管理
 */
@RestController
@RequestMapping("v1/examHandle/")
@Api(tags = "考核处理措施管理")
public class Bm2ExamHandleController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2ExamHandleService service;

    /**
     * 查询考核处理措施
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询所有考核处理措施{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody ExamHandleQueryVO vo) {
        Map<String,Object> map = service.query(vo);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询考核处理措施
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个考核处理措施{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        Bm2ExaminestandardhandleTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加考核处理措施
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加考核处理措施{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody Bm2ExaminestandardhandleTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改考核处理措施
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改考核处理措施{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Bm2ExaminestandardhandleTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除考核处理措施
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除考核处理措施{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        service.deleteType(list);
        return ResponseEntity.ok(result);
    }

}
