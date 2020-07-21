package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSlsetofficerTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolparticularTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSlsetofficerTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
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
 * 定密责任人
 *
 * @auther liuXuan
 * @date 2020/2/12
 */
@Service
public class BmSetOfficerService {

    @Resource
    private BmSlsetofficerTblMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Autowired
    private BaseCodeService codeService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private StaffService staffService;

    /**
     * 查询所有定密人
     *
     * @return
     */
    public Map<String, Object> query(String typeId, String orgId, String userId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmSlsetofficerTbl> list = mapper.select(typeId, orgId, userId, start, pageSize);
        //查询处室
        list.forEach(tbl -> {
            Organization organization = orgMapper.queryParentName(tbl.getOrgid());
            tbl.setDeptName(null == organization ? null : organization.getOrgname());
        });
        int total = mapper.selectTotal(typeId, orgId, userId);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @param vo
     * @return
     */
//    public List<BmSlsetofficerTbl> exportExcel(CooperationQueryVO vo) {
//        List<BmSlsetofficerTbl> list = mapper.selectTotal(vo);
//        return list;
//    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmSlsetofficerTbl queryById(String id) {
        BmSlsetofficerTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(BmSlsetofficerTbl info) {
        info.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(info);
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(BmSlsetofficerTbl info) {
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
            BmSlsetofficerTbl info = new BmSlsetofficerTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            //类型
            String typeName = (String) list.get(i)[0];
            info.setSltype(codeService.queryIdByName(typeName));
            //部门
            String orgName = (String) list.get(i)[1];
            info.setOrgid(organizationService.queryIdByName(orgName));
            String userName = (String) list.get(i)[2];
            info.setUserid(staffService.queryByUserName(userName));
            //职务
            info.setPost( (String) list.get(i)[3]);
            info.setSecretrange((String) list.get(i)[4]);
            info.setIstrain((String) list.get(i)[5]);
            info.setTraindate((String) list.get(i)[6]);
            info.setValid((String) list.get(i)[7]);
            info.setValid((String) list.get(i)[8]);
            mapper.insert(info);
        }
    }
}
