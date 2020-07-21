package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragecolorTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestorageinfoTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragetypeTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2HistoryRemoveService;
import com.hangyu.platform.web.sysAdmin.vo.Bm2HistoryQueryVO;
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
 * 历史移动存储介质信息管理
 * liuxuan
 * 2020-1-19
 */
@RestController
@RequestMapping("v1/HistoryRemoveInfo/")
@Api(tags = "历史移动存储介质信息管理")
public class Bm2HistoryRemoveInfoController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2HistoryRemoveService removeService;


    /**
     * 查询所有历史移动存储介质信息
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询所有历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody Bm2HistoryQueryVO vo) {
        Map<String,Object> map = removeService.query(vo);
        return ResponseEntity.ok(map);
    }




    /**
     * 查询单个历史移动存储介质信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryId(@PathVariable("id") String id) {
        Bm2HistoryremovablestorageinfoTbl info = removeService.queryById(id);
        return ResponseEntity.ok(info);
    }

    /**
     * 增加历史移动存储介质信息
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "增加历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2HistoryremovablestorageinfoTbl info) {
        removeService.add(info);
        return ResponseEntity.ok(result);
    }
    /**
     * 修改历史移动存储介质信息
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "修改历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2HistoryremovablestorageinfoTbl info) {
        removeService.update(info);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除历史移动存储介质信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        removeService.delete(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量删除历史移动存储介质信息
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除历史移动存储介质信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteBatch", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBatch(@RequestBody List<String> list) {
        list.forEach( id->{
            removeService.delete(id);
        });
        return ResponseEntity.ok(result);
    }

    /**
     * 查询所有分类
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有分类{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryClassify", method = RequestMethod.GET)
    public ResponseEntity<Object> queryClassify() {
        List<Bm2HistoryremovablestoragetypeTbl> typeList =  removeService.queryClassify();
        return ResponseEntity.ok(typeList);
    }



    /**
     * 模板下载
     *
     * @param
     * @return
     */
    @ApiOperation(value = "模板下载{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(HttpServletResponse response) throws IOException {
        String fileName = "历史移动存储介质.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(),fileName);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量导入
     *
     * @param
     * @return
     */
    @ApiOperation(value = "批量导入{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "importExcel", method = RequestMethod.POST)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        removeService.importExcel(file);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询所有所属分类配置
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @ApiOperation(value = "查询所有所属分类配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryType(@RequestParam("pageSize") int pageSize,
                                            @RequestParam("pageNum") int pageNum ) {
        Map<String,Object> map = removeService.queryType(pageSize,pageNum);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个所属分类配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个所属分类配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryType/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeById(@PathVariable("id") String id) {
        Bm2HistoryremovablestoragetypeTbl type = removeService.queryTypeById(id);
        return ResponseEntity.ok(type);
    }
    /**
     * 增加所属分类配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加单个所属分类配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody Bm2HistoryremovablestoragetypeTbl type) {
        removeService.addType(type);
        return ResponseEntity.ok(result);
    }
    /**
     * 修改所属分类配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改单个所属分类配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Bm2HistoryremovablestoragetypeTbl type) {
        removeService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量删除所属分类配置
     *
     * @param idList
     * @return
     */
    @ApiOperation(value = "批量删除所属分类配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@RequestBody List<String> idList) {
        removeService.deleteType(idList);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询所有颜色
     *
     * @return
     */
    @ApiOperation(value = "查询所有颜色{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryColor", method = RequestMethod.GET)
    public ResponseEntity<Object> queryColor() {
        List<Bm2HistoryremovablestoragecolorTbl> color = removeService.queryColor();
        return ResponseEntity.ok(color);
    }
}
