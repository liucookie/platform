package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.MediacommenuseTbl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MediacommenuseTblMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(MediacommenuseTbl record);

    MediacommenuseTbl selectByPrimaryKey(Integer id);

    List<MediacommenuseTbl> select(@Param("mediaId") String mediaId,
                                   @Param("start")int start, @Param("pageSize") int pageSize);

    int selectTotal(@Param("mediaId") String mediaId);

    int updateByPrimaryKey(MediacommenuseTbl record);
}