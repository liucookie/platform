package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.TokenUtils;
import com.hangyu.platform.web.sysAdmin.dto.Basecode;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseCodeService {

    @Resource
    private BasecodeMapper codeMapper;

    /**
     * 查询所有字典
     *
     * @return
     */
    public Map<String, Object> query(String id, int pageNum, int pageSize) {
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        List<Basecode> list = codeMapper.select(id, start, pageSize);
        int count = codeMapper.selectTotal(id);
        map.put("list", list);
        map.put("totalSize", count);
        return map;
    }

    /**
     * 查询所有字典
     *
     * @return
     */
    public List<Basecode> queryAll(String id) {
        List<Basecode> list = codeMapper.queryAll(id);
        return list;
    }

    /**
     * 查询所有字典
     *
     * @return
     */
    public Basecode queryDetail(String id) {
        Basecode type = codeMapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 增加
     *
     * @param basecode
     */
    @Transactional
    public void add(Basecode basecode) {
        basecode.setCreateperson(TokenUtils.getUserName());
        basecode.setId(CommonUtils.generateUUID());
        codeMapper.insert(basecode);
    }

    /**
     * 修改
     *
     * @param basecode
     */
    @Transactional
    public void update(Basecode basecode) {
        codeMapper.updateByPrimaryKeySelective(basecode);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        codeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 对外提供一个查询接口
     * 比如excel导入时，填写的是字典名称，所以要查询出基础字典的id
     * 适用于所有用名字在字典表的查询
     */
    public String queryIdByName(String name) {
        String id = codeMapper.queryIdByName(name);
        return StringUtils.isEmpty(id) ? null : id;
    }
}
