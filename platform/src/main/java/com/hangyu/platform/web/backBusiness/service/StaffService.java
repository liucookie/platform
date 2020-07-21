package com.hangyu.platform.web.backBusiness.service;


import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.Base64;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DESUtil;
import com.hangyu.platform.utils.EipUtils;
import com.hangyu.platform.utils.ExcelUtils;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.X5User;
import com.hangyu.platform.web.backBusiness.mapper.X5UserMapper;
import com.hangyu.platform.web.backBusiness.vo.StaffQueryVO;
import com.hangyu.platform.web.logAdmin.service.LogService;
import com.hangyu.platform.web.sysAdmin.dto.AdminTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStafffamilyTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffstudyTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffworkTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStafffamilyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffstudyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffworkTblMapper;
import com.hangyu.platform.web.sysAdmin.mapper.AdminTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.sysAdmin.service.AdminService;
import com.hangyu.platform.web.sysAdmin.service.BaseCodeService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * @author abel
 * @ClassName StaffService
 * @date
 */
@Service
public class StaffService {

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private BmStafffamilyTblMapper stafffamilyTblMapper;

    @Resource
    private BmStaffstudyTblMapper staffstudyTblMapper;

    @Resource
    private BmStaffworkTblMapper staffworkTblMapper;

    @Autowired
    private BmStaffFamilyService familyService;

    @Autowired
    private BmStaffStudyService studyService;

    @Autowired
    private BmStaffWorkService workService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private LogService logService;

    @Resource
    private OrganizationMapper orgMapper;

    @Resource
    private AdminTblMapper adminTblMapper;

    @Autowired
    private EipUtils eipUtils;

    @Resource
    private X5UserMapper x5UserMapper;

    @Resource
    private BaseCodeService codeService;

    /**
     * 根据部门id查询出员工信息
     *
     * @return BmOrgManageVO
     */
    public List<BmStaffTbl> queryByDeptId(String deptId) {
        return staffTblMapper.getStaffByOrgId(deptId);
    }

    /**
     * 增加员工
     *
     * @param staffTbl
     */
    @Transactional
    public void addUser(BmStaffTbl staffTbl, MultipartFile file) throws IOException {
        //设置用户id
        String userId = CommonUtils.generateUUID();
        staffTbl.setStaffid(userId);
        BmStaffTbl account = staffTblMapper.selectByAccount(staffTbl.getAccoutname());
        if (null != account) {
            throw new PlatException(ResultStatusEnum.AUTH_EXISTS.getMessage());
        }
        checkAccount(staffTbl.getAccoutname());
        //设置初始密码
        staffTbl.setPass(DESUtil.getEncryptString(CommonFields.getDefaultPassword()));
        if (null != file) {
            staffTbl.setUserphoto(file.getBytes());
        }
        //将用户存储到staff表
        staffTblMapper.insert(staffTbl);
        //家庭人员表
        if (CollectionUtils.isNotEmpty(staffTbl.getStafffamilyList())) {
            familyService.addFamily(staffTbl);
        }
        //学习经历
        if (CollectionUtils.isNotEmpty(staffTbl.getStaffstudyTbls())) {
            studyService.addStudy(staffTbl);
        }
        //工作经历
        if (CollectionUtils.isNotEmpty(staffTbl.getStaffworkTbls())) {
            workService.addWork(staffTbl);
        }

        // todo  (放开注释)同步人员到x5系统中
        JSONObject paramMap = new JSONObject();
        paramMap.put("account", staffTbl.getAccoutname());
        //流程id
        paramMap.put("fullname", staffTbl.getUsername());
        paramMap.put("password", CommonFields.getDefaultPassword());
        paramMap.put("mobile", staffTbl.getUserphone());
        //eip返回来的用户id
        String x5UserId = eipUtils.addX5User(paramMap);
        //增加到x5User表中
        X5User x5User = new X5User();
        x5User.setBmStaffId(userId);
        x5User.setBmStaffAccount(staffTbl.getAccoutname());
        x5User.setX5StaffName(staffTbl.getUsername());
        x5User.setX5UserId(x5UserId);
        x5User.setX5Account(staffTbl.getAccoutname());

        BmStaffTbl staffTbl1 = staffTblMapper.selectByAccount(staffTbl.getAccoutname());
        if (null == staffTbl1) {
            throw new PlatException("账号不存在");
        }
        String password = DESUtil.getDecryptString(staffTbl1.getPass());
        //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
        String auth = staffTbl.getAccoutname() + ":" + password;
        String token = "Basic " + Base64.getBase64(auth);
        x5User.setX5Token(token);
        x5UserMapper.insert(x5User);
    }

    /**
     * 校验账号的合法行
     *
     * @param account
     */
    private void checkAccount(String account) {
        String regex = "^[A-Za-z0-9]*$";
        if (!Pattern.matches(regex, account)) {
            throw new PlatException(ResultStatusEnum.ACCOUNT_ERROR.getMessage());
        }
    }

    /**
     * 修改员工信息以及角色
     *
     * @param staffTbl
     * @param file
     * @throws IOException
     */
    @Transactional
    public void updateUser(BmStaffTbl staffTbl, MultipartFile file) throws IOException {

        BmStaffTbl account = staffTblMapper.selectByAccount(staffTbl.getAccoutname());
        //判断修改后的账号，有没有和其他员工账号重复
        if (account != null && !StringUtils.equals(staffTbl.getStaffid(), account.getStaffid())) {
            throw new PlatException(ResultStatusEnum.AUTH_EXISTS.getMessage());
        }
        checkAccount(staffTbl.getAccoutname());
        //将用户信息更新到staff表
        if (null != file) {
            staffTbl.setUserphoto(file.getBytes());
        }

        //家庭人员表
        familyService.updateBatch(staffTbl);
        //学习经历
        studyService.updateBatch(staffTbl);
        //工作经历
        workService.updateBatch(staffTbl);
        //更新x5
        BmStaffTbl staffTbl1 = staffTblMapper.selectByUserId(staffTbl.getStaffid());
        //如果原账号和新账号，不一样，则更新eip中信息
        if (!StringUtils.equals(staffTbl1.getUsername(), staffTbl.getUsername())) {
            BmStaffTbl staffTbl2 = staffTblMapper.selectByUserId(staffTbl.getStaffid());
            staffTbl2.setUsername(staffTbl.getUsername());
            updateX5UserAccount(staffTbl2);
        }
        staffTblMapper.updateByPrimaryKeySelective(staffTbl);
    }

    /**
     * 根据账号查询出信息
     *
     * @param account
     * @return
     */
    public BmStaffTbl queryByAccount(String account, String password) {

        BmStaffTbl staffTbl = new BmStaffTbl();
        //如果时系统管理员等账号，则去查询admin表
        if (StringUtils.equals(account, CommonFields.getLogAdmin()) || StringUtils.equals(account, CommonFields.getSafeAdmin()) ||
                StringUtils.equals(account, CommonFields.getSysAdmin())) {
            //如果是管理员则需要查询admin_tbl这个表
            AdminTbl adminTbl = adminService.queryByAccount(account);
            //验证密码
            verifyPassword(password, adminTbl.getPass());
            staffTbl.setUsername(adminTbl.getAdminid());
            staffTbl.setAccoutname(adminTbl.getAdminid());
            staffTbl.setStaffid(adminTbl.getUniqueid());
        } else {
            //普通用户
            staffTbl = staffTblMapper.selectByAccount(account);
            if (null == staffTbl) {
                throw new PlatException(ResultStatusEnum.USER_NOT_EXIST.getMessage());
            }
            //验证密码
            verifyPassword(password, staffTbl.getPass());
        }
        //登录时没有token,所以单独添加到日志记录表
        logService.addLoginLog(staffTbl);
        return staffTbl;
    }

    /**
     * 验证密码
     *
     * @param realPassword 用户输入的密码
     * @param password     用户输入的密码
     */
    private void verifyPassword(String realPassword, String password) {
        //解密后的密码
        String decryptPwd = DESUtil.getDecryptString(password);
        if (!StringUtils.equals(decryptPwd, realPassword)) {
            throw new PlatException(ResultStatusEnum.ERROR_PASSWORD.getMessage());
        }
    }

    /**
     * 修改用户密码
     *
     * @param object
     */
    @Transactional
    public void updatePassword(Object object) throws UnsupportedEncodingException {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
        String account = (String) jsonObject.get("account");
        String userId = (String) jsonObject.get("userId");
        //原密码
        String oldPass = (String) jsonObject.get("oldPass");
        //新密码
        String newPass = (String) jsonObject.get("newPass");

        //如果时系统管理员等账号，则去查询admin表
        if (StringUtils.equals(account, CommonFields.getLogAdmin()) || StringUtils.equals(account, CommonFields.getSafeAdmin()) ||
                StringUtils.equals(account, CommonFields.getSysAdmin())) {
            //如果是管理员则需要查询admin_tbl这个表
            AdminTbl adminTbl = adminService.queryByAccount(account);
            //验证密码
            verifyPassword(oldPass, adminTbl.getPass());
            adminTbl.setPass(DESUtil.getEncryptString(newPass));
            adminTblMapper.updateByPrimaryKeySelective(adminTbl);
        } else {
            //普通用户
            BmStaffTbl staffTbl = staffTblMapper.selectByUserId(userId);
            if (null == staffTbl) {
                throw new PlatException(ResultStatusEnum.USER_NOT_EXIST.getMessage());
            }
            //验证密码
            verifyPassword(oldPass, staffTbl.getPass());
            //设置新密码
            staffTbl.setPass(DESUtil.getEncryptString(newPass));
            staffTblMapper.updateByPrimaryKeySelective(staffTbl);
            //更新x5
            updateX5UserPass(staffTbl, oldPass);
        }
    }

    private void updateX5UserPass(BmStaffTbl staffTbl, String oldPass) throws UnsupportedEncodingException {
        X5User x5User = x5UserMapper.selectByBmStaffId(staffTbl.getStaffid());
        if (null != x5User) {
            //更新x5系统和，x5_user表的数据
            JSONObject paramMap = new JSONObject();
            paramMap.put("account", staffTbl.getAccoutname());
            //流程id
            paramMap.put("fullname", staffTbl.getUsername());
            //如果修改了密码，设置新改得密码
            paramMap.put("password", DESUtil.getDecryptString(staffTbl.getPass()));
            paramMap.put("mobile", staffTbl.getUserphone());
            paramMap.put("id", x5User.getX5UserId());

            //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
            String auth = staffTbl.getAccoutname() + ":" + oldPass;
            String token = "Basic " + Base64.getBase64(auth);
            //用 旧的账号密码更新
            eipUtils.updateX5User(paramMap, token);
            //更新x5_user表,根据账号名称和 旧的密码生成token
            String auth1 = staffTbl.getAccoutname() + ":" + DESUtil.getDecryptString(staffTbl.getPass());
            String token1 = "Basic " + Base64.getBase64(auth1);
            x5User.setX5StaffName(staffTbl.getUsername());
            x5User.setX5Token(token1);
            x5UserMapper.updateByPrimaryKey(x5User);
        }
    }

    private void updateX5UserAccount(BmStaffTbl staffTbl) throws UnsupportedEncodingException {
        X5User x5User = x5UserMapper.selectByBmStaffId(staffTbl.getStaffid());
        if (null != x5User) {
            //更新x5系统和，x5_user表的数据
            JSONObject paramMap = new JSONObject();
            paramMap.put("account", staffTbl.getAccoutname());
            //流程id
            paramMap.put("fullname", staffTbl.getUsername());
            //如果修改了密码，设置新改得密码
            paramMap.put("password", DESUtil.getDecryptString(staffTbl.getPass()));
            paramMap.put("mobile", staffTbl.getUserphone());
            paramMap.put("id", x5User.getX5UserId());

            //根据账号名称和密码，生成token，去EIP验证, eip的token,就是根据账号加密码生成的
            String auth = staffTbl.getAccoutname() + ":" + DESUtil.getDecryptString(staffTbl.getPass());
            String token = "Basic " + Base64.getBase64(auth);
            //用 旧的账号密码更新
            eipUtils.updateX5User(paramMap, token);
            //更新x5_user表
            String auth1 = staffTbl.getAccoutname() + ":" + DESUtil.getDecryptString(staffTbl.getPass());
            String token1 = "Basic " + Base64.getBase64(auth1);
            x5User.setX5Token(token1);
            x5User.setX5StaffName(staffTbl.getUsername());
            x5UserMapper.updateByPrimaryKey(x5User);
        }
    }


    /**
     * 查询所有员工的信息，组织部门，以及角色信息
     *
     * @return
     */
    public Map<String, Object> queryAllStaffInfo(StaffQueryVO queryVO) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(queryVO.getPageNum(), queryVO.getPageSize());
        queryVO.setPageNum(start);
        //分页查询出的数据
        List<BmStaffTbl> list = staffTblMapper.queryStaffInfoPage(queryVO);
        list.forEach(staff -> {
            Organization organization = orgMapper.queryParentName(staff.getDeptid());
            staff.setDeptName(null == organization ? null : organization.getOrgname());
        });

        //总数据
        int totalCount = staffTblMapper.selectTotal(queryVO);

        map.put("list", list);
        map.put("totalCount", totalCount);
        return map;
    }

    /**
     * 根据员工id查询员工信息
     *
     * @param userId
     * @return
     */
    public BmStaffTbl queryInfoByUserId(String userId) {

        BmStaffTbl staffTbl = staffTblMapper.selectByUserId(userId);
        //查询出家庭人员
        List<BmStafffamilyTbl> familyList = stafffamilyTblMapper.selectByUserId(userId);
        //学习经历
        List<BmStaffstudyTbl> studyList = staffstudyTblMapper.selectByUserId(userId);
        //工作经历
        List<BmStaffworkTbl> workList = staffworkTblMapper.selectByUserId(userId);

        staffTbl.setStafffamilyList(familyList);
        staffTbl.setStaffstudyTbls(studyList);
        staffTbl.setStaffworkTbls(workList);

        return staffTbl;
    }


    /**
     * 删除用户以及角色，家庭，学习，工作表
     *
     * @param userId
     */
    @Transactional
    public void deleteUserAndRole(String userId) {
        //保密员工表
        staffTblMapper.deleteByUserId(userId);
        familyService.delFamily(userId);
        studyService.delStudy(userId);
        workService.delWorker(userId);

    }

    /**
     * 查询出要导出涉密人员信息
     *
     * @return
     */
    public List<BmStaffTbl> queryExportInfo(StaffQueryVO queryVO) {
        List<BmStaffTbl> list = staffTblMapper.queryExportInfo(queryVO);
        list.forEach(staff -> {
            Organization organization = orgMapper.queryParentName(staff.getDeptid());
            staff.setDeptName(null == organization ? null : organization.getOrgname());
        });
        return list;
    }

    /**
     * 根据人员名称查询
     *
     * @return
     */
    public String queryByUserName(String userName) {
        BmStaffTbl staffTbl = staffTblMapper.selectByUserName(userName);
        return null == staffTbl ? null : staffTbl.getStaffid();
    }


    /**
     * 批量导入Excel
     *
     * @param file
     */
    public void importExcel(MultipartFile file) {
        List<BmStaffTbl> infoList = new ArrayList<>();
        //读取excel文件内容
        List<Object[]> list = ExcelUtils.importExcel(file);
        for (int i = 0; i < list.size(); i++) {
            BmStaffTbl info = new BmStaffTbl();
            info.setStaffid(CommonUtils.generateUUID());
            String orgName = (String) list.get(i)[0];
            //根据机构名称查询出机构id
            Organization organization = orgMapper.queryByOrgName(orgName);
            info.setDeptid(null != organization ? organization.getUniqueid() : null);
            info.setIdcard((String) list.get(i)[1]);
            info.setUsername((String) list.get(i)[2]);
            info.setUsersex((String) list.get(i)[3]);
            info.setSecretlevelid(codeService.queryIdByName((String) list.get(i)[4]));
            info.setIdcard((String) list.get(i)[5]);
            info.setUserface((String) list.get(i)[6]);
            info.setJobpost((String) list.get(i)[7]);
            info.setAdminpost((String) list.get(i)[8]);
            info.setUseroffice((String) list.get(i)[9]);

            infoList.add(info);
        }
        staffTblMapper.insertBatch(infoList);
    }

    /**
     * 根据密级id查询员工
     *
     * @param levelId
     * @return
     */
    public List<BmStaffTbl> selectByLevelId(String levelId, List<String> ids) {
        List<BmStaffTbl> list = staffTblMapper.selectByLevelId(levelId, ids);
        return list;
    }


}