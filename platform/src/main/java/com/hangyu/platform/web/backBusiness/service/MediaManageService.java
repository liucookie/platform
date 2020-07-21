package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.MediacommenuseTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.TzMediamanagementTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.MediacommenuseTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.TzMediamanagementTblMapper;
import com.hangyu.platform.web.backBusiness.vo.MediaManageQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信息化设备-台账管理管理
 *
 * @auther liuXuan
 * @date 2020/2/14
 */
@Service
public class MediaManageService {

    @Resource
    private TzMediamanagementTblMapper mapper;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private MediacommenuseTblMapper useMapper;


    /**
     * 查询所有信息化设备-台账管理
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(MediaManageQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<TzMediamanagementTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询借出介质信息
     *
     * @param
     * @return
     */
    public Map<String, Object> queryBorrowInfo(String mediaId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<MediacommenuseTbl> list = useMapper.select(mediaId, start, pageSize);
        //计算过期时间，用当前的日期减去，预计归还的日期
        list.forEach(tbl -> {
            long date = DateUtils.betweenDays(tbl.getExpectedreturntime(), DateUtils.getCurrentDate1());
            tbl.setDay(date);
        });
        int total = useMapper.selectTotal(mediaId);
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
    public List<TzMediamanagementTbl> exportExcel(MediaManageQueryVO vo) {
        List<TzMediamanagementTbl> list = mapper.selectAll(vo);
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TzMediamanagementTbl queryById(String id) {
        TzMediamanagementTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(TzMediamanagementTbl tbl) {
        tbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(TzMediamanagementTbl tbl) {
        mapper.updateByPrimaryKeySelective(tbl);
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
            TzMediamanagementTbl info = new TzMediamanagementTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setOrgid(null == organization ? null : organization.getUniqueid());

            String userName = (String) list.get(i)[1];
            BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
            info.setStaffid(null == staffTbl ? null : staffTbl.getStaffid());

            info.setMediaid((String) list.get(i)[2]);
            //密级
            info.setSecretlevel((String) list.get(i)[3]);

            info.setEquipid(String.valueOf(list.get(i)[4]));
            info.setBrand(String.valueOf(list.get(i)[5]));
            info.setUsage(String.valueOf(list.get(i)[6]));
            info.setUsestate(String.valueOf(list.get(i)[7]));
            info.setMediasize(String.valueOf(list.get(i)[8]));
            info.setChipserialnumber(String.valueOf(list.get(i)[9]));
            info.setRemark(String.valueOf(list.get(i)[10]));
            mapper.insert(info);
        }
    }
}
