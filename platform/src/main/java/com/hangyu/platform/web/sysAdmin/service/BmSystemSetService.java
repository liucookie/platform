package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmSettingTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmSettingTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSystemSetService {


    @Resource
    private BmSettingTblMapper setMapper;

    /**
     * 查询系统参数配置
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object>  querySet(int pageNum, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSettingTbl> list = setMapper.querySet(start, pageSize);
        int total = setMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    /**
     * 查询单个系统参数配置
     *
     * @param id
     * @return
     */
    public BmSettingTbl queryById(Integer id) {
        return setMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加系统参数配置
     * @param settingTbl
     */
    @Transactional
    public void addSet(BmSettingTbl settingTbl){

        setMapper.insert(settingTbl);
    }

    /**
     * 修改计系统参数配置
     * @param settingTbl
     */
    @Transactional
    public void updateSet(BmSettingTbl settingTbl){

        setMapper.updateByPrimaryKeySelective(settingTbl);
    }


    /**
     * 修改系统参数配置
     * @param id
     */
    @Transactional
    public void deleteSet(Integer id){

        setMapper.deleteByPrimaryKey(id);
    }


}
