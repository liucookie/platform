package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import com.hangyu.platform.web.backBusiness.dto.Userhz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserhzMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Userhz record);


    List<Userhz> select(@Param("start")int start, @Param("pageSize") int pageSize, @Param("orgId") String orgId,
                             @Param("userId") String userId);

    int selectTotal(@Param("orgId") String orgId,
                    @Param("userId") String userId);

    Userhz selectByPrimaryKey(Integer id);

    Userhz queryIsCheck(@Param("type") int type , @Param("userId") String userId,
                        @Param("year") int year,@Param("month") int month);

    int updateByPrimaryKey(Userhz record);
}