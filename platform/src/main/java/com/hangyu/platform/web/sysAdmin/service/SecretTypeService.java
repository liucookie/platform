package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2CheckspecialtypeTbl;
import com.hangyu.platform.web.sysAdmin.dto.SecrettypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CheckspecialtypeTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.SecrettypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecretTypeService {


    @Resource
    private SecrettypeTblMapper mapper;

    /**
     * 查询国家秘密类别
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<SecrettypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询国家秘密类别
     *
     * @param id
     * @return
     */
    public SecrettypeTbl queryById(String id) {
        SecrettypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加国家秘密类别
     *
     * @param type
     */
    @Transactional
    public void addType(SecrettypeTbl type) {
        type.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保国家秘密类别
     *
     * @param type
     */
    @Transactional
    public void updateType(SecrettypeTbl type) {
        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除国家秘密类别
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
