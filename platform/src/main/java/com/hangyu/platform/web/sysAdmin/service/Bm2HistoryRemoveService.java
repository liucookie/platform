package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragecolorTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestorageinfoTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2HistoryremovablestoragetypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2HistoryremovablestoragecolorTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2HistoryremovablestorageinfoTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2HistoryremovablestoragetypeTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.Bm2HistoryQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 历史移动存储介质信息管理
 */
@Service
public class Bm2HistoryRemoveService {

    @Resource
    private Bm2HistoryremovablestorageinfoTblMapper infoMapper;

    @Resource
    private Bm2HistoryremovablestoragetypeTblMapper typeMapper;

    @Resource
    private Bm2HistoryremovablestoragecolorTblMapper colorMapper;

    @Autowired
    private  BaseCodeService codeService;

    /**
     * 查询移动介质
     *
     * @return
     */
    public Map<String, Object> query(Bm2HistoryQueryVO vo) {
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        Map<String, Object> map = new HashMap<>();
        //根据页面参数和条件查询
        List<Bm2HistoryremovablestorageinfoTbl> infoList = infoMapper.selectByAddition(vo);
        infoList.forEach(info -> {
            //设置使用范围
            info.setTimeRange(info.getUsestarttime() + "~" + info.getUseendtime());
        });
        //总页数
        int total = infoMapper.selectTotal(vo);
        map.put("list", infoList);
        map.put("total", total);
        return map;
    }

    /**
     * 查询单个信息
     *
     * @param id
     * @return
     */
    public Bm2HistoryremovablestorageinfoTbl queryById(String id) {

        return infoMapper.selectByPrimaryKey(id);
    }


    /**
     * 添加
     */
    @Transactional
    public void add(Bm2HistoryremovablestorageinfoTbl info) {
        info.setHremovablestorageid(CommonUtils.generateUUID());
        infoMapper.insert(info);
    }

    /**
     * 更新
     */
    @Transactional
    public void update(Bm2HistoryremovablestorageinfoTbl info) {
        infoMapper.updateByPrimaryKey(info);
    }


    /**
     * 更新
     */
    @Transactional
    public void delete(String id) {
        infoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所属分类
     */
    public List<Bm2HistoryremovablestoragetypeTbl> queryClassify() {
        return typeMapper.queryClassify();
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file) {
        List<Bm2HistoryremovablestorageinfoTbl> infoList = new ArrayList<>();
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            Bm2HistoryremovablestorageinfoTbl info = new Bm2HistoryremovablestorageinfoTbl();
            info.setHremovablestorageid(CommonUtils.generateUUID());
            String typeId = typeMapper.selectByName((String) list.get(i)[0]);
            info.setTypeid(typeId);
            info.setUsestarttime((String) list.get(i)[1]);
            info.setUseendtime((String) list.get(i)[2]);
            info.setSerialno((String) list.get(i)[3]);
            info.setStoragename((String) list.get(i)[4]);
            info.setStoragenumber((String) list.get(i)[5]);
            String name = (String) list.get(i)[6];
            String levelId = codeService.queryIdByName(name);
            info.setSecretlevelid(levelId);
            info.setInfomemo((String) list.get(i)[7]);
            infoList.add(info);
        }
        infoMapper.insertBatch(infoList);
    }


    /**
     * 查询所有类型配置()
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public Map<String, Object> queryType(int pageSize, int pageNum) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2HistoryremovablestoragetypeTbl> list = typeMapper.queryType(start, pageSize);
        List<Bm2HistoryremovablestoragetypeTbl> allType = typeMapper.queryClassify();
        map.put("list", list);
        map.put("count", allType.size());
        return map;
    }

    /**
     * 查询单个配置
     *
     * @param id
     * @return
     */
    public Bm2HistoryremovablestoragetypeTbl queryTypeById(String id) {
        Bm2HistoryremovablestoragetypeTbl type = typeMapper.selectByPrimaryKey(id);
        return type;
    }


    /**
     * 增加配置
     *
     * @param type
     */
    @Transactional
    public void addType(Bm2HistoryremovablestoragetypeTbl type) {
        type.setTypeid(CommonUtils.generateUUID());
        typeMapper.insert(type);
    }

    /**
     * 修改配置
     *
     * @param type
     */
    @Transactional
    public void updateType(Bm2HistoryremovablestoragetypeTbl type) {
        typeMapper.updateByPrimaryKeySelective(type);
    }

    /**
     * 批量删除配置
     *
     * @param idList
     */
    @Transactional
    public void deleteType(List<String> idList) {
        idList.forEach(id ->{
            typeMapper.deleteByPrimaryKey(id);
        });
    }

    /**
     * 查询所有颜色
     * @return
     */
    public List<Bm2HistoryremovablestoragecolorTbl> queryColor(){
        List<Bm2HistoryremovablestoragecolorTbl> list = colorMapper.selectColor();
        return list;
    }
}
