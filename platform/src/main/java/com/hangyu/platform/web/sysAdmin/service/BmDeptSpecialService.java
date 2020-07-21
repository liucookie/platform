package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmDeptSpecialService {


    @Resource
    private Bm2CheckspecialtypeTblMapper mapper;

    /**
     * 查询所有部门专项类型检查
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryType(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2CheckspecialtypeTbl> list = mapper.queryType(start, pageSize);

        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个部门专项类型检查
     *
     * @param id
     * @return
     */
    public Bm2CheckspecialtypeTbl queryById(String id) {
        Bm2CheckspecialtypeTbl bmLibtypeTbl = mapper.selectByPrimaryKey(id);
        return bmLibtypeTbl;
    }

    /**
     * 添加部门专项类型检查
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2CheckspecialtypeTbl type) {

        type.setChecktypeid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改部门专项类型检查
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2CheckspecialtypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改部门专项类型检查
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
