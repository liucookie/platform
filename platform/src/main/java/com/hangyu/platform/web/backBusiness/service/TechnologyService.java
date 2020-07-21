package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.TechnologythesissecrecyTbl;
import com.hangyu.platform.web.backBusiness.mapper.TechnologythesissecrecyTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyService {

    @Resource
    private TechnologythesissecrecyTblMapper mapper;
    /**
     * 查询所有发表论文
     * @return
     */
    public Map<String, Object>query(int pageSize,int pageNum,String formId,String type) {
        int start = CommonUtils.getPageStart(pageNum,pageSize);
        Map<String,Object> map = new HashMap<>();
        List<TechnologythesissecrecyTbl> list = mapper.query(start,pageSize,formId,type);
        int total = mapper.selectTotal(formId,type);
        map.put("list",list);
        map.put("total",total);
        return map;
    }

}
