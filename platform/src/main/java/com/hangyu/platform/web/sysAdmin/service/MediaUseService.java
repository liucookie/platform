package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.MediauseTbl;
import com.hangyu.platform.web.sysAdmin.mapper.MediauseTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.MediauseTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MediaUseService {


    @Resource
    private MediauseTblMapper mapper;

    /**
     * 查询介质便携机用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<MediauseTbl> list = mapper.query(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询介质便携机用户
     *
     * @param id
     * @return
     */
    public MediauseTbl queryById(String id) {
        MediauseTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加介质便携机用户
     *
     * @param type
     */
    @Transactional
    public void addType(MediauseTbl type) {
        type.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保介质便携机用户
     *
     * @param type
     */
    @Transactional
    public void updateType(MediauseTbl type) {
        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除介质便携机用户
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
