package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.FileUtils;
import com.hangyu.platform.web.backBusiness.dto.BmKeydeptTbl;
import com.hangyu.platform.web.backBusiness.dto.BmKeyfileTbl;
import com.hangyu.platform.web.backBusiness.dto.BmKeyplacepicmodelTbl;
import com.hangyu.platform.web.backBusiness.dto.BmKeypositionTbl;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.mapper.BmKeydeptTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmKeyfileTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmKeyplacepicmodelTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmKeypositionTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BmKeyDeptlService {

    @Resource
    private BmKeydeptTblMapper deptMapper;

    @Resource
    private BmKeypositionTblMapper positionMapper;

    @Resource
    private BmKeyfileTblMapper fileMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private BmKeyplacepicmodelTblMapper placeMapper;


    /**
     * @return
     */
    public List<BmKeyplacepicmodelTbl> queryPlace() {
        List<BmKeyplacepicmodelTbl> list = placeMapper.queryPlace();
        return list;
    }

    /**
     * 查询要害部门
     *
     * @param orgName
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> selectDept(String orgName, String userName, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmKeydeptTbl> list = deptMapper.selectDept(orgName, userName, start, pageSize);
        int count = deptMapper.selectTotal(orgName, userName);
        map.put("total", count);
        map.put("list", list);
        return map;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmKeydeptTbl queryDeptById(String id) {
        BmKeydeptTbl tbl = deptMapper.selectByPrimaryKey(id);
        //查出附件信息
        List<BmKeyfileTbl> fileTbl = fileMapper.selectByDeptId(id);
        tbl.setBmKeyfileTbls(fileTbl);
        //处理员工
        if (StringUtils.isNotEmpty(tbl.getPositionuser())) {
            List<String> useId = Arrays.asList(StringUtils.split(tbl.getPositionuser(), ","));
            List<BmStaffTbl> staffTblList = staffTblMapper.selectBatch(useId);
            tbl.setStaffTbls(staffTblList);
        }
        return tbl;

    }

    /**
     * 查询部门历史
     *
     * @param id
     * @return
     */
    public List<BmKeydeptTbl> queryDeptHistory(String id) {
        List<BmKeydeptTbl> list = deptMapper.queryDeptHistory(id);
        for (BmKeydeptTbl tbl : list) {
            //查出附件信息
            List<BmKeyfileTbl> fileTbl = fileMapper.selectByDeptId(id);
            tbl.setBmKeyfileTbls(fileTbl);
            //处理员工
            if (StringUtils.isNotEmpty(tbl.getPositionuser())) {
                tbl.setPositionuser(dealUserName(tbl.getPositionuser()));
            }
        }
        return list;
    }

    /**
     * 导出excel
     *
     * @param userName
     * @param orgName
     * @return
     */
    public List<BmKeydeptTbl> exportDept(String orgName, String userName) {
        List<BmKeydeptTbl> list = deptMapper.exportDept(orgName, userName);
        return list;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void addDept(BmKeydeptTbl tbl, MultipartFile picture, MultipartFile file) throws IOException {
        //内防还是外放
        String picModelId = tbl.getPicModelId();
        String sysId = CommonUtils.generateUUID();
        tbl.setDeptid(sysId);
        //上传附件,
        if (null != file) {
            addFile(file, sysId, 0);
        }
        //上传图片，0 是要害部门
        if (null != picture) {
            addPic(picture, sysId, 0, picModelId);
        }
        String user = dealUser(tbl.getStaffTbls());
        tbl.setPositionuser(user);
        deptMapper.insert(tbl);
    }

    private String dealUser(List<BmStaffTbl> staffTblList) {
        //涉密总人数
        StringBuilder sb = new StringBuilder();
        if (CollectionUtils.isNotEmpty(staffTblList)) {
            for (BmStaffTbl staff : staffTblList) {
                sb.append(staff.getStaffid()).append(",");
            }
        }
        return sb.toString();
    }


    private void addFile(MultipartFile file, String sysId, int type) throws IOException {
        BmKeyfileTbl fileTbl = new BmKeyfileTbl();
        fileTbl.setFileid(CommonUtils.generateUUID());
        //设置关联的部门id
        fileTbl.setDeporplaid(sysId);
        String fileUrl = FileUtils.uploads(file);
        fileTbl.setFilename(file.getOriginalFilename());
        fileTbl.setFileurl(fileUrl);
        fileTbl.setDeporplatype(type);
        //1是附件，0图片
        fileTbl.setFiletype(1);
        fileMapper.insert(fileTbl);
    }

    private void addPic(MultipartFile pic, String sysId, int type, String picModelId) throws IOException {
        BmKeyfileTbl fileTbl = new BmKeyfileTbl();
        fileTbl.setFileid(CommonUtils.generateUUID());
        //区分内防还是外防
        fileTbl.setPicmodelid(picModelId);
        //设置关联的部门id
        fileTbl.setDeporplaid(sysId);
        String fileUrl = FileUtils.uploadStaticFile(pic);
        fileTbl.setFilename(pic.getOriginalFilename());
        fileTbl.setFileurl(fileUrl);
        fileTbl.setDeporplatype(type);
        //1是附件，0图片
        fileTbl.setFiletype(0);
        fileMapper.insert(fileTbl);
    }

    private void deleteFile(String sysId) {
        List<BmKeyfileTbl> list = fileMapper.selectByDeptId(sysId);
        list.forEach(tbl -> {
            //删除服务器的附件
            if (tbl.getFiletype() == 1) {
                FileUtils.deleteFile(tbl.getFileurl());
            }
            fileMapper.deleteByPrimaryKey(tbl.getFileid());
        });

    }

    private void deletePicture(String sysId) {
        List<BmKeyfileTbl> list = fileMapper.selectByDeptId(sysId);
        list.forEach(tbl -> {
            //删除服务器的附件
            if (tbl.getFiletype() == 0) {
                FileUtils.deleteFile(CommonFields.getPicPath() + tbl.getFileurl());
            }
            fileMapper.deleteByPrimaryKey(tbl.getFileid());
        });

    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void updateDept(BmKeydeptTbl tbl, MultipartFile picture, MultipartFile file) throws IOException {
        //如果filename为Null,则说明删除了文件，删除附件表
        //内防还是外放
        String picModelId = tbl.getPicModelId();
        String[] deleteFileIds = tbl.getDeleteFileIds();
        if (null != deleteFileIds && deleteFileIds.length > 0) {
            for (String fileId : deleteFileIds) {
                BmKeyfileTbl bmKeyfileTbl = fileMapper.selectByFileId(fileId);
                FileUtils.deleteFile(bmKeyfileTbl.getFileurl());
                fileMapper.deleteByPrimaryKey(fileId);
            }
        }
        //上传附件,
        if (null != file) {
            //删除以前为0的数据
            addFile(file, tbl.getDeptid(), 0);
        }
        //上传图片，0 是要害部门
        if (null != picture) {
            addPic(picture, tbl.getDeptid(), 0, picModelId);
        }
        String user = dealUser(tbl.getStaffTbls());
        tbl.setPositionuser(user);
        //保存为历史版本，则History为1，保存之前先将以前的数据删除，再增加一条数据
        String deptId = tbl.getDeptid();
        if (1 == tbl.getIshistory()) {
            deptMapper.deleteByPrimaryKey(tbl.getId(), deptId, tbl.getIshistory());
            //清除主键
            tbl.setId(null);
            deptMapper.insert(tbl);
        } else {
            deptMapper.updateByPrimaryKey(tbl);
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void deleteDept(String id) throws IOException {
        deletePicture(id);
        deleteFile(id);
        deptMapper.deleteByDeptId(id);
    }

    /**
     * 删除历史
     *
     * @param id
     */
    @Transactional
    public void deleteHistory(int id) throws IOException {
        deptMapper.deleteHistory(id);
    }

    /**
     * 查询要害部位
     *
     * @param orgName
     * @param userName
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryPosition(String orgName, String userName, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<BmKeypositionTbl> list = positionMapper.queryPosition(orgName, userName, start, pageSize);
        int count = positionMapper.selectTotal(orgName, userName);
        map.put("total", count);
        map.put("list", list);
        return map;
    }

    /**
     * 导出excel
     *
     * @param userName
     * @param orgName
     * @return
     */
    public List<BmKeypositionTbl> exportPosition(String orgName, String userName) {
        List<BmKeypositionTbl> list = positionMapper.exportPosition(orgName, userName);
        return list;
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public BmKeypositionTbl queryPositionById(String id) {
        BmKeypositionTbl tbl = positionMapper.selectByPrimaryKey(id);
        //查出附件信息
        List<BmKeyfileTbl> fileTbl = fileMapper.selectByDeptId(id);
        tbl.setBmKeyfileTbls(fileTbl);
        //处理员工
        if (StringUtils.isNotEmpty(tbl.getPositionuser())) {
            List<String> useId = Arrays.asList(StringUtils.split(tbl.getPositionuser(), ","));
            List<BmStaffTbl> staffTblList = staffTblMapper.selectBatch(useId);
            tbl.setStaffTbls(staffTblList);
        }
        return tbl;

    }

    /**
     * 查询历史记录
     *
     * @param id
     * @return
     */
    public List<BmKeypositionTbl> queryPostionHistory(String id) {
        List<BmKeypositionTbl> list = positionMapper.queryPositionHistory(id);
        list.forEach(tbl -> {
            //查出附件信息
            List<BmKeyfileTbl> fileTbl = fileMapper.selectByDeptId(id);
            tbl.setBmKeyfileTbls(fileTbl);
            //处理员工
            if (StringUtils.isNotEmpty(tbl.getPositionuser())) {
                tbl.setPositionuser(dealUserName(tbl.getPositionuser()));
            }
        });
        return list;

    }

    private String dealUserName(String user) {
        StringBuilder sb = new StringBuilder();
        List<String> useId = Arrays.asList(StringUtils.split(user, ","));
        List<BmStaffTbl> staffTblList = staffTblMapper.selectBatch(useId);
        staffTblList.forEach(staff -> {
            sb.append(staff.getUsername()).append(",");
        });
        String userName = StringUtils.isNotEmpty(sb) ? sb.substring(0, sb.lastIndexOf(",")) : null;
        return userName;
    }


    /**
     * 增加
     *
     * @param tbl
     */
    @Transactional
    public void addPosition(BmKeypositionTbl tbl, MultipartFile picture, MultipartFile file) throws IOException {
        //内防还是外放
        String picModelId = tbl.getPicModelId();
        String sysId = CommonUtils.generateUUID();
        tbl.setPositionid(sysId);
        //上传附件,
        if (null != file) {
            addFile(file, sysId, 1);
        }
        //上传图片，0 是要害部门，1要害部位
        if (null != picture) {
            addPic(picture, sysId, 1, picModelId);
        }
        String user = dealUser(tbl.getStaffTbls());
        tbl.setPositionuser(user);
        positionMapper.insert(tbl);
    }

    /**
     * 修改
     *
     * @param tbl
     */
    @Transactional
    public void updatePosition(BmKeypositionTbl tbl, MultipartFile picture, MultipartFile file) throws IOException {
        //如果filename为Null,则说明删除了文件，删除附件表
        //内防还是外放
        String picModelId = tbl.getPicModelId();
        String[] deleteFileIds = tbl.getDeleteFileIds();
        if (null != deleteFileIds && deleteFileIds.length > 0) {
            for (String fileId : deleteFileIds) {
                BmKeyfileTbl bmKeyfileTbl = fileMapper.selectByFileId(fileId);
                FileUtils.deleteFile(bmKeyfileTbl.getFileurl());
                fileMapper.deleteByPrimaryKey(fileId);
            }
        }
        //上传附件,
        if (null != file) {
            addFile(file, tbl.getPositionid(), 1);
        }
        //上传图片，0 是要害部门,1是部位
        if (null != picture) {
            addPic(picture, tbl.getPositionid(), 1, picModelId);
        }
        String user = dealUser(tbl.getStaffTbls());
        tbl.setPositionuser(user);
        //保存为历史版本，则History为1，保存之前先将以前的数据删除，再增加一条数据
        String deptId = tbl.getPositionid();
        if (tbl.getIshistory() == 1) {
            positionMapper.deleteByPrimaryKey(tbl.getId(), deptId, tbl.getIshistory());
            //清除主键
            tbl.setId(null);
            positionMapper.insert(tbl);
        } else {
            positionMapper.updateByPrimaryKey(tbl);
        }

    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void deletePosition(String id) throws IOException {
        deletePicture(id);
        deleteFile(id);
        positionMapper.deleteByPositionId(id);
    }

    /**
     * 删除历史
     *
     * @param id
     */
    @Transactional
    public void deleteHistoryPosition(int id) throws IOException {
        positionMapper.deleteHistoryPosition(id);
    }
}
