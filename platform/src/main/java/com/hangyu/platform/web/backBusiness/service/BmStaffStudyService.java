package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffstudyTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BmStaffStudyService {

    @Resource
    private BmStaffstudyTblMapper studyMapper;

    /**
     * 新增家庭成员
     *
     * @param staffTbl
     */
    @Transactional
    public void addStudy(BmStaffTbl staffTbl) {
        //家庭人员表
        staffTbl.getStaffstudyTbls().forEach(study -> {
            if (study.getId() != null){
                study.setId(null);
            }
            //新增加
            study.setStudyid(CommonUtils.generateUUID());
            study.setStaffid(staffTbl.getStaffid());
            studyMapper.insert(study);
        });

    }


    /**
     * 删除
     *
     * @param staffId
     */
    @Transactional
    public void delStudy(String staffId) {
        //家庭人员表
        studyMapper.deleteByStaffId(staffId);

    }

    /**
     * 员工页面批量修改家庭
     */
    @Transactional
    public void updateBatch(BmStaffTbl staffTbl) {
        delStudy(staffTbl.getStaffid());
        if (CollectionUtils.isNotEmpty(staffTbl.getStaffstudyTbls())){
            addStudy(staffTbl);
        }
    }
}
