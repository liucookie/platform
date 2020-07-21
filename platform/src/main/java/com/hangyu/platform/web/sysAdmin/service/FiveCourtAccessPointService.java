package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.CardFenyuanaccesscontroltypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.WuyuanaccesspointTbl;
import com.hangyu.platform.web.sysAdmin.mapper.CardFenyuanaccesscontroltypeTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.WuyuanaccesspointTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.WuyuanAccessPointQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FiveCourtAccessPointService {


    @Resource
    private WuyuanaccesspointTblMapper mapper;

    /**
     * 查询五院门禁点
     *
     * @return
     */
    public Map<String, Object> query(WuyuanAccessPointQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<WuyuanaccesspointTbl> list = mapper.queryByAddition(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询五院门禁点
     *
     * @param id
     * @return
     */
    public WuyuanaccesspointTbl queryById(int id) {
        WuyuanaccesspointTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加五院门禁点
     *
     * @param type
     */
    @Transactional
    public void add(WuyuanaccesspointTbl type) {

        mapper.insert(type);
    }

    /**
     * 修改五院门禁点
     *
     * @param type
     */
    @Transactional
    public void update(WuyuanaccesspointTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除五院门禁点
     *
     * @param id
     */
    @Transactional
    public void delete(int id) {
        mapper.deleteByPrimaryKey(id);
    }


}
