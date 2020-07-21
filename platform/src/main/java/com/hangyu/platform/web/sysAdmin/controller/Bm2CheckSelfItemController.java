package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckSelfItemTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2CheckSelfItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "保密自查检查项配置")
@RequestMapping("/v1/Bm2CheckSelfItem")
@RestController
public class Bm2CheckSelfItemController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private Bm2CheckSelfItemService bm2CheckselfitemService;

    /**
     * 保密自查检查项批量查询
     */
    @ApiOperation(value = "保密自查检查项批量查询",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
       Map<String,Object> map = bm2CheckselfitemService.selectAll(pageNum,pageSize);
       return ResponseEntity.ok(map);
    }

    /**
     * 保密自查检查项条件查询
     */
    @ApiOperation(value = "保密自查检查项条件查询",response = Result.class)
    @RequestMapping(value = "/factorSelect",method = RequestMethod.POST)
    public ResponseEntity<Object> factorSelect(@RequestParam("itemname") String itemname,
                                               @RequestParam("createtime") String createtime,
                                               @RequestParam("endtime") String endtime,
                                               @RequestParam("typeid") String typeid,
                                               @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map = bm2CheckselfitemService.factorSelect(itemname,createtime,endtime,typeid,pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询保密自查类型名和id
     */
    @ApiOperation(value = "查询保密自查类型名和id",response = Result.class)
    @RequestMapping(value = "/typeSelect",method = RequestMethod.GET)
    public ResponseEntity<Object> typeSelect(){
        return ResponseEntity.ok(bm2CheckselfitemService.typeSelect());
    }

    /**
     * 保密自查检查项添加
     */
    @ApiOperation(value = "保密自查检查项添加",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Bm2CheckSelfItemTbl bm2CheckselfitemTbl){
        bm2CheckselfitemService.insert(bm2CheckselfitemTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 保密自查检查项删除
     */
    @ApiOperation(value = "保密自查检查项删除",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("list") List<String> list){
        bm2CheckselfitemService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询单条信息
     */
    @ApiOperation(value = "查询单条信息",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("itemid") String itemid){
        return ResponseEntity.ok(bm2CheckselfitemService.select(itemid));
    }

    /**
     * 保密自查检查项修改
     */
    @ApiOperation(value = "保密自查检查项修改",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2CheckSelfItemTbl bm2CheckselfitemTbl){
        bm2CheckselfitemService.update(bm2CheckselfitemTbl);
        return ResponseEntity.ok(result);
    }

}
