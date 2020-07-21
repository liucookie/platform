package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.GuoneivisitpointTbl;
import com.hangyu.platform.web.sysAdmin.mapper.GuoneivisitpointTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.GuoneivisitpointTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryVisitPersonService {


    @Resource
    private GuoneivisitpointTblMapper mapper;

    /**
     * 查询国内人员参观部位
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize,String accessName,String orgName) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<GuoneivisitpointTbl> list = mapper.query(start, pageSize,accessName,orgName);
        int total = mapper.selectTotal(accessName,orgName);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询国内人员参观部位
     *
     * @param id
     * @return
     */
    public GuoneivisitpointTbl queryById(String id) {
        GuoneivisitpointTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加国内人员参观部位
     *
     * @param type
     */
    @Transactional
    public void addType(GuoneivisitpointTbl type) {
        type.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保国内人员参观部位
     *
     * @param type
     */
    @Transactional
    public void updateType(GuoneivisitpointTbl type) {
        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除国内人员参观部位
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
