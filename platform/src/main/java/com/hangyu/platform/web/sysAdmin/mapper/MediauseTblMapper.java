package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.MediauseTbl;
import java.util.List;

public interface MediauseTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(MediauseTbl record);

    int insertSelective(MediauseTbl record);

    List<MediauseTbl> query(int start, int pageSize);

    int selectTotal();

    MediauseTbl selectByPrimaryKey(String id);



    int updateByPrimaryKeySelective(MediauseTbl record);

    int updateByPrimaryKey(MediauseTbl record);
}