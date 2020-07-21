package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmLibtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmLibtypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmLibraryService {


    @Resource
    private BmLibtypeTblMapper mapper;

    /**
     * 查询计算机其他属性
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryType(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmLibtypeTbl> list = mapper.queryType(start, pageSize);
        list.forEach(id -> {
            //根据父级type查询出父级名称
            BmLibtypeTbl bmLibtypeTbl = mapper.selectByPrimaryKey(id.getToptypeid());
            id.setToptypename(null == bmLibtypeTbl ? null : bmLibtypeTbl.getTypename());
        });
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个计算机其他属性
     *
     * @param id
     * @return
     */
    public BmLibtypeTbl queryById(String id) {
        BmLibtypeTbl bmLibtypeTbl = mapper.selectByPrimaryKey(id);
        BmLibtypeTbl type1 = mapper.selectByPrimaryKey(bmLibtypeTbl.getToptypeid());
        bmLibtypeTbl.setToptypename(type1 == null ? null : type1.getTypename());
        return bmLibtypeTbl;
    }

    /**
     * 添加计算机其他属性
     *
     * @param type
     */
    @Transactional
    public void addType(BmLibtypeTbl type) {

        type.setTypeid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改计算机其他属性
     *
     * @param type
     */
    @Transactional
    public void updateType(BmLibtypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改计算机设备其他属性
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
