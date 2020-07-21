package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmPictureTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BmPictureTblMapper {

    int deleteByPrimaryKey(String id);

    int insert(BmPictureTbl record);

    List<BmPictureTbl> select(@Param("start") int start, @Param("pageSize") int pageSize);

    List<BmPictureTbl> queryByTypeId(String typeId);

    int selectTotal();

    BmPictureTbl selectByPrimaryKey(String id);

    List<BmPictureTbl> selectBatch(List<String> list);

    int updateByPrimaryKey(BmPictureTbl record);
}