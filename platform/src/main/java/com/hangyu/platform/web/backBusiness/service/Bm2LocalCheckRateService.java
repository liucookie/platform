package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2LocalcheckrateTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckrateTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckrateTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.Bm2LocalcheckrsultTblMapper;
import com.hangyu.platform.web.sysAdmin.service.BaseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现场检查结果汇总
 *
 * @auther liuXuan
 * @date 2020/2/25
 */
@Service
public class Bm2LocalCheckRateService {

    @Resource
    private Bm2LocalcheckrateTblMapper mapper;

    @Resource
    private Bm2LocalcheckrsultTblMapper resultMapper;


    /**
     * 查询所有现场检查结果汇总
     *
     * @return
     */
    public Map<String, Object> query(String orgId, String checkId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2LocalcheckrateTbl> list = mapper.select(orgId, checkId, start, pageSize);
        //查询部门问题和个人问题
        for (Bm2LocalcheckrateTbl rate : list){
            //查询出部门的数量
            int deptNum = resultMapper.selectCount(rate.getDeptid(),rate.getPlanid(),0);
            //查询出个人数量
            int personNum = resultMapper.selectCount(rate.getDeptid(),rate.getPlanid(),1);
            rate.setDeptQuestNum(deptNum);
            rate.setPersonQuestNum(personNum);
        }
        int total = mapper.selectTotal(orgId, checkId);
        // todo    问题总数统计
        //问题部门数量 ,查询result那张表
         int deptIssueCount = resultMapper.queryPersonIssueCount(0);
        //存在问题总人数 ,1代表个人
        int personIssueCount = resultMapper.queryPersonIssueCount(1);
        //存在问题总数，先查询result那张表，再查询rate表
        int allQuestionCount = resultMapper.queryPersonAllQuestion();
        //部门问题总数
        int deptQuestionCount = resultMapper.queryPersonIssueCount(0);
        //个人问题总数
        int personAllQuestion = resultMapper.queryPersonIssueCount(1);
        map.put("deptIssueCount", deptIssueCount);
        map.put("personIssueCount", personIssueCount);
        map.put("allQuestionCount", allQuestionCount);
        map.put("deptQuestionCount", deptQuestionCount);
        map.put("personAllQuestion", personAllQuestion);
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 修改
     *
     * @param list
     */
    @Transactional
    public void update(List<Bm2LocalcheckrateTbl> list) {
        for (Bm2LocalcheckrateTbl rate : list){
            mapper.updateByPrimaryKey(rate);
        }
    }


}
