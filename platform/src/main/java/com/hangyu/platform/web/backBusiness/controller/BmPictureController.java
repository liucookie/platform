package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmPictureTbl;
import com.hangyu.platform.web.backBusiness.service.BmPictureService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 图片资源管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/2
 */
@Api(tags = "图片资源管理相关接口")
@RestController
@RequestMapping(value = "v1/pictureManage")
public class BmPictureController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmPictureService service;

    /**
     * 查询所有图片资源
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有图片资源{author:lx}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize) {
        Map<String, Object> type = service.query(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询类别id查询所有图片资源
     *
     * @param typeId
     * @return
     */
    @ApiOperation(value = "查询类别id查询所有图片资源{author:lx}", response = Result.class)
    @RequestMapping(value = "queryByTypeId/{typeId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryByTypeId(@PathVariable("typeId") String typeId) {
        List<BmPictureTbl> type = service.queryByTypeId(typeId);
        return ResponseEntity.ok(type);
    }


    /**
     * 查询单个图片资源
     *
     * @return
     */
    @ApiOperation(value = "查询单个图片资源{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        BmPictureTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加图片资源
     *
     * @return
     */
    @SystemLog(module="图片资源管理",methods="增加图片资源")
    @ApiOperation(value = "增加图片资源{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(
            @RequestParam(value = "picture", required = false) MultipartFile picture,
            @RequestParam("data") String data) throws IOException {
        BmPictureTbl info = JSON.parseObject(data, BmPictureTbl.class);
        service.add(info, picture);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改图片资源
     *
     * @return
     */
    @SystemLog(module="图片资源管理",methods="修改图片资源")
    @ApiOperation(value = "修改图片资源{author:lx}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(
            @RequestParam(value = "picture", required = false) MultipartFile picture,
            @RequestParam("data") String data) throws IOException {
        BmPictureTbl info = JSON.parseObject(data, BmPictureTbl.class);
        service.update(info, picture);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除图片资源
     *
     * @return
     */
    @SystemLog(module="图片资源管理",methods="删除图片资源")
    @ApiOperation(value = "删除图片资源{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.delete(id);
        }
        return ResponseEntity.ok(result);
    }


}