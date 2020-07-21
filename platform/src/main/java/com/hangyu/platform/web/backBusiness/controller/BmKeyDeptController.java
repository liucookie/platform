package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.BmKeydeptTbl;
import com.hangyu.platform.web.backBusiness.dto.BmKeyplacepicmodelTbl;
import com.hangyu.platform.web.backBusiness.dto.BmKeypositionTbl;
import com.hangyu.platform.web.backBusiness.service.BmKeyDeptlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.Map;

@RestController
@Api(tags = "要害部门部位相关接口")
@RequestMapping("/v1/bmKeyDept")
public class BmKeyDeptController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Value("${file.upload.path}")
    private String filePath;

    @Resource
    private BmKeyDeptlService service;


    /**
     * 查询内防，外防
     *
     * @return
     */
    @ApiOperation(value = "查询内防，外防", response = Result.class)
    @RequestMapping(value = "/queryPlace", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPlace() {
        List<BmKeyplacepicmodelTbl> list = service.queryPlace();
        return ResponseEntity.ok(list);
    }

    /**
     * 查询所有要害部门
     *
     * @param orgName
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有要害部门", response = Result.class)
    @RequestMapping(value = "/queryDept", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDept(@RequestParam(value = "orgName", required = false) String orgName,
                                            @RequestParam(value = "userName", required = false) String userName,
                                            @RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = service.selectDept(orgName, userName, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个要害部门
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个要害部门{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryDeptById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDeptById(@PathVariable("id") String id) {
        BmKeydeptTbl tbl = service.queryDeptById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询要害部门历史
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询要害部门历史{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryDeptHistory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDeptHistory(@PathVariable("id") String id) {
        List<BmKeydeptTbl> tbl = service.queryDeptHistory(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 添加要害部门
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "添加要害部门", response = Result.class)
    @SystemLog(module = "保密制度管理相关接口",methods = "添加信息")
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public ResponseEntity<Object> addDept(@RequestParam(value = "picture", required = false) MultipartFile picture,
                                          @RequestParam(value = "file", required = false) MultipartFile file,
                                          @RequestParam("data") String data) throws IOException {
        BmKeydeptTbl tbl = JSON.parseObject(data, BmKeydeptTbl.class);
        service.addDept(tbl, picture, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改要害部门
     * ishostory 0 正常版本，1 历史版本
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "修改要害部门", response = Result.class)
    @SystemLog(module = "保密制度管理相关接口",methods = "添加信息")
    @RequestMapping(value = "/updateDept", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDept(@RequestParam(value = "picture", required = false) MultipartFile picture,
                                             @RequestParam(value = "file", required = false) MultipartFile file,
                                             @RequestParam("data") String data) throws IOException {
        BmKeydeptTbl tbl = JSON.parseObject(data, BmKeydeptTbl.class);
        service.updateDept(tbl, picture, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除要害部门
     *
     * @return
     */
    @SystemLog(module="文化资源管理",methods="删除文化资源")
    @ApiOperation(value = "删除要害部门{author:lx}", response = Result.class)
    @RequestMapping(value = "deleteDept", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDept(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.deleteDept(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 删除历史要害部门
     * id为自增主键，只删除当前的数据
     *
     * @return
     */
    @SystemLog(module="文化资源管理",methods="删除文化资源")
    @ApiOperation(value = "删除历史要害部门{author:lx}", response = Result.class)
    @RequestMapping(value = "deleteHistory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHistory(@PathVariable("id") int id) throws IOException {
        service.deleteHistory(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 导出Excel表
     *
     * @param orgName
     * @param response
     * @return
     */
    @ApiOperation(value = "导出要害部门", response = Result.class)
    @RequestMapping(value = "/exportDept", method = RequestMethod.GET)
    public ResponseEntity<Object> exportDept(@RequestParam(value = "orgName", required = false) String orgName,
                                             @RequestParam(value = "userName", required = false) String userName,
                                             HttpServletResponse response) {
        List<BmKeydeptTbl> bmSystemTbls = service.exportDept(orgName, userName);
        MyExcelExportUtil.exportExcel(bmSystemTbls, BmKeydeptTbl.class, "要害部门管理", "要害部门", response);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询所有要害部位
     *
     * @param orgName
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有要害部位", response = Result.class)
    @RequestMapping(value = "/queryPosition", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPosition(@RequestParam(value = "orgName", required = false) String orgName,
                                            @RequestParam(value = "userName", required = false) String userName,
                                            @RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = service.queryPosition(orgName, userName, pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询单个要害部位
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个要害部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryPositionById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPositionById(@PathVariable("id") String id) {
        BmKeypositionTbl tbl = service.queryPositionById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询要害部位历史
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询要害部位历史{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryPostionHistory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPostionHistory(@PathVariable("id") String id) {
        List<BmKeypositionTbl> tbl = service.queryPostionHistory(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 添加要害部位
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "添加要害部位", response = Result.class)
//    @SystemLog(module = "保密制度管理相关接口",methods = "添加信息")
    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public ResponseEntity<Object> addPosition(@RequestParam(value = "picture", required = false) MultipartFile picture,
                                          @RequestParam(value = "file", required = false) MultipartFile file,
                                          @RequestParam("data") String data) throws IOException {
        BmKeypositionTbl tbl = JSON.parseObject(data, BmKeypositionTbl.class);
        service.addPosition(tbl, picture, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改要害部位
     * ishostory 0 正常版本，1 历史版本
     *
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "修改要害部位", response = Result.class)
//    @SystemLog(module = "保密制度管理相关接口",methods = "添加信息")
    @RequestMapping(value = "/updatePosition", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePosition(@RequestParam(value = "picture", required = false) MultipartFile picture,
                                             @RequestParam(value = "file", required = false) MultipartFile file,
                                             @RequestParam("data") String data) throws IOException {
        BmKeypositionTbl tbl = JSON.parseObject(data, BmKeypositionTbl.class);
        service.updatePosition(tbl, picture, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除要害部位
     *
     * @return
     */
//    @SystemLog(module="文化资源管理",methods="删除文化资源")
    @ApiOperation(value = "删除要害部位{author:lx}", response = Result.class)
    @RequestMapping(value = "deletePosition", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePosition(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            service.deletePosition(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 删除历史要害部位
     * id为自增主键，只删除当前的数据
     *
     * @return
     */
//    @SystemLog(module="文化资源管理",methods="删除文化资源")
    @ApiOperation(value = "删除历史要害部位{author:lx}", response = Result.class)
    @RequestMapping(value = "deleteHistoryPosition/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHistoryPosition(@PathVariable("id") int id) throws IOException {
        service.deleteHistoryPosition(id);
        return ResponseEntity.ok(result);
    }


    /**
     * 导出Excel表
     *
     * @param orgName
     * @param response
     * @return
     */
    @ApiOperation(value = "导出要害部位", response = Result.class)
    @RequestMapping(value = "/exportPosition", method = RequestMethod.GET)
    public ResponseEntity<Object> exportPosition(@RequestParam(value = "orgName", required = false) String orgName,
                                             @RequestParam(value = "userName", required = false) String userName,
                                             HttpServletResponse response) {
        List<BmKeypositionTbl> bmSystemTbls = service.exportPosition(orgName, userName);
        MyExcelExportUtil.exportExcel(bmSystemTbls, BmKeydeptTbl.class, "要害部位管理", "要害部位", response);
        return ResponseEntity.ok(result);
    }


}
