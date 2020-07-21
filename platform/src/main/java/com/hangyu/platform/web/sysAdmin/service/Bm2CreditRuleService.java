package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.web.sysAdmin.dto.Bm2CreditrulesettingTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2CreditrulesettingTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class Bm2CreditRuleService {


    @Resource
    private Bm2CreditrulesettingTblMapper mapper;

    /**
     * 查询保密信用积分规则配置
     *
     * @param year
     * @return
     */
    public Bm2CreditrulesettingTbl query(int year) {
        Bm2CreditrulesettingTbl tbl = mapper.queryByYear(year);
        return tbl;
    }




    /**
     * 修改保密信用积分规则配置
     *
     * @param type
     */
    @Transactional
    public void update(Bm2CreditrulesettingTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }




}
