package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfTypeTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2CheckSelfTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "保密自查类型配置")
@RequestMapping("/v1/Bm2CheckSelfType")
@RestController
public class Bm2CheckSelfTypeController {

    Result  result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private Bm2CheckSelfTypeService bm2CheckselftypeService;

    /**
     * 保密自查批量查询
     */
    @ApiOperation(value = "保密自查类型配批量查询",response = Result.class)
    @RequestMapping(value = "/SelectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map = bm2CheckselftypeService.selectAll(pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 保密自查条件查询
     */
    @ApiOperation(value = "保密自查类型条件查询",response = Result.class)
    @RequestMapping(value = "/factorSelect",method = RequestMethod.POST)
    public ResponseEntity<Object> factorSelect(@RequestParam("typename") String typename,
                                                          @RequestParam("createtime") String createtime,
                                                          @RequestParam("endtime") String endtime,
                                                          @RequestParam(value = "isinvolve") int isinvolve,
                                                          @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                          @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map = bm2CheckselftypeService.factorSelect(typename,createtime,endtime,isinvolve,pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 保密自查添加
     */
    @ApiOperation(value = "保密自查类型添加",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Bm2CheckSelfTypeTbl bm2CheckselftypeTbl){
        bm2CheckselftypeService.insert(bm2CheckselftypeTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 保密自查删除
     */
    @ApiOperation(value = "保密自查类型删除",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("list") List<String> list){
        bm2CheckselftypeService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 保密自查单条查询
     */
    @ApiOperation(value = "保密自查单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("typeid") String typeid){
        return ResponseEntity.ok(bm2CheckselftypeService.select(typeid));
    }

    /**
     * 保密自查修改
     */
    @ApiOperation(value = "保密自查类型修改",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2CheckSelfTypeTbl bm2CheckselftypeTbl){
        bm2CheckselftypeService.update(bm2CheckselftypeTbl);
        return ResponseEntity.ok(result);
    }

}
