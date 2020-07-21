package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckitemfoulactionmappingTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckitemfoulactionmappingTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionMappingVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2FoulactionlMappingService {


    @Resource
    private Bm2CheckitemfoulactionmappingTblMapper mapper;


    /**
     * 查询保密信用映射配置
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize, String checkItemId, String type, String behavior, int checkType) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2FoulactionMappingVO> list = mapper.query(start, pageSize, checkItemId, type, behavior, checkType);
        int total = mapper.queryAll(checkItemId, type, behavior, checkType).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询全部数据
     * @param checkItemId
     * @param type
     * @param behavior
     * @param checkType
     * @return
     */
    public List<Bm2FoulactionMappingVO> queryAll(String checkItemId, String type, String behavior, int checkType) {
        List<Bm2FoulactionMappingVO> list = mapper.queryAll(checkItemId, type, behavior, checkType);
        return list;
    }

    /**
     * 查询保密信用映射配置
     *
     * @param id
     * @return
     */
    public Bm2FoulactionMappingVO queryById(String id) {
        Bm2FoulactionMappingVO type = mapper.selectByPrimaryKey(id);
        return type;
    }


    /**
     * 添加保密信用映射配置
     *
     * @param type
     */
    @Transactional
    public void add(Bm2CheckitemfoulactionmappingTbl type) {
        if (CollectionUtils.isNotEmpty(type.getList())) {
            for (String id : type.getList()) {
                Bm2CheckitemfoulactionmappingTbl type1 = new Bm2CheckitemfoulactionmappingTbl();
                type1.setMappingid(CommonUtils.generateUUID());
                type1.setCheckitem(type.getCheckitem());
                type1.setFoulactionid(id);
                type1.setChecktype(type.getChecktype());
                mapper.insert(type1);
            }
        }

    }

    /**
     * 修改保保密信用映射配置
     *
     * @param type
     */
    @Transactional
    public void update(Bm2CheckitemfoulactionmappingTbl type) {
        //删除原来的数据
        mapper.deleteByFoulId(type.getFoulactionid());
        add(type);
    }


    /**
     * 删除保密信用映射配置
     *
     * @param list
     */
    @Transactional
    public void delete(List<String> list) {
        mapper.deleteByPrimaryKey(list);
    }


}
