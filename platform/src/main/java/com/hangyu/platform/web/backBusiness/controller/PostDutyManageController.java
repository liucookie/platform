package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.Yirenduogang;
import com.hangyu.platform.web.backBusiness.service.PostDutyManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api(tags = "岗位保密职责管理")
@RequestMapping("/v1/PostDutyManage")
@RestController
public class PostDutyManageController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Resource
    private PostDutyManageService yiRenDuoGangService;

    /**
     * 批量和条件查询
     *
     * @param post
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "批量和条件查询", response = Result.class)
    @RequestMapping(value = "/selectAllFactor", method = RequestMethod.GET)
    public ResponseEntity<Object> selectAllFactor(@RequestParam(value = "post",required = false) String post,
                                                  @RequestParam("pageNum") int pageNum,
                                                  @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(yiRenDuoGangService.selectAllFactor(post, pageNum, pageSize));
    }

    /**
     * 单条查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "单条查询", response = Result.class)
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> select(@PathVariable String id) {
        return ResponseEntity.ok(yiRenDuoGangService.select(id));
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除", response = Result.class)
    @SystemLog(module = "岗位保密职责管理", methods = "批量删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        yiRenDuoGangService.delete(list);
        return ResponseEntity.ok(result);
    }

    /**
     * 添加信息
     *
     * @param yirenduogang
     * @return
     */
    @ApiOperation(value = "添加信息", response = Result.class)
    @SystemLog(module = "岗位保密职责管理", methods = "添加信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestBody Yirenduogang yirenduogang) {
        yiRenDuoGangService.insert(yirenduogang);
        return ResponseEntity.ok(result);
    }

    /**
     * 信息修改
     *
     * @param yirenduogang
     * @return
     */
    @ApiOperation(value = "信息修改", response = Result.class)
    @SystemLog(module = "岗位保密职责管理", methods = "信息修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(@RequestBody Yirenduogang yirenduogang) {
        yiRenDuoGangService.update(yirenduogang);
        return ResponseEntity.ok(result);
    }

    /**
     * Excel数据导入
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "Excel数据导入", response = Result.class)
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public ResponseEntity<Object> importExcel(@RequestParam("File") MultipartFile file) {
        Result result = new Result(200, "导入成功！");
        yiRenDuoGangService.importExcel(file);
        return ResponseEntity.ok(result);
    }

    /**
     * 岗位职责模板下载
     *
     * @param response
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "岗位职责模板下载", response = Result.class)
    @RequestMapping(value = "/tempDownload", method = RequestMethod.GET)
    public ResponseEntity<Object> tempDownload(HttpServletResponse response) throws IOException {
        FileUtils.download(response, CommonFields.getTemplateFilePath(), "岗位职责.xls");
        return ResponseEntity.ok(result);
    }

}
