package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.CooperationinfoTbl;
import com.hangyu.platform.web.backBusiness.mapper.CooperationinfoTblMapper;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 协作配套管理
 * @auther  liuXuan
 * @date 2020/2/10
 */
@Service
public class CooperationService {

    @Resource
    private CooperationinfoTblMapper mapper;

    /**
     * 查询所有协作配套
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(CooperationQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<CooperationinfoTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     * @param vo
     * @return
     */
    public List<CooperationinfoTbl> exportExcel (CooperationQueryVO vo){
        List<CooperationinfoTbl> list = mapper.selectTotal(vo);
        list.forEach(id ->{
            if (StringUtils.equals(id.getIssecret(),"0")){
                id.setIssecret("是");
            }else {
                id.setIssecret("否");
            }
        });
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public CooperationinfoTbl queryById(String id) {
        CooperationinfoTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(CooperationinfoTbl info) {
        info.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(info);
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(CooperationinfoTbl info) {
        mapper.updateByPrimaryKey(info);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(String id){
        mapper.deleteByPrimaryKey(id);
    }
}
