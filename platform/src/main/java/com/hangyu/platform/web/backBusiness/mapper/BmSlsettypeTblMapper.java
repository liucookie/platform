package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.BmSlsettypeTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSlsettypeTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmSlsettypeTblMapper {
    int countByExample(BmSlsettypeTblExample example);

    int deleteByExample(BmSlsettypeTblExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BmSlsettypeTbl record);

    int insertSelective(BmSlsettypeTbl record);

    List<BmSlsettypeTbl> selectByExample(BmSlsettypeTblExample example);

    BmSlsettypeTbl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BmSlsettypeTbl record, @Param("example") BmSlsettypeTblExample example);

    int updateByExample(@Param("record") BmSlsettypeTbl record, @Param("example") BmSlsettypeTblExample example);

    int updateByPrimaryKeySelective(BmSlsettypeTbl record);

    int updateByPrimaryKey(BmSlsettypeTbl record);
}