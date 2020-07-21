package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.TechnologythesissecrecyTbl;
import com.hangyu.platform.web.backBusiness.service.TechnologyCheckService;
import com.hangyu.platform.web.backBusiness.vo.ApproveVO;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 科技论文保密审查 管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/5/19
 */
@Api(tags = "科技论文保密审查管理相关接口")
@RestController
@RequestMapping(value = "v1/technologyCheck")
public class TechnologyCheckController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private TechnologyCheckService service;

    /**
     * 查询单个科技论文保密审查
     *
     * @return
     */
    @ApiOperation(value = "查询单个科技论文保密审查{author:lx}", response = Result.class)
    @RequestMapping(value = "query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@PathVariable("id") String id) {
        TechnologythesissecrecyTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加科技论文保密审查
     *
     * @return
     */
    @SystemLog(module="科技论文保密审查管理",methods="增加馆藏文件变更")
    @ApiOperation(value = "增加科技论文保密审查{author:lx}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("data") String data) throws IOException {
        TechnologythesissecrecyTbl info = JSON.parseObject(data, TechnologythesissecrecyTbl.class);
        service.add(info, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 处理科技论文保密审查
     * isapprove   1同意，0不同意
     * @return
     */
    @SystemLog(module="科技论文保密审查管理",methods="处理科技论文保密审查 ")
    @ApiOperation(value = "处理科技论文保密审查 author:lx}", response = Result.class)
    @RequestMapping(value = "deal", method = RequestMethod.PUT)
    public ResponseEntity<Object> deal(@RequestBody ApproveVO info) throws IOException {
        service.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 模板下载
     *
     * @param
     * @return
     */
    @ApiOperation(value = "模板下载{author:acc}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String fileName = "五院发表国际论文审批表（公开）.doc";
        FileUtils.download(response, CommonFields.getTemplateFilePath(),fileName);
        return ResponseEntity.ok(result);
    }

}