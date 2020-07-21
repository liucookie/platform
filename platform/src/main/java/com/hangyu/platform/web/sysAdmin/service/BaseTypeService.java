package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.sysAdmin.dto.Basetype;
import com.hangyu.platform.web.sysAdmin.mapper.BasetypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BaseTypeService {

    @Resource
    private BasetypeMapper typeMapper;

    /**
     * 查询所有类型
     *
     * @return
     */
    public List<Basetype> query() {
        List<Basetype> list = typeMapper.select();
        return list;
    }

    /**
     * 查询所有类型
     *
     * @return
     */
    public Basetype queryDetail(String id) {
        Basetype type = typeMapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加
     * @param basetype
     */
    @Transactional
    public void add(Basetype basetype){
        basetype.setCreateperson(TokenUtils.getUserName());
        basetype.setTypeid(CommonUtils.generateUUID());
        typeMapper.insert(basetype);
    }

    /**
     * 修改
     * @param basetype
     */
    @Transactional
    public void update(Basetype basetype){
        typeMapper.updateByPrimaryKeySelective(basetype);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(String id){
        typeMapper.deleteByPrimaryKey(id);
    }
}
