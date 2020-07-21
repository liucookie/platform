package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckitemfoulactionmappingTbl;
import com.hangyu.platform.web.sysAdmin.service.Bm2FoulactionlMappingService;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionMappingVO;
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

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 保密信用映射配置管理
 */
@RestController
@RequestMapping("v1/foulactionMapping/")
@Api(tags = "保密信用映射配置管理")
public class Bm2FoulactionMappingController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private Bm2FoulactionlMappingService service;

    /**
     * 查询保密信用映射配置
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有保密信用映射配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                                         @RequestParam(value = "checkItemId",required = false) String checkItemId,
                                         @RequestParam(value = "violationType",required = false) String violationType,
                                         @RequestParam(value = "checkType") int checkType,
                                         @RequestParam(value = "behavior",required = false) String behavior) {
        Map<String,Object> map = service.query(pageNum, pageSize,checkItemId,violationType,behavior,checkType);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询保密信用映射配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个保密信用映射配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        Bm2FoulactionMappingVO vo = service.queryById(id);
        return ResponseEntity.ok(vo);
    }


    /**
     * 增加保密信用映射配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加保密信用映射配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@RequestBody Bm2CheckitemfoulactionmappingTbl type) {
        service.add(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改保密信用映射配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改保密信用映射配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Bm2CheckitemfoulactionmappingTbl type) {
        service.update(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除保密信用映射配置
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除保密信用映射配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody List<String> list) {
        service.delete(list);
        return ResponseEntity.ok(result);
    }


    /**
     * 导出文件
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.GET)
    @ApiOperation(value = "导出excel{author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportExcel(HttpServletResponse response,
                                            @RequestParam(value = "checkItemId",required = false) String checkItemId,
                                            @RequestParam(value = "violationType",required = false) String violationType,
                                            @RequestParam(value = "checkType") int checkType,
                                            @RequestParam(value = "behavior",required = false) String behavior) {
        List<Bm2FoulactionMappingVO> list = service.queryAll(checkItemId, violationType, behavior, checkType);
        MyExcelExportUtil.exportExcel(list, Bm2FoulactionMappingVO.class, "保密信用映射配置管理", "保密信用映射配置", response);
        return ResponseEntity.ok(result);
    }

}
