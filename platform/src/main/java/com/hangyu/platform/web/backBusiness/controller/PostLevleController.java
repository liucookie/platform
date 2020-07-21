package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.PostsecretlevelTbl;
import com.hangyu.platform.web.backBusiness.service.PostLevelService;
import com.hangyu.platform.web.backBusiness.vo.PostLevelQueryVO;
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
import java.util.List;
import java.util.Map;

/**
 * 岗位密级管理
 */
@RestController
@RequestMapping("v1/postLevel/")
@Api(tags = "岗位密级管理")
public class PostLevleController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private PostLevelService service;

    /**
     * 查询所有岗位密级
     *
     * @return
     */
    @ApiOperation(value = "查询所有岗位密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody PostLevelQueryVO vo) {
        Map<String, Object> type = service.queryType(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询所有岗位密级名称（下拉用）
     *
     * @return
     */
    @ApiOperation(value = "查询所有岗位密级名称（下拉用）{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    public ResponseEntity<Object> queryName(@RequestParam(value = "orgId",required = false) String orgId) {
        List<PostsecretlevelTbl> type = service.queryName(orgId);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询岗位密级
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个岗位密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeById(@PathVariable("id") String id) {
        PostsecretlevelTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加岗位密级
     *
     * @param type
     * @return
     */
    @SystemLog(module = "岗位密级管理", methods = "增加岗位密级")
    @ApiOperation(value = "增加岗位密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody PostsecretlevelTbl type) {
        service.add(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改岗位密级
     *
     * @param type
     * @return
     */
    @SystemLog(module = "岗位密级管理", methods = "修改岗位密级")
    @ApiOperation(value = "修改岗位密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody PostsecretlevelTbl type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除岗位密级
     *
     * @param list
     * @return
     */
    @SystemLog(module = "岗位密级管理", methods = "删除岗位密级")
    @ApiOperation(value = "删除岗位密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        list.forEach(id -> {
            service.delete(id);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 模板下载
     *
     * @param
     * @return
     */
    @ApiOperation(value = "模板下载{author:lx}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String fileName = "岗位密级.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }


    /**
     * 导入
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ApiOperation(value = "导入{author:lx}", response = Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }


}
