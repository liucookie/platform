package com.hangyu.platform.global;

public enum ResultStatusEnum {

    SUCCESS(200, "请求成功！"),
    USER_NOT_EXIST(500, "用户不存在"),
    ERROR_PASSWORD(500, "密码错误"),
    FILE_UPLOAD_DOWNLOAD_FAILE(500, "文件上传下载失败"),
    EXPECTION(500, "服务器内部错误，请稍后再试"),
    AUTH__TOKEN_ERROR(401, "认证失败,token非法"),
    AUTH_TOKEN_NULL(401, "认证失败,token为空"),
    AUTH_EXISTS(500, "账号已存在"),
    ACCOUNT_ERROR(500, "账号名格式不正确"),
    ORGNAME_REPEAT(500, "机构名称已存在"),
    File_ERROR(500,"文件后缀名称不合法"),
    File_NOT_EXISTS(500,"文件不存在");

    private int code;
    private String message;


    ResultStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }
}
