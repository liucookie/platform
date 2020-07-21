package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.BmPicturetypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.BmPictureTypeTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//图片资源类别管理
@Service
public class BmPictureTypeService {

    @Resource
    private BmPictureTypeTblMapper bmPicturetypeTblMapper;

    //图片资源类别管理批量查询
    public Map<String,Object> selectAll(int pageNum, int pageSize){
        Map<String,Object> map = new HashMap<>();
        int start= CommonUtils.getPageStart(pageNum,pageSize);
        List<BmPicturetypeTbl> list =  bmPicturetypeTblMapper.selectAll(start,pageSize);
        int total = bmPicturetypeTblMapper.selectTotal();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    //图片资源类别管理单条查询

    public List<BmPicturetypeTbl> select(String uniqueid){
        return bmPicturetypeTblMapper.select(uniqueid);
    }

    //图片资源类别管理添加
    @Transactional
    public void insert(BmPicturetypeTbl bmPicturetypeTbl){
        bmPicturetypeTblMapper.insert(bmPicturetypeTbl);
    }

    //图片资源类别管理删除
    @Transactional
    public void delete(List<String> list){
        bmPicturetypeTblMapper.delete(list);
    }

    //图片资源类别管理删修改
    @Transactional
    public void update(BmPicturetypeTbl bmPicturetypeTbl){
        bmPicturetypeTblMapper.update(bmPicturetypeTbl);
    }

}
