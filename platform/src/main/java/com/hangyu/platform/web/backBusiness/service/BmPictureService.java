package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmPictureTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmPictureTblMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片资源管理
 *
 * @auther liuXuan
 * @date 2020/3/2
 */
@Service
public class BmPictureService {

    @Resource
    private BmPictureTblMapper mapper;


    /**
     * 查询所有图片资源
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmPictureTbl> list = mapper.select(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询类别id查询所有图片资源
     *
     * @param typeId
     * @return
     */
    public List<BmPictureTbl> queryByTypeId(String typeId) {
        List<BmPictureTbl> list = mapper.queryByTypeId(typeId);
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmPictureTbl queryById(String id) {
        BmPictureTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmPictureTbl tbl, MultipartFile picture) throws IOException {
        tbl.setUniqueid(CommonUtils.generateUUID());
        //上传图片
        if (null != picture) {
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setNativefilename(picture.getOriginalFilename());
            tbl.setRemotefilename(picUrl);
        }
        mapper.insert(tbl);
    }


    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmPictureTbl tbl, MultipartFile picture) throws IOException {

        //上传图片
        if (null != picture) {
            deleteFile(tbl.getUniqueid());
            String picUrl = FileUtils.uploadStaticFile(picture);
            tbl.setNativefilename(picture.getOriginalFilename());
            tbl.setRemotefilename(picUrl);
        }
        mapper.updateByPrimaryKey(tbl);
    }

    /**
     * 删除原来附件
     */
    private void deleteFile(String id) throws IOException {
        //查询出附件信息
        BmPictureTbl tbl = mapper.selectByPrimaryKey(id);
        if (null != tbl) {
            //删除图片
            if (StringUtils.isNotEmpty(tbl.getRemotefilename())) {
                FileUtils.deleteStaticFile(tbl.getRemotefilename());
            }
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(String id) throws IOException{
        deleteFile(id);
        mapper.deleteByPrimaryKey(id);
    }
}
