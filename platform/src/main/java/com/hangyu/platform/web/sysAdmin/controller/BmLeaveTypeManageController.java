package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2LeaveTypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmLeaveTypeManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "保密检查未签到类型管理")
@RestController
@RequestMapping(value = "/v1/BmLeaveTypeMana")
public class BmLeaveTypeManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private BmLeaveTypeManageService bmLeaveTypeManageService;

    /**
     * 保密检查未签到批量信息显示
     *LeaveTypeMode字段：1表示 “保密自查”，2表示 “计算机检查”
     */
    @ApiOperation(value = "保密检查未签到批量信息显示",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object>  selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map = bmLeaveTypeManageService.selectAll(pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 保密检查未签到类型管理单条信息查询
     */
    @ApiOperation(value = "保密检查未签到类型管理单条信息查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public ResponseEntity<Object>  select(@RequestParam("id") String id){
        List<Bm2LeaveTypeTbl> list = bmLeaveTypeManageService.select(id);
        return ResponseEntity.ok(list);
    }

    /**
     * 保密检查未签到类型管理信息添加
     */
    @ApiOperation(value = "保密检查未签到类型管理信息添加",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Bm2LeaveTypeTbl bm2LeavetypeTbl){
        bmLeaveTypeManageService.insert(bm2LeavetypeTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 保密检查未签到类型管理信息修改
     */
    @ApiOperation(value = "保密检查未签到类型管理信息修改",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object>  update(@RequestBody Bm2LeaveTypeTbl bm2LeavetypeTbl){
        //  测试使用  bm2LeavetypeTbl.setId("e93950ee-2307-11ea-802b-9cb6547d381f");
        bmLeaveTypeManageService.update(bm2LeavetypeTbl);
        return  ResponseEntity.ok(result);
    }

    /**
     * 保密检查未签到类型管理信息删除
     */
    @ApiOperation(value = "保密检查未签到类型管理信息删除",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("list") List<String> list){
        bmLeaveTypeManageService.delete(list);
        return ResponseEntity.ok(result);
    }

}
