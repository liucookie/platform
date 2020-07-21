package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.mapper.SecretcontrolparticularTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.SecretcontrolparticularTblMapper;
import com.hangyu.platform.web.backBusiness.vo.CooperationQueryVO;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactionTbl;
import com.hangyu.platform.web.sysAdmin.service.BaseCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国家秘密二级目录管理
 *
 * @auther liuXuan
 * @date 2020/2/12
 */
@Service
public class SecretCountryTwoService {

    @Resource
    private SecretcontrolparticularTblMapper mapper;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private BaseCodeService codeService;


    /**
     * 查询所有国家秘密二级目录
     *
     * @return
     */
    public Map<String, Object> query(String levelId, String name, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<SecretcontrolparticularTbl> list = mapper.select(levelId, name, start, pageSize);
        int total = mapper.selectTotal(levelId, name).size();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @return
     */
    public List<SecretcontrolparticularTbl> exportExcel(String levelId, String name) {
        List<SecretcontrolparticularTbl> list = mapper.selectTotal(levelId, name);
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public SecretcontrolparticularTbl queryById(String id) {
        SecretcontrolparticularTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(SecretcontrolparticularTbl info) {
        info.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(info);
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(SecretcontrolparticularTbl info) {
        mapper.updateByPrimaryKey(info);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            SecretcontrolparticularTbl info = new SecretcontrolparticularTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            //部门
            String orgName = (String) list.get(i)[0];
            info.setDeptid(organizationService.queryIdByName(orgName));
            //类型
            String typeName = (String) list.get(i)[1];
            info.setNamer(codeService.queryIdByName(typeName));
            info.setNamer((String) list.get(i)[2]);
            //密集
            String secretName = (String) list.get(i)[3];
            info.setSecretlevelid(codeService.queryIdByName(secretName));
            info.setKeepsecretdate((String) list.get(i)[4]);
            info.setSecretmodel((String) list.get(i)[5]);
            info.setScope((String) list.get(i)[6]);
            info.setRemarkr((String) list.get(i)[7]);
            mapper.insert(info);
        }
    }
}
