package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.BmSecrectwayTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextTbl;
import com.hangyu.platform.web.backBusiness.service.BmStaffCipherTextService;
import com.hangyu.platform.web.backBusiness.vo.StaffCipherQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 脱密期管理
 * liuxuan
 * 2020.1.19
 */
@Api(tags = "脱密期管理接口")
@RestController
@RequestMapping(value = "v1/StaffCipher")
public class BmStaffCipherTextController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmStaffCipherTextService service;

    /**
     * 查询脱密人员（以及页面条件查询）
     *
     * @param queryVO
     * @return
     */
    @ApiOperation(value = "查询脱密人员{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseEntity<Object> query(@RequestBody StaffCipherQueryVO queryVO) {

        Map<String, Object> map = service.query(queryVO);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询脱密人员（以及页面条件查询）
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个脱密人员{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        BmStaffciphertextTbl tbl = service.queryById(id);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 查询脱密方式
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "查询脱密方式{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryType(@PathVariable("type") int type) {
        List<BmSecrectwayTbl> tbl = service.queryType(type);
        return ResponseEntity.ok(tbl);
    }

    /**
     * 增加脱密人员
     *
     * @param file
     * @param visitFile
     * @param staff
     * @return
     */
    @SystemLog(module="脱密人员管理",methods="增加脱密人员")
    @ApiOperation(value = "增加脱密人员{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestParam(value = "file", required = false) MultipartFile file,
                                      @RequestParam(value = "staff", required = false) String staff,
                                      @RequestParam(value = "visitFile", required = false) MultipartFile[] visitFile) throws IOException {
        //回访文件
        BmStaffciphertextTbl info = JSON.parseObject(staff, BmStaffciphertextTbl.class);
        service.addUser(info, file, visitFile);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改脱密人员
     *
     * @param staff
     * @return
     */
    @SystemLog(module="脱密人员管理",methods="修改脱密人员")
    @ApiOperation(value = "修改脱密人员{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@RequestPart(value = "file", required = false) MultipartFile file,
                                             @RequestPart(value = "staff", required = false) String staff,
                                             @RequestPart(value = "visitFile", required = false) MultipartFile[] visitFile) throws IOException {
        BmStaffciphertextTbl info = JSON.parseObject(staff, BmStaffciphertextTbl.class);
        service.update(info, file, visitFile);
        return ResponseEntity.ok(result);

    }

    /**
     * 批量删除脱密人员
     *
     * @param list
     * @return
     */
    @SystemLog(module="脱密人员管理",methods="批量删除脱密人员")
    @ApiOperation(value = "批量删除脱密人员{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBatch(@RequestBody List<String> list) {
        service.delete(list);
        return ResponseEntity.ok(result);

    }

    /**
     * 导出>脱密期管理
     *
     * @param
     * @return
     */
    @RequestMapping(value = "exportStaffInfo", method = RequestMethod.POST)
    @ApiOperation(value = "导出脱密期人员信息 {author:liuxuan}", response = Result.class)
    public ResponseEntity<Object> exportStaffInfo(HttpServletResponse response, @RequestBody StaffCipherQueryVO queryVO) {
        List<BmStaffciphertextTbl> list = service.export(queryVO);
        MyExcelExportUtil.exportExcel(list, BmStaffciphertextTbl.class, "脱密期人员信息", "脱密人员信息记录", response);
        return ResponseEntity.ok("导出成功");
    }


}