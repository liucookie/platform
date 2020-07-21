package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.TzMediamanagementTbl;
import com.hangyu.platform.web.backBusiness.dto.TzPortablemanagementTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.TzPortablemanagementTblMapper;
import com.hangyu.platform.web.backBusiness.vo.MediaManageQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 便携机管理
 * @auther  liuXuan
 * @date 2020/2/17
 */
@Service
public class PortableManageService {

    @Resource
    private TzPortablemanagementTblMapper mapper;
    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;


    /**
     * 查询所有便携机
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(MediaManageQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<TzPortablemanagementTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
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
    public List<TzPortablemanagementTbl> exportExcel(MediaManageQueryVO vo) {
        List<TzPortablemanagementTbl> list = mapper.selectAll(vo);
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TzPortablemanagementTbl queryById(String id) {
        TzPortablemanagementTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(TzPortablemanagementTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(TzPortablemanagementTbl tbl) {
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(String id){
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
            TzPortablemanagementTbl info = new TzPortablemanagementTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());

            String userName = (String) list.get(i)[1];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setStaffid(null == staffTbl ? null : staffTbl.getStaffid());

            info.setAssetnumber((String) list.get(i)[2]);
            //密级
            info.setSecretlevel((String) list.get(i)[3]);

            info.setBrand(String.valueOf(list.get(i)[4]));
            info.setUsage(String.valueOf(list.get(i)[5]));
            info.setUsestate(String.valueOf(list.get(i)[6]));
            info.setInstallationtime(String.valueOf(list.get(i)[7]));
            info.setDiskserialnumber(String.valueOf(list.get(i)[8]));
            info.setRemark(String.valueOf(list.get(i)[9]));
            mapper.insert(info);
        }
    }
}
