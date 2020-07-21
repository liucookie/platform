package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;
import com.hangyu.platform.web.backBusiness.dto.BmOrgfileTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgfileTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

/**
 * BmOrgFileService
 */
@Service
public class BmOrgFileService {


    @Resource
    private BmOrgfileTblMapper bmOrgfileTblMapper;

    /**
     * 增加文件附件表记录
     * @param bmOrgTbl
     * @throws IOException
     */
    @Transactional
    public void addOrgFile(BmOrgTbl bmOrgTbl) throws IOException{
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //组织部门文件记录表
        MultipartFile file = bmOrgTbl.getMultipartFile();

        BmOrgfileTbl bmOrgfileTbl = new BmOrgfileTbl();
        //机构平台文件名
        bmOrgfileTbl.setFilename(file.getOriginalFilename());
        bmOrgfileTbl.setOrgid(bmOrgTbl.getOrgid());
        bmOrgfileTbl.setOrgfileid(uuid);
        //上传文件并返回存储路径
        String url = FileUtils.uploads(file);
        bmOrgfileTbl.setFileurl(url);
        bmOrgfileTblMapper.insert(bmOrgfileTbl);
    }


    /**
     * 删除文件附件表记录并删除文件
     * @param orgId
     * @throws IOException
     */
    @Transactional
    public void delOrgFile(String orgId){
        //机构文件
        BmOrgfileTbl oldOrgfileTbl = bmOrgfileTblMapper.selectByOrgId(orgId);
        if (null != oldOrgfileTbl){
            FileUtils.deleteFile( oldOrgfileTbl.getFileurl());
            bmOrgfileTblMapper.deleteByOrgId(orgId);
        }

    }


}