package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.Secretlevel;
import com.hangyu.platform.web.sysAdmin.mapper.SecretlevelMapper;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.SecretLevelVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecretLevelService {


    @Resource
    private SecretlevelMapper secretMapper;

    /**
     * 查询所有机密
     * @param pageNum
     * @param pageSize
     * @return
     */
    public SecretLevelVO querySecretLevel(int pageNum, int pageSize) {
        SecretLevelVO vo = new SecretLevelVO();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<Secretlevel> useStateList = secretMapper.selectAllSecret(start, pageSize);
        int total = secretMapper.selectTotal();
        vo.setSecretlevelList(useStateList);
        vo.setTotalSize(total);
        return vo;
    }

    /**
     * 查询密级，不分页
     * @return
     */
    public List<Secretlevel> querySecret() {

        List<Secretlevel> list = secretMapper.querySecret();

        return list;
    }


    /**
     * 查询单个密级
     *
     * @param id
     * @return
     */
    public Secretlevel querySecretById(String id) {
        return secretMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加密级
     * @param secretlevel
     */
    @Transactional
    public void addSecret(Secretlevel secretlevel){
        secretlevel.setUniqueid(CommonUtils.generateUUID());
        secretMapper.insert(secretlevel);
    }

    /**
     * 修改密级
     * @param secretlevel
     */
    @Transactional
    public void updateSecret(Secretlevel secretlevel){
        secretMapper.updateByPrimaryKeySelective(secretlevel);

    }


    /**
     * 删除密级
     * @param id
     */
    @Transactional
    public void deleteSecret(String id){
        secretMapper.deleteByPrimaryKey(id);
    }


}
