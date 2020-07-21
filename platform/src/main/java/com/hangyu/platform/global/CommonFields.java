package com.hangyu.platform.global;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * 配置文件字段读取类，set时需要设置方法属性为私有，安全考虑
 */
@Component
public class CommonFields {


    /**
     * 文件上传默认路径
     */
    private static String filePath;

    /**
     * 图片上传默认路径
     */
    private static String picPath;
    /**
     * 私钥token
     */
    private static String token;

    /**
     * 密码密钥
     */
    private static String passwordSecret;
    /**
     * 用户初始密码
     */
    private static String defaultPassword;

    /**
     * 安全管理员
     */
    private static String safeAdmin;
    /**
     * 系统管理员
     */
    private static String sysAdmin;
    /**
     * 日志管理员
     */
    private static String logAdmin;
    /**
     * 模板下载路径
     */
    private static String templateFilePath;

    /**
     * 菜单
     */
    private static String menuIcon;
    /**
     * 按钮
     */
    private static String buttonIcon;
    /**
     * i静态文件地址
     */
    private static String staticFile;

    private static String total;

    private static String data;

    private static String politicalDepartmentId;
    private static String coreSecretLevelId;
    private static String importantSecretLevelId;
    private static String generalSecretLevelId;
    private static String notSecretLevelId;


    public static String getPoliticalDepartmentId() {
        return politicalDepartmentId;
    }
    @Value("${political_department_id}")
    public  void setPoliticalDepartmentId(String politicalDepartmentId) {
        CommonFields.politicalDepartmentId = politicalDepartmentId;
    }

    public static String getCoreSecretLevelId() {
        return coreSecretLevelId;
    }
    @Value("${core_secretLevel_id}")
    public  void setCoreSecretLevelId(String coreSecretLevelId) {
        CommonFields.coreSecretLevelId = coreSecretLevelId;
    }

    public static String getImportantSecretLevelId() {
        return importantSecretLevelId;
    }
    @Value("${important_secretLevel_id}")
    public  void setImportantSecretLevelId(String importantSecretLevelId) {
        CommonFields.importantSecretLevelId = importantSecretLevelId;
    }

    public static String getGeneralSecretLevelId() {
        return generalSecretLevelId;
    }
    @Value("${general_secretLevel_id}")
    public  void setGeneralSecretLevelId(String generalSecretLevelId) {
        CommonFields.generalSecretLevelId = generalSecretLevelId;
    }

    public static String getNotSecretLevelId() {
        return notSecretLevelId;
    }
    @Value("${not_secretLevel_id}")
    public  void setNotSecretLevelId(String notSecretLevelId) {
        CommonFields.notSecretLevelId = notSecretLevelId;
    }

    public static String getTotal() {
        return total;
    }

    @Value("total")
    private void setTotal(String total) {
        CommonFields.total = total;
    }

    public static String getData() {
        return data;
    }

    @Value("list")
    private void setData(String data) {
        CommonFields.data = data;
    }

    public static String getStaticFile() {
        return staticFile;
    }

    @Value("${picture.upload.path}")
    private void setStaticFile(String staticFile) {
        CommonFields.staticFile = staticFile;
    }

    @Value("${file.upload.path}")
    private void setFilePath(String filePath) {
        CommonFields.filePath = filePath;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static String getPicPath() {
        return picPath;
    }

    @Value("${picture.upload.path}")
    public void setPicPath(String picPath) {
        CommonFields.picPath = picPath;
    }

    public static String getToken() {
        return token;
    }

    @Value("${secret_token}")
    private void setToken(String token) {
        CommonFields.token = token;
    }

    public static String getPasswordSecret() {
        return passwordSecret;
    }

    @Value("${secret_password}")
    private void setPasswordSecret(String passwordSecret) {
        CommonFields.passwordSecret = passwordSecret;
    }

    public static String getDefaultPassword() {
        return defaultPassword;
    }

    @Value("${default_password}")
    private void setDefaultPassword(String defaultPassword) {
        CommonFields.defaultPassword = defaultPassword;
    }

    public static String getSafeAdmin() {
        return safeAdmin;
    }

    @Value("${safe_admin}")
    private void setSafeAdmin(String safeAdmin) {
        CommonFields.safeAdmin = safeAdmin;
    }

    public static String getSysAdmin() {
        return sysAdmin;
    }

    @Value("${sys_admin}")
    private void setSysAdmin(String sysAdmin) {
        CommonFields.sysAdmin = sysAdmin;
    }

    public static String getLogAdmin() {
        return logAdmin;
    }

    @Value("${log_admin}")
    private void setLogAdmin(String logAdmin) {
        CommonFields.logAdmin = logAdmin;
    }

    public static String getTemplateFilePath() throws IOException {
//        String path = ResourceUtils.getURL("classpath:templates/").getPath();
//        return path;
        return templateFilePath;
    }

    @Value("${file.template.path}")
    private void setTemplateFilePath(String templateFilePath) {
        CommonFields.templateFilePath = templateFilePath;
    }

    public static String getMenuIcon() {
        return menuIcon;
    }

    @Value("${menu_icon}")
    public void setMenuIcon(String menuIcon) {
        CommonFields.menuIcon = menuIcon;
    }

    public static String getButtonIcon() {
        return buttonIcon;
    }

    @Value("${button_icon}")
    public void setButtonIcon(String buttonIcon) {
        CommonFields.buttonIcon = buttonIcon;
    }
}
