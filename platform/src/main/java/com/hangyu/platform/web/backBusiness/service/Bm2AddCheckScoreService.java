package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckresultTbl;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrsultTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSystemitemTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckresultTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckrsultTblMapper;
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
 * 信誉积分加分管理
 *
 * @auther liuXuan
 * @date 2020/2/26
 */
@Service
public class Bm2AddCheckScoreService {

    @Resource
    private Bm2LocalcheckrsultTblMapper mapper;

    @Resource
    private Bm2DeptcheckresultTblMapper deptMapper;

    @Resource
    private BmSystemitemTblMapper itemMapper;

    /**
     * 查询所有信誉积分加分
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(DeptPunishQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        //1代表惩罚 0加分
        vo.setIsAdd("0");
        List<Bm2LocalcheckrsultTbl> list = mapper.select(vo);
        //拼接处罚结果
        for (Bm2LocalcheckrsultTbl result : list) {
            StringBuilder sb = new StringBuilder();
            //type = 0,部门
            if (result.getChecktype() == 0) {
                sb.append("奖励信誉积分").append(result.getDscore());
            } else {
                //个人
                sb.append("奖励信誉积分").append(result.getDscore()).append(",").append("奖励保密补贴").append(result.getDconsub()).append("月");
                sb.append("奖励效益工资").append(result.getDwages()).append("元");
            }
            result.setResult(sb.toString());
        }
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询分院考核
     */
    public List<Bm2LocalcheckrsultTbl> queryFengYuanCheck(String year, String deptId, String userId, String month, int type) {
        List<Bm2LocalcheckrsultTbl> list ;
        if (type == 1) {
            //查询checkresult表,0，部门，1个人
            list = mapper.queryFengYuanCheck(year, deptId, userId, month, "'0",1);
            for (Bm2LocalcheckrsultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(tbl.getDscore());
                tbl.setResult(sb.toString());
            }
        } else {
            //查询checkresult表
            list = mapper.queryFengYuanCheck(year, deptId, userId, month, "'1",1);
            for (Bm2LocalcheckrsultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(tbl.getDscore()).append(",").append("扣除保密补贴").append(tbl.getDconsub()).append("月");
                sb.append("扣除效益工资").append(tbl.getDwages()).append("元");
                tbl.setResult(sb.toString());
            }
        }
        return list;
    }

    /**
     * 查询加分明细
     */
    public List<Bm2LocalcheckrsultTbl> queryAddResult(String year, String deptId, String userId, String month, int type) {
        List<Bm2LocalcheckrsultTbl> list ;
        if (type == 1) {
            //查询checkresult表,0，部门，1个人
            list = mapper.queryFengYuanCheck(year, deptId, userId, month, "'0",0);
            for (Bm2LocalcheckrsultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("奖励信誉积分").append(tbl.getDscore());
                tbl.setResult(sb.toString());
            }
        } else {
            //查询checkresult表
            list = mapper.queryFengYuanCheck(year, deptId, userId, month, "'1",0);
            for (Bm2LocalcheckrsultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("奖励信誉积分").append(tbl.getDscore()).append(",").append("奖励保密补贴").append(tbl.getDconsub()).append("月");
                sb.append("奖励效益工资").append(tbl.getDwages()).append("元");
                tbl.setResult(sb.toString());
            }
        }
        return list;
    }

    /**
     * 查询部门考核
     */
    public List<Bm2DeptcheckresultTbl> queryDeptCheck(String year, String deptId, String userId, String month, int type) {
        List<Bm2DeptcheckresultTbl> list ;
        if (type == 1) {
            //查询deptresult表,0，部门，1个人
            list = deptMapper.queryDeptCheck(year, deptId, userId, month, "0");
            for (Bm2DeptcheckresultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(tbl.getDscore());
                tbl.setResult(sb.toString());
            }
        } else {
            //查询deptresult表
            list = deptMapper.queryDeptCheck(year, deptId, userId, month, "1");
            for (Bm2DeptcheckresultTbl tbl : list) {
                StringBuilder sb = new StringBuilder();
                sb.append("扣除信誉积分").append(tbl.getDscore()).append(",").append("扣除保密补贴").append(tbl.getDconsub()).append("月");
                sb.append("扣除效益工资").append(tbl.getDwages()).append("元");
                tbl.setResult(sb.toString());
            }
        }
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Bm2LocalcheckrsultTbl queryById(String id) {
        Bm2LocalcheckrsultTbl tbl = mapper.selectByPrimaryKey(id);
        //展示处罚依据和违反规定
        String deregulation = tbl.getDeregulation();
        tbl.setDeregulationList(dealItems(deregulation));
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
    public void add(Bm2LocalcheckrsultTbl tbl) {
        tbl.setIsadd(0);
        tbl.setUniqueid(CommonUtils.generateUUID());
        //违反规定，用，分割
        String deregulation = dealSystemItem(tbl.getDeregulationList());
        tbl.setDeregulation(deregulation);
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
    public void update(Bm2LocalcheckrsultTbl tbl) {
        //违反规定，用，分割
        String deregulation = dealSystemItem(tbl.getDeregulationList());
        tbl.setDeregulation(deregulation);
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
