package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckitemfoulactionmappingTbl;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionMappingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Bm2CheckitemfoulactionmappingTblMapper {


    int deleteByPrimaryKey(List<String> list);

    int insert(Bm2CheckitemfoulactionmappingTbl record);

    int insertSelective(Bm2CheckitemfoulactionmappingTbl record);
    int deleteByFoulId(String foulactionid);

    Bm2FoulactionMappingVO selectByPrimaryKey(String mappingid);

    //violationType 违规分类，checkType 检查分类
    List<Bm2FoulactionMappingVO> query(@Param("start") int start, @Param("pageSize") int pageSize, @Param("checkItemId") String checkItemId,
                                       @Param("violationType") String violationType,@Param("behavior")   String behavior,@Param("checkType")   int checkType);

    List<Bm2FoulactionMappingVO> queryAll(@Param("checkItemId") String checkItemId,
                                          @Param("violationType") String violationType,@Param("behavior")   String behavior,@Param("checkType")   int checkType);

    int updateByPrimaryKeySelective(Bm2CheckitemfoulactionmappingTbl record);

    int updateByPrimaryKey(Bm2CheckitemfoulactionmappingTbl record);
}