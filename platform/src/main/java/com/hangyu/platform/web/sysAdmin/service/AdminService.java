package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.web.sysAdmin.dto.AdminTbl;
import com.hangyu.platform.web.sysAdmin.mapper.AdminTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    @Resource
    private AdminTblMapper adminTblMapper;

    /**
     * 根据账号查询管理员
     * @param account
     * @return
     */
    public AdminTbl queryByAccount(String account){
        AdminTbl admin = adminTblMapper.queryByAccount(account);
        return admin;
    }
}
