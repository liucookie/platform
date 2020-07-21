package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2KeepsecretqualificationtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2KeepsecretqualificationtypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmCheckSpecialTypeService {


    @Resource
    private Bm2CheckspecialtypeTblMapper mapper;

    /**
     * 查询现场检查问题类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2CheckspecialtypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询现场检查问题类型
     *
     * @param id
     * @return
     */
    public Bm2CheckspecialtypeTbl queryById(String id) {
        Bm2CheckspecialtypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加现场检查问题类型
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2CheckspecialtypeTbl type) {

        type.setChecktypeid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保现场检查问题类型
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2CheckspecialtypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除现场检查问题类型
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
