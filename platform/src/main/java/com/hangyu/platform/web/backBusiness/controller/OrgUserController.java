package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmOrguserTbl;
import com.hangyu.platform.web.backBusiness.service.BmOrgUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 组织管理管理
 *
 * @author abel
 * @ClassName OrganizationController
 * @date 2019年11月25日
 */
@Api(tags = "保密内部员工相关接口")
@RestController
@RequestMapping(value = "v1/organization")
public class OrgUserController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private BmOrgUserService bmOrgUserService;

    /**
     * 批量更新保密机构人员信息
     * @param userList
     * @return
     */
    @SystemLog(module="保密机构人员管理",methods="批量更新机构人员信息")
    @ApiOperation(value = "批量更新机构人员信息{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ResponseEntity<Object> list(@RequestBody List<BmOrguserTbl> userList) {
        bmOrgUserService.updateByOrgId(userList);
        return  ResponseEntity.ok(result);

    }

    /**
     * 根据机构id查询处下属员工
     * @param orgId
     * @return
     */
    @ApiOperation(value = "根据机构id查询处下属员工{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public ResponseEntity<Object> list( @RequestParam("orgId") String orgId) {
        List<BmOrguserTbl> list = bmOrgUserService.selectByOrgId(orgId);
        return  ResponseEntity.ok(list);

    }


}