package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.ZptypeTbl;
import com.hangyu.platform.web.sysAdmin.service.ZpTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "展品类别管理")
@RequestMapping("/v1/zptype")
@RestController
public class ZpTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private ZpTypeService zpTypeService;

    /**
     * 单条查询
     * @param id
     * @return
     */
    @ApiOperation(value = "单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("id") int id){
        return ResponseEntity.ok(zpTypeService.select(id));
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
        Map<String,Object> map = zpTypeService.selectAll(pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 添加信息
     * @param zptypeTbl
     * @return
     */
    @ApiOperation(value = "添加信息",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody ZptypeTbl zptypeTbl){
        zpTypeService.insert(zptypeTbl);
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
        zpTypeService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信息
     * @param zptypeTbl
     * @return
     */
    @ApiOperation(value = "修改信息",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody ZptypeTbl zptypeTbl){
        zpTypeService.update(zptypeTbl);
        return ResponseEntity.ok(result);
    }

}
