package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactionTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2FoulactionService;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionMappingVO;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionQueryVO;
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
 * 违规行为库管理
 */
@RestController
@RequestMapping("v1/bm2Foulaction/")
@Api(tags = "违规行为库管理")
public class Bm2FoulactionController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2FoulactionService service;

    /**
     * 查询违规行为库
     *
     * @return
     */
    @ApiOperation(value = "查询所有违规行为库{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody Bm2FoulactionQueryVO vo) {
        Map<String,Object> type = service.query(vo);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询违规行为库
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个违规行为库{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        Bm2FoulactionTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询违规行为库（根据违规类型）
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "查询违规行为库（根据违规类型）{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryByType(@PathVariable("type") String type) {
        List<Bm2FoulactionTbl> list = service.queryByType(type);
        return ResponseEntity.ok(list);
    }

    /**
     * 增加违规行为库
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加违规行为库{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2FoulactionTbl type) {
        service.add(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改违规行为库
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改违规行为库{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2FoulactionTbl type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除违规行为库
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除违规行为库{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@RequestBody List<String> list) {
        list.forEach(id->{
            service.deleteType(id);
        });
        return ResponseEntity.ok(result);
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
        String fileName = "违规行为库.xls";
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
        service.importExcel(file);
        return ResponseEntity.ok(result);
    }
    /**
     * 导出文件
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    @ApiOperation(value = "导出excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportExcel(HttpServletResponse response, @RequestBody Bm2FoulactionQueryVO vo) {
        List<Bm2FoulactionTbl> list = service.queryAll(vo);
        MyExcelExportUtil.exportExcel(list, Bm2FoulactionTbl.class, "违规行为库管理", "违规行为库", response);
        return ResponseEntity.ok(result);
    }
}
