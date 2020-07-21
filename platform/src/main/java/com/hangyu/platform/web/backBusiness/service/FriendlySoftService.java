package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2FriendlysoftwareTbl;
import com.hangyu.platform.web.backBusiness.dto.OaLevelintegrate;
import com.hangyu.platform.web.backBusiness.mapper.Bm2FriendlysoftwareTblMapper;
import com.hangyu.platform.web.backBusiness.vo.SoftWareQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 软件白名单管理
 * @auther  liuXuan
 * @date 2020/2/4
 */
@Service
public class FriendlySoftService {

    @Resource
    private Bm2FriendlysoftwareTblMapper mapper;

    @Resource
    private BasecodeMapper basecodeMapper;

    /**
     * 查询所有软件白名单
     *
     * @param vo
     * @return
     */
    public Map<String, Object> query(SoftWareQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2FriendlysoftwareTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
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
    public Bm2FriendlysoftwareTbl queryById(String id) {
        Bm2FriendlysoftwareTbl softWare = mapper.selectByPrimaryKey(id);
        return softWare;
    }

    /**
     * 增加
     *
     * @param softWare
     */
    @Transactional
    public void add(Bm2FriendlysoftwareTbl softWare) {
        softWare.setSoftid(CommonUtils.generateUUID());
        mapper.insert(softWare);
    }

    /**
     * 修改
     *
     * @param softWare
     */
    @Transactional
    public void update(Bm2FriendlysoftwareTbl softWare) {
        mapper.updateByPrimaryKey(softWare);
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
     * 查询所有软件白名单
     *
     * @param vo
     * @return
     */
    public List<Bm2FriendlysoftwareTbl> exportExcel(SoftWareQueryVO vo) {
        List<Bm2FriendlysoftwareTbl> list = mapper.exportExcel(vo);
        return list;
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
            Bm2FriendlysoftwareTbl info = new Bm2FriendlysoftwareTbl();
            info.setSoftid(CommonUtils.generateUUID());
            String typeName = (String) list.get(i)[0];
            info.setTypeid(basecodeMapper.queryIdByName(typeName));
            info.setSoftname((String) list.get(i)[1]);
            info.setSoftver((String) list.get(i)[2]);
            info.setManufacturer((String) list.get(i)[3]);
            info.setSourcefrom((String) list.get(i)[4]);
            info.setUsedate((String) list.get(i)[5]);
            info.setUseage((String) list.get(i)[6]);
            info.setKeyword((String) list.get(i)[7]);
            info.setAuthorizationuse((String) list.get(i)[8]);
            info.setSoftremark((String) list.get(i)[9]);
            mapper.insert(info);
        }
    }
}
