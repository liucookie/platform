package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Connectwaytypelist;
import com.hangyu.platform.web.sysAdmin.service.ConnectWayTypeListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "通讯录管理表")
@RequestMapping("/v1/ConnectWayTypeList")
@RestController
public class ConnectWayTypeListController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private ConnectWayTypeListService connectWayTypeListService;

    /**
     * 单条查询
     * @param id
     * @return
     */
    @ApiOperation(value = "单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("id") int id){
        return ResponseEntity.ok(connectWayTypeListService.select(id));
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
        Map<String,Object> map = connectWayTypeListService.selectAll(pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 条件模糊查询
     * @param pageNum
     * @param pageSize
     * @param typename
     * @return
     */
    @ApiOperation(value = "条件模糊查询",response = Result.class)
    @RequestMapping(value = "/factorSelect",method = RequestMethod.POST)
    public ResponseEntity<Object> factorSelect(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                               @RequestParam("typename") String typename){
        Map<String,Object> map = connectWayTypeListService.factorSelect(pageNum,pageSize,typename);
        return ResponseEntity.ok(map);
    }

    /**
     * 添加信息
     * @param connectwaytypelist
     * @return
     */
    @ApiOperation(value = "添加信息",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Connectwaytypelist connectwaytypelist){
        connectWayTypeListService.insert(connectwaytypelist);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除信息
     * @param list
     * @return
     */
    @ApiOperation(value = "删除信息",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("id") List<Integer> list){
        connectWayTypeListService.delete(list);
        return  ResponseEntity.ok(result);
    }

    /**
     * 修改信息
     * @param connectwaytypelist
     * @return
     */
    @ApiOperation(value = "修改信息",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Connectwaytypelist connectwaytypelist){
        connectWayTypeListService.update(connectwaytypelist);
        return ResponseEntity.ok(result);
    }

}
