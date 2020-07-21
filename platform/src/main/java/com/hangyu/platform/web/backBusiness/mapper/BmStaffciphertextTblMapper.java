package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextTbl;
import com.hangyu.platform.web.backBusiness.vo.StaffCipherQueryVO;

import java.util.List;


public interface BmStaffciphertextTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(BmStaffciphertextTbl record);



    BmStaffciphertextTbl selectByPrimaryKey(String id);

    List<BmStaffciphertextTbl> query(StaffCipherQueryVO vo);

    int selectTotal(StaffCipherQueryVO vo);


    int updateByPrimaryKey(BmStaffciphertextTbl record);

    List<BmStaffciphertextTbl> queryExport(StaffCipherQueryVO vo);
}