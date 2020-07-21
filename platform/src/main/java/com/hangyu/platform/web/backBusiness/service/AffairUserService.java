package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.web.backBusiness.dto.AffairsexerciseinfoUsers;
import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.mapper.AffairsexerciseinfoUsersMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 外事活动人员i信息
 *
 * @auther liuXuan
 * @date 2020/2/11
 */
@Service
public class AffairUserService {

    @Resource
    private AffairsexerciseinfoUsersMapper mapper;

    /**
     * 查询外事活动 下机构人员信息
     *
     * @param id
     * @return
     */
    public List<AffairsexerciseinfoUsers> query(String id) {
        List<AffairsexerciseinfoUsers> list = mapper.select(id);
        return list;
    }


    /**
     * 增加
     *
     * @param list
     */
    @Transactional
    public void add(List<AffairsexerciseinfoUsers> list, String uniqueId) {
        for (AffairsexerciseinfoUsers user : list) {
            user.setStaffid(uniqueId);
            mapper.insert(user);
        }
    }

    /**
     * 修改
     *
     * @param list
     * @param uniqueId
     */
    @Transactional
    public void update(List<AffairsexerciseinfoUsers> list, String uniqueId) {
        //先删除原数据
        delete(uniqueId);
        add(list,uniqueId);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
    }
}
