package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.service.OrganizationService;
import com.hangyu.platform.web.backBusiness.vo.OrganizationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 组织管理管理
 *
 * @author abel
 * @ClassName OrganizationController
 * @date 2019年11月25日
 */
@Api(tags = "部门机构相关接口")
@RestController
@RequestMapping(value = "v1/organization")
public class OrganizationController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private OrganizationService organizationService;

    /**
     * 保密机构管理组织机构查询,
     * 递归查询
     * @return
     */
    @ApiOperation(value = "查询机构{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<Object> list() {
        List<OrganizationVO> organizationVOS = organizationService.queryOrg();
        return ResponseEntity.ok(organizationVOS);

    }

    /**
     * 增加保密机构管理组织机构
     *
     * @param organization
     * @return
     */
    @ApiOperation(value = "添加机构{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/addOrg", method = RequestMethod.POST)
    @SystemLog(module="机构部门管理",methods="增加组织机构")
    public ResponseEntity<Object> addOrg(@RequestBody Organization organization) {
        organizationService.add(organization);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     *
     * 根据父级id查询处子集目录
     *
     * @param pId
     * @return
     */
    @ApiOperation(value = "根据父级组织机构id获取子级组织{author:zkl}", response = Result.class)
    @RequestMapping(value = "/getChildrenOrgByParentId/{pId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getByParentId(@PathVariable("pId") String pId) {
        List<OrganizationVO> list = organizationService.getChildrenOrgByParentId(pId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * 查询当前机构信息
     * @param
     * @return
     */
    @ApiOperation(value = "查询当前机构信息{author:zkl}", response = Result.class)
    @RequestMapping(value = "/getOrgById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrgById(@PathVariable("id") String id) {
       Organization organization = organizationService.getOrgById(id);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    /**
     * 查询所有机构平级
     * @param
     * @return
     */
    @ApiOperation(value = "查询所有机构平级{author:zkl}", response = Result.class)
    @RequestMapping(value = "/getAllOrg", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllOrg() {
        List<Organization> list = organizationService.getAllOrg();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "改变机构序号{author:zkl}", response = Result.class)
    @RequestMapping(value = "/changeOrgOrder", method = RequestMethod.POST)
    public ResponseEntity<Object> changeOrgOrder(@RequestBody List<Organization> list) {
        organizationService.updateBatch(list);
        return  ResponseEntity.ok(result);
    }


    /**
     * 更新组织
     *
     * @param organization
     * @return
     */
    @SystemLog(module="机构部门管理",methods="更新组织机构")
    @ApiOperation(value = "更新组织机构{author:zkl}", response = Result.class)
    @RequestMapping(value = "/updateOrganization", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateOrganization(@RequestBody Organization organization) {
        organizationService.update(organization);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 刪除组织
     *
     * @param orgId
     * @return
     */
    @SystemLog(module="机构部门管理",methods="删除组织机构")
    @ApiOperation(value = "刪除组织{author:zkl}", response = Result.class)
    @RequestMapping(value = "/deleteOrganization/{orgId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteOrganization(@PathVariable("orgId") String orgId) {
        organizationService.delete(orgId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}