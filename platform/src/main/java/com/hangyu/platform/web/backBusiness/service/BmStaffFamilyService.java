package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStafffamilyTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BmStaffFamilyService {

    @Resource
    private BmStafffamilyTblMapper stafffamilyTblMapper;

    /**
     * 新增家庭成员
     *
     * @param staffTbl
     */
    @Transactional
    public void addFamily(BmStaffTbl staffTbl) {
        //家庭人员表
        staffTbl.getStafffamilyList().forEach(family -> {
            if (family.getId() != null){
                family.setId(null);
            }
            //新增加
            family.setFamid(CommonUtils.generateUUID());
            family.setStaffid(staffTbl.getStaffid());
            stafffamilyTblMapper.insert(family);
        });

    }


    /**
     * 删除
     *
     * @param staffId
     */
    @Transactional
    public void delFamily(String staffId) {
        //家庭人员表
        stafffamilyTblMapper.updateByPrimaryKey(staffId);

    }

    /**
     * 员工页面批量修改家庭
     */
    @Transactional
    public void updateBatch(BmStaffTbl staffTbl) {
        //修改时先删除原来的数据，再重新添加
        delFamily(staffTbl.getStaffid());
        if (CollectionUtils.isNotEmpty(staffTbl.getStafffamilyList())){
            addFamily(staffTbl);
        }
    }
}
