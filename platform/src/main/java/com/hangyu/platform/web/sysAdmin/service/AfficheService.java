package com.hangyu.platform.web.sysAdmin.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.web.sysAdmin.dto.AfficheTbl;
import com.hangyu.platform.web.sysAdmin.mapper.AfficheTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AfficheService {


    @Resource
    private AfficheTblMapper mapper;

    /**
     * 查询所有公告
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryAffiche(int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<AfficheTbl> list = mapper.queryAffiche(start, pageSize);
        int total = mapper.selectTotal();
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个公告
     *
     * @param id
     * @return
     */
    public AfficheTbl queryAfficheById(String id) {
        AfficheTbl afficheTbl = mapper.selectByPrimaryKey(id);
        return afficheTbl;
    }

    /**
     * 发布/撤销公告
     *
     * @param id
     * @return
     */
    @Transactional
    public void publish(String id,int isPublish) {
         mapper.publish(id,isPublish);
    }

    /**
     * 添加公告
     *
     * @param afficheTbl
     */
    @Transactional
    public void addType(AfficheTbl afficheTbl,Boolean flag) {
        afficheTbl.setIspublish(flag? 1:0);
        afficheTbl.setUniqueid(CommonUtils.generateUUID());
        mapper.insert(afficheTbl);
    }

    /**
     * 修改公告
     *
     * @param afficheTbl
     */
    @Transactional
    public void updateType(AfficheTbl afficheTbl,Boolean flag) {
        if(flag){
            afficheTbl.setIspublish(1);
        }
        mapper.updateByPrimaryKeySelective(afficheTbl);
    }


    /**
     * 修改公告
     *
     * @param id
     */
    @Transactional
    public void deleteType(String id) {
        mapper.deleteByPrimaryKey(id);
    }


}
