package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;

import java.util.List;


public interface BmOrgTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmOrgTbl record);

    int insertSelective(BmOrgTbl record);

    int updateByOrgIdSelective(BmOrgTbl record);

    int updateByOrgId(BmOrgTbl record);

    //获取页面信息
    List<BmOrgTbl> getBmOrgInfo(int start, int pageSize, String orgName, String startDate, String endDate);

    int selectTotal(String orgName, String startDate, String endDate);

    //删除部门信息
    int delByOrgId(String orgId);

    BmOrgTbl queryByOrgId(String orgId);

    //查询历史版本信息
    List<BmOrgTbl> queryHistory(String orgId);

    int deleteHistroy(Integer id);


}