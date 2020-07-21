package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.CardWuyuanaccesscontroltypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.CardWuyuanaccesscontroltypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardWuYuanAccessTypeService {


    @Resource
    private CardWuyuanaccesscontroltypeTblMapper mapper;

    /**
     * 查询五院门禁授权证件种类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<CardWuyuanaccesscontroltypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个五院门禁授权证件种类
     *
     * @param id
     * @return
     */
    public CardWuyuanaccesscontroltypeTbl queryById(int id) {
        CardWuyuanaccesscontroltypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加五院门禁授权证件种类
     *
     * @param type
     */
    @Transactional
    public void addType(CardWuyuanaccesscontroltypeTbl type) {

        mapper.insert(type);
    }

    /**
     * 修改五院门禁授权证件种类
     *
     * @param type
     */
    @Transactional
    public void updateType(CardWuyuanaccesscontroltypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除五院门禁授权证件种类
     *
     * @param id
     */
    @Transactional
    public void deleteType(int id) {
        mapper.deleteByPrimaryKey(id);
    }


}
