package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2ExaminestandardhandleTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2ExaminestandardhandleTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.ExamHandleQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2ExamHandleService {


    @Resource
    private Bm2ExaminestandardhandleTblMapper mapper;

    /**
     * 查询考核处理措施
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(ExamHandleQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(),vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2ExaminestandardhandleTbl> list = mapper.query(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询考核处理措施
     *
     * @param id
     * @return
     */
    public Bm2ExaminestandardhandleTbl queryById(String id) {
        Bm2ExaminestandardhandleTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }

    /**
     * 添加考核处理措施
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2ExaminestandardhandleTbl type) {

        type.setExstdhandleid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保考核处理措施
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2ExaminestandardhandleTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除考核处理措施
     *
     * @param list
     */
    @Transactional
    public void deleteType(List<String> list) {
        mapper.deleteByPrimaryKey(list);
    }


}
