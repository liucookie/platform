package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmSysdefinetypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmSysdefinetypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSysdefineTypeService {



    @Resource
    private BmSysdefinetypeTblMapper typeMapper;

    /**
     * 查询所有保密制度类别管理
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String,Object> queryType(int pageNum, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSysdefinetypeTbl> list = typeMapper.selectAllType(start, pageSize);
        int total = typeMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    /**
     * 查询单个保密制度类别管理
     *
     * @param id
     * @return
     */
    public BmSysdefinetypeTbl queryById(String id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加保密制度类别管理
     * @param type
     */
    @Transactional
    public void addType(BmSysdefinetypeTbl type){

        type.setDefinetypeid(CommonUtils.generateUUID());
        typeMapper.insert(type);
    }

    /**
     * 修改保密制度类别管理
     * @param type
     */
    @Transactional
    public void updateType(BmSysdefinetypeTbl type){

        typeMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改保密制度类别管理
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        typeMapper.deleteByPrimaryKey(id);
    }


}
