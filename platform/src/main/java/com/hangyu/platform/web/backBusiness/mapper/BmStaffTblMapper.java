package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.vo.StaffQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmStaffTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(BmStaffTbl record);

    int insertSelective(BmStaffTbl record);

    int insertBatch(List<BmStaffTbl> list);

    BmStaffTbl selectByPrimaryKey(Integer id);
    //用员工的id选择性更新
    int updateByPrimaryKeySelective(BmStaffTbl record);

    int updateByPrimaryKeyWithBLOBs(BmStaffTbl record);

    int updateByPrimaryKey(BmStaffTbl record);

    //根据部门id查询出员工信息
    List<BmStaffTbl> queryByDeptId(String deptId);

    List<BmStaffTbl> queryByOrgId(String orgId);

    BmStaffTbl selectByUserId(String userId);

    BmStaffTbl selectByUserName(String userName);

    BmStaffTbl  selectByAccount(String account);

    List<BmStaffTbl> queryStaffInfoPage(StaffQueryVO vo);

    List<BmStaffTbl> selectBatch(List<String> list);

    int selectTotal (StaffQueryVO vo);
    //根据机构id查员工，new
    List<BmStaffTbl> getStaffByOrgId(@Param("orgid") String orgid);

    int deleteByUserId(@Param("userid") String userid);

    List<BmStaffTbl> queryExportInfo(StaffQueryVO vo);

    List<BmStaffTbl> selectByLevelId(@Param("levelId") String levelId,@Param("list") List<String> ids);
}