package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffworkTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BmStaffWorkService {

    @Resource
    private BmStaffworkTblMapper workMapper;

    /**
     * 新增家庭成员
     *
     * @param staffTbl
     */
    @Transactional
    public void addWork(BmStaffTbl staffTbl) {
        //家庭人员表
        staffTbl.getStaffworkTbls().forEach(work -> {
            if (work.getId() != null){
                work.setId(null);
            }
            work.setWorkid(CommonUtils.generateUUID());
            work.setStaffid(staffTbl.getStaffid());
            workMapper.insert(work);

        });

    }


    /**
     * 删除
     *
     * @param staffId
     */
    @Transactional
    public void delWorker(String staffId) {
        //家庭人员表
        workMapper.deleteByStaffId(staffId);

    }

    /**
     * 员工页面批量修改工作
     */
    @Transactional
    public void updateBatch(BmStaffTbl staffTbl) {
        delWorker(staffTbl.getStaffid());
        if (CollectionUtils.isNotEmpty(staffTbl.getStaffstudyTbls())){
            addWork(staffTbl);
        }
    }
}
