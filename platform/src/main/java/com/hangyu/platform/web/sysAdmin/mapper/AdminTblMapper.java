package com.hangyu.platform.web.sysAdmin.mapper;

import com.hangyu.platform.web.sysAdmin.dto.AdminTbl;


public interface AdminTblMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AdminTbl record);

    int insertSelective(AdminTbl record);

    AdminTbl selectByPrimaryKey(Integer id);

    AdminTbl queryByAccount(String account);

    int updateByPrimaryKeySelective(AdminTbl record);

    int updateByPrimaryKey(AdminTbl record);
}