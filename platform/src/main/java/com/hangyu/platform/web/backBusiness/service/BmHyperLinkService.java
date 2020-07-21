package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmHyperlinkTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 平台链接管理
 *
 * @auther liuXuan
 * @date 2020/3/6
 */
@Service
public class BmHyperLinkService {

    @Resource
    private BmHyperlinkTblMapper mapper;


    /**
     * 查询所有平台链接管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmHyperlinkTbl> list = mapper.select(start, pageSize);
        int total = mapper.selectTotal();
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
    public BmHyperlinkTbl queryById(String id) {
        BmHyperlinkTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmHyperlinkTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmHyperlinkTbl tbl){
        mapper.updateByPrimaryKey(tbl);
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
    }

}
