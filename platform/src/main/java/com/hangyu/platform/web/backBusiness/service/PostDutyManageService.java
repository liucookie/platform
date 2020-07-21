package com.hangyu.platform.web.backBusiness.service;

import com.alibaba.fastjson.JSON;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.Yirenduogang;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.YirenduogangMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostDutyManageService {

    @Resource
    private YirenduogangMapper yirenduogangMapper;

    @Resource
    private OrganizationMapper organizationMapper;


    //批量和条件查询
    public Map<String, Object> selectAllFactor(String post, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        Yirenduogang yirenduogang = JSON.parseObject(post, Yirenduogang.class);
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Yirenduogang> list = yirenduogangMapper.selectAllFactor(yirenduogang, start, pageSize);
        for (Yirenduogang yi : list) {
            Organization organization = organizationMapper.queryParentName(yi.getDeptid());
            yi.setDeptid(organization == null ? null : organization.getOrgname());
        }
        map.put("total", yirenduogangMapper.selectTotal(yirenduogang));
        map.put("list", list);
        return map;
    }

    //单条查询
    public Yirenduogang select(String id) {
        Yirenduogang yirenduogang = yirenduogangMapper.select(id);
        return yirenduogang;
    }

    //批量删除
    public void delete(List<String> list) {
        yirenduogangMapper.delete(list);
    }

    //信息添加
    @Transactional
    public void insert(Yirenduogang yirenduogang) {
        yirenduogang.setUniqueid(CommonUtils.generateUUID());
        yirenduogangMapper.insert(yirenduogang);
    }

    //信息修改
    @Transactional
    public void update(Yirenduogang yirenduogang) {
        yirenduogangMapper.update(yirenduogang);
    }

    //导入Excel数据
    public void importExcel(MultipartFile file) {
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            Yirenduogang yirenduogang = new Yirenduogang();
            yirenduogang.setUniqueid(CommonUtils.generateUUID());
            if (list.get(i)[1].toString().equals("1") || list.get(i)[1].toString().equals("2")) {
                yirenduogang.setZhize((String) list.get(i)[0]);
                yirenduogang.setIscommon(Integer.parseInt(list.get(i)[1].toString()));
            } else {
                String orgName = (String) list.get(i)[0];
                String deptId = yirenduogangMapper.selectOrgId(orgName);
                yirenduogang.setDeptid(deptId);
                yirenduogang.setGangwei((String) list.get(i)[1]);
                yirenduogang.setZhize((String) list.get(i)[2]);
                int comm = Integer.parseInt(list.get(i)[3].toString());
                yirenduogang.setIscommon(comm);
            }
            yirenduogangMapper.insert(yirenduogang);
        }
    }

}