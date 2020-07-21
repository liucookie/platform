package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import com.hangyu.platform.web.backBusiness.service.BmSystemTblService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "保密制度管理相关接口")
@RequestMapping("/v1/bmSystemMessage")
public class BmSystemTblController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Value("${file.upload.path}")
    private String filePath;

    @Resource
    private BmSystemTblService bmSystemTblService;


    /**
     * 基本制度查询
     *
     * @param name
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有基本制度", response = Result.class)
    @RequestMapping(value = "/selectSystem", method = RequestMethod.GET)
    public ResponseEntity<Object> selectSystem(@RequestParam(value = "name", required = false) String name,
                                               @RequestParam("type") String type,
                                               @RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = bmSystemTblService.selectSystem(name, type, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 单个基本制度查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "单个基本制度查询{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        BmSystemTbl tbl = bmSystemTblService.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询历史保密制度
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询历史保密制度{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryHistory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryHistory(@PathVariable("id") String id) {
        List<BmSystemTbl> tbl = bmSystemTblService.queryHistory(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 删除历史保密制度
     *
     * @param list
     * @return
     */
    @SystemLog(module = "保密制度管理", methods = "删除历史保密制度")
    @ApiOperation(value = "删除历史保密制度{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/deleteHistory", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHistory(@RequestBody List<Integer> list) {
        list.forEach(id -> {
            bmSystemTblService.deleteHistory(id);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 添加信息
     *
     * @param files
     * @param system
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "添加保密制度", response = Result.class)
    @SystemLog(module = "保密制度管理相关接口", methods = "添加信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Object> insert(@RequestParam(value = "files", required = false) MultipartFile[] files,
                                         @RequestParam("system") String system) throws IOException {
        BmSystemTbl bmSystemTbl = JSON.parseObject(system, BmSystemTbl.class);
        bmSystemTblService.add(bmSystemTbl, files);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改信息
     *
     * @param files
     * @param system
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "修改保密制度", response = Result.class)
    @SystemLog(module = "保密制度管理相关接口", methods = "添加信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestParam(value = "files", required = false) MultipartFile[] files,
                                         @RequestParam("system") String system) throws IOException {
        BmSystemTbl bmSystemTbl = JSON.parseObject(system, BmSystemTbl.class);
        bmSystemTblService.update(bmSystemTbl, files);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除
     *
     * @return
     */
    @SystemLog(module = "保密制度管理", methods = "删除保密制度")
    @ApiOperation(value = "删除保密制度{author:lx}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            bmSystemTblService.delete(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 导出Excel表
     *
     * @param type
     * @param response
     * @return
     */
    @ApiOperation(value = "导出Excel", response = Result.class)
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public ResponseEntity<Object> exportExcel(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam("type") String type,
                                              HttpServletResponse response) {
        List<BmSystemTbl> bmSystemTbls = bmSystemTblService.exportExcel(name, type);
        MyExcelExportUtil.exportExcel(bmSystemTbls, BmSystemTbl.class, "保密基本制度", "基本制度管理", response);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询制度内容（下拉用）
     *
     * @param pageNum
     * @param pageSize
     * @param type
     * @param content
     * @return
     */
    @ApiOperation(value = "查询制度内容（下拉用）", response = Result.class)
    @RequestMapping(value = "/selectContent", method = RequestMethod.GET)
    public ResponseEntity<Object> selectContent(@RequestParam("pageNum") int pageNum,
                                                @RequestParam("pageSize") int pageSize,
                                                @RequestParam(value = "type", required = false) String type,
                                                @RequestParam(value = "content", required = false) String content,
                                                @RequestParam(value = "sysId", required = false) String name) {
        Map<String, Object> map = bmSystemTblService.selectContent(pageNum, pageSize, type, content, name);
        return ResponseEntity.ok(map);
    }

    /**
     * 根据制度类型查询制度名称（下拉用）
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "根据制度类型查询制度名称（下拉用）", response = Result.class)
    @RequestMapping(value = "/selectSystemByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> selectSystemByType(@PathVariable("type") int type) {
        List<BmSystemTbl> list = bmSystemTblService.selectSystemByType(type);
        return ResponseEntity.ok(list);
    }


    /**
     * 查询制度细则
     *
     * @param name
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有制度细则", response = Result.class)
    @RequestMapping(value = "/selectSystemItem", method = RequestMethod.GET)
    public ResponseEntity<Object> selectSystemItem(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam("id") String id,
                                                   @RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = bmSystemTblService.selectSystemItem(name, id, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 单个基本制度细则查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个基本制度细则{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryItem/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryItem(@PathVariable("id") String id) {
        BmSystemitemTbl tbl = bmSystemTblService.queryItem(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 添加制度细则
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "添加制度细则", response = Result.class)
    @SystemLog(module = "制度细则管理", methods = "添加信息")
    @RequestMapping(value = "/insertItem/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> insertItem(@RequestBody BmSystemitemTbl tbl,
                                             @PathVariable("id") String id) {
        bmSystemTblService.insertItem(tbl, id);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改制度细则
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "修改制度细则", response = Result.class)
    @SystemLog(module = "制度细则管理", methods = "修改制度细则")
    @RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateItem(@RequestBody BmSystemitemTbl tbl) {
        bmSystemTblService.updateItem(tbl);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除制度细则
     *
     * @return
     */
    @SystemLog(module = "制度细则管理", methods = "删除制度细则")
    @ApiOperation(value = "删除制度细则{author:lx}", response = Result.class)
    @RequestMapping(value = "deleteItem", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteItem(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            bmSystemTblService.deleteItem(id);
        }
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
        String fileName = "制度细则.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(), fileName);
        return ResponseEntity.ok(result);
    }

    /**
     * 导入
     *
     * @param id   制度id
     * @param file
     * @return
     */
    @RequestMapping(value = "import/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "导入{author:lx}", response = Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file,
                                              @PathVariable("id") String id) {
        bmSystemTblService.importExcel(file, id);
        return ResponseEntity.ok(result);
    }


}
