package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2ViolationrectificationinstructionTbl;

import java.util.List;

public interface Bm2ViolationrectificationinstructionTblMapper {


    int deleteByPrimaryKey(String instructionid);

    int insert(Bm2ViolationrectificationinstructionTbl record);

    int insertSelective(Bm2ViolationrectificationinstructionTbl record);



    Bm2ViolationrectificationinstructionTbl selectByPrimaryKey(String instructionid);

    List<Bm2ViolationrectificationinstructionTbl> query(int start,int pageSize,String itemId);

    int selectTotal(String itemId);

    int updateByPrimaryKeySelective(Bm2ViolationrectificationinstructionTbl record);

    int updateByPrimaryKeyWithBLOBs(Bm2ViolationrectificationinstructionTbl record);

    int updateByPrimaryKey(Bm2ViolationrectificationinstructionTbl record);
}