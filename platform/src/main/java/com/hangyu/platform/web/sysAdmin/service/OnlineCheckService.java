package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.web.sysAdmin.dto.BmCheckitemadvancedsetTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmCheckitemsetTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmCheckitemadvancedsetTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.BmCheckitemsetTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OnlineCheckService {

    @Resource
    private BmCheckitemadvancedsetTblMapper itemMapper;

    @Resource
    private BmCheckitemsetTblMapper setMapper;

    /**
     * 查询
     * @return
     */
    public Map<String,Object> query(){
        Map<String,Object> map = new HashMap<>();
        List<BmCheckitemadvancedsetTbl> itemList = itemMapper.query();
        List<BmCheckitemsetTbl> setList = setMapper.query();
        map.put("itemList",itemList);
        map.put("setList",setList);
        return map;
    }

    /**
     * update
     * @param map
     */
    @Transactional
    public void update(Map<String,Object> map){
        List<BmCheckitemadvancedsetTbl> itemList = (List<BmCheckitemadvancedsetTbl>)map.get("itemList");
        List<BmCheckitemsetTbl> setList = (List<BmCheckitemsetTbl>)map.get("setList");

        itemMapper.updateBatch(itemList);
        setMapper.updateBatch(setList);

    }





}
