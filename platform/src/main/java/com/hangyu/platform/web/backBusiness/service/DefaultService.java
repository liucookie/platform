package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.Bm2DeptcheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanTbl;
import com.hangyu.platform.web.backBusiness.dto.BmCheckplanpeasonTbl;
import com.hangyu.platform.web.backBusiness.dto.BmHyperlinkTbl;
import com.hangyu.platform.web.backBusiness.dto.BmNotifyTbl;
import com.hangyu.platform.web.backBusiness.dto.BmOrgfileTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSecsoftverTbl;
import com.hangyu.platform.web.backBusiness.dto.BmSpecnewsTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStafffamilyTbl;
import com.hangyu.platform.web.backBusiness.dto.BmWorkdynTbl;
import com.hangyu.platform.web.backBusiness.dto.Computerinfo;
import com.hangyu.platform.web.backBusiness.dto.CreditscoreTbl;
import com.hangyu.platform.web.backBusiness.dto.Oaequipinfo;
import com.hangyu.platform.web.backBusiness.dto.Organization;
import com.hangyu.platform.web.backBusiness.dto.PostsecretlevelTbl;
import com.hangyu.platform.web.backBusiness.dto.PublicityTbl;
import com.hangyu.platform.web.backBusiness.dto.TzMediamanagementTbl;
import com.hangyu.platform.web.backBusiness.dto.TzPortablemanagementTbl;
import com.hangyu.platform.web.backBusiness.dto.Userhz;
import com.hangyu.platform.web.backBusiness.dto.Yirenduogang;
import com.hangyu.platform.web.backBusiness.mapper.Bm2DeptcheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCheckplanpeasonTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmCommonformTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmHyperlinkTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmNotifyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmOrgfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmSpecnewsTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStafffamilyTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmVouchinfoTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmWorkdynTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.ComputerinfoMapper;
import com.hangyu.platform.web.backBusiness.mapper.CreditscoreTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.OaequipinfoMapper;
import com.hangyu.platform.web.backBusiness.mapper.OrganizationMapper;
import com.hangyu.platform.web.backBusiness.mapper.PostsecretlevelTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.PublicityTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.TzMediamanagementTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.TzPortablemanagementTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.UserhzMapper;
import com.hangyu.platform.web.backBusiness.mapper.YirenduogangMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户核对信息管理
 *
 * @auther liuXuan
 * @date 2020/3/13
 */
@Service
public class DefaultService {

    //测试机
    @Value("testing_machine_id")
    private String testMachineId;

    //联网计算机
    @Value("computer_id")
    private String computerId;

    //打印机
    @Value("printer_id")
    private String printerId;

    //投影机
    @Value("projector_id")
    private String projectorId;

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultService.class);

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private BmStafffamilyTblMapper stafffamilyTblMapper;

    @Resource
    private BmNotifyTblMapper bmNotifyTblMapper;

    @Resource
    private BmWorkdynTblMapper workMapper;

    @Resource
    private PublicityTblMapper publicityTblMapper;

    @Resource
    private BmHyperlinkTblMapper linkMapper;

    @Resource
    private BmSpecnewsTblMapper specnewsTblMapper;

    @Resource
    private CreditscoreTblMapper creditscoreTblMapper;

    @Resource
    private BmCheckplanTblMapper checkplanTblMapper;

    @Resource
    private BmCheckplanpeasonTblMapper checkplanpeasonTblMapper;

    @Resource
    private Bm2DeptcheckplanTblMapper deptcheckplanTblMapper;

    @Resource
    private ComputerinfoMapper computerinfoMapper;

    @Resource
    private OaequipinfoMapper oaequipinfoMapper;

    @Resource
    private YirenduogangMapper yirenduogangMapper;

    @Resource
    private PostsecretlevelTblMapper postsecretlevelTblMapper;

    @Resource
    private BmVouchinfoTblMapper vouchinfoTblMapper;

    @Autowired
    private BmSecSoftManageService secSoftManageService;

    @Resource
    private BmCommonformTblMapper commonformTblMapper;

    @Resource
    private UserhzMapper userhzMapper;

    @Resource
    private TzPortablemanagementTblMapper portableMapper;

    @Resource
    private TzMediamanagementTblMapper mediaMapper;

    @Resource
    private BmOrgfileTblMapper orgFileTblMapper;


    /**
     * 查询出用户个人信息
     *
     * @param userId 用户id
     * @return
     */
    public BmStaffTbl queryUserInfo(String userId) {
        BmStaffTbl staff = staffTblMapper.selectByUserId(userId);
        //查询出部门
        Organization organization = organizationMapper.queryParentName(staff.getDeptid());
        staff.setDeptName(null == organization ? null : organization.getOrgname());
        //查询出岗位
        List<Yirenduogang> list = yirenduogangMapper.selectByUserId(userId);
        StringBuilder sb = new StringBuilder();
        for (Yirenduogang yi : list) {
            sb.append(yi.getGangwei()).append(",");
            staff.setGangWei(sb.toString().substring(0, sb.lastIndexOf(",")));
        }
        //查询出家庭人员
        List<BmStafffamilyTbl> familyList = stafffamilyTblMapper.selectByUserId(userId);
        staff.setStafffamilyList(familyList);
        return staff;
    }

    /**
     * 查询所有岗位职责
     *
     * @param userId
     * @return
     */
    public List<PostsecretlevelTbl> queryWork(String userId) {
        List<PostsecretlevelTbl> list = postsecretlevelTblMapper.selectByUserId(userId);
        return list;
    }

    /**
     * 查询出通知公告管理
     *
     * @param
     * @return
     */
    public List<BmNotifyTbl> queryNotify(String topSign) {
        List<BmNotifyTbl> list = bmNotifyTblMapper.queryNotify(topSign);
        //处理标题
        for (BmNotifyTbl work : list) {
            String name = "[" + work.getUpdatetime() + "]" + work.getInfoname();
            work.setShowName(name);
        }
        return list;
    }

    /**
     * 查询工作动态
     *
     * @param
     * @return
     */
    public List<BmWorkdynTbl> queryWorkDynamic(String topSign) {
        List<BmWorkdynTbl> list = workMapper.queryWorkDynamic(topSign);
        //处理标题
        for (BmWorkdynTbl work : list) {
            String name = "[" + work.getUpdatetime() + "]" + work.getInfoname();
            work.setShowName(name);
        }
        return list;
    }

    /**
     * 查询宣传教育
     *
     * @param
     * @return
     */
    public List<PublicityTbl> queryPublicity(String type) {
        List<PublicityTbl> list = publicityTblMapper.queryPublicity(type);
        //处理标题
        for (PublicityTbl work : list) {
            String name = "[" + work.getAddtime() + "]" + work.getTitle();
            work.setShowTitle(name);
            //查询出附件表的数据
            BmOrgfileTbl file = orgFileTblMapper.selectByOrgId(work.getUniqueid());
            work.setFileUrl(null == file ? null : file.getFileurl());
        }
        return list;
    }

    /**
     * 查询工作动态
     *
     * @param
     * @return
     */
    public List<BmHyperlinkTbl> queryHyperLink(String topSign) {
        List<BmHyperlinkTbl> list = linkMapper.queryHyperLink(topSign);
        return list;
    }

    /**
     * 查询工作动态
     *
     * @param
     * @return
     */
    public List<BmSpecnewsTbl> querySpecNews(String topSign) {
        List<BmSpecnewsTbl> list = specnewsTblMapper.querySpecNews(topSign);
        return list;
    }


    /**
     * 查询积分管理
     *
     * @param userId
     * @return
     */
    public Map<String, Double> queryScore(String userId) {
        Map<String, Double> map = new HashMap<>();
        double userYearScore = 0;
        double deptYearScore = 0;
        double deptMonthScore = 0;
        //查询出处室id
        BmStaffTbl staffTbl = staffTblMapper.selectByUserId(userId);
        String orgId = staffTbl.getDeptid();
        //查询出部门信息
        Organization organization = organizationMapper.selectByPrimaryKey(orgId);
        //部门id
        String deptId = null == organization ? null : organization.getParentid();
        //获取当前年份,月份
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        //查询部门年度积分
        CreditscoreTbl creditscoreTbl = creditscoreTblMapper.selectDeptOrUserScore(deptId, "0", year);
        if (null != creditscoreTbl) {
            //年度积分
            deptYearScore = creditscoreTbl.getYearscore();
            //月度积分
            switch (month) {
                case 1:
                    deptMonthScore = creditscoreTbl.getMonthscore1();
                    break;
                case 2:
                    deptMonthScore = creditscoreTbl.getMonthscore2();
                    break;
                case 3:
                    deptMonthScore = creditscoreTbl.getMonthscore3();
                    break;
                case 4:
                    deptMonthScore = creditscoreTbl.getMonthscore4();
                    break;
                case 5:
                    deptMonthScore = creditscoreTbl.getMonthscore5();
                    break;
                case 6:
                    deptMonthScore = creditscoreTbl.getMonthscore6();
                    break;
                case 7:
                    deptMonthScore = creditscoreTbl.getMonthscore7();
                    break;
                case 8:
                    deptMonthScore = creditscoreTbl.getMonthscore8();
                    break;
                case 9:
                    deptMonthScore = creditscoreTbl.getMonthscore9();
                    break;
                case 10:
                    deptMonthScore = creditscoreTbl.getMonthscore10();
                    break;
                case 11:
                    deptMonthScore = creditscoreTbl.getMonthscore11();
                    break;
                case 12:
                    deptMonthScore = creditscoreTbl.getMonthscore12();
                    break;
                default:
                    break;
            }

        }
        //查询部门当月积分
        //查询人员积分
        CreditscoreTbl userScore = creditscoreTblMapper.selectDeptOrUserScore(userId, "1", year);
        if (null != userScore) {
            userYearScore = userScore.getYearscore();
        }
        map.put("deptYearScore", deptYearScore);
        map.put("deptMonthScore", deptMonthScore);
        map.put("userYearScore", userYearScore);
        return map;
    }


    /**
     * 计算机检查
     *
     * @param
     * @return
     */
    public Map<String, String> queryComputerCheck(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("data", null);
        //当前年月日
        String date = DateUtils.getCurrentDate();
        //根据时间节点查询出检查计划
        BmCheckplanTbl checkplanTbl = checkplanTblMapper.selectByDate(date);
        if (null != checkplanTbl) {
            //计划id
            String planId = checkplanTbl.getPlanid();
            //判断计划下的人员表中，有没有该职员信息
            BmCheckplanpeasonTbl checkplanpeasonTbl = checkplanpeasonTblMapper.selectByDateAndUser(planId, userId);
            if (null != checkplanpeasonTbl) {
                map.put("data", "通知: 请与" + checkplanTbl.getPlanbegindate() + "-" + checkplanTbl.getPlanenddate() + "期间进行保密检查登记!");
            }
        }
        return map;
    }


    /**
     * 部门检查
     *
     * @param
     * @return
     */
    public Map<String, String> queryDeptCheck(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("data", null);
        //当前年月日
        String date = DateUtils.getCurrentDate();
        Bm2DeptcheckplanTbl deptcheckplanTbl = deptcheckplanTblMapper.selectByDate(date);
        if (null != deptcheckplanTbl) {
            //计划id
            String planId = deptcheckplanTbl.getPlanid();
            //判断计划下的人员表中，有没有该职员信息
            BmCheckplanpeasonTbl checkplanpeasonTbl = checkplanpeasonTblMapper.selectByDateAndUser(planId, userId);
            LOGGER.info("planId:{}", planId);
            if (null != checkplanpeasonTbl) {
                map.put("data", "通知: 请与" + deptcheckplanTbl.getPlanbegindate() + "-" + deptcheckplanTbl.getPlanenddate() + "期间进行保密检查登记!");
            }
        }
        return map;
    }

    /**
     * 个人持有信息设备
     *
     * @param userId
     * @return
     */
    public Map<String, Object> queryUserComputerInfo(String userId) {
        Map<String, Object> map = new HashMap<>();
        //测试机
        List<Computerinfo> testMachineList = computerinfoMapper.queryComputerInfo(userId, testMachineId);
        //联网计算机
        List<Computerinfo> computerList = computerinfoMapper.queryComputerInfo(userId, computerId);
        //查询存储介质
        List<TzMediamanagementTbl> mediaList = mediaMapper.queryByUserId(userId);
        //查询便携机
        List<TzPortablemanagementTbl> portablemanagementTbls = portableMapper.queryByUserId(userId);
        //打印机
        List<Oaequipinfo> printerInfos = oaequipinfoMapper.queryOAInfo(userId, printerId);
        //投影机
        List<Oaequipinfo> oaequipinfos = oaequipinfoMapper.queryOAInfo(userId, projectorId);

        map.put("testMachine",testMachineList.size());
        map.put("computer",computerList.size());
        map.put("media",mediaList.size());
        map.put("portableManage",portablemanagementTbls.size());
        map.put("printer",printerInfos.size());
        map.put("projector",oaequipinfos.size());
        return map;
    }

    /**
     * 查询工作动态
     *
     * @param
     * @return
     */
    public List<Computerinfo> queryComputerInfo(String userId) {
        //测试机
        List<Computerinfo> machineList = computerinfoMapper.queryComputerInfo(userId, testMachineId);
        //联网计算机
        List<Computerinfo> computerList = computerinfoMapper.queryComputerInfo(userId, computerId);
        machineList.addAll(computerList);
        //查询便携机
        List<TzPortablemanagementTbl> portablemanagementTbls = portableMapper.queryByUserId(userId);
        //处理便携机
        dealPortableManage(portablemanagementTbls, machineList);

        //查询存储介质
        List<TzMediamanagementTbl> mediaList = mediaMapper.queryByUserId(userId);
        //处理存储介质
         dealMedia(mediaList,machineList);

        //打印机
        List<Oaequipinfo> printerInfos = oaequipinfoMapper.queryOAInfo(userId, printerId);
        //投影机
        List<Oaequipinfo> oaequipinfos = oaequipinfoMapper.queryOAInfo(userId, projectorId);
        oaequipinfos.addAll(printerInfos);
        for (Oaequipinfo oa : oaequipinfos) {
            Computerinfo info = new Computerinfo();
            info.setSbxh(oa.getSbxh());
            info.setSbbm(oa.getSbbm());
            //设备类型
            info.setEquipTypeName(oa.getOaequipname());
            //密级
            info.setSecretName(oa.getSecretName());
            //使用状态
            info.setUseStateName(oa.getUseStateName());
            //房间
            info.setPlacement(oa.getPlacement());
            //备注
            info.setComputerinfomemo(oa.getInfomemo());
            machineList.add(info);
        }
        return machineList;
    }

    /**
     * 处理介质
     *
     * @param list
     * @param testMachineList
     */
    private void dealMedia(List<TzMediamanagementTbl> list, List<Computerinfo> testMachineList) {
        for (TzMediamanagementTbl oa : list) {
            Computerinfo info = new Computerinfo();
            info.setSbxh(oa.getBrand());
            info.setSbbm(oa.getChipserialnumber());
            //设备类型
            info.setEquipTypeName("存储介质");
            //密级
            info.setSecretName(oa.getSecretlevel());
            //使用状态
            info.setUseStateName(oa.getUsage());
            //备注
            info.setComputerinfomemo(oa.getRemark());
            testMachineList.add(info);
        }
    }

    /**
     * 处理便携机
     *
     * @param list
     * @param testMachineList
     */
    private void dealPortableManage(List<TzPortablemanagementTbl> list, List<Computerinfo> testMachineList) {
        for (TzPortablemanagementTbl oa : list) {
            Computerinfo info = new Computerinfo();
            info.setSbxh(oa.getBrand());
            info.setSbbm(oa.getAssetnumber());
            //设备类型
            info.setEquipTypeName("便携机");
            //密级
            info.setSecretName(oa.getSecretlevel());
            //使用状态
            info.setUseStateName(oa.getUsage());
            //备注
            info.setComputerinfomemo(oa.getRemark());
            testMachineList.add(info);
        }
    }

    /**
     * 用户核对信息
     *
     * @param user
     */
    public void checkUserhz(String user, int type) {
        Userhz userhz = new Userhz();
        userhz.setHztype(type);
        userhz.setUserid(user);
        userhz.setHzyear(DateUtils.currentYear());
        userhz.setHzmonth(DateUtils.currentMonth());
        userhzMapper.insert(userhz);
    }

    /**
     * 查询用户是否核对
     *
     * @param userId
     * @param type
     * @return
     */
    public Boolean queryIsCheck(String userId, int type) {
        Boolean flag = false;
        Userhz userhz = userhzMapper.queryIsCheck(type, userId, DateUtils.currentYear(), DateUtils.currentMonth());
        if (null != userhz) {
            flag = true;
            return flag;
        }
        return flag;
    }


    /**
     * 白名单软件
     *
     * @param
     * @return
     */
    public List<BmSecsoftTbl> querySoft(String type) {
        List<BmSecsoftTbl> list = secSoftManageService.queryByType(type);
        return list;
    }

    /**
     * 白名单软件(下载按钮)
     *
     * @param
     * @return
     */
    public List<BmSecsoftverTbl> downloadSoft(String id) {
        List<BmSecsoftverTbl> list = secSoftManageService.downloadSoft(id);
        return list;
    }


}
