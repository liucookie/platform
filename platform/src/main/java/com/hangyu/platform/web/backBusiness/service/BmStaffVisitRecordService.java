package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffciphertextHf;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffciphertextHfMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * 脱密人员回访记录表
 * liuxuan
 * 2020.1.20
 */
@Service
public class BmStaffVisitRecordService {

    @Resource
    private BmStaffciphertextHfMapper mapper;

    /**
     * 增加记录
     */
    @Transactional
    public void add(List<BmStaffciphertextHf> records, String cipId, MultipartFile[] visitfile) throws IOException {
        if (CollectionUtils.isEmpty(records)) {
            return;
        }
        for (BmStaffciphertextHf record : records) {
            record.setUniqueid(CommonUtils.generateUUID());
            record.setTbid(cipId);
            for (MultipartFile file : visitfile) {
                //如果文件名称都相等，那就是新增加的文件
                if (StringUtils.equals(record.getHfatt(), file.getOriginalFilename())) {
                    String url = FileUtils.uploads(file);
                    record.setHfatt(url);
                }
            }
            mapper.insert(record);
        }
    }

    /**
     * 修改记录
     */
    @Transactional
    public void update(List<BmStaffciphertextHf> records, List<String> ids, String cipId, MultipartFile[] visitfile) throws IOException {
        //判断有没有删除的id,先删除原来的数据以及附件记录
        if (CollectionUtils.isNotEmpty(ids)) {
            for (String id : ids) {
                BmStaffciphertextHf staff = mapper.selectByPrimaryKey(id);
                //根据涉密人员id删除
                mapper.deleteByPrimaryKey(id);
                //删除附件
                FileUtils.deleteFile(staff.getHfatt());
            }
        }
        for (BmStaffciphertextHf record : records) {
            for (MultipartFile file : visitfile) {
                //如果文件名称都相等，那就是新增加的文件
                if (StringUtils.equals(record.getHfatt(), file.getOriginalFilename())) {
                    String url = FileUtils.uploads(file);
                    record.setHfatt(url);
                }
            }
            if (StringUtils.isEmpty(record.getUniqueid())) {
                record.setTbid(cipId);
                record.setUniqueid(CommonUtils.generateUUID());
                mapper.insert(record);
            } else {
                mapper.updateByPrimaryKey(record);
            }

        }
    }

    /**
     * 删除记录
     */
    @Transactional
    public void delete(String cId) {
        List<BmStaffciphertextHf> list = mapper.select(cId);
        list.forEach(id -> {
            //根据涉密人员id删除
            mapper.deleteByPrimaryKey(id.getTbid());
            //删除附件
            FileUtils.deleteFile(id.getHfatt());
        });
    }
}
