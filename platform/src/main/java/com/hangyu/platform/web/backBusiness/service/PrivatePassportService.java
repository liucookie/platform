package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.TzPrivatepassportTbl;
import com.hangyu.platform.web.backBusiness.dto.UsbkeyTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.TzPrivatepassportTblMapper;
import com.hangyu.platform.web.backBusiness.vo.UsbKeyQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 因私护照管理
 * @auther  liuXuan
 * @date 2020/2/18
 */
@Service
public class PrivatePassportService {

    @Resource
    private TzPrivatepassportTblMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private BasecodeMapper basecodeMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;


    /**
     * 查询所有因私护照
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(UsbKeyQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<TzPrivatepassportTbl> list = mapper.select(vo);
        for (TzPrivatepassportTbl sever : list){
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
//    public List<TzPrivatepassportTbl> exportExcel(UsbKeyQueryVO vo) {
//        List<TzPrivatepassportTbl> list = mapper.selectAll(vo);
//        for (TzPrivatepassportTbl tbl : list){
//
//        }
//        return list;
//    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TzPrivatepassportTbl queryById(String id) {
        TzPrivatepassportTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(TzPrivatepassportTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(TzPrivatepassportTbl tbl) {
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
            TzPrivatepassportTbl info = new TzPrivatepassportTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());

            String userName =  (String) list.get(i)[1];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setStaffid(null == staffTbl ? null : staffTbl.getStaffid());

            info.setZhiwu((String) list.get(i)[2]);
            //密级
            String secretName = (String) list.get(i)[3];
            info.setMiji(basecodeMapper.queryIdByName(secretName));

            info.setPosttype(String.valueOf(list.get(i)[4]));
            info.setPassportnumber(String.valueOf(list.get(i)[5]));
            info.setQfdate(String.valueOf(list.get(i)[6]));
            info.setQfplace(String.valueOf(list.get(i)[7]));
            info.setYouxiaoqi(String.valueOf(list.get(i)[8]));
            info.setRemark(String.valueOf(list.get(i)[9]));
            mapper.insert(info);
        }
    }
}
