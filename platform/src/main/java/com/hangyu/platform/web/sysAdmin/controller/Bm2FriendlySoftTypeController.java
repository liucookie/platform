package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FriendlySoftTypeTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2FriendlySoftTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/Bm2FriendSoftType")
@Api(tags = "软件白名单类型管理")
public class Bm2FriendlySoftTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private Bm2FriendlySoftTypeService bm2FriendlysofttypeService;

    /**
     * 软件白名单类型管理批量查询
     */
    @ApiOperation(value = "软件白名单类型管理批量查询",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map=bm2FriendlysofttypeService.selectAll(pageNum,pageSize);
        return  ResponseEntity.ok(map);
    }

    /**
     * 软件白名单管理添加
     */
    @ApiOperation(value = "软件白名单管理添加",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl){
        bm2FriendlysofttypeService.insert(bm2FriendlysofttypeTbl);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 软件白名单管理删除(支持批量删除)
     */
    @ApiOperation(value = "软件白名单管理删除",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("list") List<String> list){
        bm2FriendlysofttypeService.delete(list);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 软件白名单单条查询
     */
    @ApiOperation(value = "软件白名单单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("typeid") String typeid){
        return  ResponseEntity.ok(bm2FriendlysofttypeService.select(typeid));
    }

    /**
     * 软件白名单管理修改
     */
    @ApiOperation(value = "软件白名单管理修改",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl){
        bm2FriendlysofttypeService.update(bm2FriendlysofttypeTbl);
        return  ResponseEntity.ok(result);
    }

}
