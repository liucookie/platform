package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.ApprovesuggestionselectTbl;
import com.hangyu.platform.web.backBusiness.mapper.ApprovesuggestionselectTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表单审批意见管理·
 * @auther  liuXuan
 * @date 2020/2/4
 */
@Service
public class ApproveSuggestService {

    @Resource
    private ApprovesuggestionselectTblMapper mapper;

    /**
     * 查询所有表单审批意见
     *
     * @return
     */
    public Map<String, Object> query(String formId,String orgName,int pageNum,int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        List<ApprovesuggestionselectTbl> list = mapper.select(formId,orgName,start,pageSize);
        int total = mapper.selectTotal(formId,orgName);
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
    public ApprovesuggestionselectTbl queryById(int id) {
        ApprovesuggestionselectTbl softWare = mapper.selectByPrimaryKey(id);
        return softWare;
    }

    /**
     * 增加
     *
     * @param approve
     */
    @Transactional
    public void add(ApprovesuggestionselectTbl approve) {
        mapper.insert(approve);
    }

    /**
     * 修改
     *
     * @param softWare
     */
    @Transactional
    public void update(ApprovesuggestionselectTbl softWare) {
        mapper.updateByPrimaryKeySelective(softWare);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(Integer id){
        mapper.deleteByPrimaryKey(id);
    }
}
