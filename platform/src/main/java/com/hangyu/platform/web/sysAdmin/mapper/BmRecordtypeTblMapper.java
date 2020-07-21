package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.BmRecordtypeTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmRecordtypeTblMapper {


    int deleteByPrimaryKey(List<String> list);

    int insert(BmRecordtypeTbl record);

    int insertSelective(BmRecordtypeTbl record);


    BmRecordtypeTbl selectByPrimaryKey(String id);

    List<BmRecordtypeTbl> queryByType(int type,String topId,int start,int pageSize);

    List<BmRecordtypeTbl> queryName(int type,String topId);

    int selectMaxOrder(String topId,int type);

    int selectTotal(int type,String topId,int start,int pageSize);

    int updateByPrimaryKeySelective(BmRecordtypeTbl record);

    int updateByPrimaryKeyWithBLOBs(BmRecordtypeTbl record);

    int updateByPrimaryKey(BmRecordtypeTbl record);
}