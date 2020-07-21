package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSlsetsendfileTbl;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmSlsetsendfileTblMapper {


    int deleteByPrimaryKey(String id);

    int deleteHistory(String id);

    int insert(BmSlsetsendfileTbl record);

    int insertSelective(BmSlsetsendfileTbl record);


    BmSlsetsendfileTbl selectByPrimaryKey(String id);

    List<BmSlsetsendfileTbl> selectHistory(String id);

    List<BmSlsetsendfileTbl> select(@Param("name")String name, @Param("start")int start, @Param("pageSize") int pageSize);

    int  selectTotal(@Param("name")String name);



    int updateByPrimaryKeySelective(BmSlsetsendfileTbl record);

    int updateByPrimaryKey(BmSlsetsendfileTbl record);
}