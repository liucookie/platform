package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.web.sysAdmin.dto.SystemsetTbl;
import com.hangyu.platform.web.sysAdmin.mapper.SystemsetTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SystemSetService {

    @Resource
    private SystemsetTblMapper mapper;

    /**
     * 查询配置
     * @return
     */
    public SystemsetTbl querySet(){
        SystemsetTbl systemsetTbl = mapper.selectByPrimaryKey();
        return systemsetTbl;
    }

    /**
     * 修改配置
     * @param set
     */
    @Transactional
    public void updateSet(SystemsetTbl set){
        mapper.updateByPrimaryKeySelective(set);
    }
}
