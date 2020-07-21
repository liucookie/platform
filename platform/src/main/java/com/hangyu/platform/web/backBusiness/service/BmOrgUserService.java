package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;
import com.hangyu.platform.web.backBusiness.dto.BmOrguserTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgContentMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrguserTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 保密机构管理员工信息表
 */
@Service
public class BmOrgUserService {

    @Resource
    private BmOrguserTblMapper orgUserTblMapper;


    /**
     * 批量更新保密机构员工信息（userId,orgId）
     *
     * @return BmOrgManageVO
     */
    @Transactional
    public void updateByOrgId(List<BmOrguserTbl> userList) {
        orgUserTblMapper.updateByUserId(userList);
    }

    /**
     * 根据组织id在机构人员表中查询
     *
     * @param orgId
     * @return
     */
    public List<BmOrguserTbl> selectByOrgId(String orgId) {
        List<BmOrguserTbl> list = orgUserTblMapper.selectByOrgId(orgId);
        return list;
    }

    /**
     * 增加数据
     * @param bmOrgTbl
     */
    public void add(BmOrgTbl bmOrgTbl) {
        //如果机构下有成员，处理成员信息
        if (CollectionUtils.isNotEmpty(bmOrgTbl.getBmStaffTblList())) {
            for (BmStaffTbl st : bmOrgTbl.getBmStaffTblList()) {
                //orgUser_tbl数据
                BmOrguserTbl user = new BmOrguserTbl();
                user.setUniqueid(CommonUtils.generateUUID());
                user.setUserid(st.getStaffid());
                user.setOrgid(bmOrgTbl.getOrgid());
                orgUserTblMapper.insert(user);
            }
        }
    }


}