package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.ComputyequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.mapper.ComputyequiptypeTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.ComputerTypeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComputerTypeService {



    @Resource
    private ComputyequiptypeTblMapper computerMapper;

    /**
     * 查询计算机设备类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ComputerTypeVO queryType(int pageNum, int pageSize) {
        ComputerTypeVO vo = new ComputerTypeVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<ComputyequiptypeTbl> list = computerMapper.selectAllType(start, pageSize);
        int total = computerMapper.selectTotal();
        vo.setComputyequiptypeTblList(list);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询单个计算机设备类型
     *
     * @param id
     * @return
     */
    public ComputyequiptypeTbl queryById(String id) {
        return computerMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加计算机设备类型
     * @param type
     */
    @Transactional
    public void addType(ComputyequiptypeTbl type){

        type.setUniqueid(CommonUtils.generateUUID());
        computerMapper.insert(type);
    }

    /**
     * 修改计算机设备类型
     * @param type
     */
    @Transactional
    public void updateType(ComputyequiptypeTbl type){

        computerMapper.updateByPrimaryKeySelective(type);
    }


    /**
     * 修改计算机设备类型
     * @param id
     */
    @Transactional
    public void deleteType(String id){

        computerMapper.deleteByPrimaryKey(id);
    }


}
