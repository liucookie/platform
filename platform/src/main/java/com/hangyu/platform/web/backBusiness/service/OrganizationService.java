package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.CommonUtils;

import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.vo.OrganizationVO;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author abel
 * @ClassName OrganizationService
 * @date
 */
@Service
public class OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;


    /**
     * 递归查询
     * @return
     */
    //开启事务
    public List<OrganizationVO> queryOrg() {
        List<OrganizationVO> childList = organizationMapper.queryOrganization("0");
        return queryOrganization(childList);
    }


    /**
     * 机构组织查询,递归查询
     *
     * @return BmOrgManageVO
     */
    public List<OrganizationVO> queryOrganization(List<OrganizationVO> list) {
        for (OrganizationVO org : list) {
            List<OrganizationVO> allChildList = organizationMapper.queryOrganization(org.getId());
            if (null != allChildList && allChildList.size() > 0) {
                org.setChildOrganization(allChildList);
                queryOrganization(allChildList);
            }
        }
        return list;
    }

    /**
     * 增加机构
     *
     * @param organization
     */
    @Transactional
    public void add(Organization organization) {
        //第一次增加机构是，parentid需要设置下值0
        if (null == organization.getParentid()) {
            organization.setParentid("0");
        }
        organization.setUniqueid(CommonUtils.generateUUID());
        checkOrgName(organization.getOrgname());
        organizationMapper.insert(organization);

    }

    /**
     * 校验机构名称是否重复
     */
    private void checkOrgName(String orgName){
        Organization organization = organizationMapper.queryByOrgName(orgName);
        if (null != organization){
            throw new PlatException(ResultStatusEnum.ORGNAME_REPEAT.getMessage());
        }
    }

    /**
     * 对外提高查询接口
     * excel导入时，需要用name查询出id。
     * @param name
     * @return
     */
    public String queryIdByName(String name){
        Organization organization = organizationMapper.queryByOrgName(name);
        return null == organization ? null : organization.getUniqueid();

    }



    /**
     * 根据父级id查询子集菜单
     *
     * @param pId
     * @return
     */
    public List<OrganizationVO> getChildrenOrgByParentId(String pId) {

        return organizationMapper.queryOrganization(pId);
    }

    /**
     * 查询机构（不递归）
     *
     * @return
     */
    public List<Organization> getAllOrg() {
        return organizationMapper.getAllOrg();
    }

    /**
     * 根据当前菜单信息
     *
     * @return
     */
    public Organization getOrgById(String id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新机构
     *
     * @param organization
     */
    @Transactional
    public void update(Organization organization) {
        checkOrgName(organization.getOrgname());
        organizationMapper.updateByPrimaryKeySelective(organization);
    }


    /**
     * 批量更新机构
     *
     * @param list
     */
    @Transactional
    public void updateBatch(List<Organization> list) {
        organizationMapper.updateBatch(list);
    }

    /**
     * 删除机构以及子集
     *
     * @param orgId
     */
    @Transactional
    public void delete(String orgId) {
        //删除当前机构,父级id的机构
        organizationMapper.deleteByPrimaryKey(orgId);
    }




}