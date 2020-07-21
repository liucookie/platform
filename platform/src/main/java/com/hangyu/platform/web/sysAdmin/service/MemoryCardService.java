package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MemorycardtypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.Bm2MemorycardtypeTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.MemoryCardVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemoryCardService {

    @Resource
    private Bm2MemorycardtypeTblMapper cardMapper;

    /**
     * 查询从存储卡类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    public MemoryCardVO queryType(int pageNum, int pageSize) {
        MemoryCardVO vo = new MemoryCardVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Bm2MemorycardtypeTbl> useStateList = cardMapper.selectType(start, pageSize);
        int total = cardMapper.selectTotal();
        vo.setTypeList(useStateList);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询单个类型
     *
     * @param id
     * @return
     */
    public Bm2MemorycardtypeTbl queryUseStateById(String id) {
        return cardMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加类型
     * @param type
     */
    @Transactional
    public void addType(Bm2MemorycardtypeTbl type){

        type.setUniqueid(CommonUtils.generateUUID());
        cardMapper.insert(type);
    }

    /**
     * 修改类型
     * @param type
     */
    @Transactional
    public void updateType(Bm2MemorycardtypeTbl type){

        cardMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改类型
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        cardMapper.deleteByPrimaryKey(id);
    }


}
