package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckresultTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSystemitemTblMapper;
import com.hangyu.platform.web.backBusiness.vo.DeptPunishQueryVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二级部门考核处罚管理
 *
 * @auther liuXuan
 * @date 2020/2/21
 */
@Service
public class Bm2DeptPunishService {

    @Resource
    private Bm2DeptcheckresultTblMapper mapper;

    @Resource
    private BmSystemitemTblMapper itemMapper;


    /**
     * 查询所有二级部门考核处罚
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(DeptPunishQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2DeptcheckresultTbl> list = mapper.select(vo);
        //拼接处罚结果
        for (Bm2DeptcheckresultTbl result : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("扣信誉积分").append(result.getDscore()).append(",").append("扣保密补贴").append(result.getDconsub()).append("月");
            sb.append("扣效益工资").append(result.getDwages()).append("元");
            result.setResult(sb.toString());
        }
        int total = mapper.selectTotal(vo);
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
    public Bm2DeptcheckresultTbl queryById(String id) {
        Bm2DeptcheckresultTbl tbl = mapper.selectByPrimaryKey(id);
        //展示处罚依据和违反规定
        String deregulation = tbl.getDeregulation();
        //处理处罚依据
        String punishbasis = tbl.getPunishbasis();
        tbl.setDeregulationList(dealItems(deregulation));
        tbl.setPublishList(dealItems(punishbasis));
        return tbl;
    }

    private List<BmSystemitemTbl> dealItems(String info) {
        List<BmSystemitemTbl> list = new ArrayList<>();
        if (StringUtils.isNotEmpty(info)) {
            List<String> itemIds = Arrays.asList(StringUtils.split(info, ","));
            list = itemMapper.selectBatch(itemIds);
        }
        return list;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Bm2DeptcheckresultTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        //违反规定，用，分割
        String deregulation = dealSystemItem(tbl.getDeregulationList());
        //处理处罚依据
        String punishbasis = dealSystemItem(tbl.getPublishList());
        tbl.setDeregulation(deregulation);
        tbl.setPunishbasis(punishbasis);
        mapper.insert(tbl);
    }

    private String dealSystemItem(List<BmSystemitemTbl> list) {
        StringBuilder derSb = new StringBuilder();
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(der -> {
                derSb.append(der.getItemid()).append(",");
            });
            derSb.substring(0, derSb.lastIndexOf(","));
        }
        return derSb.toString();
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Bm2DeptcheckresultTbl tbl) {
        String deregulation = dealSystemItem(tbl.getDeregulationList());
        String punishbasic = dealSystemItem(tbl.getPublishList());
        tbl.setDeregulation(deregulation);
        tbl.setPunishbasis(punishbasic);
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
