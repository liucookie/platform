package com.hangyu.platform.web.backBusiness.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * 登录管理
 *
 * @author
 * @ClassName LoginController
 * @date 2019年11月25日
 */
@RestController
@Api(tags = "登录管理相关接口")
@RequestMapping(value = "v1/")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private StaffService staffService;

    /**
     * 登录接口
     * @param obj
     * @return
     */
    @ApiOperation(value = "登录",response = Result.class)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Object obj) {
        JSONObject json = (JSONObject) JSON.toJSON(obj);
        String account = (String) json.get("account");
        String password = (String) json.get("password");
        BmStaffTbl staff = staffService.queryByAccount(account,password);
        //用账号，员工id，员工名称；返回token
        String token = TokenUtils.sign(account,staff.getStaffid(),staff.getUsername());
        logger.info("Token obtained successfully:{}",token);
        logger.info("login successfully:{}",account);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        map.put("userId",staff.getStaffid());
        map.put("username",staff.getUsername());
        map.put("deptId",staff.getDeptid());
        map.put("deptName",staff.getOrgName());
        map.put("level",staff.getLevelName());
        return ResponseEntity.ok(map);

    }

}