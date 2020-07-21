package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.service.StaffService;
import com.hangyu.platform.web.backBusiness.vo.StaffQueryVO;
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
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


/**
 * 员工管理
 *
 * @author abel
 * @ClassName OrgManagerController
 * @date 2019年11月25日
 */
@Api(tags = "员工相关接口")
@RestController
@RequestMapping(value = "v1/staff")
public class StaffController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private StaffService staffService;

    /**
     * 根据部门id查询处部门下所有的员工信息
     *
     * @param deptId
     * @return
     */
    @ApiOperation(value = "根据部门id查询处部门下所有的员工信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/info/organization", method = RequestMethod.GET)
    public ResponseEntity<Object> list(@RequestParam("deptId") String deptId) {

        List<BmStaffTbl> staffTblList = staffService.queryByDeptId(deptId);
        return ResponseEntity.ok(staffTblList);

    }


    /**
     * 增加员工信息
     *
     * @param userphoto
     * @return
     */
    @ApiOperation(value = "添加用户以及角色{author:acc}", response = Result.class)
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @SystemLog(module="保密人员管理",methods="增加保密人员")
    public ResponseEntity<Object> addUser(@RequestParam(value = "userphoto", required = false) MultipartFile userphoto,
                                          @RequestParam("staff") String staff) throws IOException {
        BmStaffTbl staffTbl = JSON.parseObject(staff, BmStaffTbl.class);
        staffService.addUser(staffTbl, userphoto);
        return ResponseEntity.ok(result);

    }

    /**
     * 修改员工密码
     *
     * @param object
     * @return
     */
    @ApiOperation(value = "修改密码{author:acc}", response = Result.class)
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @SystemLog(module="员工管理",methods="修改密码")
    public ResponseEntity<Object> updatePassword(@RequestBody Object object ) throws UnsupportedEncodingException {
        staffService.updatePassword(object);
        return ResponseEntity.ok(result);

    }


    /**
     * 查询员工信息以及角色信息（以及页面条件查询）
     *
     * @param queryVO
     * @return
     */
    @ApiOperation(value = "查询员工信息以及角色信息{author:acc}", response = Result.class)
    @RequestMapping(value = "/getAllUserInfo", method = RequestMethod.POST)
    public ResponseEntity<Object> getUserInfo(@RequestBody StaffQueryVO queryVO) {

        Map<String,Object> map = staffService.queryAllStaffInfo(queryVO);
        return ResponseEntity.ok(map);
    }


    /**
     * 修改员工信息
     *
     * @param staff
     * @return
     */
    @ApiOperation(value = "修改用户以及角色{author:acc}", response = Result.class)
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    @SystemLog(module="保密人员管理",methods="修改保密人员信息")
    public ResponseEntity<Object> updateUser(@RequestParam(value = "userphoto", required = false) MultipartFile userphoto,
                                             @RequestParam("staff") String staff) throws IOException {
        BmStaffTbl staffTbl = JSON.parseObject(staff, BmStaffTbl.class);
        staffService.updateUser(staffTbl, userphoto);
        return ResponseEntity.ok(result);

    }

    /**
     * 批量删除用户以及角色
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除用户以及角色{author:acc}", response = Result.class)
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.DELETE)
    @SystemLog(module="保密人员管理",methods="删除保密人员信息")
    public ResponseEntity<Object> deleteBatch(@RequestBody List<String> list) {
        list.forEach(id ->{
            staffService.deleteUserAndRole(id);
        });
        return ResponseEntity.ok(result);

    }

    /**
     * 删除员工信息
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除用户以及角色{author:acc}", response = Result.class)
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") String userId) {

        staffService.deleteUserAndRole(userId);
        return ResponseEntity.ok(result);

    }

    /**
     *  根据员工id查询员工信息以及家属，工作，修改用
     * @param userId
     * @return
     */
    @ApiOperation(value = "查询员工id以及角色信息{author:acc}", response = Result.class)
    @RequestMapping(value = "/getUserInfoById/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserInfoById(@PathVariable("userId") String userId) {

        BmStaffTbl staff = staffService.queryInfoByUserId(userId);
        return ResponseEntity.ok(staff);
    }


    /**
     * 导出保密人员信息
     * @param
     * @return
     */
    @RequestMapping(value = "exportStaffInfo",method = RequestMethod.POST)
    @ApiOperation(value="导出保密人员信息{author:acc}",response= Result.class)
    public ResponseEntity<Object> exportStaffInfo(HttpServletResponse response,@RequestBody StaffQueryVO queryVO){
        List<BmStaffTbl> staffTblList = staffService.queryExportInfo(queryVO);
        MyExcelExportUtil.exportExcel(staffTblList, BmStaffTbl.class,"涉密人员信息","涉密人员信息记录",response);
        return ResponseEntity.ok("导出成功");
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
        String fileName = "涉密人员信息.xls";
        FileUtils.download(response, CommonFields.getTemplateFilePath(),fileName);
        return ResponseEntity.ok(result);
    }

    /**
     * 导入保密人员信息
     * @param file
     * @param
     * @return
     */
    @RequestMapping(value = "importStaffInfo",method = RequestMethod.POST)
    @ApiOperation(value="导入保密人员信息{author:acc}",response= Result.class)
    public ResponseEntity<Object> importExcel(@RequestParam("file") MultipartFile file) {
        staffService.importExcel(file);
        return ResponseEntity.ok(result);
    }

}