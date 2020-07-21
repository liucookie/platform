package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2ConcactwayTbl;
import com.hangyu.platform.web.backBusiness.mapper.Bm2ConcactwayTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保密通讯录管理
 *
 * @auther liuXuan
 * @date 2020/3/10
 */
@Service
public class Bm2ConcactWayService {

    @Resource
    private Bm2ConcactwayTblMapper mapper;



    /**
     * 查询所有保密通讯录
     *
     * @return
     */
    public Map<String, Object> query(String orgName, String userName,String typeName, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2ConcactwayTbl> list = mapper.select(orgName, userName,typeName,start,pageSize);
        int total = mapper.selectCount(orgName, userName,typeName);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @return
     */
    public List<Bm2ConcactwayTbl> exportExcel(String orgName, String userName) {
        List<Bm2ConcactwayTbl> list = mapper.selectTotal(orgName, userName);
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public Bm2ConcactwayTbl queryById(String id) {
        Bm2ConcactwayTbl tbl = mapper.selectByPrimaryKey(id);
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(Bm2ConcactwayTbl info) {
        info.setConcactwayid(CommonUtils.generateUUID());
        mapper.insert(info);
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(Bm2ConcactwayTbl info) {
        mapper.updateByPrimaryKey(info);
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
            Bm2ConcactwayTbl info = new Bm2ConcactwayTbl();
            info.setConcactwayid(CommonUtils.generateUUID());
            //部门
            info.setDeptid( (String) list.get(i)[0]);
            info.setUserid((String) list.get(i)[1]);
            info.setTelephone(String.valueOf(list.get(i)[2]));
            info.setMobilephone( String.valueOf(list.get(i)[3]));
            info.setEmail(String.valueOf(list.get(i)[4]));
            info.setRemark(String.valueOf(list.get(i)[5]));
            info.setOrdertax(Integer.valueOf(String.valueOf(list.get(i)[6])));
            mapper.insert(info);
        }
    }
}
