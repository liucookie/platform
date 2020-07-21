package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.CardFenyuanaccesscontroltypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.CardFenyuanaccesscontroltypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardXianAccessTypeService {


    @Resource
    private CardFenyuanaccesscontroltypeTblMapper mapper;

    /**
     * 查询西安分院院门禁授权证件种类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<CardFenyuanaccesscontroltypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询西安分院院门禁授权证件种类
     *
     * @param id
     * @return
     */
    public CardFenyuanaccesscontroltypeTbl queryById(int id) {
        CardFenyuanaccesscontroltypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加西安分院院门禁授权证件种类
     *
     * @param type
     */
    @Transactional
    public void addType(CardFenyuanaccesscontroltypeTbl type) {

        mapper.insert(type);
    }

    /**
     * 修改西安分院院门禁授权证件种类
     *
     * @param type
     */
    @Transactional
    public void updateType(CardFenyuanaccesscontroltypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除西安分院院门禁授权证件种类
     *
     * @param id
     */
    @Transactional
    public void deleteType(int id) {
        mapper.deleteByPrimaryKey(id);
    }


}
