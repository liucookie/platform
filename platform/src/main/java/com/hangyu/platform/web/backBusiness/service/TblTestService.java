package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.TblTest;
import com.hangyu.platform.web.backBusiness.mapper.TblTestMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 试题管理
 *
 * @auther liuXuan
 * @date 2020/4/7
 */
@Service
public class TblTestService {

    @Resource
    private TblTestMapper mapper;


    /**
     * 查询所有试题
     *
     * @return
     */
    public Map<String, Object> query(String type, String name, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<TblTest> list = mapper.select(type, name, start, pageSize);
        int total = mapper.selectTotal(type, name);
        map.put(CommonFields.getData(), list);
        map.put(CommonFields.getTotal(), total);
        return map;
    }

    /**
     * 根据类型查询题目
     * @param type
     * @return
     */
    public List<TblTest> queryByType(String type,Integer count) {
        List<TblTest> list = mapper.queryByTypeAndCount(type,count);
        return list;
    }

    /**
     * 导出excel
     *
     * @return
     */
    public List<TblTest> exportExcel(String type, String name) {
        List<TblTest> list = mapper.exportExcel(type, name);
        for (TblTest tbl : list) {
            //选择，填空没有选项，需判断下
            if (StringUtils.isNotEmpty(tbl.getForanswers())) {
                tbl.setForanswers(tbl.getForanswers().replaceAll("&\\*","//"));
            }
            //正确答案
            if (StringUtils.isNotEmpty(tbl.getRightanswer())) {
            tbl.setRightanswer(tbl.getRightanswer().replaceAll("&\\*","//"));
            }
        }
        return list;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TblTest queryById(int id) {
        TblTest tbl = mapper.selectByPrimaryKey(id);
        //处理选项和正确答案
        if (StringUtils.isNotEmpty(tbl.getRightanswer())){
            List<String> rightAnswers = Arrays.asList(StringUtils.split(tbl.getRightanswer(), "&*"));
            tbl.setRightAnswer(rightAnswers);
        }
        if (StringUtils.isNotEmpty(tbl.getForanswers())){
            List<String> options = Arrays.asList(StringUtils.split(tbl.getForanswers(), "&*"));
            tbl.setOptions(options);
        }
        return tbl;
    }

    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(TblTest info) {
        dealOption(info);
        mapper.insert(info);
    }

    /**
     * 处理选项和答案
     *
     * @param info
     */
    private void dealOption(TblTest info) {
        //选项集合
        List<String> options = info.getOptions();
        //处理选项和正确答案,  填空题，没有选项，所以要判断空
        if (CollectionUtils.isNotEmpty(options)) {
            String foranswer = String.join("&*", options);
            info.setForanswers(foranswer);
        }
        //正确答案
        List<String> rightAnswers = info.getRightAnswer();
        if (CollectionUtils.isNotEmpty(rightAnswers)){
            String rightanswer = String.join("&*", rightAnswers);
            info.setRightanswer(rightanswer);
        }
    }

    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(TblTest info) {
        dealOption(info);
        mapper.updateByPrimaryKey(info);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delete(int id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file, int type) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        List<TblTest> dataList = new ArrayList<>();
        //单选
        if (type == 1) {
            for (int i = 0; i < list.size(); i++) {
                TblTest info = new TblTest();
                info.setTestcontent((String) list.get(i)[0]);
                String option = (String) list.get(i)[1];
                info.setForanswers(option.replaceAll("//", "&*"));
                info.setRightanswer((String) list.get(i)[2]);
                info.setType("单选题");
                dataList.add(info);
            }
        } else if (type == 2) {
            //多选
            for (int i = 0; i < list.size(); i++) {
                TblTest info = new TblTest();
                info.setTestcontent((String) list.get(i)[0]);
                String option = (String) list.get(i)[1];
                info.setForanswers(option.replaceAll("//", "&*"));
                String rightAnswer = (String) list.get(i)[2];
                info.setRightanswer(rightAnswer.replaceAll("//", "&*"));
                info.setType("多选题");
                dataList.add(info);
            }
        } else if (type == 3) {
            //判断题
            for (int i = 0; i < list.size(); i++) {
                TblTest info = new TblTest();
                info.setTestcontent((String) list.get(i)[0]);
                info.setRightanswer((String) list.get(i)[1]);
                info.setType("判断题");
                dataList.add(info);
            }
        } else {
            //填空题
            for (int i = 0; i < list.size(); i++) {
                TblTest info = new TblTest();
                info.setTestcontent((String) list.get(i)[0]);
                String rightAnswer = (String) list.get(i)[1];
                info.setRightanswer(rightAnswer.replaceAll("//", "&*"));
                info.setType("填空题");
                dataList.add(info);
            }
        }
        mapper.insertBatch(dataList);
    }
}
