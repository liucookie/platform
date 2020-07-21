package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.OaLevelintegrate;
import com.hangyu.platform.web.backBusiness.mapper.OaLevelintegrateMapper;
import com.hangyu.platform.web.backBusiness.mapper.OaLevelintegrateMapper;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OA定密集成管理
 * @auther  liuXuan
 * @date 2020/2/4
 */
@Service
public class OALevelService {

    @Resource
    private OaLevelintegrateMapper mapper;

    /**
     * 查询所有OA定密集成
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(AvidmQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<OaLevelintegrate> list = mapper.select(vo);
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
    public OaLevelintegrate queryById(int id) {
        OaLevelintegrate avidmLevelintegrate = mapper.selectByPrimaryKey(id);
        return avidmLevelintegrate;
    }

    /**
     * 增加
     *
     * @param level
     */
    @Transactional
    public void add(OaLevelintegrate level) {
        mapper.insert(level);
    }

    /**
     * 修改
     *
     * @param level
     */
    @Transactional
    public void update(OaLevelintegrate level) {
        mapper.updateByPrimaryKeySelective(level);
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
