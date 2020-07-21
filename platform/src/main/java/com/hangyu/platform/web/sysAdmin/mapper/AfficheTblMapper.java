package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.AfficheTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AfficheTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(AfficheTbl record);

    int insertSelective(AfficheTbl record);


    AfficheTbl selectByPrimaryKey(String id);

    List<AfficheTbl> queryAffiche(@Param("start") int start,@Param("pageSize")  int pageSize);

    int selectTotal();

    int publish(@Param("id")  String id,@Param("isPublish") int isPublish);

    int updateByPrimaryKeySelective(AfficheTbl record);
}