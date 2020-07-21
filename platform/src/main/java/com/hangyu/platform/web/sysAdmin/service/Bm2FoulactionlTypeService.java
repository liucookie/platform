package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactiontypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FoulactiontypeTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FoulactiontypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2FoulactionlTypeService {


    @Resource
    private Bm2FoulactiontypeTblMapper mapper;

    /**
     * 查询违规分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2FoulactiontypeTbl> list = mapper.query(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询所有行为分类
     * @return
     */
    public List<Bm2FoulactiontypeTbl> queryAll(){
        List<Bm2FoulactiontypeTbl> list = mapper.queryAll();
        return list;
    }

    /**
     * 查询违规分类
     *
     * @param id
     * @return
     */
    public Bm2FoulactiontypeTbl queryById(String id) {
        Bm2FoulactiontypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加违规分类
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2FoulactiontypeTbl type) {

        type.setFoulactiontypeid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保违规分类
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2FoulactiontypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除违规分类
     *
     * @param list
     */
    @Transactional
    public void deleteType(List<String> list) {
        mapper.deleteByPrimaryKey(list);
    }


}
