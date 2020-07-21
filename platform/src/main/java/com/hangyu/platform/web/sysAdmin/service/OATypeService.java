package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.OaequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.OaequiptypeTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.OATypeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OATypeService {


    @Resource
    private OaequiptypeTblMapper typeMapper;

    /**
     * 查询办公自动化类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    public OATypeVO queryType(int pageNum, int pageSize) {
        OATypeVO vo = new OATypeVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<OaequiptypeTbl> list = typeMapper.selectAllType(start, pageSize);
        int total = typeMapper.selectTotal();
        vo.setOaequiptypeTblList(list);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询单个办公自动化类型
     *
     * @param id
     * @return
     */
    public OaequiptypeTbl queryById(String id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加办公自动化类型
     * @param type
     */
    @Transactional
    public void addType(OaequiptypeTbl type){

        type.setUniqueid(CommonUtils.generateUUID());
        typeMapper.insert(type);
    }

    /**
     * 修改办公自动化类型
     * @param type
     */
    @Transactional
    public void updateType(OaequiptypeTbl type){

        typeMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改办公自动化类型
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        typeMapper.deleteByPrimaryKey(id);
    }


}
