package com.hangyu.platform.global;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class X5CommonFields {

    // erp服务器地址
    private static String x5HttpUrl;
    // eip流程启动接口地址
    private static String x5Start;
    // eip流程执行下一步接口地址
    private static String x5Next;
    //eip流程获取代办事项
    private static String x5TodoList;
    //eip流程获取已办事项
    private static String x5DoneList;
    //eip流程获取我发起的事项
    private static String x5MyList;
    //eip人工终止流程
    private static String x5StopTask;
    //eip流程审批历史
    private static String x5TaskHistory;
    //eip实例id获取任务TaskId
    private static String x5GetTasksByInstId;

    //eip增加用户
    private static String x5AddUser;
    //eip更新用户
    private static String x5UpdateUser;
    //eip根据id查询用户
    private static String x5QueryUserById;


    //国家秘密审批流程配置key
    private static String secretCountryApproveId;
    //国家秘密解除审批流程配置key
    private static String secretCountryCancelApproveId;
    //国家秘密事项变更审批 key
    private static String secretCountryAlterApproveId;
    //馆藏文件变更审批 key
    private static String nationFileAlterApproveId;
    //涉密人员每月考核 key
    private static String examMonthSecretApproveId;
    //移动存储介质借用审批 key
    private static String mediaManageApproveId;
    //便携机借用审批 key
    private static String portableManageApproveId;
    //科技论文保密审查 key
    private static String technologyCheckApproveId;



    //国家秘密安全审定发起人节点
    private static String countrySecRequestNode;
    //国家秘密安全审定节点1：定密责任人审批
    private static String countrySecMakeNode1;
    //国家秘密安全审定节点2：部门责任热审批
    private static String countrySecMakeNode2;
    //国家秘密安全审定节点3：部门责任热审批
    private static String countrySecMakeNode4;

    public static String getTechnologyCheckApproveId() {
        return technologyCheckApproveId;
    }
    @Value("${technology_check_approve}")
    public  void setTechnologyCheckApproveId(String technologyCheckApproveId) {
        X5CommonFields.technologyCheckApproveId = technologyCheckApproveId;
    }

    public static String getProtableManageApproveId() {
        return portableManageApproveId;
    }
    @Value("${protable_manage_approve}")
    public  void setProtableManageApproveId(String portableManageApproveId) {
        X5CommonFields.portableManageApproveId = portableManageApproveId;
    }

    public static String getCountrySecMakeNode4() {
        return countrySecMakeNode4;
    }
    @Value("${country_secret_make_department_user3}")
    public  void setCountrySecMakeNode4(String countrySecMakeNode4) {
        X5CommonFields.countrySecMakeNode4 = countrySecMakeNode4;
    }

    public static String getMediaManageApproveId() {
        return mediaManageApproveId;
    }

    @Value("${media_manage_approve}")
    public  void setMediaManageApproveId(String mediaManageApproveId) {
        X5CommonFields.mediaManageApproveId = mediaManageApproveId;
    }

    public static String getExamMonthSecretApproveId() {
        return examMonthSecretApproveId;
    }

    @Value("${exam_month_secret}")
    public void setExamMonthSecretApproveId(String examMonthSecretApproveId) {
        X5CommonFields.examMonthSecretApproveId = examMonthSecretApproveId;
    }

    public static String getNationFileAlterApproveId() {
        return nationFileAlterApproveId;
    }
    @Value("${nation_file_alter_approveId}")
    public  void setNationFileAlterApproveId(String nationFileAlterApproveId) {
        X5CommonFields.nationFileAlterApproveId = nationFileAlterApproveId;
    }

    public static String getSecretCountryAlterApproveId() {
        return secretCountryAlterApproveId;
    }
    @Value("${secret_country_alter_approveId}")
    public void setSecretCountryAlterApproveId(String secretCountryAlterApproveId) {
        X5CommonFields.secretCountryAlterApproveId = secretCountryAlterApproveId;
    }

    public static String getSecretCountryCancelApproveId() {
        return secretCountryCancelApproveId;
    }

    @Value("${secret_country_cancel_approveId}")
    public  void setSecretCountryCancelApproveId(String secretCountryCancelApproveId) {
        X5CommonFields.secretCountryCancelApproveId = secretCountryCancelApproveId;
    }

    public static String getX5UpdateUser() {
        return x5UpdateUser;
    }

    @Value("${x5.update.user}")
    public  void setX5UpdateUser(String x5UpdateUser) {
        X5CommonFields.x5UpdateUser = x5UpdateUser;
    }

    public static String getX5QueryUserById() {
        return x5QueryUserById;
    }
    @Value("${x5.query.userById}")
    public  void setX5QueryUserById(String x5QueryUserById) {
        X5CommonFields.x5QueryUserById = x5QueryUserById;
    }

    public static String getX5GetTasksByInstId() {
        return x5GetTasksByInstId;
    }
    @Value("${x5.task.getTasksByInstId}")
    public  void setX5GetTasksByInstId(String x5GetTasksByInstId) {
        X5CommonFields.x5GetTasksByInstId = x5GetTasksByInstId;
    }

    public static String getCountrySecRequestNode() {
        return countrySecRequestNode;
    }
    @Value("${country_secret_make_request}")
    public  void setCountrySecRequestNode(String countrySecRequestNode) {
        X5CommonFields.countrySecRequestNode = countrySecRequestNode;
    }

    public static String getX5AddUser() {
        return x5AddUser;
    }
    @Value("${x5.add.user}")
    public  void setX5AddUser(String x5AddUser) {
        X5CommonFields.x5AddUser = x5AddUser;
    }

    public static String getX5TaskHistory() {
        return x5TaskHistory;
    }
    @Value("${x5.task.history}")
    public  void setX5TaskHistory(String x5TaskHistory) {
        X5CommonFields.x5TaskHistory = x5TaskHistory;
    }

    public static String getX5StopTask() {
        return x5StopTask;
    }
    @Value("${x5.stop.task}")
    public  void setX5StopTask(String x5StopTask) {
        X5CommonFields.x5StopTask = x5StopTask;
    }

    public static String getX5MyList() {
        return x5MyList;
    }

    @Value("${x5.my.list}")
    public void setX5MyList(String x5MyList) {
        X5CommonFields.x5MyList = x5MyList;
    }

    public static String getX5DoneList() {
        return x5DoneList;
    }

    @Value("${x5.done.list}")
    public void setX5DoneList(String x5DoneList) {
        X5CommonFields.x5DoneList = x5DoneList;
    }

    public static String getX5TodoList() {
        return x5TodoList;
    }

    @Value("${x5.todo.list}")
    public void setX5TodoList(String x5TodoList) {
        X5CommonFields.x5TodoList = x5TodoList;
    }

    public static String getCountrySecMakeNode1() {
        return countrySecMakeNode1;
    }

    @Value("${country_secret_make_secret_user1}")
    public void setCountrySecMakeNode1(String countrySecMakeNode1) {
        X5CommonFields.countrySecMakeNode1 = countrySecMakeNode1;
    }

    public static String getCountrySecMakeNode2() {
        return countrySecMakeNode2;
    }

    @Value("${country_secret_make_department_user2}")
    public void setCountrySecMakeNode2(String countrySecMakeNode2) {
        X5CommonFields.countrySecMakeNode2 = countrySecMakeNode2;
    }

    public static String getX5Next() {
        return x5Next;
    }

    @Value("${x5.next.url}")
    public void setX5Next(String x5Next) {
        X5CommonFields.x5Next = x5Next;
    }

    public static String getX5Start() {
        return x5Start;
    }

    @Value("${x5.start.url}")
    public void setX5Start(String x5Start) {
        X5CommonFields.x5Start = x5Start;
    }

    public static String getX5HttpUrl() {
        return x5HttpUrl;
    }

    @Value("${x5_http_url}")
    private void setX5HttpUrl(String x5HttpUrl) {
        X5CommonFields.x5HttpUrl = x5HttpUrl;
    }

    public static String getSecretCountryApproveId() {
        return secretCountryApproveId;
    }

    @Value("${secret_country_approveId}")
    private void setSecretCountryApproveId(String secretCountryApproveId) {
        X5CommonFields.secretCountryApproveId = secretCountryApproveId;
    }
}
