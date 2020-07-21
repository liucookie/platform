package com.hangyu.platform.web.backBusiness.service;


import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmOrgContent;
import com.hangyu.platform.web.backBusiness.dto.BmOrgTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgContentMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * 员工履历或者内容表
 *
 * @author abel
 * @ClassName BmOrgContentService
 * @date 2019年11月26日
 */
@Service
public class BmOrgContentService {

    @Resource
    private BmOrgContentMapper bmOrgContentMapper;


    /**
     * orgContent批量加入
     *
     * @return BmOrgManageVO
     */
    public void addContent(List<BmOrgContent> list) {
        list.forEach(content -> {
            bmOrgContentMapper.insert(content);
        });
    }

    /**
     * orgContent更新
     *
     * @return BmOrgManageVO
     */
    public void updateContent(BmOrgTbl orgTbl, MultipartFile[] files) throws IOException {
        //存储的所有的机构活动和人员履历
        List<BmOrgContent> contentList = orgTbl.getBmOrgContentList();
        //要删除的数据
        List<String> deleteIds = orgTbl.getDeleletList();
        if (CollectionUtils.isNotEmpty(deleteIds)) {
            deleteIds.forEach(id -> {
                BmOrgContent deleteContent = bmOrgContentMapper.selectByPrimaryKey(id);
                //删除数据
                bmOrgContentMapper.deleteByPrimaryKey(id);
                //删除文件地址
                FileUtils.deleteFile( deleteContent.getAttfile());
            });
        }

        for (BmOrgContent content : contentList) {
            //主键不为空，则表示，数据已存在
            if (StringUtils.isNotEmpty(content.getContentid())) {
                continue;
            }
            content.setContentid(CommonUtils.generateUUID());
            content.setOrgid(orgTbl.getOrgid());
            //1为机构活动，则需要遍历，机构表
            for (MultipartFile activty : files) {
                //相等则是，新增加的数据
                if (StringUtils.equals(content.getAttfile(), activty.getOriginalFilename())) {
                    String url = FileUtils.uploads(activty);
                    content.setAttfile(url);
                }
            }
            //新增加的，加到表中
            bmOrgContentMapper.insert(content);
        }


    }


}