package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2FilemoduleTbl;
import com.hangyu.platform.web.sysAdmin.dto.Bm2RecordmodulerelationTbl;
import com.hangyu.platform.web.sysAdmin.dto.BmRecordtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2FilemoduleTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2RecordmodulerelationTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.BmRecordtypeTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmRecordTypeService {


    @Resource
    private BmRecordtypeTblMapper mapper;

    @Resource
    private Bm2FilemoduleTblMapper modileMapper;

    @Resource
    private Bm2RecordmodulerelationTblMapper  relationMapper;


    /**
     * 查询保密档案(一级或者二级)
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> query(int type, String topId, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmRecordtypeTbl> list = mapper.queryByType(type, topId, start, pageSize);
        dealRecordList(list);
        int total = mapper.selectTotal(type, topId, start, pageSize);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    private void dealRecordList(List<BmRecordtypeTbl> list) {
        for (BmRecordtypeTbl tbl : list) {
            //取出上级id
            String topTypeId = tbl.getToptypeid();
            //查询出所属类别信息
            if (StringUtils.equals("0", topTypeId)) {
                continue;
            }
            BmRecordtypeTbl topRecord = mapper.selectByPrimaryKey(topTypeId);
            tbl.setClassId(null == topRecord ? null : topRecord.getToptypeid());
            List<Bm2FilemoduleTbl> moduleList = modileMapper.selectById(tbl.getTypeid());
            tbl.setFilemoduleTbls(moduleList);
        }
    }

    /**
     * 查询单个保密档案
     *
     * @param id
     * @return
     */
    public BmRecordtypeTbl queryById(String id) {
        BmRecordtypeTbl type = mapper.selectByPrimaryKey(id);
        List<Bm2FilemoduleTbl> list = modileMapper.selectById(id);
        type.setFilemoduleTbls(list);
        BmRecordtypeTbl topRecord = mapper.selectByPrimaryKey(id);
        type.setClassId(null == topRecord ? null : topRecord.getToptypeid());
        return type;
    }

    /**
     * 回显用
     *
     * @param type
     * @param topId
     * @return
     */
    public List<BmRecordtypeTbl> queryName(int type, String topId) {
        List<BmRecordtypeTbl> list = mapper.queryName(type, topId);
        return list;
    }

    /**
     * 添加保密档案
     *
     * @param record
     */
    @Transactional
    public void addType(BmRecordtypeTbl record) {
        String typeId = CommonUtils.generateUUID();
        String topId = record.getToptypeid();
        //查询出当前目录下最大的序号
//        int count = mapper.selectMaxOrder(topId, record.getRecordtype());
//        record.setSortorder(++count);
        record.setToptypeid(topId);
        record.setTypeid(typeId);
        //增加文档目录
        if (CollectionUtils.isNotEmpty(record.getFilemoduleTbls())) {
            addRelation(record,typeId);
        }
        mapper.insert(record);
    }

    private void addRelation(BmRecordtypeTbl record,String typeId){
        for (Bm2FilemoduleTbl tbl : record.getFilemoduleTbls()){
            Bm2RecordmodulerelationTbl relationTbl = new Bm2RecordmodulerelationTbl();
            relationTbl.setRecordtypeid(typeId);
            relationTbl.setModuleid(tbl.getModuleid());
            relationMapper.insert(relationTbl);
        }
    }

    /**
     * 修改保密档案
     *
     * @param type
     */
    @Transactional
    public void updateType(BmRecordtypeTbl type) {
        //删除原来的数据
        relationMapper.deleteByPrimaryKey(type.getTypeid());
        //增加文档目录
        if (CollectionUtils.isNotEmpty(type.getFilemoduleTbls())) {
            addRelation(type,type.getTypeid());
        }
        mapper.updateByPrimaryKeySelective(type);

    }


    /**
     * 修改保密档案
     *
     * @param
     */
    @Transactional
    public void deleteType(List<String> ids) {
        mapper.deleteByPrimaryKey(ids);
    }

    /**
     * 查询所有的归档栏目
     *
     * @param type
     * @return
     */
    public List<Bm2FilemoduleTbl> selectByType(int type) {
        List<Bm2FilemoduleTbl> list = modileMapper.selectByType(type);
        return list;
    }

}
