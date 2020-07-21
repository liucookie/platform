package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmOrguserTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BmOrguserTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BmOrguserTbl record);

    int insertSelective(BmOrguserTbl record);


    BmOrguserTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BmOrguserTbl record);

    int updateByPrimaryKey(BmOrguserTbl record);
    //批量查询，根据机构id在员工表中查询下属员工
    List<BmOrguserTbl> selectByIds(@Param("list") List<String> list,@Param("orgId") String orgId);

    int updateByUserId(List<BmOrguserTbl> list);

    //根据组织id在机构人员表中查询
    List<BmOrguserTbl> selectByOrgId(String orgId);

    //根据组织id删除orgUser数据
    int deleteByOrgId(String orgId);





}