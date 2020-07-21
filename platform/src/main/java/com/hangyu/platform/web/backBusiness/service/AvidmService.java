package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.mapper.AvidmLevelintegrateMapper;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AVIDM定密集成管理
 * @auther  liuXuan
 * @date 2020/1/15
 */
@Service
public class AvidmService {

    @Resource
    private AvidmLevelintegrateMapper mapper;

    /**
     * 查询所有AVIDM定密集成
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(AvidmQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<AvidmLevelintegrate> list = mapper.select(vo);
        int total = mapper.selectTotal(vo).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public AvidmLevelintegrate queryById(int id) {
        AvidmLevelintegrate avidmLevelintegrate = mapper.selectByPrimaryKey(id);
        return avidmLevelintegrate;
    }

    /**
     * 增加
     *
     * @param avidmLevelintegrate
     */
    @Transactional
    public void add(AvidmLevelintegrate avidmLevelintegrate) {
        mapper.insert(avidmLevelintegrate);
    }

    /**
     * 修改
     *
     * @param avidmLevelintegrate
     */
    @Transactional
    public void update(AvidmLevelintegrate avidmLevelintegrate) {
        mapper.updateByPrimaryKeySelective(avidmLevelintegrate);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(int id){
        mapper.deleteByPrimaryKey(id);
    }
}
