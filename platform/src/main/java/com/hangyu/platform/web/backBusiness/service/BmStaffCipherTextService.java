package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmSecrectwayTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextHf;
import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmSecrectwayTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffciphertextHfMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffciphertextTblMapper;
import com.hangyu.platform.web.backBusiness.vo.StaffCipherQueryVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 脱密期管理
 * liuxuan
 * 2020.1.19
 */
@Service
public class BmStaffCipherTextService {

    @Resource
    private BmStaffciphertextTblMapper staffCipherTextMapper;

    @Autowired
    private BmStaffVisitRecordService recordService;

    @Resource
    private BmStaffciphertextHfMapper recordMapper;

    @Resource
    private BmSecrectwayTblMapper awayMapper;

    /**
     * 查询所有脱密期人员
     *
     * @return
     */
    public Map<String, Object> query(StaffCipherQueryVO queryVO) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(queryVO.getPageNum(), queryVO.getPageSize());
        queryVO.setPageNum(start);
        List<BmStaffciphertextTbl> list = staffCipherTextMapper.query(queryVO);
        int total = staffCipherTextMapper.selectTotal(queryVO);
        map.put("list", list);
        map.put("totalCount", total);
        return map;
    }

    /**
     * 查询单个脱密期人员
     *
     * @param id
     * @return
     */
    public BmStaffciphertextTbl queryById(String id) {
        BmStaffciphertextTbl tbl = staffCipherTextMapper.selectByPrimaryKey(id);
        //处理Outwayids
        if (StringUtils.isNotEmpty(tbl.getOutway())){
            List<String> list = Arrays.asList(StringUtils.split(tbl.getOutway(), ","));
            tbl.setOutWayIds(list);
        }
        //查询出回访信息
        List<BmStaffciphertextHf> list = recordMapper.select(tbl.getCipid());
        tbl.setVisitRecords(list);
        return tbl;
    }

    /**
     * 查询脱密方式
     * @param type
     * @return
     */
    public List<BmSecrectwayTbl> queryType(int type){
        return awayMapper.selectByType(type);
    }

    /**
     * 增加
     */
    @Transactional
    public void addUser(BmStaffciphertextTbl info, MultipartFile file, MultipartFile[] visitfile) throws IOException {
        //设置唯一id
        String cipId = CommonUtils.generateUUID();
        info.setCipid(cipId);
        //上传附件
        if (null != file) {
            String url = FileUtils.uploads(file);
            info.setFile(url);
        }
        //处理Outwayids
        if (CollectionUtils.isNotEmpty(info.getOutWayIds())){
            String citiesCommaSeparated = String.join(",", info.getOutWayIds());
            info.setOutway(citiesCommaSeparated);
        }
        staffCipherTextMapper.insert(info);
        //增加回访记录信息数据，以及附件
        List<BmStaffciphertextHf> visitRecords = info.getVisitRecords();
        recordService.add(visitRecords, cipId, visitfile);
    }

    /**
     * 增加
     */
    @Transactional
    public void update(BmStaffciphertextTbl info, MultipartFile file, MultipartFile[] visitfile) throws IOException {
        //上传附件
        if (null != file) {
            //删除原来的附件
            FileUtils.deleteFile( info.getFile());
            String url = FileUtils.uploads(file);
            info.setFile(url);
        }
        //处理Outwayids
        if (CollectionUtils.isNotEmpty(info.getOutWayIds())){
            String citiesCommaSeparated = String.join(",", info.getOutWayIds());
            info.setOutway(citiesCommaSeparated);
        }
        staffCipherTextMapper.updateByPrimaryKey(info);
        //增加回访记录信息数据，以及附件
        List<BmStaffciphertextHf> visitRecords = info.getVisitRecords();
        recordService.update(visitRecords,info.getDeleteIds(), info.getCipid(), visitfile);
    }

    /**
     * 批量删除
     *
     * @param list
     */
    @Transactional
    public void delete(List<String> list) {
        list.forEach(id -> {
            staffCipherTextMapper.deleteByPrimaryKey(id);
            BmStaffciphertextTbl tbl = staffCipherTextMapper.selectByPrimaryKey(id);
            //删除附件
            FileUtils.deleteFile(tbl.getFile());
            recordService.delete(id);
        });
    }

    /**
     * 导出excel
     *
     * @param queryVO
     * @return
     */
    public List<BmStaffciphertextTbl> export(StaffCipherQueryVO queryVO) {
        List<BmStaffciphertextTbl> list = staffCipherTextMapper.queryExport(queryVO);
        //查询所脱密期执行方式
        list.forEach(tbl -> {
            List<String> ids = tbl.getOutWayIds();
            StringBuilder sb = new StringBuilder();
            if (CollectionUtils.isNotEmpty(ids)) {
                List<BmSecrectwayTbl> secrectwayTbls = awayMapper.select(ids);
                if (CollectionUtils.isNotEmpty(secrectwayTbls)) {
                    for (BmSecrectwayTbl away : secrectwayTbls) {
                        sb.append(away.getOutwayname()).append(",");
                    }
                }
            }
            tbl.setOutwayName(sb.toString());
        });
        return list;
    }
}
