package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import com.hangyu.platform.web.backBusiness.dto.NationalsecurityTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.mapper.ComputerinfoMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.vo.ComputerQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信息化设备-台账管理管理
 * @auther  liuXuan
 * @date 2020/2/4
 */
@Service
public class ConputerInfoService {

    @Resource
    private ComputerinfoMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    /**
     * 查询所有信息化设备-台账管理
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(ComputerQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Computerinfo> list = mapper.select(vo);
        //设置部门信息
        for (Computerinfo info : list){
            //根据子集查询父级
            Organization organization = orgMapper.queryParentName(info.getOrgid());
            info.setDeptName(null == organization ? null : organization.getOrgname());
        }
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }
    /**
     * 导出excel
     *
     * @param vo
     * @return
     */
    public List<Computerinfo> exportExcel(ComputerQueryVO vo) {
        List<Computerinfo> list = mapper.selectAll(vo);
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Computerinfo queryById(String id) {
        Computerinfo softWare = mapper.selectByPrimaryKey(id);
        return softWare;
    }

    /**
     * 增加
     *
     * @param softWare
     */
    @Transactional
    public void add(Computerinfo softWare) {
        softWare.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(softWare);
    }

    /**
     * 修改
     *
     * @param softWare
     */
    @Transactional
    public void update(Computerinfo softWare) {
        mapper.updateByPrimaryKeySelective(softWare);
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
