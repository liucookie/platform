package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.PostsecretlevelTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.PostsecretlevelTblMapper;
import com.hangyu.platform.web.backBusiness.vo.PostLevelQueryVO;
import com.hangyu.platform.web.sysAdmin.mapper.BasecodeMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostLevelService {


    @Resource
    private PostsecretlevelTblMapper mapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private BasecodeMapper codeMapper;


    /**
     * 查询岗位密级
     *
     * @return
     */
    public Map<String, Object> queryType(PostLevelQueryVO vo) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(vo.getPageNum(), vo.getPageSize());
        vo.setPageNum(start);
        List<PostsecretlevelTbl> list = mapper.select(vo);
        int total = mapper.selectTotal(vo);
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    /**
     * 查询岗位名称
     *
     * @return
     */
    public List<PostsecretlevelTbl> queryName(String orgId) {
        List<PostsecretlevelTbl> list = mapper.queryName(orgId);
        return list;
    }

    /**
     * 查询单个岗位密级
     *
     * @param id
     * @return
     */
    public PostsecretlevelTbl queryById(String id) {
        PostsecretlevelTbl info = mapper.selectByPrimaryKey(id);
        //查询出员工
        if (StringUtils.isNotEmpty(info.getStaffid())) {
            List<String> userIds = Arrays.asList(StringUtils.split(info.getStaffid(), ","));
            List<BmStaffTbl> list = staffTblMapper.selectBatch(userIds);
            info.setStaffTblList(list);
        }
        return info;
    }

    /**
     * 添加岗位密级
     *
     * @param info
     */
    @Transactional
    public void add(PostsecretlevelTbl info) {
        info.setUniqueid(CommonUtils.generateUUID());
        dealUser(info);
        mapper.insert(info);
    }

    private void dealUser(PostsecretlevelTbl info) {
        List<BmStaffTbl> userList = info.getStaffTblList();
        //处理人员id,变成字符串，用，分割
        if (CollectionUtils.isNotEmpty(userList)) {
            StringBuilder sb = new StringBuilder();
            for (BmStaffTbl staffTbl : userList) {
                sb.append(staffTbl.getStaffid()).append(",");
            }
            info.setStaffid(sb.toString().substring(0, sb.lastIndexOf(",")));
        }
    }

    /**
     * 修改岗位密级
     *
     * @param info
     */
    @Transactional
    public void update(PostsecretlevelTbl info) {
        dealUser(info);
        mapper.updateByPrimaryKey(info);
    }


    /**
     * 删除岗位密级
     *
     * @param id
     */
    @Transactional
    public void delete(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file) {
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            PostsecretlevelTbl info = new PostsecretlevelTbl();
            info.setUniqueid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            Organization organization = organizationMapper.queryByOrgName(orgName);
            info.setDeptid(null == organization ? null : organization.getUniqueid());

            info.setGangwei((String) list.get(i)[1]);

            String secretName = (String) list.get(i)[2];
            String secretId = codeMapper.queryIdByName(secretName);
            info.setSecretlevelname(secretId);

            String secretBusinessName = (String) list.get(i)[3];
            String secretBusinessId = codeMapper.queryIdByName(secretBusinessName);
            info.setBsecretlevelid(secretBusinessId);

            info.setSecretcontent((String) list.get(i)[4]);
            info.setRemark((String) list.get(i)[5]);
            mapper.insert(info);
        }
    }

}
