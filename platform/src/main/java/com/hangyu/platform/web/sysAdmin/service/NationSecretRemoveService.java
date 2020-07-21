package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.NationlevelremoveopinionTbl;
import com.hangyu.platform.web.sysAdmin.mapper.NationlevelremoveopinionTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NationSecretRemoveService {


    @Resource
    private NationlevelremoveopinionTblMapper mapper;

    /**
     * 查询国家秘密事项变更解除表承办人意见
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<NationlevelremoveopinionTbl> list = mapper.query(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询国家秘密事项变更解除表承办人意见
     *
     * @param id
     * @return
     */
    public NationlevelremoveopinionTbl queryById(String id) {
        NationlevelremoveopinionTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加国家秘密事项变更解除表承办人意见
     *
     * @param type
     */
    @Transactional
    public void addType(NationlevelremoveopinionTbl type) {
        type.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保国家秘密事项变更解除表承办人意见
     *
     * @param type
     */
    @Transactional
    public void updateType(NationlevelremoveopinionTbl type) {
        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除国家秘密事项变更解除表承办人意见
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
