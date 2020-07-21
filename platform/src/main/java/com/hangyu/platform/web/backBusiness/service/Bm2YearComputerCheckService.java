package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2YearplancomputeronlinecheckTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2YearplancomputeronlinecheckTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.vo.YearcheckAddVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年度计算机在线检查管理
 *
 * @auther liuXuan
 * @date 2020/2/26
 */
@Service
public class Bm2YearComputerCheckService {

    @Resource
    private Bm2YearplancomputeronlinecheckTblMapper mapper;

    @Resource
    private BmStaffTblMapper staffMapper;



    /**
     * 查询所有年度计算机在线检查
     *
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(String year, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2YearplancomputeronlinecheckTbl> list = mapper.select(year, start, pageSize);
        int total = mapper.selectTotal(year);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    public List<Bm2YearplancomputeronlinecheckTbl> addPlan(YearcheckAddVO tbl) {
        int year = tbl.getYear();
        int startMonth = tbl.getStartMonth();
        int endMonth = tbl.getEndMonth();
        double allRate = tbl.getCheckrate();
        //总的月数
        int allMonth = endMonth - startMonth;
        //平均检查率,保留两位小数
        double everyRate = CommonUtils.roundValue(allRate/(allMonth+1),2);
        List<Bm2YearplancomputeronlinecheckTbl> list = new ArrayList<>();
        //查询数据有没有重复
        for (int i = startMonth; i <= endMonth; i++) {
            Bm2YearplancomputeronlinecheckTbl data = mapper.selectByYearMonth(year, i);
            if (null != data) {
                throw new PlatException(year + "年" + i + "月" + "在线检查计划已存在!");
            }
            //添加计划
            Bm2YearplancomputeronlinecheckTbl checktbl = new Bm2YearplancomputeronlinecheckTbl();
            checktbl.setPlanname(year + "年" + i + "月分" + "计算机在线检查计划");
            checktbl.setYearnum(year);
            checktbl.setMonthnum(i);
            checktbl.setBegindate(year + "-" + i + "-" + "05");
            checktbl.setEnddate(year + "-" + i + "-" + "25");
            //检查率
            checktbl.setCheckrate(everyRate);
            checktbl.setPersonincharge(tbl.getUserId());
            BmStaffTbl staff = staffMapper.selectByUserId(tbl.getUserId());
            checktbl.setChargeName(null == staff ? null : staff.getUsername());
            // todo 修改未获取的id
            checktbl.setCreator(tbl.getUserId());
            checktbl.setCreatName(null == staff ? null : staff.getUsername());
            list.add(checktbl);
        }
        return list;
    }

    /**
     * 增加
     *
     * @param list
     */
    @Transactional
    public void add(List<Bm2YearplancomputeronlinecheckTbl> list) {
        for (Bm2YearplancomputeronlinecheckTbl tbl : list){
            tbl.setYearplanid(CommonUtils.generateUUID());
            mapper.insert(tbl);
        }
    }

    /**
     * 修改
     *
     * @param list
     */
    @Transactional
    public void update(List<Bm2YearplancomputeronlinecheckTbl> list) {
        list.forEach(tbl ->{
            mapper.updateByPrimaryKey(tbl);
        });
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
