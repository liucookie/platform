package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.CardGuomipasstypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.CardGuomipasstypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardCountryTypeService {


    @Resource
    private CardGuomipasstypeTblMapper mapper;

    /**
     * 查询现场检查问题类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<CardGuomipasstypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个现五院国密出入证证件种类
     *
     * @param id
     * @return
     */
    public CardGuomipasstypeTbl queryById(int id) {
        CardGuomipasstypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加五院国密出入证证件种类
     *
     * @param type
     */
    @Transactional
    public void addType(CardGuomipasstypeTbl type) {

        mapper.insert(type);
    }

    /**
     * 修改五院国密出入证证件种类
     *
     * @param type
     */
    @Transactional
    public void updateType(CardGuomipasstypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除五院国密出入证证件种类
     *
     * @param id
     */
    @Transactional
    public void deleteType(int id) {
        mapper.deleteByPrimaryKey(id);
    }


}
