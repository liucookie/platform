package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Oaequipinfo;
import com.hangyu.platform.web.backBusiness.dto.UsbkeyTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.UsbkeyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.UsbkeyTblMapper;
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
 * usekey台账管理
 * @auther  liuXuan
 * @date 2020/2/18
 */
@Service
public class UsbKeyService {

    @Resource
    private UsbkeyTblMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private BasecodeMapper basecodeMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;


    /**
     * 查询所有usekey台账
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(UsbKeyQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<UsbkeyTbl> list = mapper.select(vo);
        for (UsbkeyTbl usb : list){
            //根据子集查询父级
            Organization organization = orgMapper.queryParentName(usb.getOrgid());
            usb.setDeptName(null == organization ? null : organization.getOrgname());
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
//    public List<UsbkeyTbl> exportExcel(UsbKeyQueryVO vo) {
//        List<UsbkeyTbl> list = mapper.selectAll(vo);
//        for (UsbkeyTbl tbl : list){
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
    public UsbkeyTbl queryById(String id) {
        UsbkeyTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(UsbkeyTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(UsbkeyTbl tbl) {
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
            UsbkeyTbl info = new UsbkeyTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());

            String userName =  (String) list.get(i)[1];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setUserid(null == staffTbl ? null : staffTbl.getStaffid());

            info.setUsbname((String) list.get(i)[2]);
            info.setUsbtype((String) list.get(i)[3]);
            //密级
            String secretName = (String) list.get(i)[4];
            info.setUsbsecret(basecodeMapper.queryIdByName(secretName));

            info.setGetdate(String.valueOf(list.get(i)[5]));
            info.setStartusedate(String.valueOf(list.get(i)[6]));
            info.setFactory(String.valueOf(list.get(i)[7]));
            mapper.insert(info);
        }
    }
}
