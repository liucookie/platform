package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.*;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.ServerequipinfoMapper;
import com.hangyu.platform.web.backBusiness.mapper.ServerpropertymatchTblMapper;
import com.hangyu.platform.web.backBusiness.vo.ServerManageQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务器台账管理
 *
 * @auther liuXuan
 * @date 2020/2/17
 */
@Service
public class ServerManageService {

    @Resource
    private ServerequipinfoMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private ServerpropertymatchTblMapper serverMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private BasecodeMapper basecodeMapper;


    /**
     * 查询所有服务器台账
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(ServerManageQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Serverequipinfo> list = mapper.select(vo);
        for (Serverequipinfo sever : list) {
            //根据子集查询父级
            Organization organization = orgMapper.queryParentName(sever.getOrgid());
            sever.setDeptName(null == organization ? null : organization.getOrgname());
        }
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
    public List<Serverequipinfo> exportExcel(ServerManageQueryVO vo) {
        List<Serverequipinfo> list = mapper.selectAll(vo);
        for (Serverequipinfo sever : list) {
            //根据子集查询父级
            Organization organization = orgMapper.queryParentName(sever.getOrgid());
            sever.setDeptName(null == organization ? null : organization.getOrgname());
        }
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Serverequipinfo queryById(String id) {
        Serverequipinfo tbl = mapper.selectByPrimaryKey(id);
        //查询出其他 属性
        List<String> propertyIds = serverMapper.selectByComputerId(id);
        tbl.setPropertyIds(propertyIds);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Serverequipinfo tbl) {
        String computerId = CommonUtils.generateUUID();
        tbl.setUniqueid(computerId);
        //其他属性
        List<String> propertyIds = tbl.getPropertyIds();
        if (CollectionUtils.isNotEmpty(propertyIds)) {
            //加入到属性表
            addProperty(propertyIds,computerId);
        }
        mapper.insert(tbl);
    }

    /**
     * 其他设备属性关联表
     * @param list
     * @param computerId
     */
    private void addProperty(List<String> list, String computerId) {
        for (String id : list) {
            ServerpropertymatchTbl tbl = new ServerpropertymatchTbl();
            tbl.setComputerpropertyid(computerId);
            tbl.setPropertymatchid(CommonUtils.generateUUID());
            tbl.setServerequipinfoid(id);
            serverMapper.insert(tbl);
        }
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Serverequipinfo tbl) {
        //其他属性
        List<String> propertyIds = tbl.getPropertyIds();
        //先删除
        serverMapper.deleteByPrimaryKey(tbl.getUniqueid());
        if (CollectionUtils.isNotEmpty(propertyIds)) {
            //加入到属性表
            addProperty(propertyIds,tbl.getUniqueid());
        }
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
        //先删除其他属性
        serverMapper.deleteByPrimaryKey(id);
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
            Serverequipinfo info = new Serverequipinfo();
            info.setUniqueid(CommonUtils.generateUUID());
            info.setEquipboxnum((String) list.get(i)[0]);
            info.setBoxplace((String) list.get(i)[1]);
            info.setSbxh( (String) list.get(i)[2]);
            String orgName = (String) list.get(i)[3];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());
            String userName =  (String) list.get(i)[4];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setInusestaffid(null == staffTbl ? null : staffTbl.getStaffid());
            info.setSbbm((String) list.get(i)[5]);
            info.setPlacement((String) list.get(i)[6]);
            //密级
            String secretName = (String) list.get(i)[7];
            info.setSecretlevelid(basecodeMapper.queryIdByName(secretName));
            info.setOsname((String) list.get(i)[8]);
            info.setOsinstalldate((String) list.get(i)[9]);
            info.setHarddiscno((String) list.get(i)[10]);
            info.setIp((String) list.get(i)[11]);
            info.setMac((String) list.get(i)[12]);
            info.setVmip((String) list.get(i)[13]);
            info.setVmmac((String) list.get(i)[14]);
            String useStateName = (String) list.get(i)[15];
            info.setUsestateid(basecodeMapper.queryIdByName(useStateName));
            info.setServerequipinfomemo((String) list.get(i)[16]);
            mapper.insert(info);
        }
    }
}
