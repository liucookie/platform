package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmSecsofttypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmSecsofttypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmSecSoftService {


    @Resource
    private BmSecsofttypeTblMapper mapper;

    /**
     * 查询信息安全软件类别
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryType(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSecsofttypeTbl> list = mapper.queryType(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个信息安全软件类别
     *
     * @param id
     * @return
     */
    public BmSecsofttypeTbl queryById(String id) {
        BmSecsofttypeTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加信息安全软件类别
     *
     * @param type
     */
    @Transactional
    public void addType(BmSecsofttypeTbl type) {

        type.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改信息安全软件类别
     *
     * @param type
     */
    @Transactional
    public void updateType(BmSecsofttypeTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改信息安全软件类别
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
