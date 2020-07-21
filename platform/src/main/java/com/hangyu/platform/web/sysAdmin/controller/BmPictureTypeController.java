package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.BmPicturetypeTbl;
import com.hangyu.platform.web.sysAdmin.service.BmPictureTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = "图片资源类别管理")
@RestController
@RequestMapping(value = "/v1/BMPictureType")
public class BmPictureTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private BmPictureTypeService bmPictureTypeService;

    /**
     * 图片资源类别管理批量查询
     */
    @ApiOperation(value = "图片资源类别管理批量查询",response = Result.class)
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public ResponseEntity<Object> selectAll(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String,Object> map = bmPictureTypeService.selectAll(pageNum,pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 图片资源类别管理单条查询(将单条信息填充到修改输入框)
     */
    @ApiOperation(value = "图片资源类别管理单条查询",response = Result.class)
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResponseEntity<Object> select(@RequestParam("uniqueid")  String uniqueid){
        return  ResponseEntity.ok(bmPictureTypeService.select(uniqueid));
    }

    /**
     * 图片资源类别管理添加
     */
    @ApiOperation(value = "图片资源类别管理添加",response = Result.class)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody BmPicturetypeTbl bmPicturetypeTbl){
        bmPictureTypeService.insert(bmPicturetypeTbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 图片资源类别管理删除
     */
    @ApiOperation(value = "图片资源类别管理删除",response = Result.class)
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("uniqueid") List<String> list){
        bmPictureTypeService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 图片资源类别管理删修改
     */
    @ApiOperation(value = "图片资源类别管理删修改",response = Result.class)
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody BmPicturetypeTbl bmPicturetypeTbl){
        bmPictureTypeService.update(bmPicturetypeTbl);
        return ResponseEntity.ok(result);
    }

}
