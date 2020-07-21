package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSpecnewsTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.BmWorkdynTbl;
import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import com.hangyu.platform.web.backBusiness.dto.PostsecretlevelTbl;
import com.hangyu.platform.web.backBusiness.dto.PublicityTbl;
import com.hangyu.platform.web.backBusiness.service.BmCheckThingService;
import com.hangyu.platform.web.backBusiness.service.BmCommonFormService;
import com.hangyu.platform.web.backBusiness.service.BmPublishService;
import com.hangyu.platform.web.backBusiness.service.BmVouchInfoService;
import com.hangyu.platform.web.backBusiness.service.DefaultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 首页展示管理(后台接口)
 *
 * @auther liuXuan
 * @date 2020/3/12
 */
@Api(tags = "首页展示接口")
@RestController
@RequestMapping(value = "v1/default")
public class DefaultController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private DefaultService service;

    @Autowired
    private BmVouchInfoService bmVouchInfoService;

    @Autowired
    private BmCommonFormService bmCommonFormService;

    @Autowired
    private BmCheckThingService bmCheckThingService;

    @Autowired
    private BmPublishService bmPublishService;

    /**
     * 查询用户的个人信息，头像，密级，处室
     *
     * @return
     */
    @ApiOperation(value = "查询用户信息{author:lx}", response = Result.class)
    @RequestMapping(value = "queryUserInfo/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryUserInfo(@PathVariable(value = "userId") String userId) {
        BmStaffTbl staff = service.queryUserInfo(userId);
        return ResponseEntity.ok(staff);
    }


    /**
     * 查询岗位
     *
     * @return
     */
    @ApiOperation(value = "查询岗位职责{author:lx}", response = Result.class)
    @RequestMapping(value = "queryWork/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryWork(@PathVariable(value = "userId") String userId) {
        List<PostsecretlevelTbl> list = service.queryWork(userId);
        return ResponseEntity.ok(list);
    }


    /**
     * 查询通知公告
     *
     * @return
     */
    @ApiOperation(value = "查询通知公告{author:lx}", response = Result.class)
    @RequestMapping(value = "queryNotify", method = RequestMethod.GET)
    public ResponseEntity<Object> queryNotify(@RequestParam(value = "topSign", required = false) String topSign) {
        List<BmNotifyTbl> list = service.queryNotify(topSign);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询工作动态
     *
     * @return
     */
    @ApiOperation(value = "查询工作动态{author:lx}", response = Result.class)
    @RequestMapping(value = "queryWorkDynamic", method = RequestMethod.GET)
    public ResponseEntity<Object> queryWorkDynamic(@RequestParam(value = "topSign", required = false) String topSign) {
        List<BmWorkdynTbl> list = service.queryWorkDynamic(topSign);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询宣传教育
     *
     * @return
     */
    @ApiOperation(value = "查询宣传/视频/保密文化建设教育{author:lx}", response = Result.class)
    @RequestMapping(value = "queryPublicity{type}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPublicity(@PathVariable("type") String type) {
        List<PublicityTbl> list = service.queryPublicity(type);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询平台链接
     *
     * @return
     */
    @ApiOperation(value = "查询平台链接{author:lx}", response = Result.class)
    @RequestMapping(value = "queryHyperLink", method = RequestMethod.GET)
    public ResponseEntity<Object> queryHyperLink(@RequestParam(value = "topSign", required = false) String topSign) {
        List<BmHyperlinkTbl> list = service.queryHyperLink(topSign);
        return ResponseEntity.ok(list);
    }

    /**
     * 查询百叶窗图片
     *
     * @return
     */
    @ApiOperation(value = "查询百叶窗图片{author:lx}", response = Result.class)
    @RequestMapping(value = "querySpecNews", method = RequestMethod.GET)
    public ResponseEntity<Object> querySpecNews(@RequestParam(value = "topSign", required = false) String topSign) {
        List<BmSpecnewsTbl> list = service.querySpecNews(topSign);
        return ResponseEntity.ok(list);
    }

    /**
     * 保密知识应知应会
     *
     * @return
     */
    @ApiOperation(value = "保密知识应知应会{author:lx}", response = Result.class)
    @RequestMapping(value = "querySecretKnowledge", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecretKnowledge(@RequestParam("pageNum") int pageNum,
                                                       @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = bmVouchInfoService.query(pageNum, pageSize);
        return ResponseEntity.ok(map);
    }

    /**
     * 查询积分
     *
     * @return
     */
    @ApiOperation(value = "查询积分{author:lx}", response = Result.class)
    @RequestMapping(value = "queryScore/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryScore(@PathVariable(value = "userId") String userId) {
        Map<String, Double> map = service.queryScore(userId);
        return ResponseEntity.ok(map);
    }

    /**
     * 计算机检查
     *
     * @return
     */
    @ApiOperation(value = "计算机检查{author:lx}", response = Result.class)
    @RequestMapping(value = "queryComputerCheck/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryComputerCheck(@PathVariable(value = "userId") String userId) {
        Map<String, String> message = service.queryComputerCheck(userId);
        return ResponseEntity.ok(message);
    }

    /**
     * 部门检查
     *
     * @return
     */
    @ApiOperation(value = "部门检查{author:lx}", response = Result.class)
    @RequestMapping(value = "queryDeptCheck/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryDeptCheck(@PathVariable(value = "userId") String userId) {
        Map<String, String> message = service.queryDeptCheck(userId);
        return ResponseEntity.ok(message);
    }

    /**
     * 查看信息化设备
     *
     * @return
     */
    @ApiOperation(value = "查看信息化设备{author:lx}", response = Result.class)
    @RequestMapping(value = "queryComputerInfo/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryComputerInfo(@PathVariable(value = "userId") String userId) {
        List<Computerinfo> list = service.queryComputerInfo(userId);
        return ResponseEntity.ok(list);
    }

    /**
     * 个人持有信息设备
     *
     * @return
     */
    @ApiOperation(value = "个人持有信息设备{author:lx}", response = Result.class)
    @RequestMapping(value = "queryUserComputerInfo/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryUserComputerInfo(@PathVariable(value = "userId") String userId) {
        Map<String, Object> map = service.queryUserComputerInfo(userId);
        return ResponseEntity.ok(map);
    }

    /**
     * 用户核对
     * type  1,涉密载体  2信息设备
     *
     * @return
     */
    @ApiOperation(value = "用户核对{author:lx}", response = Result.class)
    @RequestMapping(value = "checkUserHz/{type}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> checkUserHz(@PathVariable(value = "userId") String userId,
                                              @PathVariable(value = "type") int type) {
        service.checkUserhz(userId, type);
        return ResponseEntity.ok(result);
    }

    /**
     * 查询用户是否核对
     * type  1,涉密载体  2信息设备
     *
     * @return
     */
    @ApiOperation(value = "查询用户是否核对{author:lx}", response = Result.class)
    @RequestMapping(value = "queryIsCheck/{type}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryIsCheck(@PathVariable(value = "userId") String userId,
                                               @PathVariable(value = "type") int type) {
        Boolean flag = service.queryIsCheck(userId, type);
        return ResponseEntity.ok(flag);
    }

    /**
     * 白名单软件
     *
     * @return
     * @Param type 类别。不传则表示，查询全部
     */
    @ApiOperation(value = "白名单软件{author:lx}", response = Result.class)
    @RequestMapping(value = "querySoft", method = RequestMethod.GET)
    public ResponseEntity<Object> querySoft(@RequestParam(value = "type", required = false) String type) {
        List<BmSecsoftTbl> list = service.querySoft(type);
        return ResponseEntity.ok(list);
    }

    /**
     * 白名单软件(下载按钮)
     *
     * @return
     * @Param type 类别。不传则表示，查询全部
     */
    @ApiOperation(value = "白名单软件(下载按钮){author:lx}", response = Result.class)
    @RequestMapping(value = "downloadSoft", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadSoft(@RequestParam("id") String id) {
        List<BmSecsoftverTbl> list = service.downloadSoft(id);
        return ResponseEntity.ok(list);
    }

    /**
     * 流程表格查询
     *
     * @return
     */
    @ApiOperation(value = "流程表格查询{author:lx}", response = Result.class)
    @RequestMapping(value = "queryTable", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTable(@RequestParam("pageNum") int pageNum,
                                             @RequestParam("pageSize") int pageSize) {
        //1.查询已经发布的
        Map<String, Object> map = bmCommonFormService.query(pageNum, pageSize, "1");
        return ResponseEntity.ok(map);
    }

    /**
     * 检查情况通报
     *
     * @return
     */
    @ApiOperation(value = "检查情况通报{author:lx}", response = Result.class)
    @RequestMapping(value = "queryCheckNotice", method = RequestMethod.GET)
    public ResponseEntity<Object> queryCheckNotice(@RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize) {
        //1.查询已经发布的
        Map<String, Object> map = bmCheckThingService.query(pageNum, pageSize, "1");
        return ResponseEntity.ok(map);
    }

    /**
     * 违规处罚通报
     *
     * @return
     */
    @ApiOperation(value = "违规处罚通报{author:lx}", response = Result.class)
    @RequestMapping(value = "queryPublish", method = RequestMethod.GET)
    public ResponseEntity<Object> queryPublish(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        //1.查询已经发布的
        Map<String, Object> map = bmPublishService.query(pageNum, pageSize, "1");
        return ResponseEntity.ok(map);
    }
}