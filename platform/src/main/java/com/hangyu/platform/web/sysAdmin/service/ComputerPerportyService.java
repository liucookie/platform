package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.ComputerpropertyTbl;
import com.hangyu.platform.web.sysAdmin.mapper.ComputerpropertyTblMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.ComputerPerportyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ComputerPerportyService {


    @Resource
    private ComputerpropertyTblMapper computerMapper;

    /**
     * 查询计算机属性
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ComputerPerportyVO queryProperty(int pageNum, int pageSize) {
        ComputerPerportyVO vo = new ComputerPerportyVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<ComputerpropertyTbl> list = computerMapper.queryProperty(start, pageSize);
        int total = computerMapper.selectTotal();
        vo.setPropertyList(list);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询单个计算机属性
     *
     * @param id
     * @return
     */
    public ComputerpropertyTbl queryById(String id) {
        return computerMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加计算机属性
     * @param computer
     */
    @Transactional
    public void addProperty(ComputerpropertyTbl computer){

        computer.setComputerpropertyid(CommonUtils.generateUUID());
        computerMapper.insert(computer);
    }

    /**
     * 修改计算机属性
     * @param computer
     */
    @Transactional
    public void updateProperty(ComputerpropertyTbl computer){

        computerMapper.updateByPrimaryKeySelective(computer);
    }


    /**
     * 修改计算机设备属性
     * @param id
     */
    @Transactional
    public void deleteProperty(String id){

        computerMapper.deleteByPrimaryKey(id);
    }


}
