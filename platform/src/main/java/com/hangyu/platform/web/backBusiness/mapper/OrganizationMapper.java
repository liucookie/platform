package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.vo.OrganizationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface OrganizationMapper {

    int deleteByPrimaryKey(String id);


    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String id);

    List<Organization> getAllOrg();

    List<String> queryNameBatch(List<String> list);

    int updateByPrimaryKeySelective(Organization record);

    int updateBatch(List<Organization> list);



    //地区基础数据查询
    List<OrganizationVO> queryOrganization(@Param("pid") String pid);

    int deleteBatch(@Param("list") List<String> list);
    //根据子id，查询父级结构名称
    Organization queryParentName(String childId);

    //根据机构名称，查询
    Organization queryByOrgName(String orgName);

    List<String> queryByParentId(String pId);

}