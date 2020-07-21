package com.hangyu.platform.web.logAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.logAdmin.dto.Loginfo;
import com.hangyu.platform.web.logAdmin.mapper.LoginfoMapper;
import com.hangyu.platform.web.logAdmin.vo.LogQueryVO;
import com.hangyu.platform.web.logAdmin.vo.LogVO;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogService {


    @Resource
    private LoginfoMapper loginfoMapper;
    @Resource
    private OrganizationMapper orgMapper;

    /**
     * 全局日志记录表
     *
     * @param loginfo
     */
    @Transactional
    public void addLog(Loginfo loginfo) {
        loginfo.setUniqueid(CommonUtils.generateUUID());
        loginfoMapper.insert(loginfo);
    }

    /**
     * 查询用户日志
     */
    public LogVO queryLog(LogQueryVO queryVO) {
        LogVO vo = new LogVO();
        int start = CommonUtils.getPageStart(queryVO.getPageNum(),queryVO.getPageSize());
        queryVO.setPageNum(start);
        List<Loginfo> logInfos = loginfoMapper.selectByPage(queryVO);
        dealLog(logInfos);
        int totalCount = loginfoMapper.selectAllLog(queryVO).size();
        vo.setLogInfoList(logInfos);
        vo.setTotalSize(totalCount);
        return vo;
    }

    /**
     * 处理部门
     * @param logInfos
     * @return
     */
    private List<Loginfo> dealLog(List<Loginfo> logInfos){
        logInfos.forEach(log -> {
            Organization organization = orgMapper.queryParentName(log.getDeptId());
            log.setOrgMemo(null == organization ? null : organization.getOrgname());
        });
        return logInfos;
    }
    /**
     * 导出excel
     *
     * @param queryVO
     */
    public List<Loginfo> exportExcel( LogQueryVO queryVO) {
        List<Loginfo> logInfos =  loginfoMapper.selectAllLog(queryVO);
        dealLog(logInfos);
        return logInfos;
    }

    /**
     * 用户登录日志增加
     */
    @Transactional
    public void addLoginLog(BmStaffTbl staffTbl) {
        Loginfo loginfo = new Loginfo();
        loginfo.setUniqueid(CommonUtils.generateUUID());
        loginfo.setUsername(staffTbl.getUsername());
        loginfo.setStaffaccoutname(staffTbl.getAccoutname());
        loginfo.setModule("登录模块");
        loginfo.setOperateaction("登录系统");
        loginfo.setStatus("执行成功");
        loginfoMapper.insert(loginfo);
    }

}
