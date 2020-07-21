package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2YearplanspecialcheckTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2YearplanspecialcheckTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 年度部门专项检查管理
 *
 * @auther liuXuan
 * @date 2020/2/27
 */
@Service
public class Bm2YearDeptCheckService {

    @Resource
    private Bm2YearplanspecialcheckTblMapper mapper;

    @Resource
    private BmStaffTblMapper staffMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private Bm2CheckspecialtypeTblMapper typeMapper;


    /**
     * 查询所有年度部门专项检查
     *
     * @param year
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(String year, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2YearplanspecialcheckTbl> list = mapper.select(year, start, pageSize);
        //处理机构名称和类型名称
        for (Bm2YearplanspecialcheckTbl tbl : list) {
            //处理后的机构id集合
            List<String> orgIds = Arrays.asList(StringUtils.split(tbl.getPlancheckorgid(), "/"));
            List<String> orgNames = organizationMapper.queryNameBatch(orgIds);
            //处理后 的机构名称
            tbl.setOrgName(String.join(",", orgNames));
            //类型集合
            List<String> typeIds = Arrays.asList(StringUtils.split(tbl.getPlanchecktypeid(), "/"));
            List<String> typeNames = typeMapper.queryNameBatch(typeIds);
            //处理后 的类型名称
            tbl.setTypeName(String.join(",", typeNames));
        }
        int total = mapper.selectTotal(year);
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
    public Bm2YearplanspecialcheckTbl queryById(String id) {
        Bm2YearplanspecialcheckTbl tbl = mapper.selectByPrimaryKey(id);
        List<String> orgIds = Arrays.asList(StringUtils.split(tbl.getPlancheckorgid(), "/"));
        //类型集合
        List<String> typeIds = Arrays.asList(StringUtils.split(tbl.getPlanchecktypeid(), "/"));
        tbl.setOrgIds(orgIds);
        tbl.setTypeList(typeIds);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Bm2YearplanspecialcheckTbl tbl) {
        //所有的检查类型id
        List<String> typeIds = tbl.getTypeList();
        tbl.setPlanchecktypeid(String.join("/", typeIds));
        //机构id
        List<String> orgIds = tbl.getOrgIds();
        tbl.setPlancheckorgid(String.join("/", orgIds));
        tbl.setYearplanid(CommonUtils.generateUUID());
        //设置创建人 todo  修改从request
        tbl.setCreatorid(tbl.getPlanchargerid());
        //设置开始时间结束时间
        tbl.setBegindate(tbl.getYearnum() + "-" + tbl.getMonthnum() + "-" + "01");
        tbl.setEnddate(tbl.getYearnum() + "-" + tbl.getMonthnum() + "-" + "28");
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Bm2YearplanspecialcheckTbl tbl) {
        //所有的检查类型id
        List<String> typeIds = tbl.getTypeList();
        tbl.setPlanchecktypeid(String.join("/", typeIds));
        //机构id
        List<String> orgIds = tbl.getOrgIds();
        tbl.setPlancheckorgid(String.join("/", orgIds));
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
