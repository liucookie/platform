package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FoulactionTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FoulactionTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FoulactiontypeTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.Bm2FoulactionQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bm2FoulactionService {


    @Resource
    private Bm2FoulactionTblMapper mapper;

    @Resource
    private Bm2FoulactiontypeTblMapper typeMapper;


    /**
     * 查询违规行为库
     *
     * @return
     */
    public Map<String, Object> query(Bm2FoulactionQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<Bm2FoulactionTbl> list = mapper.query(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询违规行为库
     *
     * @param id
     * @return
     */
    public Bm2FoulactionTbl queryById(String id) {
        Bm2FoulactionTbl type = mapper.selectByPrimaryKey(id);
        return type;
    }
    /**
     * 查询违规行为库
     *
     * @param type
     * @return
     */
    public List<Bm2FoulactionTbl> queryByType(String type) {
        List<Bm2FoulactionTbl> list = mapper.queryByType(type);
        return list;
    }

    /**
     * 添加违规行为库
     *
     * @param type
     */
    @Transactional
    public void add(Bm2FoulactionTbl type) {

        type.setFoulactionid(CommonUtils.generateUUID());
        mapper.insert(type);
    }

    /**
     * 修改保违规行为库
     *
     * @param type
     */
    @Transactional
    public void update(Bm2FoulactionTbl type) {

        mapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 删除违规行为库
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


    /**
     * 批量导入Excel
     * @param file
     */
    public void importExcel(MultipartFile file) {
        List<Bm2FoulactionTbl> infoList = new ArrayList<>();
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            Bm2FoulactionTbl info = new Bm2FoulactionTbl();
            info.setFoulactionid(CommonUtils.generateUUID());
            //根据违规行为名称，查出分类id
            String typeName = (String) list.get(i)[0];
            info.setFoulactiontypeid(typeMapper.selectByName(typeName));
            info.setFoulactionname((String) list.get(i)[1]);
            info.setDeductleaderallow(Double.valueOf((String)list.get(i)[2]));
            info.setDeductpersonallow(Double.valueOf((String)list.get(i)[3]));
            info.setAdminpunish((String) list.get(i)[4]);
            info.setDeductleadercash(Double.valueOf((String)list.get(i)[5]));
            info.setDeductpersoncash(Double.valueOf((String)list.get(i)[6]));
            info.setDeductdeptscore(Double.valueOf((String)list.get(i)[7]));
            info.setDeductpersonscore((Double)list.get(i)[8]);
            info.setMemo((String) list.get(i)[9]);
            infoList.add(info);
        }
        mapper.insertBatch(infoList);
    }

    /**
     * 查询违规行为库
     *
     * @return
     */
    public List<Bm2FoulactionTbl> queryAll(Bm2FoulactionQueryVO vo) {
        List<Bm2FoulactionTbl> list = mapper.queryAll(vo);
        return list;
    }

}
