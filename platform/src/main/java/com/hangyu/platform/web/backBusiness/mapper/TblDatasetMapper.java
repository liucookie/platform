package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.TblDataset;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblDatasetMapper {


    int deleteByPrimaryKey(Integer tid);

    int insert(TblDataset record);


    TblDataset selectByPrimaryKey();


    int updateByPrimaryKey(TblDataset record);
}