package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.RemovereasonTbl;
import com.hangyu.platform.web.sysAdmin.service.RemoveReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "国家秘密事项解除审批表解除理由")
@RequestMapping("/v1/RemoveSeason")
@RestController
public class RemoveReasonController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private RemoveReasonService removeReasonService;

    /**
     * 单条信息查询
     * @param id
     * @return
     */
    @ApiOperation(value = "单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("id") int id){
        return ResponseEntity.ok(removeReasonService.select(id));
    }

    /**
     * 批量查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "批量查询",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return ResponseEntity.ok(removeReasonService.selectAll(pageNum,pageSize));
    }

    /**
     * 添加信息
     * @param removereasonTbl
     * @return
     */
    @ApiOperation(value = "添加信息",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody RemovereasonTbl removereasonTbl){
        removeReasonService.insert(removereasonTbl);
        return  ResponseEntity.ok(result);
    }

    /**
     * 删除信息
     * @param list
     * @return
     */
    @ApiOperation(value = "删除信息",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("id") List<Integer> list){
        removeReasonService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信息
     * @param removereasonTbl
     * @return
     */
    @ApiOperation(value = "修改信息",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody RemovereasonTbl removereasonTbl){
        removeReasonService.update(removereasonTbl);
        return ResponseEntity.ok(result);
    }

}
