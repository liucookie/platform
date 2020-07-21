package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.SecrettypeTbl;
import java.util.List;

public interface SecrettypeTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(SecrettypeTbl record);

    int insertSelective(SecrettypeTbl record);

    List<SecrettypeTbl> queryType(int start,int pageSize);

    int selectTotal();

    SecrettypeTbl selectByPrimaryKey(String id);



    int updateByPrimaryKeySelective(SecrettypeTbl record);

    int updateByPrimaryKey(SecrettypeTbl record);
}