package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2ViolationrectificationinstructionTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmCheckplanitemTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2ViolationrectificationinstructionTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.BmCheckplanitemTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2ViolationConfigService {


    @Resource
    private Bm2ViolationrectificationinstructionTblMapper mapper;

    @Resource
    private BmCheckplanitemTblMapper itemMapper;

    /**
     * 查询所有单个违规项整改指导配置
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize,String itemId) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2ViolationrectificationinstructionTbl> list = mapper.query(start, pageSize,itemId);
        int total = mapper.selectTotal(itemId);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个单个违规项整改指导配置
     *
     * @param id
     * @return
     */
    public Bm2ViolationrectificationinstructionTbl queryById(String id) {
        Bm2ViolationrectificationinstructionTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加违规项整改指导配置
     *
     * @param tbl
     */
    @Transactional
    public void add(Bm2ViolationrectificationinstructionTbl tbl) {
        tbl.setInstructionid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改违规项整改指导配置
     *
     * @param tbl
     */
    @Transactional
    public void update(Bm2ViolationrectificationinstructionTbl tbl) {

        mapper.updateByPrimaryKeySelective(tbl);
    }


    /**
     * 删除违规项整改指导配置
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询违规项整改指导配置
     *
     */
    @Transactional
    public List<BmCheckplanitemTbl> queryItem() {
        return itemMapper.queryItem();
    }
    /**
     * 查询违规项整改指导配置
     *
     */
    @Transactional
    public List<BmCheckplanitemTbl> queryItemById(int id) {
        return itemMapper.queryItemById(id);
    }


}
