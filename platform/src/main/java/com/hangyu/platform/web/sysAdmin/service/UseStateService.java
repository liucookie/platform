package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Usestate;
import com.hangyu.platform.web.sysAdmin.mapper.UsestateMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.UseStateVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UseStateService {

    @Resource
    private UsestateMapper usestateMapper;

    public UseStateVO queryUseState(int pageNum, int pageSize) {
        UseStateVO vo = new UseStateVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Usestate> useStateList = usestateMapper.selectAllByPage(start, pageSize);
        int total = usestateMapper.selectTotal();
        vo.setUseStateList(useStateList);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询单个设备状态
     *
     * @param id
     * @return
     */
    public Usestate queryUseStateById(String id) {
        return usestateMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加设备状态
     * @param usestate
     */
    @Transactional
    public void addUseState(Usestate usestate){

        usestate.setUniqueid(CommonUtils.generateUUID());
        usestateMapper.insert(usestate);
    }

    /**
     * 修改设备状态
     * @param usestate
     */
    @Transactional
    public void updateUseState(Usestate usestate){

        usestateMapper.updateByPrimaryKeySelective(usestate);
    }


    /**
     * 修改设备状态
     * @param id
     */
    @Transactional
    public void deleteUseState(String id){

        usestateMapper.deleteByPrimaryKey(id);
    }


}
