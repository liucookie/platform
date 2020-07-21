package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmAllroundcheckTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmAllroundcheckTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmAllroundcheckTblMapper;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全面检查管理
 *
 * @auther liuXuan
 * @date 2020/2/21
 */
@Service
public class BmAllRoundCheckService {

    @Resource
    private BmAllroundcheckTblMapper mapper;

    /**
     * 查询所有全面检查
     * <p>
     * *@param pageNum
     *
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmAllroundcheckTbl> list = mapper.select(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmAllroundcheckTbl queryById(String id) {
        BmAllroundcheckTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void add(BmAllroundcheckTbl tbl, MultipartFile file) throws IOException {
        if (null != file) {
            String url = FileUtils.uploads(file);
            tbl.setFileurl(url);
        }
        tbl.setAllcheckid(CommonUtils.generateUUID());
        mapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void update(BmAllroundcheckTbl tbl, MultipartFile file) throws IOException {
        if (null != file) {
            String url = FileUtils.uploads(file);
            tbl.setFileurl(url);
        }
        mapper.updateByPrimaryKeySelective(tbl);
    }

        /**
         * 删除
         * @param id
         */
        @Transactional
        public void delete (String id){
            mapper.deleteByPrimaryKey(id);
        }
    }
