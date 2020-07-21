package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;
import com.hangyu.platform.web.backBusiness.service.BmOrgService;
import com.hangyu.platform.web.backBusiness.vo.BmOrgManageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;


/**
 * 保密机构管理
 *
 * @author abel
 * @ClassName OrgManagerController
 * @date 2019年11月25日
 */
@RestController
@RequestMapping(value = "v1/organizationManage")
@Api(tags = "保密机构相关接口")
public class OrgManagerController {
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());
    private static final Logger logger = LoggerFactory.getLogger(OrgManagerController.class);

    @Value("${file.upload.path}")
    private String filePath;

    @Autowired
    private BmOrgService bmOrgService;

    /**
     * 保密机构管理页面查询
     *
     * @return
     */
    /**
     * 保密机构管理页面查询
     *
     * @return
     */
    @ApiOperation(value = "根据所有的保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam("pageSize") int pageSize,
                                       @RequestParam("pageNum") int pageNum,
                                       @RequestParam(value = "orgName", required = false) String orgName,
                                       @RequestParam(value = "startDate", required = false) String startDate,
                                       @RequestParam(value = "endDate", required = false) String endDate) {

        Map<String, Object> map = bmOrgService.getOrgManageInfo(pageSize, pageNum, orgName, startDate, endDate);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询当前保密机构信息
     *
     * @return
     */
    @ApiOperation(value = "查询当前保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryById/{orgId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("orgId") String orgId) {

        BmOrgTbl vo = bmOrgService.queryById(orgId);
        return ResponseEntity.ok(vo);
    }

    /**
     * 增加部门信息
     *
     * @param
     * @return
     */
    @SystemLog(module="保密机构管理",methods="增加保密机构信息")
    @ApiOperation(value = "增加保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addOrganization(@RequestParam("orgFile") MultipartFile orgFile,
                                                  @RequestParam(value = "files", required = false) MultipartFile[] files,
                                                  @RequestParam("bmOrgTbl") String org) throws IOException {
        BmOrgTbl bmOrgTbl = JSON.parseObject(org, BmOrgTbl.class);
        //部门文件依据
        bmOrgTbl.setMultipartFile(orgFile);
        bmOrgService.addOrganization(bmOrgTbl, files);
        return ResponseEntity.ok(result);
    }


    /**
     * 更新部门信息
     *
     * @param
     * @return
     */
    @SystemLog(module="保密机构管理",methods="更新保密机构信息")
    @ApiOperation(value = "更新保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateOrganization(@RequestParam(value = "orgFile", required = false) MultipartFile orgFile,
                                                     @RequestParam(value = "files", required = false) MultipartFile[] files,
                                                     @RequestParam("bmOrgTbl") String org,
                                                     @RequestParam("type") int type) throws IOException {
        BmOrgTbl bmOrgTbl = JSON.parseObject(org, BmOrgTbl.class);
        //部门文件依据
        bmOrgTbl.setMultipartFile(orgFile);
        //0为保存，1为保存为历史版本
        bmOrgService.updateOrganization(bmOrgTbl, files, type);
        return ResponseEntity.ok(result);
    }


    /**
     * 查询历史版本信息
     *
     * @return
     */
    @ApiOperation(value = "查询历史保密机构版本信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/queryHistory/{orgId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryHistory(@PathVariable("orgId") String orgId) {

        List<BmOrgTbl> bmOrgTbls = bmOrgService.queryHistory(orgId);
        return ResponseEntity.ok(bmOrgTbls);
    }

    /**
     * 删除部门信息
     *
     * @param
     * @return
     */
    @SystemLog(module="保密机构管理",methods="删除保密机构信息")
    @ApiOperation(value = "删除保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delOrganization(@RequestBody List<String> list) throws IOException {
        for (String id : list) {
            bmOrgService.delOrg(id);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 删除历史部门信息
     *
     * @param
     * @return
     */
    @SystemLog(module="保密机构管理",methods="删除历史保密机构信息")
    @ApiOperation(value = "删除历史保密机构信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/delHostiory", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delHostiory(@RequestBody List<Integer> list) throws IOException {
        for (Integer id : list) {
            bmOrgService.delHostiory(id);
        }
        return ResponseEntity.ok(result);
    }


    /**
     * 导出excel
     *
     * @param
     * @return
     */
    @ApiOperation(value = "导出保密机构信息Excel{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ResponseEntity<Object> export(HttpServletResponse response, @RequestParam("orgId") String orgId) throws IOException {
        Result result = new Result(200, "文件导出成功");
        bmOrgService.exportExcelTemplate(orgId, response);
        logger.info("文件导出成功");
        return ResponseEntity.ok(result);

    }


}