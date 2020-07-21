package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.Oaequipinfo;
import com.hangyu.platform.web.backBusiness.dto.SecretcontrolscopeTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OaequipinfoMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.vo.ServerManageQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打印机设备-绘图仪管理
 * @auther  liuXuan
 * @date 2020/2/18
 */
@Service
public class OaManageService {

    @Resource
    private OaequipinfoMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private BasecodeMapper basecodeMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;
    /**
     * 查询所有打印机设备-绘图仪
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(ServerManageQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Oaequipinfo> list = mapper.select(vo);
        for (Oaequipinfo sever : list){
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
    public List<Oaequipinfo> exportExcel(ServerManageQueryVO vo) {
        List<Oaequipinfo> list = mapper.selectAll(vo);
        for (Oaequipinfo sever : list){
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
    public Oaequipinfo queryById(String id) {
        Oaequipinfo tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(Oaequipinfo tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(Oaequipinfo tbl) {
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
    public void     importExcel(MultipartFile file,String typeId) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            Oaequipinfo info = new Oaequipinfo();
            info.setEquiptypeid(typeId);
            info.setUniqueid(CommonUtils.generateUUID());
            info.setSbxh((String) list.get(i)[0]);
            info.setSbbm((String) list.get(i)[1]);
            //密级
            String secretName = (String) list.get(i)[2];
            info.setSecretlevelid(basecodeMapper.queryIdByName(secretName));
            String orgName = (String) list.get(i)[3];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());
            String userName =  (String) list.get(i)[4];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setStaffid(null == staffTbl ? null : staffTbl.getStaffid());
            info.setPlacement(String.valueOf(list.get(i)[5]));
            String useStateName = (String) list.get(i)[6];
            info.setUsestateid(basecodeMapper.queryIdByName(useStateName));
            info.setIp(String.valueOf( list.get(i)[7]));
            info.setInfomemo((String) list.get(i)[8]);
            mapper.insert(info);
        }
    }
}
